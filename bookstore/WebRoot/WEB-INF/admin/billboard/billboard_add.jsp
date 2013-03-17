<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加公告-<%=getServletContext().getServletContextName()%></title>
		<link type="text/css" rel="stylesheet" href="../style/admin/common/header.css"/>
		<link rel="stylesheet" type="text/css" href="../style/admin/billboard/billboard_add.css">
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
				  <form action="addbillboard.action" method="post">
					<div id="temp_nav">
						新增公告
					</div>
					<div id="billboard_title">
                		公告标题：
                		<input type="text" id="title" name="title" size="60"/>
               		</div>
               		<div id="billboard_content_panel">
                		公告内容：
               		 	<p id="billboard_content_p">
               		 		<textarea rows="20" cols="55" id="billboard_content" name="content"></textarea>
               		 	</p>
                	</div>
                	<div id="billboard_submit">
                		<input type="submit" value="添加"/>
                	</div>
				  </form>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>
	</body>
</html>