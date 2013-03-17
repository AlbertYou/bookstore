package com.albert.bs.admin.action.admin;

import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Admin;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.AdminService;
import com.albert.bs.util.MD5Util;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class AdminLoginAction extends AdminAction implements ModelDriven<Admin> {
	private static final long serialVersionUID = -4375941832357522657L;

	private Admin admin = new Admin();
	private AdminService adminService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		admin.setPassword(MD5Util.encrypt(admin.getPassword()));
		Admin a = adminService.login(admin);
		if(a != null && a.getAdminId() != null) { //登录成功
			SessionContainer container = null;
			Map session = ActionContext.getContext().getSession();
			if(session.get("container") != null) {
				container = (SessionContainer) session.get("container");
			} else {
				container = new SessionContainer();
			}
			container.setAdmin(a);
			session.put("container", container);
			return SUCCESS;
		} else {
			addActionError("用户名或密码错误");
			return LOGIN;
		}
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
