<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>待确认订单-<%=getServletContext().getServletContextName()%></title>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/gotop.js"></script>
    	<link rel="stylesheet" type="text/css" href="../style/user/order/order_delivered.css">
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
				<div id="temp_nav">
					<span id="order_total">待确认订单(<s:property value="#request.orders.size"/>笔)</span>
					<span id="order_sort">按发货时间升序排列</span>
				</div>
				<div id="orders">
					<ul id="orderlist">
							<s:iterator id="order" value="#request.orders">
								<li class="order_detail">
									<ul class="order_title">
										<li class="ordernumber_label">订单号：<s:property value="#order.orderNumber"/></li>
										<li class="confirmorder_label"><a href="receivebook.action?orderId=<s:property value="#order.orderId"/>">确认收货</a></li>
									</ul>
									<ul class="ordertime_label">
										<li class="ordercreatetime_label">
											购买时间：
											<s:date name="#order.createTime" format="yyyy-MM-dd" id="ct"/>
											<s:property value="#ct"/>
										</li>
										<li class="orderdeliveriedtime_label">
											发货时间：
											<s:date name="#order.deliveryTime" format="yyyy-MM-dd" id="dt"/>
											<s:property value="#dt"/>
										</li>
										<li class="ordertotalprice_label">￥<s:property value="#order.totalPrice"/></li>
									</ul>
									<ul class="book_list">
											<li>
												<ul class="book_detail">
													<li class="row1">&nbsp;</li>
													<li class="row2">商品名称</li>
													<li class="row3">单价</li>
													<li class="row4">数量</li>
													<li class="row5">小计</li>
												</ul>
											</li>
										<s:iterator id="orderitem" value="#order.orderItems">
											<li>
												<ul class="book_detail">
													<li class="row1">
														<a href="book.action?bookId=<s:property value="#orderitem.book.bookId"/>" target="_blank">
															<img src="<s:property value="#orderitem.book.imageUrl"/>" height="100"/>
														</a>
													</li>
													<li class="row2"><br/><br/>
														<a href="book.action?bookId=<s:property value="#orderitem.book.bookId"/>" target="_blank">
															<s:property value="#orderitem.book.name"/>
														</a>
													</li>
													<li class="row3"><br/><br/><s:property value="#orderitem.price"/></li>
													<li class="row4"><br/><br/><s:property value="#orderitem.quantity"/></li>
													<li class="row5"><br/><br/>
														<fmt:formatNumber pattern="0.00" value="${orderitem.price * orderitem.quantity}"></fmt:formatNumber>
													</li>
												</ul>
											</li>
										</s:iterator>
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