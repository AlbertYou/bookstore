<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>新用户注册-<%=getServletContext().getServletContextName()%></title>
		<link rel="stylesheet" href="../style/user/user/register.css" type="text/css">
		<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
    	<script type="text/javascript" src="../js/register.js"></script>
	</head>
	<body>
		<div id="page">
			<div id="logo"><a href="../user/index.action"><img src="../image/logo.gif" height="80px" width="200px" alt="<s:text name="system.site.name"></s:text>"/></a></div>
			<div id="register">
				<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b> 
				<div class="content">
				<form action="register.action" method="post" id="registerForm">
					<div id="title">用户注册</div>
					<div class="register_item">&nbsp;&nbsp;<label for="username">用户名</label>
						<input type="text" id="username" name="username" size="20" label="用户名"/><span class="required_label">*</span>
						<span id="username_error"></span>
						<s:fielderror cssClass="error_label">
                    		<s:param>username</s:param>   
               			</s:fielderror>
					</div>
					<div class="register_item">&nbsp;&nbsp;&nbsp;&nbsp;<label for="email">邮箱</label>
						<input type="text" id="email" name="email" size="20" label="邮箱"/><span class="required_label">*</span>
						<span id="email_error"></span>
						<s:fielderror cssClass="error_label">
                    		<s:param>email</s:param>   
               			</s:fielderror>
					</div>
					<div class="register_item">&nbsp;&nbsp;&nbsp;&nbsp;<label for="password">密码</label>
						<input type="password" id="password" name="password" size="20" label="密码"/><span class="required_label">*</span>
						<s:fielderror cssClass="error_label">
                    		<s:param>password</s:param>   
               			</s:fielderror>
					</div>
					<div class="register_item"><label for="repeatPassword">重复密码</label>
						<input type="password" id="repeatPassword" name="repeatPassword" size="20" label="重复密码"/><span class="required_label">*</span>
						<s:fielderror cssClass="error_label">
                    		<s:param>repeatPassword</s:param>   
               			</s:fielderror>
					</div>
					<div class="register_item">&nbsp;&nbsp;&nbsp;
						<s:radio id="sex" name="sex" list="#{'0':'男','1':'女'}" value="0" label="性别"></s:radio>
					</div>
					<div class="register_item">&nbsp;&nbsp;&nbsp;&nbsp;<label for="phone">电话</label>
						<input type="text" id="phone" name="phone" size="20" label="电话"/>
						<s:fielderror cssClass="error_label">
                    		<s:param>phone</s:param>   
               			</s:fielderror>
					</div>
					<div class="submit_label"><input type="image" src="../image/register_button.gif"/></div>
				</form>
				</div>
				<b class="b5"></b><b class="b6"></b><b class="b7"></b><b class="b8"></b>  
			</div>
		</div>
	</body>
</html>