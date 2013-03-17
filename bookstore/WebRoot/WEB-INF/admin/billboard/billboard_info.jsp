<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${requestScope.billboard.title }-<%=getServletContext().getServletContextName()%></title>
		<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
		<link rel="stylesheet" type="text/css" href="../style/admin/billboard/billboard_info.css">
	</head>
	<body>
		<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="left">
					<ul id="left_nav">
						<li><a href="currentbillboards.action">当前公告</a></li>
						<li><a href="billboardlist.action">所有公告</a></li>
					  </ul>
				</div>
				<div id="right">
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
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>
	</body>
</html>