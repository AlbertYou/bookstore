<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>增加管理员-<%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link rel="stylesheet" type="text/css" href="../style/admin/admin/admin_add.css">
	</head>
	<body>
	<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="admin_add_panel">
					<div id="temp_nav"><span>增加管理员</span></div>
					<s:form action="addadmin" method="post"  theme="simple">
						<ul id="form_add">
							<li id="name_label"><label>用户名</label><s:textfield name="adminName"></s:textfield></li>
							<li id="psw_label"><label>密&nbsp;&nbsp;码</label><s:password name="password"></s:password></li>
							<li id="submit_label"><input id="add_label" type="image" src="../image/sure.gif"/></li>
						</ul>
					</s:form>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>
	</body>
</html>