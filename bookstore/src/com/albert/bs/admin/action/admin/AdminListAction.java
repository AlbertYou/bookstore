package com.albert.bs.admin.action.admin;

import java.util.List;
import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.Admin;
import com.albert.bs.model.SessionContainer;
import com.albert.bs.service.AdminService;
import com.opensymphony.xwork2.ActionContext;

public class AdminListAction extends AdminAction {
	private static final long serialVersionUID = 4805309954552375334L;

	private AdminService adminService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		Map request = (Map) ActionContext.getContext().get("request");		
		SessionContainer container = (SessionContainer) session.get("container");
		if(container.getAdmin().getAdminName() != null && container.getAdmin().getAdminName().equals("admin")) {			
			List<Admin> admins = adminService.findAll();
			request.put("admins", admins);
		}
		return SUCCESS;
	}
	
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
}
