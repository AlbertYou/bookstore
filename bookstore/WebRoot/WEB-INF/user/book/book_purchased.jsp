<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>已购商品-<%=getServletContext().getServletContextName()%></title>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<link rel="stylesheet" type="text/css" href="../style/user/book/book_purchased.css">
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
						<div class="current_nav"><a href="purchasedbooks.action">已购商品</a></div>
						<div class="nav_item1"><a href="recipientlist.action">收货地址管理</a></div>
						<div class="nav_item1">评价管理</div>
						<div class="nav_item2"><a href="nocomment.action">待评价</a></div>
						<div class="nav_item2"><a href="allcomments.action">所有评价</a></div>
					</div>
              </div>
              <div id="right">
				<div id="temp_nav">
					<span>已购商品(${requestScope.books.allRecords }件)</span>
				</div>
				<div id="purchaseddbooks">
					<ul id="booklist">
						<s:iterator id="book" value="#request.books.list">
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
                <div id="paginating">
				  <form action="purchasedbooks.action" method="post">
					<c:if test="${requestScope.page_index >1 }">
						<span><a href="purchasedbooks.action?page_index=${requestScope.page_index - 1 }">上一页</a></span>
					</c:if>
					<c:if test="${requestScope.page_index <= 1 }">
						<span>上一页</span>
					</c:if>
					<a href="purchasedbooks.action?page_index=${requestScope.page_index }">
						${requestScope.page_index }
					</a>
					<c:if test="${requestScope.page_index < requestScope.books.allPages }">
						<span><a href="purchasedbooks.action?page_index=${requestScope.page_index + 1 }">下一页</a></span>
					</c:if>
					<c:if test="${requestScope.page_index >= requestScope.books.allPages }">
						<span>下一页</span>
					</c:if>
					<span>共${requestScope.books.allPages }页</span>
					<span>到第</span>
					<input type="text" name="page_index" size="1" value="${requestScope.page_index }"/>
					<span>页</span>
					<input type="submit" value="确定"/>
				  </form>
				</div>
			  </div>
            </div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
</body>
</html>