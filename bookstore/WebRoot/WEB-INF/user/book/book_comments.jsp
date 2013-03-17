<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>${requestScope.book.name }-<%=getServletContext().getServletContextName()%></title>
    	<link rel="stylesheet" type="text/css" href="../style/user/book/book_comments.css">
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/gotop.js"></script>
	</head>
	<body>
<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="bookinfo">
					<div id="book_show">
						<a href="book.action?bookId=<s:property value="#request.book.bookId"/>">
							<img src="<s:property value="#request.book.imageUrl"/>" height="130px" title="<s:property value="#request.book.name"/>"/>
						</a>
					</div>
					<div id="book_detail">
						<p id="book_title">
							<a href="book.action?bookId=<s:property value="#request.book.bookId"/>"><s:property value="#request.book.name"/></a>
						</p>
						<p><span id="price_label">￥<s:property value="#request.book.price"/></span>
							<s:if test="#request.book.status == 1">(已下架)</s:if>&nbsp;
							<span id="discount_label"><s:property value="#request.book.discount"/>折</span>
						</p>
						<p><s:property value="#request.book.author"/>著/<s:property value="#request.book.publisher.publisher"/>
						</p>
					</div>
				</div>
				<div id="comment_nav"><span>所有评论</span></div>
				<div id="book_comment">
					<ul id="comment_list">
						<s:iterator id="comment" value="#request.comments.list" status="status">
						<li class="comment_item">
							<ul class="comment_info">
								<li class="comment_title"><s:property value="#comment.title"/></li>
								<li class="comment_author">
									<ul>
										<li class="comment_author_label">作者：<span class="author_label"><s:property value="#comment.user.username"/></span></li>
										<li class="comment_score_label"><s:property value="#comment.score"/>分</li>
										<li class="comment_date_label">
											<s:date name="#comment.commentDate" format="yyyy-MM-dd HH:mm:ss" id="cd"/>
											<s:property value="#cd"/>
										</li>
									</ul>
								</li>
								<li class="comment_content"><s:property value="#comment.content"/></li>
 							</ul>
						</li>
						</s:iterator>
					</ul>
					<p id="comment_other_panel">
					<s:if test="#request.book.bookStatistics.commentCount == 0"><span id="nocomment_lable">暂无评论</span></s:if>
					<s:elseif test="#request.book.bookStatistics.commentCount > 5">
						<span id="seeallcomments_label"><a href="#">查看所有<s:property value="#request.book.bookStatistics.commentCount"/>条评论&gt;&gt;</a></span>
					</s:elseif>
					<s:else>
						<p>&nbsp;</p>
					</s:else>
					</p>
				</div>
				<div id="paginating">
					<c:if test="${requestScope.page_index > 1 }">
						<span><a href="commentsofbook.action?page_index=${requestScope.page_index - 1 }&bookId=<s:property value="#request.book.bookId"/>">上一页</a></span>
					</c:if>
					<c:if test="${requestScope.page_index <= 1 }">
						<span>上一页</span>
					</c:if>
					<a href="commentsofbook.action?page_index=${requestScope.page_index }&bookId=<s:property value="#request.book.bookId"/>">
						${requestScope.page_index }
					</a>
					<c:if test="${requestScope.page_index < requestScope.comments.allPages }">
						<span><a href="commentsofbook.action?page_index=${requestScope.page_index + 1 }&bookId=<s:property value="#request.book.bookId"/>">下一页</a></span>
					</c:if>
					<c:if test="${requestScope.page_index >= requestScope.comments.allPages }">
						<span>下一页</span>
					</c:if>
					<span>共${requestScope.comments.allPages }页</span>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
	</body>
</html>