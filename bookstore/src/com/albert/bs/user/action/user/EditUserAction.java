package com.albert.bs.user.action.user;

import java.util.Map;

import com.albert.bs.model.SessionContainer;
import com.albert.bs.model.User;
import com.albert.bs.service.UserService;
import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class EditUserAction extends UserAction implements ModelDriven<User> {
	private static final long serialVersionUID = -8171490693613680578L;

	private User user = new User();
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		userService.update(user);
		container.setUser(user);
		session.put("container", container);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getModel() {
		return user;
	}
	
}
