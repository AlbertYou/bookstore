<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>所有订单-<%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link rel="stylesheet" type="text/css" href="../style/admin/order/order_new.css">
    	<link rel="stylesheet" type="text/css" href="../style/admin/order/order_all.css">
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/gotop.js"></script>
		<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
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
						<li><a href="queryorder.action">订单查询</a></li>
						<li><a href="deliveredorderslist.action">已发货订单</a></li>
						<li id="current_left_nav"><a href="orderslist.action">所有订单</a></li>
					</ul>
				</div>
				<div id="right">
					<div id="order_panel">
						<div id="query_panel">
							<form action="orderslist.action" method="post">
								<ul>
									<li><span>选择日期</span></li>
									<li><input id="createTime" name="createTime" type="text" value="<s:property value="#request.createTime"/>" size="10" readonly="readonly" onclick="WdatePicker();"/></li>
									<li><input id="query_button" type="image" src="../image/sure.gif"></li>
								</ul>
							</form>
						</div>
						<ul id="order_list">
							<s:iterator id="order" value="#request.orders.list">
								<li class="order_detail">
									<ul class="order_title">
										<li class="ordernumber_label">订单号：<s:property value="#order.orderNumber"/></li>
										<li class="ordercreatetime_label">
											<s:date name="#order.createTime" format="yyyy-MM-dd HH:mm" id="ct"/>
											(<s:property value="#ct"/>)
										</li>
										<li class="ordercount_label">共<s:property value="#order.count"/>条</li>
										<li class="ordertotalprice_label">￥<s:property value="#order.totalPrice"/></li>
										<li class="order_status">
											<s:if test="#request.order.status == 1">未发货</s:if>
											<s:elseif test="#request.order.status == 2">已发货</s:elseif>
											<s:else>已完成交易</s:else>
										</li>
									</ul>
									<ul class="user_info">
										<li>用户名：<s:property value="#order.user.username"/></li>
										<li>邮箱：<s:property value="#order.user.email"/></li>
										<li>手机：<s:property value="#order.user.phone"/></li>
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
										<s:set name="total" value="0"/>
										<s:iterator id="orderitem" value="#order.orderItems">
											<li>
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
														<s:set name="total" value="#total + #orderitem.price * #orderitem.quantity"></s:set>
													</li>
												</ul>
											</li>
										</s:iterator>
									</ul>
								</li>
							</s:iterator>
						</ul>
					</div>
				<div id="paginating">
				  <form action="orderslist.action" method="post">
					<c:if test="${requestScope.page_index >1 }">
						<span><a href="orderslist.action?page_index=${requestScope.page_index - 1 }&createTime=<s:property value="#request.createTime"/>">上一页</a></span>
					</c:if>
					<c:if test="${requestScope.page_index <= 1 }">
						<span>上一页</span>
					</c:if>
					<a href="orderslist.action?page_index=${requestScope.page_index }&createTime=<s:property value="#request.createTime"/>">
						${requestScope.page_index }
					</a>
					<c:if test="${requestScope.page_index < requestScope.orders.allPages }">
						<span><a href="orderslist.action?page_index=${requestScope.page_index + 1 }&createTime=<s:property value="#request.createTime"/>">下一页</a></span>
					</c:if>
					<c:if test="${requestScope.page_index >= requestScope.orders.allPages }">
						<span>下一页</span>
					</c:if>
					<span>${requestScope.orders.recordInPage }条/页</span>
					<span>共${requestScope.orders.allRecords }条</span>
					<span>共${requestScope.orders.allPages }页</span>
					<span>到第</span>
					<input type="text" name="page_index" size="1" value="${requestScope.page_index }"/>
					<span>页</span>
					<input type="submit" value="确定"/>
				  </form>
				</div>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>

<!-- UJian Button BEGIN -->
	<script type="text/javascript" src="http://v1.ujian.cc/code/ujian.js?type=slide&icon=3"></script>
<!-- UJian Button END -->

	</body>
</html>