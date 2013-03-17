package com.albert.bs.interceptor;

import java.util.Map;

import com.albert.bs.model.SessionContainer;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * the interceptor of administrators’ logining
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class AdminInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -2302359741387187979L;

	public String intercept(ActionInvocation invocation) throws Exception {
	    @SuppressWarnings("unchecked")
		Map session = invocation.getInvocationContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");  //管理员已登录
		if(container != null && container.getAdmin() != null) {
			return invocation.invoke();
		} else {  //管理员未登录
			return "login";
		}
	}

}
