<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>修改密码-<%=getServletContext().getServletContextName()%></title>
    	<link rel="stylesheet" type="text/css" href="../style/user/user/password_modify.css">
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
					<div id="username">
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
				<div id="temp_nav">修改密码</div>
				<div id="psw_panel">
					<form action="modifypsw.action" method="post" id="modifyPswForm">
						<div id="message_panel">
							<s:actionmessage/>
						</div>
						<div id="oldpsw_label">
							旧密码：&nbsp;&nbsp;<input type="password" id="oldpsw" name="oldpsw"/>
							<s:fielderror><s:param>oldpsw</s:param></s:fielderror>
						</div>
						<div id="newpsw_label">
							新密码：&nbsp;&nbsp;<input type="password" id="password" name="password"/>
							<s:fielderror><s:param>password</s:param></s:fielderror>
						</div>
						<div id="repeatpsw_label">
							重复密码：<input type="password" id="repeatepsw" name="repeatepsw"/>
							<s:fielderror><s:param>repeatepsw</s:param></s:fielderror>
						</div>
						<div id="psw_button">
							<input type="image" src="../image/modify.gif" height="40px"/>
						</div>
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