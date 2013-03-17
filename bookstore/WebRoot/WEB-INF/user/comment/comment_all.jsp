<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>所有评价-<%=getServletContext().getServletContextName()%></title>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/gotop.js"></script>
    	<link rel="stylesheet" type="text/css" href="../style/user/comment/comment_all.css">
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
						<div class="current_nav"><a href="allcomments.action">所有评价</a></div>
					</div>
              </div>
              <div id="right">
				<div id="title_panel">
					<span>所有评论</span>
				</div>
				<div id="comment_panel">
					<ul id="comment_list">
						<li class="comment_item">
							<ul class="comment_title_panel">
								<li class="book_info">图书信息</li>
								<li class="comment_title_score">评分</li>
								<li class="comment_title_content">评论</li>
							</ul>
						</li>
						<li class="comment_item">
							<s:iterator id="comment" value="#request.comments.list">
								<ul class="comment_info">
									<li class="book_image">
										<a href="book.action?bookId=<s:property value="#comment.book.bookId"/>">
											<img alt="<s:property value="#comment.book.name"/>" src="<s:property value="#comment.book.imageUrl"/>" height="80px" title="<s:property value="#comment.book.name"/>"/>
										</a>
									</li>
									<li class="book_other">
										<p class="book_name">
											<a href="book.action?bookId=<s:property value="#comment.book.bookId"/>">
												<s:property value="#comment.book.name"/>
											</a>
										</p>
										<p class="book_price">￥<s:property value="#comment.book.price"/></p>
									</li>
									<li class="comment_score"><s:property value="#comment.score"/></li>
									<li class="comment_content">
										<ul class="comment_title_ul">
											<li class="comment_title">
												<s:property value="#comment.title"/>
											</li>
											<li class="comment_time">
												<s:date id="cd" name="#comment.commentDate" format="yyyy-MM-dd HH:mm"/>									
													<s:property value="#cd"/>											
											</li>
										</ul>
										<p class="comment"><s:property value="#comment.content"/></p>
									</li>
								</ul>
							</s:iterator>
						</li>
					</ul>
				</div>
				<div id="paginating">
					<c:if test="${requestScope.page_index > 1 }">
						<span><a href="allcomments.action?page_index=${requestScope.page_index - 1 }">上一页</a></span>
					</c:if>
					<c:if test="${requestScope.page_index <= 1 }">
						<span>上一页</span>
					</c:if>
					<a href="allcomments.action?page_index=${requestScope.page_index }">
						${requestScope.page_index }
					</a>
					<c:if test="${requestScope.page_index < requestScope.comments.allPages }">
						<span><a href="allcomments.action?page_index=${requestScope.page_index + 1 }">下一页</a></span>
					</c:if>
					<c:if test="${requestScope.page_index >= requestScope.comments.allPages }">
						<span>下一页</span>
					</c:if>
					<span>共${requestScope.comments.allPages }页</span>
				</div>
              </div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
</body>
</html>