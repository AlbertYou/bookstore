<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>编辑个人档案-<%=getServletContext().getServletContextName()%></title>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
    	<link rel="stylesheet" href="../style/user/user/user_edit.css" type="text/css">
    	<script type="text/javascript">
    		function checkpsw() {
        		var psw = $("#password").val();
        		var repeatepsw = $("#repeatepsw").val();
        		if(psw != repeatepsw) {
            		alert("两次输入密码不相同");
            		return false;
        		}
        		return true;
    		}
    		$(function() {
        		var oldemail = $("#email").val();
    			$("#email").blur(function() {
        			var url = "existemail.action?email=" + $("#email").val();
            		$.ajax({
                		url: url,
                		type: "POST",
                		dataType: "text",
                		success: function(data) {
    	        			if(data == "true") {
				        		if(oldemail != $("#email").val()) {
	    	                		$("#email_error").text("邮箱已注册");
				        		}
    	        			} else {
    	                		$("#email_error").text("");
    	        			}
            			}
            		});
        		});
        		$("#editUserForm").validate({
            		rules:{
            			email: {
        					required: true,
        					email: true
        				},
        				phone: {
            				digits: true
            				rangelength: [11,11]
        				}
        			},
        			messages:{
            			email: "邮箱输入错误",
            			phone: "手机号码输入错误"
        			}
        		});
    		});
    	</script>
	</head>
	<body>
<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
			  <div id="left">
					<div id="nav_panel">
						<div class="current_nav"><a href="homepage.action">我的主页</a></div>
						<div class="nav_item1"><a href="tocart.action">我的购物车</a></div>
						<div class="nav_item1">订单管理</div>
						<div class="nav_item2"><a href="undeliveredorderlist.action">待发货</a></div>
						<div class="nav_item2"><a href="deliveredorderlist.action">待确认收货</a></div>
						<div class="nav_item2"><a href="finishedorderlist.action">交易成功</a></div>
						<div class="nav_item1"><a href="collectlist.action">我的收藏</a></div>
						<div class="nav_item1"><a href="purchasedbooks.action">已购商品</a></div>
						<div class="nav_item1"><a href="recipientlist.action">收货地址管理</a></div>
						<div class="nav_item1">评价管理</div>
						<div class="nav_item2"><a href="nocomment.action">待评价</a></div>
						<div class="nav_item2"><a href="allcomments.action">所有评价</a></div>
					</div>
              </div>
              <div id="right">
				<div id="user_info">
					<div id="username_label">
						<span id="name"><s:property value="#session.container.user.username" /></span>&nbsp;
						<a href="tomodifypsw.action">[修改密码]</a>
					</div>
					<div id="modifyinfo">
						<a href="toedituser.action">编辑个人档案</a>
					</div>
					<div id="other">
						<ul>
							<li><a href="deliveredorderlist.action">待确认订单(<s:property value="#request.deliveriedOrderCount"/>)</a></li>
							<li><a href="nocomment.action">待评价(<s:property value="#request.finishedOrdersCount"/>)</a></li>
						</ul>
					</div>
				</div>
				<div id="temp_nav">修改个人信息</div>
				<div id="edit_panel">
					<form action="edituser.action" method="post" id="editUserForm">
						<ul id="user_form">
							<li>用户名：&nbsp;
								<input type="hidden" name="userId" value="<s:property value="#session.container.user.userId"/>"/>
								<input type="hidden" name="password" value="<s:property value="#session.container.user.password"/>"/>
								<input type="text" id="username" name="username" readonly="readonly" value="<s:property value="#session.container.user.username"/>"/></li>
							<li>注册邮箱：<input type="text" id="email" name="email" value="<s:property value="#session.container.user.email"/>"/>
								<span id="email_error"><s:fielderror><s:param>email</s:param></s:fielderror></span>
							</li>
							<li>手机：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="phone" name="phone" value="<s:property value="#session.container.user.phone"/>"/>
								<span id="phone_error"><s:fielderror><s:param>email</s:param></s:fielderror></span>
							</li>
							<li>性别：&nbsp;&nbsp;&nbsp;&nbsp;
								<s:if test="#session.container.user.sex == 0">
									<input type="radio" name="sex" value="0" checked="checked"/>男&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="sex" value="1"/>女&nbsp;&nbsp;&nbsp;&nbsp;
								</s:if>
								<s:else>
									<input type="radio" name="sex" value="0"/>男&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="sex" value="1" checked="checked"/>女&nbsp;&nbsp;&nbsp;&nbsp;
								</s:else>
							</li>
							<li><input id="submit_label" type="image" src="../image/modify.gif" height="40px"/></li>
						</ul>
					</form>
				</div>
              </div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
</body>
</html>