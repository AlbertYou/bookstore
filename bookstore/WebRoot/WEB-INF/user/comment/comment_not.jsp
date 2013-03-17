<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>待评价-<%=getServletContext().getServletContextName()%></title>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/gotop.js"></script>
    	<link rel="stylesheet" type="text/css" href="../style/user/comment/comment_not.css">
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
						<div class="nav_item2"><a href="deliveredorderlist.action">待确认收货</a></div>
						<div class="nav_item2"><a href="finishedorderlist.action">交易成功</a></div>
						<div class="nav_item1"><a href="collectlist.action">我的收藏</a></div>
						<div class="nav_item1"><a href="purchasedbooks.action">已购商品</a></div>
						<div class="nav_item1"><a href="recipientlist.action">收货地址管理</a></div>
						<div class="nav_item1">评价管理</div>
						<div class="current_nav"><a href="nocomment.action">待评价</a></div>
						<div class="nav_item2"><a href="allcomments.action">所有评价</a></div>
					</div>
              </div>
              <div id="right">
				<div id="title_panel">
					<span>待评价商品</span>
				</div>
				<div id="book_panel">
					<ul id="book_list">
						<s:iterator id="orderitem" value="#request.orderItems">
							<li class="book_item">
								<ul class="order_title">
									<li class="order_number">订单号：<s:property value="#orderitem.order.orderNumber"/></li>
									<li class="order_time">购买时间：
										<s:date id="ct" name="#orderitem.order.createTime" format="yyyy-MM-dd HH:mm"/>
										<s:property value="#ct"/>
									</li>
								</ul>
								<ul class="book_info">
									<li class="row1">
										<a href="book.action?bookId=<s:property value="#orderitem.book.bookId"/>">
											<img src="<s:property value="#orderitem.book.imageUrl"/>" width="60px" title="<s:property value="#orderitem.book.name"/>"/>
										</a>
									</li>
									<li class="row2">
										<a href="book.action?bookId=<s:property value="#orderitem.book.bookId"/>">
											<s:property value="#orderitem.book.name"/>
										</a>
									</li>
									<li class="row3">￥<s:property value="#orderitem.price"/></li>
									<li class="row4"><s:property value="#orderitem.quantity"/></li>
									<li class="row5"><a href="toaddcomment.action?itemId=<s:property value="#orderitem.itemId"/>">
										<img alt="评价" title="评价" src="../image/comment_button.gif" height="30px">
									</a></li>
								</ul>
							</li>
						</s:iterator>
					</ul>
				</div>
              </div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
</body>
</html>