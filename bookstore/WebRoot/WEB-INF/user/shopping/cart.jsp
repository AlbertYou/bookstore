<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>购物车-<%=getServletContext().getServletContextName()%></title>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/cart.js"></script>
    	<link rel="stylesheet" type="text/css" href="../style/user/shopping/cart.css">
	</head>
	<body>
<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
			  <div id="shoppingcart_nav">
				    我的购物车
			  </div>
			  <div id="message_panel"><s:actionmessage theme="simple"/></div>
			  <div id="shoppingcart_business_dd">
			  		<p><s:text name="system.site.name"></s:text></p>
			  </div>
			  <div id="book_list">
			  	<ul id="ui_shoppingcart_title">
			  	  <li class="row1">商品名称</li>
			  	  <li class="row2">价格</li>
			  	  <li class="row3">数量</li>
			  	  <li class="row4">操作</li>
			    </ul>
			  <s:if test="#session.container.cart.products.size > 0">
			    <s:set name="totalPrice" value="0"></s:set>
				<s:iterator id="product" value="#session.container.cart.products" status="status">
					<s:set name="totalPrice" value="#product.book.price * #product.quantity + #totalPrice"></s:set>
					<ul id="shoppingcart_list">
						<li class="row00">
							<a href="book.action?bookId=<s:property value="#product.book.bookId"/>"><img class="bookimage" src="<s:property value="#product.book.imageUrl"/>" height="165px"/></a>
						</li>
						<li class="row11">
							<a href="book.action?bookId=<s:property value="#product.book.bookId"/>"><s:property value="#product.book.name"/></a>
						</li>
						<li class="row22"><br/>
							￥<fmt:formatNumber pattern="0.00" value="${product.book.price }"></fmt:formatNumber>
							(<s:property value="#product.book.discount"/>折)
						</li>
						<li class="row33">
							<p class="modifyquantity_form">
								<input type="hidden" class="stock" value="<s:property value="#product.book.stock"/>"/>
								<input type="text" class="quantity" name="quantity" size="1" value="<s:property value="#product.quantity"/>"/>
								<input id="modifyquantity" type="button" value="修改" onclick="changequantity(this,'<s:property value="#product.productId"/>');"/>
							</p>
							<p class="modifyquantity_result">
								<span class="notice_label"></span>								
							</p>
						</li>
						<li class="row44"><br/>
							<a href="movetocollect.action?productId=<s:property value="#product.productId"/>">移入收藏</a>&nbsp;&nbsp;
							<a href="deletecart.action?productId=<s:property value="#product.productId"/>">删除</a>
						</li>
					</ul>
				</s:iterator>
			<div id="shoppingcart_total">
				<div id="clearcart"><a href="clearcart.action">清空购物车</a></div>
				<div id="total_money">商品金额总计：
					<span id="total_money_label">￥<fmt:formatNumber pattern="0.00" value="${totalPrice }"></fmt:formatNumber></span>
				</div>
				<div id="total_nav">
					<ul>
						<li id="continuebuy"><a href="index.action">
							&lt;&lt;继续购物
						</a></li>
						<li id="countorder"><a href="javascript::void(0);" id="countorder_button">结算</a></li>
					</ul>
				</div>
			</div>
			  </s:if>
			  <s:else>
			  	<div id="nullnotice">
			  		<a href="index.action">尚未购买任何商品,请先购物</a>
			  	</div>
			  </s:else>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
</body>
</html>