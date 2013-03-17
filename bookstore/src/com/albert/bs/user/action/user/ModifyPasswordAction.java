package com.albert.bs.user.action.user;

import java.util.Map;

import com.albert.bs.model.SessionContainer;
import com.albert.bs.model.User;
import com.albert.bs.service.UserService;
import com.albert.bs.user.action.UserAction;
import com.albert.bs.util.MD5Util;
import com.opensymphony.xwork2.ActionContext;

public class ModifyPasswordAction extends UserAction {
	private static final long serialVersionUID = -4357525212351724516L;

	private String oldpsw;
	private String password;	
	private String repeatepsw;	
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		User u = userService.findById(container.getUser().getUserId());
		if(!u.getPassword().equals(MD5Util.encrypt(oldpsw))) {
			this.addFieldError("oldpsw", getText("password.error"));
			return INPUT;
		} else {
			u.setPassword(MD5Util.encrypt(password));
			userService.update(u);
			container.setUser(u);
			session.put("container", container);
			this.addActionMessage(getText("modifypassword.success"));
		}
		return SUCCESS;
	}

	public String getOldpsw() {
		return oldpsw;
	}
	public void setOldpsw(String oldpsw) {
		this.oldpsw = oldpsw;
	}
	public String getRepeatepsw() {
		return repeatepsw;
	}
	public void setRepeatepsw(String repeatepsw) {
		this.repeatepsw = repeatepsw;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
