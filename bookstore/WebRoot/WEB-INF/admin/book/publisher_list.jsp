<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>出版社管理-<%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link href="../style/admin/common/apprise.css" type="text/css" rel="stylesheet"/>
    	<link href="../style/admin/book/publish_list.css" type="text/css" rel="stylesheet">
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="../js/apprise.js"></script>
        <script type="text/javascript" src="../js/publisher_list.js"></script>
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
						<li id="current_left_nav"><a href="publisherlist.action">出版社管理</a></li>
					  </ul>
				</div>
				<div id="right">
					<div id="temp_nav">
						<ul>
							<li id="temp_title">出版社管理</li>
							<li id="publisher_add_label"><span onclick="addpublisher();">增加出版社</span></li>
						</ul>
					</div>
					<div id="operate_result_panel"><span id="operate_result"></span></div>
					<div id="publishers_panel">
						<ul id="publisher_list">
						    <s:iterator id="publisher" value="#request.publishers">
						    	<li class="publisher_item">
						    		<ul class="publisher_content">
						    			<li class="publisher_label"><s:property value="#publisher.publisher"/></li>
						    			<li class="modify_publisher_label">
						    				<span id="modify_button" onclick="modifypublisher('<s:property value="#publisher.publisherId"/>','<s:property value="#publisher.publisher"/>');">修改</span>
						    			</li>
						    			<li class="delete_publisher_label">
						    				<span id="delete_button" onclick="deletepublisher(this,'<s:property value="#publisher.publisherId"/>','<s:property value="#publisher.publisher"/>');">删除</span>
						    			</li>
						    		</ul>
						    	</li>
							</s:iterator>
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