package com.albert.bs.admin.action.admin;

import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.SessionContainer;
import com.opensymphony.xwork2.ActionContext;

public class AdminLogoutAction extends AdminAction {
	private static final long serialVersionUID = -4505054519996703645L;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		if(container != null && container.getAdmin() != null) {
			container.setAdmin(null);
		}
		session.put("container", container);
		return SUCCESS;
	}

}
