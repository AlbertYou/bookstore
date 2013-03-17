<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>好书推荐-<%=getServletContext().getServletContextName()%></title>
    	<link rel="stylesheet" type="text/css" href="../style/user/book/book_new.css">
    	<link rel="stylesheet" type="text/css" href="../style/page.css" media="all" />
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/gotop.js"></script>
	</head>
	<body>
<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
			  <div id="breadcrumb">
				好书推荐
			  </div>
				<div id="book_list">
					<ul id="books">
						<s:iterator id="book" value="#request.books.list" status="status">
							<li class="listitem">
								<div class="listitem_pic">
									<a href="book.action?bookId=<s:property value="#book.bookId"/>"><img src="<s:property value="#book.imageUrl"/>" height="165px"/></a>
								</div>
								<div class="listitem_detail">
									<ul class="tiplist">
										<li><a href="book.action?bookId=<s:property value="#book.bookId"/>"><s:property value="#book.name"/></a></li>
										<li><p></p></li>
										<li>
											<s:if test="#book.bookStatistics.avgCommentScore > 0">
												<s:property value="#book.bookStatistics.avgCommentScore"/>分
												(<s:property value="#book.bookStatistics.commentCount"/>条评论)
											</s:if>
											<s:else>暂无评论</s:else>
										</li>
										<li><s:property value="#book.author"/>&nbsp;编著/
											<s:date name="#book.publishDate" format="yyyy-MM-dd" id="publishdate"/>
											<s:property value="#publishdate"/>/<s:property value="#book.publisher.publisher"/></li>
										<li><p>
											<s:if test="#book.description.length() > 100">
												<s:property value="%{#book.description.substring(0,100) }"/>...											
											</s:if>
											<s:else>
												<s:property value="#book.description"/>
											</s:else>
										</p></li>
										<li class="operate_panel">
											<span class="price_label">￥<s:property value="#book.price"/></span>
											<span class="originalprice_label">￥<s:property value="#book.originalPrice"/></span>
											<span class="discount_label">折扣：<s:property value="#book.discount"/>折</span>&nbsp;&nbsp;&nbsp;
											<span><a href="addcollect.action?bookId=<s:property value="#book.bookId"/>">
												<img alt="收藏" src="../image/collect_button.gif" height="30px">
											</a></span>
											<span><a href="addcart.action?bookId=<s:property value="#book.bookId"/>" target="_blank">
												<img alt="加入购物车" src="../image/addtocart.gif" height="30px">												
											</a></span>
										</li>
									</ul>
								</div>
							</li>
						</s:iterator>
					</ul>
				</div>
 				<div id="pagepanel">
				  <s:if test="#request.books.allRecords > 0">
					<s:if test="#request.page_index <= 1">
						<span>上一页</span>
					</s:if>
					<s:else>
						<a href="goodbooklist.action?page_index=<s:property value="#request.page_index - 1"/>">上一页</a>
					</s:else>
					
					<s:if test="#request.page_index - 3 > 0">
						<a href="goodbooklist.action?page_index=<s:property value="#request.page_index - 3"/>"><s:property value="#request.page_index - 3"/></a>
					</s:if>
					<s:if test="#request.page_index - 2 > 0">
						<a href="goodbooklist.action?page_index=<s:property value="#request.page_index - 2"/>"><s:property value="#request.page_index - 2"/></a>
					</s:if>
					<s:if test="#request.page_index - 1 > 0">
						<a href="goodbooklist.action?page_index=<s:property value="#request.page_index - 1"/>"><s:property value="#request.page_index - 1"/></a>
					</s:if>
					<a href="goodbooklist.action?page_index=<s:property value="#request.page_index"/>"><s:property value="#request.page_index"/></a>
					<s:if test="#request.page_index + 1 <= #request.books.allPages">
						<a href="goodbooklist.action?page_index=<s:property value="#request.page_index + 1"/>"><s:property value="#request.page_index + 1"/></a>
					</s:if>
					<s:if test="#request.page_index + 2 <= #request.books.allPages">
						<a href="goodbooklist.action?page_index=<s:property value="#request.page_index + 2"/>"><s:property value="#request.page_index + 2"/></a>
					</s:if>
					<s:if test="#request.page_index - 3 <= 0 && #request.page_index + 3 <= #request.books.allPages">
						<a href="goodbooklist.action?page_index=<s:property value="#request.page_index + 3"/>"><s:property value="#request.page_index + 3"/></a>
					</s:if>
					<s:if test="#request.page_index - 2 <= 0 && #request.page_index + 4 <= #request.books.allPages">
						<a href="goodbooklist.action?page_index=<s:property value="#request.page_index + 4"/>"><s:property value="#request.page_index + 4"/></a>
					</s:if>
					<s:if test="#request.page_index - 1 <= 0 && #request.page_index + 5 <= #request.books.allPages">
						<a href="goodbooklist.action?page_index=<s:property value="#request.page_index + 5"/>"><s:property value="#request.page_index + 5"/></a>
					</s:if>
					<s:if test="#request.books.allPages > 6 && #request.page_index < #request.books.allPages">
						<span>...</span>
					</s:if>
					<s:if test="#request.page_index == #request.books.allPages">
						<span>下一页</span>
					</s:if>
					<s:else>
						<a href="goodbooklist.action?page_index=<s:property value="#request.page_index + 1"/>">下一页</a>
					</s:else>&nbsp;&nbsp;
					<span>共<s:property value="#request.books.allPages"/>页</span>&nbsp;
					<span>到第</span>
					<input type="text" id="jumpto" name="jumpto" value="<s:property value="#request.page_index"/>" size="3"/>
					<span>页</span>
					<span onclick="gotoPage();" style="cursor:pointer;color:orange;">确定</span>
				  </s:if>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
</body>
</html>