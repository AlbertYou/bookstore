<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>修改密码-<%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link rel="stylesheet" type="text/css" href="../style/admin/admin/admin_modifypsw.css">
	</head>
	<body>
	<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="admin_modifypsw_panel">
					<div id="temp_nav"><span>修改密码</span></div>
					<div id="result_panel"><s:actionmessage/></div>
					<s:form action="modifypsw" method="post"  theme="simple">
						<ul id="form_modifypsw">
							<li id="psw_label"><label>原密码&nbsp;&nbsp;</label><s:textfield name="password"></s:textfield></li>
							<li id="newpsw_label"><label>新密码&nbsp;&nbsp;</label><s:password name="newPassword"></s:password></li>
							<li id="repeatpsw_label"><label>重复密码</label><s:password name="repeatPassword"></s:password></li>
							<li id="submit_label"><input id="modify_button" type="image" src="../image/modify.gif"/></li>
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