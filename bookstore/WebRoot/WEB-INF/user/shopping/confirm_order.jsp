<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>确认订单信息-<%=getServletContext().getServletContextName()%></title>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<link rel="stylesheet" type="text/css" href="../style/user/shopping/confirm_order.css">
    	<script type="text/javascript">
    		$(function() {
    			/*假如没有默认收货地址，默认选择第一个收货地址*/
        		if($(".recipient_radio:checked").length < 1) {
        			$(".recipient_radio:first").attr("checked","checked");
        		}
        		$(".recipient_li").mouseover(function() {
            		$(this).addClass("recipient_mouseover");
            		$(this).children(".default_addr_label").show();
        		});
        		$(".recipient_li").mouseout(function() {
            		$(this).removeClass("recipient_mouseover");
            		$(this).children(".default_addr_label").hide();
        		});
        		$(".recipient_li").click(function() {
            		$(this).addClass("selected_addr");
            		$(this).children(":radio").attr("checked", "checked");
            		$(this).siblings().removeClass("selected_addr");
            		$(this).parent().children().children(".use_addr_notice").empty();
            		$(this).children(":radio").before("<span class='use_addr_notice'>寄送至</span>");
        		});
        		$("#use_addr_label").click(function() {
            		$("#new_addr_form").show("slow");
        		});
        		$("#cancel_new_addr").click(function() {
            		$("#new_addr_form").hide("slow");
        		});
        		$("#finishorder").click(function() {
        			if($(".recipient_radio:checked").length > 0) {
	            		var recipientId = $(".recipient_li").children(":radio:checked").val();
    	        		location.href="finishorder.action?recipientId=" + recipientId;
        			} else {
        				$("#new_addr_form").show("slow");
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
			  <div id="shoppingcart_nav">
				    确认订单信息
			  </div>
			  <div id="breadcrumb">
			  	  <span id="title_left">确认收货地址</span>
			  	  <span id="title_right"><a href="recipientlist.action">管理收货地址</a></span>
			  </div>
			  <div id="recipient_list">
			  		<ul id="recipient_ul">
			  			<s:iterator id="recipient" value="#request.recipients">
			  				<s:if test="#recipient.defaultAddr == 1">
					  			<li class="recipient_li selected_addr">
					  				<span class="use_addr_notice">寄送至</span>
					  				<input name="recipientId" class="recipient_radio" type="radio" value="<s:property value="#recipient.recipientId"/>" checked="checked">
					  				<span><s:property value="#recipient.address"/>(<s:property value="#recipient.recipient"/>&nbsp;收)<s:property value="#recipient.phone"/></span>
					  				&nbsp;&nbsp;<span>默认地址</span>
					  			</li>
			  				</s:if>
			  				<s:else>
			  					<li class="recipient_li">
					  				<input name="recipientId" class="recipient_radio" type="radio" value="<s:property value="#recipient.recipientId"/>">
					  				<span><s:property value="#recipient.address"/>(<s:property value="#recipient.recipient"/>&nbsp;收)<s:property value="#recipient.phone"/></span>
					  				&nbsp;&nbsp;<a href="defaultrecipient.action?recipientId=<s:property value="#recipient.recipientId"/>&type=confirmorder" 
					  									class="default_addr_label" style="display: none;">设为默认地址</a>
			  					</li>
			  				</s:else>
			  			</s:iterator>
			  		</ul>
	  				<div id="new_addr_label"><span id="use_addr_label">使用新地址</span></div>
			  </div>
			  <div id="new_addr_form">
			  	<form action="addrecipient.action" method="post">
			  		<ul id="recipient_form_label">
						<li>
							<span id="new_addr_title">新增收货地址</span><span id="cancel_new_addr">[取消]</span>
							<input type="hidden" name="type" value="confirmorder"/>
							<p>收货人姓名：<input name="recipient" type="text"/><span class="required_warn">*</span></p>
						</li>
						<li><p>收货地址：<textarea rows="3" cols="40" name="address"/></textarea><span class="required_warn">*</span></p></li>
						<li><p>邮政编码：<input name="zipcode" type="text"/><span class="required_warn">*</span></p></li>
						<li><p>手机号码：<input name="phone" type="text"/></p></li>
						<li><p>设为默认：<input name="defaultAddr" type="checkbox" value="1"/></p></li>
						<li><input type="image" id="addrecipient_button" src="../image/save_button.gif" height="30px"/></li>
 					</ul>
			  	</form>
			  </div>
			  <div id="order_info">
              	<ul id="order_title">
			  	  <li class="row1">商品名称</li>
			  	  <li class="row2">单价(元)</li>
			  	  <li class="row3">数量</li>
			  	  <li class="row4">小计(元)</li>
			    </ul>
					<c:forEach var="product" items="${sessionScope.container.cart.products }">
						<ul class="order_list">
							<li class="row00">
								<input type="hidden" value="${product.book.bookId }"/>
								<a href="book.action?bookId=${product.book.bookId }"><img class="bookimage" src="${product.book.imageUrl }" height="165px"/></a>
							</li>
							<li class="row11">
								<a href="book.action?bookId=${product.book.bookId }">${product.book.name }</a>
							</li>
							<li class="row22">
								￥<fmt:formatNumber pattern="0.00" value="${product.book.price }"></fmt:formatNumber>
							</li>
							<li class="row33">${product.quantity }</li>
							<li class="row44">
								<c:set var="totalPrice" value="${totalPrice + product.book.price * product.quantity }"></c:set>
								<fmt:formatNumber pattern="0.00" value="${product.book.price * product.quantity }"></fmt:formatNumber>
							</li>
						</ul>
					</c:forEach>
			  </div>
			  <div id="total_money">商品金额总计：<span id="total_money_label">￥<fmt:formatNumber pattern="0.00" value="${totalPrice }"></fmt:formatNumber></span></div>
			  <div id="total_nav">
					<ul>
						<li><a href="tocart.action">&lt;&lt;返回购物车</a></li>
						<li><a href="javascript:void(0);" id="finishorder">提交订单</a></li>
					</ul>
 			  </div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
</div>
</body>
</html>