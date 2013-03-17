package com.albert.bs.user.action.user;

import java.util.Map;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.albert.bs.model.SessionContainer;
import com.albert.bs.model.User;
import com.albert.bs.service.UserService;
import com.albert.bs.user.action.UserAction;
import com.albert.bs.util.MD5Util;
import com.albert.bs.util.PasswordCreator;
import com.opensymphony.xwork2.ActionContext;

public class FindPasswordAction extends UserAction {
	private static final long serialVersionUID = -4357525212351724516L;

	private String validcode;
	private String username;
	private String email;	
	private UserService userService;
	private JavaMailSender mailSender;
	private SimpleMailMessage message;
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		SessionContainer container = (SessionContainer) session.get("container");
		if(!validcode.equalsIgnoreCase(container.getValidationCode())) {
			this.addFieldError("validcode", getText("validationcode.error"));
			return INPUT;
		}
		User user = userService.findPassword(username, email);
		if(user != null) {
			String newPsw = PasswordCreator.newPassword();
			user.setPassword(MD5Util.encrypt(newPsw));
			userService.update(user);
//			Map request = (Map) ActionContext.getContext().get("request");
//			request.put("newPsw", newPsw);
			
			//把新密码通过邮箱发送给用户
			message.setTo(user.getEmail());
			message.setSubject(user.getUsername() + "-找回密码-" + getText("system.site.name"));
			message.setText("您好，" + user.getUsername() + "。 您的新密码为 " + newPsw + "  ———" + getText("system.site.name"));
			mailSender.send(message);
			
		} else {
			this.addActionError(getText("findpassword.error.info"));
			return INPUT;
		}
		return SUCCESS;
	}

	public String getValidcode() {
		return validcode;
	}
	public void setValidcode(String validcode) {
		this.validcode = validcode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public JavaMailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	public SimpleMailMessage getMessage() {
		return message;
	}
	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}
	
}
