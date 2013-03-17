package com.albert.bs.result;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.albert.bs.action.ValidationCodeAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

/**
 * the type of result which action returned 
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class ValidationCodeResult implements Result {
	private static final long serialVersionUID = 8429512070233603438L;

	public void execute(ActionInvocation invocation) throws Exception {
		ValidationCodeAction action = (ValidationCodeAction) invocation.getAction();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Param", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType(action.getContentType());
		response.setContentLength(action.getContentLength());
		ServletOutputStream sos = response.getOutputStream();
		sos.write(action.getImageInBytes());
		sos.close();
	}

}
