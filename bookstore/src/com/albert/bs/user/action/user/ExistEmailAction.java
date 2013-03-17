package com.albert.bs.user.action.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.service.UserService;
import com.albert.bs.user.action.UserAction;

public class ExistEmailAction extends UserAction {
	private static final long serialVersionUID = 8455732752993518869L;
	
	private String email;
	private UserService userService;
	
	public String execute() throws Exception {
		boolean exist = userService.existEmail(email);
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
