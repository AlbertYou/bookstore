package com.albert.bs.user.action.user;

import com.albert.bs.model.User;
import com.albert.bs.service.UserService;
import com.albert.bs.user.action.UserAction;
import com.albert.bs.util.MD5Util;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends UserAction implements ModelDriven<User> {
	private static final long serialVersionUID = 5002407129598474580L;
	
	private User user = new User();
	private UserService userService;
	
	public String execute() throws Exception {
		user.setPassword(MD5Util.encrypt(user.getPassword()));
		userService.save(user);
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
