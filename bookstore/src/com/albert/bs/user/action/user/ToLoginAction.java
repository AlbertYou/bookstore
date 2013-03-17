package com.albert.bs.user.action.user;

import java.util.Map;

import com.albert.bs.model.SessionContainer;
import com.albert.bs.model.User;
import com.albert.bs.service.UserService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class ToLoginAction extends UserAction {
	private static final long serialVersionUID = 217920375680004075L;

	private UserService userService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		if(container == null) {
			container = new SessionContainer();
		}
		User user = container.getUser();
		if(user != null) {
			return "index";
		}
		return SUCCESS;
	}

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
