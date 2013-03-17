<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>交易成功-<%=getServletContext().getServletContextName()%></title>
    	<link rel="stylesheet" type="text/css" href="../style/user/order/order_success.css">
	</head>
	<body>
<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
			  <div id="left">
					<div id="nav_panel">
						<div class="nav_item1"><a href="homepage.action">我的主页</a></div>
						<div class="nav_item1"><a href="tocart.action">我的购物车</a></div>
						<div class="nav_item1">订单管理</div>
						<div class="nav_item2"><a href="undeliveredorderlist.action">待发货</a></div>
						<div class="current_nav"><a href="deliveredorderlist.action">待确认收货</a></div>
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
              		<div id="result_panel"><span>交易成功，感谢购买<s:text name="system.site.name"></s:text>商品</span></div>
              		<div id="temp_nav"><a href="nocomment.action">点此对本次交易进行评价</a></div>
              </div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
</body>
</html>