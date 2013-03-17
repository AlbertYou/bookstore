<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录-<%=getServletContext().getServletContextName()%></title>
		<link rel="stylesheet" href="../style/user/user/login.css" type="text/css">
		<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
    	<script type="text/javascript" src="../js/login.js"></script>
	</head>
	<body>
		<div id="page">
			<div id="logo"><a href="../index.html"><img src="../image/logo.gif" height="100px" width="200px" alt="<s:text name="system.site.name"></s:text>"/></a></div>
			<div id="login">
			<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b> 
 			<div class="content">
				<form action="login.action" method="post" id="loginForm">
					<div id="title">用户登录</div>
					<div id="result_label">
						<s:actionerror/>
					</div>
					<div id="namelabel">用户名&nbsp;<input id="username" name="username" type="text" size="30" value="请输入用户名或邮箱..." class="default_name_input"/>
						<span id="username_error"><s:fielderror><s:param>username</s:param></s:fielderror></span>
					</div>
					<div id="passwordlabel">密&nbsp;&nbsp;码&nbsp;<input id="password" name="password" type="password" size="30" />
						<label class="error"><s:fielderror><s:param>password</s:param></s:fielderror></label>
					</div>
					<div id="validcodelabel">验证码
						<input id="validcode" name="validcode" type="text" size="6"/>
						<img src="<s:url value='validationcode.action'/>" id="vc" onclick="javascript: this.src = 'validationcode.action?rnd='+Math.random();" style="cursor: pointer;" height="30px" title="点击图片刷新"/>
						<label class="error"><s:fielderror><s:param>validcode</s:param></s:fielderror></label>
					</div>
					<div id="rememberpswlabel">
						<input type="checkbox" name="rememberPsw" value="yes"/>&nbsp;&nbsp;自动登录&nbsp;&nbsp;<a href="forgetpsw.action">忘记密码?</a>
					</div>
					<div id="loginlabel">
						<input type="image" src="../image/login_button.gif">
				</form>
			</div>
			<b class="b5"></b><b class="b6"></b><b class="b7"></b><b class="b8"></b>
			</div>
		</div>
	</body>
</html>