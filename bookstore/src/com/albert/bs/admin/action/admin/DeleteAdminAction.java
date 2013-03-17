package com.albert.bs.admin.action.admin;

import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Admin;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.AdminService;
import com.opensymphony.xwork2.ActionContext;

public class DeleteAdminAction extends AdminAction {
	private static final long serialVersionUID = -6090059536805205725L;
	
	private String adminId;
	private AdminService adminService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		if(container.getAdmin().getAdminName() != null && container.getAdmin().getAdminName().equals("admin")) {			
			adminService.delete(new Admin(adminId));
		}
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
