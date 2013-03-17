package com.albert.bs.admin.action.admin;

import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Admin;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.AdminService;
import com.albert.bs.util.MD5Util;
import com.opensymphony.xwork2.ActionContext;

/**
 * 管理员修改密码
 * @author Albert
 *
 */
public class ModifyPasswordAction extends AdminAction {
	private static final long serialVersionUID = 8522793480718219127L;
	
	private String password;
	private String newPassword;
	private String repeatPassword;
	private AdminService adminService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		if(newPassword != null && repeatPassword != null && newPassword.equals(repeatPassword)) {
			Map session = (Map) ActionContext.getContext().getSession();
			SessionContainer container = (SessionContainer) session.get("container");
			Admin admin = container.getAdmin();
			Admin newAdmin;
			if(password != null && MD5Util.encrypt(password).equals(admin.getPassword())) {
				admin.setPassword(MD5Util.encrypt(newPassword));
				newAdmin = adminService.resetPassword(admin);
				container.setAdmin(newAdmin);
				session.put("container", container);
				return SUCCESS;
			} else { //原密码输入错误
				this.addActionMessage(getText("admin.login.error.psw"));
				return INPUT;
			}
		} else { //两次新密码输入不相同
			this.addActionMessage(getText("modifypassword.error.diffpsw"));
			return INPUT;
		}
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
}
