<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>订单查询<%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link rel="stylesheet" type="text/css" href="../style/admin/order/order_query.css">
	</head>
	<body>
		
		<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="left">
					<ul id="left_nav">
						<li><a href="ordersnew.action">新订单</a></li>
						<li id="current_left_nav"><a href="queryorder.action">订单查询</a></li>
						<li><a href="deliveredorderslist.action">已发货订单</a></li>
						<li><a href="orderslist.action">所有订单</a></li>
					</ul>
				</div>
				<div id="right">
					<div id="query_panel">
						<form action="queryorder.action">
							<span>订单查询</span>
							<input type="text" name="orderNumber" value="<s:property value="#request.orderNumber"/>">
							<input type="submit" value="查询">
						</form>
					</div>
					<div id="order_panel">
						<s:if test="#request.order != null">
							<ul class="order_title">
										<li class="ordernumber_label">订单号：<s:property value="#request.order.orderNumber"/></li>
										<li class="ordercreatetime_label">
											<s:date name="#request.order.createTime" format="yyyy-MM-dd HH:mm" id="ct"/>
											(<s:property value="#ct"/>)
										</li>
										<li class="ordercount_label">共<s:property value="#request.order.count"/>条</li>
										<li class="ordertotalprice_label">￥<s:property value="#request.order.totalPrice"/></li>
										<li class="order_status">
											<s:if test="#request.order.status == 1">未发货</s:if>
											<s:elseif test="#request.order.status == 2">已发货</s:elseif>
											<s:else>已完成交易</s:else>
										</li>
									</ul>
									<ul class="user_info">
										<li>用户名：<s:property value="#request.order.user.username"/></li>
										<li>邮箱：<s:property value="#request.order.user.email"/></li>
										<li>手机：<s:property value="#request.order.user.phone"/></li>
									</ul>
									<ul class="book_list">
											<li id="book_list_title">
												<ul class="book_detail">
													<li class="row1">&nbsp;</li>
													<li class="row2">商品名称</li>
													<li class="row3">单价</li>
													<li class="row4">数量</li>
													<li class="row5">小计</li>
												</ul>
											</li>
										<s:iterator id="orderitem" value="#request.order.orderItems">
											<li class="book_item">
												<ul class="book_detail">
													<li class="row1">
														<a href="bookinfo.action?bookId=<s:property value="#orderitem.book.bookId"/>" target="_blank">
															<img src="<s:property value="#orderitem.book.imageUrl"/>" height="100"/>
														</a>
													</li>
													<li class="row2"><br/><br/>
														<a href="bookinfo.action?bookId=<s:property value="#orderitem.book.bookId"/>" target="_blank">
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
						</s:if>
						<s:else>
							<div style="height: 300px;"></div>
						</s:else>
					</div>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>
	</body>
</html>