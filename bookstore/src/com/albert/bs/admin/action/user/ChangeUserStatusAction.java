package com.albert.bs.admin.action.user;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.service.UserService;

public class ChangeUserStatusAction extends AdminAction {
	private static final long serialVersionUID = 1587362740092644486L;

	private String userId;
	private UserService userService;
	
	public String execute() throws Exception {
		userService.changeStatus(userId);
		return SUCCESS;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
