package com.albert.bs.admin.action.admin;

import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Admin;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.AdminService;
import com.albert.bs.util.MD5Util;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class AddAdminAction extends AdminAction implements ModelDriven<Admin> {
	private static final long serialVersionUID = -8334295580025243554L;
	
	private Admin admin = new Admin();
	private AdminService adminService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		if(container.getAdmin().getAdminName() != null && container.getAdmin().getAdminName().equals("admin")) {			
			if(adminService.findByName(admin.getAdminName()) == null) {
				admin.setPassword(MD5Util.encrypt(admin.getPassword())); //MD5加密密码
				adminService.save(admin);
				return SUCCESS;
			} else { //用户名已存在
				addActionError("用户名已存在");
				return LOGIN;
			}
		}
		return SUCCESS;
	}

	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public Admin getModel() {
		return admin;
	}
	
}
