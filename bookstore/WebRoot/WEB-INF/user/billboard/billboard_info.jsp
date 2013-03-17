<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>${requestScope.billboard.title }-<%=getServletContext().getServletContextName()%></title>
		<link rel="stylesheet" type="text/css" href="../style/user/billboard/billboard_info.css">
	</head>
	<body>
<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
                <div id="billboard_title">
                	<s:property value="#request.billboard.title"/>
                </div>
                <div id="billboard_publishTime">
                	发布时间：
                	<s:date id="pt" name="#request.billboard.publishTime" format="yyyy-MM-dd HH:mm:ss"/>
                	<s:property value="#pt"/>
                </div>
                <div id="billboard_content">
                	<s:property value="#request.billboard.content"/>
                </div>
            </div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
</body>
</html>