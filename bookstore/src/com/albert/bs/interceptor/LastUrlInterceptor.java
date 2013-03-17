package com.albert.bs.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 把登录前的页面地址放到session中
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class LastUrlInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -5711811480573928522L;

	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		setTOGoingURL(request, invocation);
		return invocation.invoke();
	}
	
	private void setTOGoingURL(HttpServletRequest request, ActionInvocation invocation) {
		String url = request.getHeader("referer");
		request.getSession().setAttribute("lastUrl", url);
	}
}
