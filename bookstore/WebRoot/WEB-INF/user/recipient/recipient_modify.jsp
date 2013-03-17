<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>收货地址管理-<%=getServletContext().getServletContextName()%></title>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<link rel="stylesheet" href="../style/user/recipient/recipient.css" type="text/css">
    	<script type="text/javascript">
    	$(function() {
    		$(".not_default_addr").mouseover(function(){
            	$(this).addClass("not_default_addr_onmove");
            	$(this).children().children(".default_label").show();
        	});
    		$(".not_default_addr").mouseout(function(){
            	$(this).removeClass("not_default_addr_onmove");
            	$(this).children().children(".default_label").hide();
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
						<div class="nav_item2"><a href="nocomment.action">待评价</a></div>
						<div class="nav_item2"><a href="allcomments.action">所有评价</a></div>
					</div>
              </div>
              <div id="right">
				<div id="temp_nav">
					<span>收货地址</span>
				</div>
				<div id="recipient_form">
					<form action="modifyrecipient.action" method="post">
						<div id="form_title">修改收货地址</div>
						<ul id="recipient_form_label">
							<li><p>收货人姓名：</p></li>
							<li><p>收货地址：</p></li>
							<li><p>邮政编码：</p></li>
							<li><p>手机号码：</p></li>
							<li><p>设为默认：</p></li>
						</ul>
						<ul id="recipient_form_input">
							<li>
								<p><input name="recipientId" type="hidden" value="<s:property value="#request.recipient.recipientId" />"/>
								<input name="recipient" type="text" value="<s:property value="#request.recipient.recipient" />"/><span class="required_warn">*</span></p></li>
							<li><textarea rows="3" cols="40" name="address"><s:property value="#request.recipient.address" /></textarea><span class="required_warn">*</span></li>
							<li><p><input name="zipcode" type="text" value="<s:property value="#request.recipient.zipcode" />"/><span class="required_warn">*</span></p></li>
							<li><p><input name="phone" type="text" value="<s:property value="#request.recipient.phone" />"/></p></li>
							<li><p>
								<s:if test="#request.recipient.defaultAddr == 1">
									<input name="defaultAddr" type="checkbox" checked="checked" value="1"/>
								</s:if>
								<s:else>
									<input name="defaultAddr" type="checkbox" value="1"/>
								</s:else></p>
							</li>
							<li><p><input type="image" src="../image/save_button.gif" height="40px"/></p></li>
						</ul>
					</form>
				</div>
				<div id="all_recipients">
						<ul class="recipient_list recipient_title">
							<li class="row1">收货人</li>
							<li class="row2">收货地址</li>
							<li class="row3">邮编</li>
							<li class="row4">手机</li>
							<li class="row5">&nbsp;</li>
							<li class="row6">操作</li>
						</ul>
					<s:if test="#request.recipients.size > 0">
						<s:iterator id="recipient" value="#request.recipients">
  						  <s:if test="#recipient.defaultAddr == 1">
							<ul class="recipient_list default_addr">
								<li class="row11"><s:property value="#recipient.recipient" /></li>
								<li class="row22"><s:property value="#recipient.address" /></li>
								<li class="row33"><s:property value="#recipient.zipcode" /></li>
								<li class="row44"><s:property value="#recipient.phone" /></li>
								<li class="row55">
								<span>默认地址</span>
								</li>
								<li class="row66">
									<a href="recipient.action?recipientId=<s:property value="#recipient.recipientId" />">修改</a>|
									<a href="deleterecipient.action?recipientId=<s:property value="#recipient.recipientId" />">删除</a>
								</li>
							</ul>
 						  </s:if>
						  <s:else>
							<ul class="recipient_list not_default_addr">
								<li class="row11"><s:property value="#recipient.recipient" /></li>
								<li class="row22"><s:property value="#recipient.address" /></li>
								<li class="row33"><s:property value="#recipient.zipcode" /></li>
								<li class="row44"><s:property value="#recipient.phone" /></li>
								<li class="row55">
									<span class="default_label"><a href="defaultrecipient.action?recipientId=<s:property value="#recipient.recipientId" />">设为默认</a></span>
								</li>
								<li class="row66">
									<a href="recipient.action?recipientId=<s:property value="#recipient.recipientId" />">修改</a>|
									<a href="deleterecipient.action?recipientId=<s:property value="#recipient.recipientId" />">删除</a>
								</li>
							</ul>
						  </s:else>
						</s:iterator>
					</s:if>
					<s:else>
						<p id="null_notice">暂无收货地址</p>
					</s:else>
				</div>
				<div id="warn_label">最多保存<s:text name="recipient.maxcount"></s:text>个有效地址</div>
              </div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
</body>
</html>