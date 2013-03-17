package com.albert.bs.admin.action.user;

import java.util.Map;

import com.albert.bs.admin.action.AdminAction;
import com.albert.bs.model.User;
import com.albert.bs.service.UserService;
import com.opensymphony.xwork2.ActionContext;

public class UserInfoAction extends AdminAction {
	private static final long serialVersionUID = 1587362740092644486L;

	private String userId;
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map request = (Map) ActionContext.getContext().get("request");
		User user = userService.findById(userId);
		request.put("user", user);
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
