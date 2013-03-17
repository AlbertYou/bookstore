<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>添加评论-<%=getServletContext().getServletContextName()%></title>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<link rel="stylesheet" type="text/css" href="../style/user/comment/comment_add.css">
	</head>
	<body>
<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
			  <div id="shoppingcart_business_dd">
			  		<p>商品评价</p>
			  </div>
			  <div id="book_info">
			  	  <ul>
			  	  	<li id="book_image">
			  	  		<a href="book.action?bookId=<s:property value="#request.orderItem.book.bookId"/>">
			  	  			<img alt="<s:property value="#request.orderItem.book.name"/>" src="<s:property value="#request.orderItem.book.imageUrl"/>" height="300px" title="<s:property value="#request.orderItem.book.name"/>" />
			  	  		</a>
			  	  	</li>
			  	  	<li id="book_name">
			  			<a href="book.action?bookId=<s:property value="#request.orderItem.book.bookId"/>"><s:property value="#request.orderItem.book.name"/></a>			  	  		
			  	  	</li>
			  	  </ul>
			  </div>
			  <div id="comment_form">
   	  	  	      <div id="comment_title"><span>对本次交易进行评价</span></div>
			  	  <form action="addcomment.action" method="post">
			  	  		<ul>
			  	  			<li class="form_item_name">商品评分：
			  	  			</li>
			  	  			<li class="form_item_value">
			  	  				<input type="hidden" name="itemId" value="<s:property value="#request.orderItem.itemId"/>"/>
			  	  				<input type="hidden" name="user.userId" value="<s:property value="#session.container.user.userId"/>"/>
			  	  				<input type="hidden" name="book.bookId" value="<s:property value="#request.orderItem.book.bookId"/>"/>
			  	  				<input name="score" type="radio" value="1">1分
			  	  				<input name="score" type="radio" value="2">2分
			  	  				<input name="score" type="radio" value="3">3分
			  	  				<input name="score" type="radio" value="4">4分
			  	  				<input name="score" type="radio" value="5" checked="checked">5分
			  	  			</li>
			  	  			<li class="form_item_name">评论标题：</li>
			  	  			<li class="form_item_value">
			  	  				<input type="text" name="title" size="40">
			  	  			</li>
			  	  			<li class="form_item_name">评论内容：</li>
			  	  			<li class="form_item_value">
			  	  				<textarea rows="10" cols="45" name="content"></textarea>
			  	  			</li>
			  	  			<li id="form_submit">
			  	  				<input type="image" src="../image/submitcomment_button.gif" height="40px">
			  	  			</li>
			  	  		</ul>
			  	  </form>
			  </div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
</body>
</html>