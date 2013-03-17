package com.albert.bs.interceptor;

import java.util.Map;

import com.albert.bs.model.SessionContainer;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * the interceptor of users‘ logining
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class UserInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -2302359741387187979L;

	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session = invocation.getInvocationContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");  //用户已登录
		if(container != null && container.getUser() != null && container.getUser().getUserId() != null) {
			return invocation.invoke();
		} else {  //用户未登录
			return "login";
		}
	}

}
