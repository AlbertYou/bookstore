<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div id="page_top">
			<div id="top">
			<div id="login">
				<ul>
					<li>
						您好,
						<s:property value="#session.container.admin.adminName" />
					</li>
					<li>
						<a href="tomodifypassword.action">修改密码</a>
					</li>
					<li>
						<a href="logout.action">注销</a>
					</li>
				</ul>
			</div>
			<div id="logo_panel">
				<a href="../admin/index.action"><img src="../image/logo.gif"
						height="80px" width="200px"
						alt="<s:text name="system.site.name"></s:text>" />
				</a>
			</div>
		</div>
		<div id="banner">
			<div id="nav">
				<ul>
					<li class="nav_item">
						<a href="index.action">图书管理</a>
					</li>
					<li class="nav_item">
						<a href="ordersnew.action">订单管理</a>
					</li>
					<li class="nav_item">
						<a href="todaycomments.action">评论管理</a>
					</li>
					<li class="nav_item">
						<a href="currentbillboards.action">公告管理</a>
					</li>
					<li class="nav_item">
						<a href="categorylist.action">类别管理</a>
					</li>
					<li class="nav_item">
						<a href="searchuser.action">用户管理 </a>
					</li>
					<s:if test="#session.container.admin.adminName == 'admin'">
						<li class="nav_item">
							<a href="adminlist.action">管理员管理 </a>
						</li>
					</s:if>
				</ul>
			</div>
		</div>
		</div>
	</body>
</html>