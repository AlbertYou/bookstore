<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册成功-<%=getServletContext().getServletContextName()%></title>
		<link rel="stylesheet" href="../style/user/user/register_success.css" type="text/css">
	</head>
	<body>
		<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="newpsw"><span>注册成功</span></div>
				<div id="temp_nav">
					<a href="tologin.action">登录</a>
					<a href="index.action">返回首页</a>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
	</body>
</html>