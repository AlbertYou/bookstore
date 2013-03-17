package com.albert.bs.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.model.SessionContainer;
import com.albert.bs.model.User;
import com.albert.bs.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CookieInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 887115767084339733L;
	
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		if(container == null) {
			container = new SessionContainer();
		}
		User u = container.getUser();
		if(u == null) {
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			String user_cookie = "userId";
			if(cookies != null) {
				for (Cookie cookie : cookies) {
					if(cookie.getName().equals(user_cookie)) {
						String userId = cookie.getValue();
						User user = userService.findById(userId);
						container.setUser(user);
						session.put("container", container);
						break;
					}
				}
			}
		}
		return invocation.invoke();
	}

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
