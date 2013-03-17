<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>管理员登录-<%=getServletContext().getServletContextName()%></title>
    	<link rel="stylesheet" href="../style/admin/admin/login.css" type="text/css">
	</head>
	<body>
		<div id="page">
			<div id="logo">
				<a href="../user/index.action"><img src="../image/logo.gif" title="<s:text name="system.site.name"></s:text>" alt="<s:text name="system.site.name"></s:text>"/></a>
			</div>
			<div id="nav"><s:text name="system.site.name"></s:text>后台管理系统</div>
			<div id="login">
			<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b> 
 			<div class="content">
				<form action="login.action" method="post">
					<div id="namelabel">账户名&nbsp;<input id="adminName" name="adminName" type="text" size="20" /></div>
					<div id="passwordlabel">密&nbsp;&nbsp;码&nbsp;<input id="password" name="password" type="password" size="20"/></div>
					<div id="loginlabel"><input type="image" src="../image/login_button.gif" /></div>
				</form>
			</div>
			<b class="b5"></b><b class="b6"></b><b class="b7"></b><b class="b8"></b>   
			</div>
		</div>
	</body>
</html>