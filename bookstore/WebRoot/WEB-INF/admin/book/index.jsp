<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>后台管理-<%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/book/index.css" type="text/css" rel="stylesheet">
	</head>
	<body>
		<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="left">
					<ul id="left_nav">
						<li><a href="searchbook.action">图书管理</a></li>
						<li><a href="lowstockbooklist.action">低库存图书</a></li>
						<li><a href="publisherlist.action">出版社管理</a></li>
					  </ul>
				</div>
				<div id="right">
					<div id="welcome_panel">欢迎进入<s:text name="system.site.name"></s:text>后台管理系统</div>
					<div id="total_sell">今日的销售额为<span id="sell_label"><s:property value="#request.bookCountSelled"/></span></div>
					<div id="notice_panel">
						<ul>
							<li>
								<a href="ordersnew.action">新订单：<s:property value="#request.orderCount"/></a>
							</li>
							<li>
								<a href="todaycomments.action">新评论：<s:property value="#request.commentCount"/></a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>
	</body>
</html>