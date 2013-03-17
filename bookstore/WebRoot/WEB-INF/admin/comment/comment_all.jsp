<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>所有评论-<%=getServletContext().getServletContextName()%></title>
    	<link rel="stylesheet" type="text/css" href="../style/admin/comment/comment_today.css">
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/gotop.js"></script>
    	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
	</head>
	<body onload="init();">
		<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="left">
					<ul id="left_nav">
						<li><a href="todaycomments.action">今日评论</a></li>
						<li><a href="lowscorecomments.action">低分评论</a></li>
						<li id="current_left_nav"><a href="querycomments.action">所有评论</a></li>
					 </ul>
				</div>
				<div id="right">
					<div id="temp_nav">
						<form action="querycomments.action" method="post">
						<span>选择评论日期</span>
							<input type="text" id="commentDate" name="commentDate" value="<s:property value="#request.commentDate"/>" readonly="readonly" size="9" onclick="WdatePicker();">
							<input type="submit" value="查询">
						</form>
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
									<li class="book_iamge">
										<a href="bookinfo.action?bookId=<s:property value="#comment.book.bookId"/>">
											<img alt="<s:property value="#comment.book.name"/>" src="<s:property value="#comment.book.imageUrl"/>" height="80px"/>
										</a>
									</li>
									<li class="book_other">
										<p class="book_name">
											<a href="bookinfo.action?bookId=<s:property value="#comment.book.bookId"/>">
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
						<span><a href="querycomments.action?page_index=${requestScope.page_index - 1 }&commentDate=<s:property value="#request.commentDate"/>">上一页</a></span>
					  </c:if>
					  <c:if test="${requestScope.page_index <= 1 }">
						<span>上一页</span>
					  </c:if>
					  <a href="querycomments.actionpage_index=${requestScope.page_index }&commentDate=<s:property value="#request.commentDate"/>">
						${requestScope.page_index }
					  </a>
					  <c:if test="${requestScope.page_index < requestScope.comments.allPages }">
						<span><a href="querycomments.action?page_index=${requestScope.page_index + 1 }&commentDate=<s:property value="#request.commentDate"/>">下一页</a></span>
					  </c:if>
					  <c:if test="${requestScope.page_index >= requestScope.comments.allPages }">
						<span>下一页</span>
					  </c:if>
					</div>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>
	</body>
</html>