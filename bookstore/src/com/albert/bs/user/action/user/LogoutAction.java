package com.albert.bs.user.action.user;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.user.action.UserAction;
import com.opensymphony.xwork2.ActionContext;

public class LogoutAction extends UserAction {
	private static final long serialVersionUID = 918945515649074234L;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		String user_cookie = "userId";
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(user_cookie)) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					ServletActionContext.getResponse().addCookie(cookie);  //注：如果没有该语句，则之前的操作无效
					break;
				}
			}
		}
		ActionContext.getContext().getSession().put("container", null);
		return SUCCESS;
	}

}
