package com.albert.bs.user.action.collect;

import java.util.Map;

import com.albert.bs.model.SessionContainer;
import com.albert.bs.model.User;
import com.albert.bs.service.CollectService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class ClearCollectAction extends UserAction {
	private static final long serialVersionUID = 8464023015430268952L;

	private CollectService collectService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		User user = container.getUser();
		collectService.deleteCollects(user.getUserId());
		return SUCCESS;
	}

	public CollectService getCollectService() {
		return collectService;
	}
	public void setCollectService(CollectService collectService) {
		this.collectService = collectService;
	}
	
}
