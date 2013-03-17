package com.albert.bs.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 把登录前的页面地址参数放到session中
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class LastUrlParamInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -539037560919482121L;

	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		setTOGoingURLParam(request, invocation);
		return invocation.invoke();
	}
	
	@SuppressWarnings("unchecked")
	private void setTOGoingURLParam(HttpServletRequest request, ActionInvocation invocation) {
		String url = "";
		Map<String, String[]> zzMap = request.getParameterMap();
		if(zzMap != null) {
			url = "?";
			for (String s : zzMap.keySet()) {
				String[] value = zzMap.get(s);
				for (String val : value) {
					url = url + s + "=" + val + "&";
				}
			}
			url = url.substring(0, url.lastIndexOf("&"));
		}
		request.getSession().setAttribute("lastUrlParam", url);
	}
}
