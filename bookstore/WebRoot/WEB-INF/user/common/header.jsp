<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><%=getServletContext().getServletContextName()%></title>
		<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../style/user/common/header.css">
		<script type="text/javascript">
    		function searchbook() {
        		if($("#key").val() == null || $("#key").val() == "" || $("#key").val() == "请输入图书名称...") {
            		alert("请输入图书名称");
            		return false;
        		} else {
	        		return true;
        		}
    		}
    		$(function() {
        		$(".search_book_input").focus(function() {
        			if($(this).val() == "请输入图书名称...") {
	            		$(this).val("");
    	        		$(this).removeClass("search_book_input");
        			}
        		});
        		$(".search_book_input").blur(function() {
            		if($(this).val() == null || $(this).val() == "") {
	            		$(this).addClass("search_book_input");
            			$(this).val("请输入图书名称...");
            		}
        		});
    		});
    	</script>
	</head>
	<body>
		<div id="top">
			<div id="login">
				<ul>
					<li>
						<s:hidden value="#session.container.user.userId"></s:hidden>
						<s:if test="#session.container != null && #session.container.user != null && #session.container.user.userId != null">
							您好，<a href="homepage.action"><s:property value="#session.container.user.username" /></a>
							&nbsp;<a href="logout.action">退出</a>&nbsp;&nbsp;
						</s:if>
						<s:else>
							<a href="tologin.action">登录</a>/<a href="toregister.action">注册</a>&nbsp;&nbsp;
							</s:else>
					</li>
					<li>
							<a href="tocart.action">购物车</a>
					</li>
					<li>
						<a href="collectlist.action">我的收藏</a>
					</li>
				</ul>
			</div>
			<div id="logo_panel">
				<a href="index.action"><img src="../image/logo.gif" height="80px" width="200px"
					alt="<s:text name="system.site.name"></s:text>" />
				</a>
			</div>
				<form action="findbook.action" method="post" onsubmit="return searchbook();">
					<div id="search_form">
						<div class="search_icon"><img alt="图书搜索" src="../image/searchIcon.png"></div>
						<div class="input_label">
							<s:if test="#request.key != null && #request.key != ''">
								<input type="text" name="key" id="key" value="<s:property value="#request.key"/>" />
							</s:if>
							<s:else>
								<input type="text" name="key" id="key" value="请输入图书名称..." class="search_book_input"/>							
							</s:else>
						</div>
						<div class="search_button"><input type="image" src="../image/searchbook_button.gif" height="38px" /></div>
					</div>
				</form>
		</div>
	</body>
</html>