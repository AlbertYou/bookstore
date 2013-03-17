<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>找回密码-<%=getServletContext().getServletContextName()%></title>
		<link rel="stylesheet" type="text/css" href="../style/user/user/password_find.css">
		<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
    	<script type="text/javascript" src="../js/password_find.js"></script>
	</head>
	<body>
<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
			  	<div id="temp_nav">
			  		<span>找回密码</span>
			  	</div>
			  	<div id="message_label"><s:actionerror /></div>
			  	<div id="form_panel">
			  		<form action="findpsw.action" method="post" id="findPswForm">
			  			<div class="item">用户名：&nbsp;&nbsp;<input id="username" name="username" type="text" size="25"/>
			  				<span id="username_error">
			  				<s:fielderror cssClass="error_label">
                    			<s:param>username</s:param>   
               				</s:fielderror>
			  				</span>
			  			</div>
			  			<div class="item">注册邮箱：<input id="email" name="email" type="text" size="25"/>
			  				<span id="email_error">
               				<s:fielderror cssClass="error_label">
                    			<s:param>email</s:param>
               				</s:fielderror>
			  				</span>
			  			</div>
			  			<div class="item">验证码：&nbsp;
			  				<input id="validcode" name="validcode" type="text" size="4"/>
							<img src="<s:url value='validationcode.action'/>" id="vc" onclick="javascript: this.src = 'validationcode.action?rnd='+Math.random();" style="cursor: pointer;" title="点击图片刷新"/>
							<span id="validcode_error">
               				<s:fielderror cssClass="error_label">
                    			<s:param>validcode</s:param>   
               				</s:fielderror>
               				</span>
						</div>
			  			<div class="item"><input id="submit_image" type="image" src="../image/sure.gif" height="40px"/></div>
			  		</form>
             	</div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
</body>
</html>