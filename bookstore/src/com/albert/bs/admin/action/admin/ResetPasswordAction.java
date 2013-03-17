package com.albert.bs.admin.action.admin;

import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Admin;
import com.albert.bs.service.AdminService;
import com.albert.bs.util.MD5Util;
import com.albert.bs.util.PasswordCreator;
import com.opensymphony.xwork2.ActionContext;

/**
 * 重置管理员密码
 * @author Albert
 *
 */
public class ResetPasswordAction extends AdminAction {
	private static final long serialVersionUID = 1025645777011162188L;
	
	private String adminId;
	private AdminService adminService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		Admin admin = new Admin(adminId);
		String newPsw = PasswordCreator.newPassword();
		admin.setPassword(MD5Util.encrypt(newPsw));
		Admin a = adminService.resetPassword(admin);
		a.setPassword(newPsw);
		request.put("admin", a);
		return SUCCESS;
	}

	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
}
