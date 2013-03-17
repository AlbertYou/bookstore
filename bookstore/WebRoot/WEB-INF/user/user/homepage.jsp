<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>我的主页-<%=getServletContext().getServletContextName()%></title>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<link rel="stylesheet" href="../style/user/user/homepage.css" type="text/css">
	</head>
	<body>
<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
			  <div id="left">
					<div id="nav_panel">
					<b class="b1"></b><b class="b2"></b><b class="b3"></b><b class="b4"></b> 
 					<div class="content">
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
					<b class="b5"></b><b class="b6"></b><b class="b7"></b><b class="b8"></b>
              </div>
              <div id="right">
				<div id="user_info">
					<div id="username">
						<span id="name"><s:property value="#session.container.user.username" /></span>
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
				  <div id="temp_nav">重点图书推荐</div>
				  <div id="emphasisbooks">
				  	<ul id="booklist">
						<s:iterator id="book" value="#request.books">
							<li class="book_item">
								<span class="book_image">
									<a href="book.action?bookId=<s:property value="#book.bookId"/>">
										<img alt="<s:property value="#book.name"/>" height="150px" width="110px" src="<s:property value="#book.imageUrl"/>">
									</a>
								</span>
								<span class="book_name">
									<a href="book.action?bookId=<s:property value="#book.bookId"/>">
										<s:if test="#book.name.length() > 15">
											<s:property value="%{#book.name.substring(0,13) }"/>...											
										</s:if>
										<s:else>
											<s:property value="#book.name"/>
										</s:else>
									</a>
								</span>
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