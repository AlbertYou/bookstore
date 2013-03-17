<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>低库存图书-<%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link rel="stylesheet" type="text/css" href="../style/admin/book/book_lowstock.css">
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/gotop.js"></script>
    	<script type="text/javascript">
    		$(function() {
        		$("#setstockbutton").click(function() {
        			var stock = $("#safestock").val();
            		location.href="setsafestock.action?stock=" + stock;
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
					<ul id="left_nav">
						<li><a href="searchbook.action">图书管理</a></li>
						<li id="current_left_nav"><a href="lowstockbooklist.action">低库存图书</a></li>
						<li><a href="publisherlist.action">出版社管理</a></li>
					  </ul>
				</div>
				<div id="right">
					<div id="title_panel">
						<ul>
							<li id="title_label">以下是少于安全库存的图书</li>
							<li id="stock_label">安全库存为
								<input type="text" id="safestock" name="safestock" value="<s:property value="#application.safestock"/>" size="1"/>&nbsp;
								<a href="javascript::void(0);" id="setstockbutton">设置安全库存</a>
							</li>
						</ul>
					</div>
					<div id="books_panel">
						<ul id="book_list">
						    <s:iterator id="book" value="#request.books" status="status">						
								<li class="book_item">
									<ul class="book_item_panel">
										<li class="book_image_panel">
											<a href="bookinfo.action?bookId=<s:property value="#book.bookId"/>">
					    						<img src="<s:property value="#book.imageUrl"/>" height="150px"/>
					    					</a>
										</li>
										<li class="book_content_panel">
											<ul class="book_content">
												<li><a href="bookinfo.action?bookId=<s:property value="#book.bookId"/>"><s:property value="#book.name"/></a></li>
												<li>库存：<s:property value="#book.stock"/></li>
												<li><s:property value="#book.author"/>编著/<s:property value="#book.publishDate"/>/<s:property value="#book.publisher.publisher"/></li>
												<li>
													<s:if test="#book.description.length() > 100">
														<s:property value="%{#book.description.substring(0,100) }"/>...
													</s:if>
													<s:else>
														<s:property value="#book.description"/>
													</s:else>
												</li>
												<li>
													<span>进价：<s:property value="#book.bid"/></span>
													<span>定价：<s:property value="#book.originalPrice"/></span>
													<span>折扣：<s:property value="#book.discount"/></span>
													<span>销售价格：<s:property value="#book.price"/></span>
												</li>
												<li>
													<form action="modifystock.action" method="post">
					    								<input type="text" value="<s:property value="#book.stock"/>" id="stock" name="stock" size="2"/>
					    								<input type="hidden" id="bookId" name="bookId" value="<s:property value="#book.bookId"/>"/>
					    								<input type="submit" value="修改库存"/>
				    								</form>
					    							<s:if test="#book.status == 1">已下架</s:if>
					    							<s:else>
						    							<a href="downshelf.action?bookId=<s:property value="#book.bookId"/>&type=searchbook">下架</a>
					    							</s:else>
												</li>
											</ul>
										</li>
									</ul>
								</li>
							</s:iterator>
						</ul>
					</div>
					<div id="paginating">
					  <s:if test="#request.books.allRecords > 0">
							<s:if test="#request.page_index <= 1">
								<span>上一页</span>
							</s:if>
							<s:else>
								<a href="searchbook.action?key=<s:property value="#request.key"/>&page_index=<s:property value="#request.page_index - 1"/>">上一页</a>
							</s:else>
							<s:if test="#request.page_index - 3 > 0">
								<a href="searchbook.action?key=<s:property value="#request.key"/>&page_index=<s:property value="#request.page_index - 3"/>"><s:property value="#request.page_index - 3"/></a>
							</s:if>
							<s:if test="#request.page_index - 2 > 0">
								<a href="searchbook.action?key=<s:property value="#request.key"/>&page_index=<s:property value="#request.page_index - 2"/>"><s:property value="#request.page_index - 2"/></a>
							</s:if>
							<s:if test="#request.page_index - 1 > 0">
								<a href="searchbook.action?key=<s:property value="#request.key"/>&page_index=<s:property value="#request.page_index - 1"/>"><s:property value="#request.page_index - 1"/></a>
							</s:if>
							<a href="searchbook.action?key=<s:property value="#request.key"/>&page_index=<s:property value="#request.page_index"/>"><s:property value="#request.page_index"/></a>
							<s:if test="#request.page_index + 1 <= #request.books.allPages">
								<a href="searchbook.action?key=<s:property value="#request.key"/>&page_index=<s:property value="#request.page_index + 1"/>"><s:property value="#request.page_index + 1"/></a>
							</s:if>
							<s:if test="#request.page_index + 2 <= #request.books.allPages">
								<a href="searchbook.action?key=<s:property value="#request.key"/>&page_index=<s:property value="#request.page_index + 2"/>"><s:property value="#request.page_index + 2"/></a>
							</s:if>
							<s:if test="#request.page_index - 3 <= 0 && #request.page_index + 3 <= #request.books.allPages">
								<a href="searchbook.action?key=<s:property value="#request.key"/>&page_index=<s:property value="#request.page_index + 3"/>"><s:property value="#request.page_index + 3"/></a>
							</s:if>
							<s:if test="#request.page_index - 2 <= 0 && #request.page_index + 4 <= #request.books.allPages">
								<a href="searchbook.action?key=<s:property value="#request.key"/>&page_index=<s:property value="#request.page_index + 4"/>"><s:property value="#request.page_index + 4"/></a>
							</s:if>
							<s:if test="#request.page_index - 1 <= 0 && #request.page_index + 5 <= #request.books.allPages">
								<a href="searchbook.action?key=<s:property value="#request.key"/>&page_index=<s:property value="#request.page_index + 5"/>"><s:property value="#request.page_index + 5"/></a>
							</s:if>
							<s:if test="#request.books.allPages > 6 && #request.page_index < #request.books.allPages">
								<span>...</span>
							</s:if>
							<s:if test="#request.page_index == #request.books.allPages">
								<span>下一页</span>
							</s:if>
							<s:else>
								<a href="searchbook.action?key=<s:property value="#request.key"/>&page_index=<s:property value="#request.page_index + 1"/>">下一页</a>
							</s:else>&nbsp;&nbsp;
							<span>每页显示<s:property value="#request.books.recordInPage"/>条&nbsp;&nbsp;共<s:property value="#request.books.allPages"/>页</span>&nbsp;
					  </s:if>
					</div>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>

<!-- UJian Button BEGIN -->
	<script type="text/javascript" src="http://v1.ujian.cc/code/ujian.js?type=slide&icon=3"></script>
<!-- UJian Button END -->

	</body>
</html>