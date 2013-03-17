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
    	<link rel="stylesheet" type="text/css" href="../style/user/shopping/buy_now.css">
    	<script type="text/javascript">
    		$(function() {
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
        		/*假如没有默认收货地址，默认选择第一个收货地址*/
        		if($(".recipient_radio:checked").length < 1) {
        			$(".recipient_radio:first").attr("checked","checked");
        		}
    		});
    		function finishorder(bookId, bookCount) {
    			if($(".recipient_radio:checked").length > 0) {
	        		var recipientId = $(".recipient_li").children(":radio:checked").val();
    	    		location.href="addorder.action?bookId=" + bookId + "&bookCount=" + bookCount + "&recipientId=" + recipientId;
    			} else {
    				$("#new_addr_form").show("slow");
    			}
    		}
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
					  				&nbsp;&nbsp;<a href="defaultrecipientnow.action?recipientId=<s:property value="#recipient.recipientId"/>&bookId=${requestScope.book.bookId }&bookCount=${requestScope.bookCount }" 
					  									class="default_addr_label" style="display: none;">设为默认地址</a>
			  					</li>
			  				</s:else>
			  			</s:iterator>
			  		</ul>
	  				<div id="new_addr_label"><span id="use_addr_label">+使用新地址</span></div>
			  </div>
			  <div id="new_addr_form">
			  	<s:form action="addrecipientnow.action" method="post">
			  		<ul id="recipient_form_label">
						<li>
							<span id="new_addr_title">新增收货地址</span><span id="cancel_new_addr">[取消]</span>
							<input type="hidden" name="bookId" value="${requestScope.book.bookId }"/>
							<input type="hidden" name="bookCount" value="${requestScope.bookCount }"/>
							<p>收货人姓名：<input name="recipient" type="text"/><span class="required_warn">*</span></p>
						</li>
						<li><p>&nbsp;&nbsp;收货地址：<textarea rows="3" cols="40" name="address"/></textarea><span class="required_warn">*</span></p></li>
						<li><p>&nbsp;&nbsp;邮政编码：<input name="zipcode" type="text"/><span class="required_warn">*</span></p></li>
						<li><p>&nbsp;&nbsp;手机号码：<input name="phone" type="text"/></p></li>
						<li><p>&nbsp;&nbsp;设为默认：<input name="defaultAddr" type="checkbox" value="1"/></p></li>
						<li>
							<s:token></s:token>
							<input type="image" id="addrecipient_button" src="../image/save_button.gif" height="30px"/>
						</li>
 					</ul>
			  	</s:form>
			  </div>
			  <div id="order_info">
              	<ul id="order_title">
			  	  <li class="row1">商品名称</li>
			  	  <li class="row2">单价(元)</li>
			  	  <li class="row3">数量</li>
			  	  <li class="row4">小计(元)</li>
			    </ul>
						<ul class="order_list">
							<li class="row00">
								<input type="hidden" value="${requestScope.book.bookId }"/>
								<a href="book.action?bookId=${requestScope.book.bookId }"><img class="bookimage" src="${requestScope.book.imageUrl }" height="165px"/></a>
							</li>
							<li class="row11">
								<a href="book.action?bookId=${requestScope.book.bookId }">${requestScope.book.name }</a>
							</li>
							<li class="row22">
								￥${requestScope.book.price }
							</li>
							<li class="row33">${requestScope.bookCount }</li>
							<li class="row44">
								<fmt:formatNumber pattern="0.00" value="${requestScope.book.price * requestScope.bookCount }"></fmt:formatNumber>
							</li>
						</ul>
			  </div>
			  <div id="total_nav" onclick="finishorder('${requestScope.book.bookId }', '${requestScope.bookCount }');">
			  		<span id="submit_order_label">提交订单</span>
 			  </div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
</div>
</body>
</html>