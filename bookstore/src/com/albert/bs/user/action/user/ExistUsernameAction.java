package com.albert.bs.user.action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.service.UserService;
import com.albert.bs.user.action.UserAction;

public class ExistUsernameAction extends UserAction {
	private static final long serialVersionUID = 1855186944429744308L;
	
	private String username;
	private UserService userService;
	
	public String execute() throws Exception {
		boolean exist = userService.existUsername(username);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter writer = response.getWriter();
		try {
			writer.print(exist);
		} finally {
			if(writer != null) {
				writer.flush();
				writer.close();
			}
		}
		return null;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
