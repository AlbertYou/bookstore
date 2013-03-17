<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>管理员管理-<%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link rel="stylesheet" type="text/css" href="../style/admin/admin/admin_list.css">
	</head>
	<body>
	<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="admin_add_panel">
					<ul id="title_list">
						<li id="temp_nav">所有管理员</li>
						<li id="admin_add_label"><a href="toaddadmin.action">增加管理员</a></li>
					</ul>
				</div>
				<div id="admin_panel">
					<ul id="admin_list">
						<s:iterator id="admin" value="#request.admins">
							<li class="admin_item">
								<span><s:property value="#admin.adminName"/></span>
								<a href="resetpassword.action?adminId=<s:property value="#admin.adminId"/>">[重置密码]</a>
								<a href="deleteadmin.action?adminId=<s:property value="#admin.adminId"/>">[删除]</a>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>
	</body>
</html>