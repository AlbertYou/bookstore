<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title><%=getServletContext().getServletContextName()%>-尤氏集团旗下网上购书中心</title>
		<link rel="stylesheet" type="text/css" href="../style/user/index.css">
		<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
		<script type="text/javascript" src="../js/gotop.js"></script>
	</head>
	<body>
<div id="page">
			<div id="header">
				<s:include value="common/header.jsp"></s:include>
			</div>
			<div id="content">
			  <div id="left">
                <div id="category_panel">
                	<s:include value="common/category.jsp"></s:include>
                </div>
                <div id="billboard_panel">
                	<div id="billboard_title">公告</div>
              		<ul id="billboard_list">
						<c:forEach var="b" items="${requestScope.billboards}">
							<li class="billboard_item">
								<a href="billboard.action?billboardId=${b.billboardId }">${b.title }</a>
							</li>
						</c:forEach>
             		</ul>
	              </div>
              </div>
              <div id="right">
                <div id="newbook">
					<ul class="part_title">
						<li class="part_left">新书上架</li>
						<li class="part_right"><a href="newbooklist.action">更多&gt;&gt;</a></li>
					</ul>
					<ul class="book_list">
						<s:iterator id="newBook" value="#request.newBooks" status="status">
							<li class="book_item">
								<ul class="book_info">
									<li><a href="book.action?bookId=<s:property value="#newBook.bookId"/>"><img src="<s:property value="#newBook.imageUrl"/>" height="150px" width="120px"/></a></li>
									<li>
										<a href="book.action?bookId=<s:property value="#newBook.bookId"/>">
										<s:if test="#newBook.name.length() > 16">
												<s:property value="%{#newBook.name.substring(0,13) }"/>...
										</s:if>
										<s:else>
												<s:property value="#newBook.name"/>
										</s:else>
										</a>
									</li>
									<li>
										<span class="price_label">￥<s:property value="#newBook.price"/></span>
										<span class="originalprice_label">￥<s:property value="#newBook.originalPrice"/></span>
									</li>
								</ul>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div id="goodbook">
					<ul class="part_title">
						<li class="part_left">好书推荐</li>
						<li class="part_right"><a href="goodbooklist.action">更多&gt;&gt;</a></li>
					</ul>
					<ul class="book_list">
						<s:iterator id="goodBook" value="#request.goodBooks" status="status">
							<li class="book_item">
								<ul class="book_info">
									<li><a href="book.action?bookId=<s:property value="#goodBook.bookId"/>"><img src="<s:property value="#goodBook.imageUrl"/>" height="150px" width="120px"/></a></li>
									<li>
										<a href="book.action?bookId=<s:property value="#goodBook.bookId"/>">
										<s:if test="#goodBook.name.length() > 19">
												<s:property value="%{#goodBook.name.substring(0,16) }"/>...
										</s:if>
										<s:else>
												<s:property value="#goodBook.name"/>
										</s:else>
										</a>
									</li>
									<li>
										<span class="price_label">￥<s:property value="#goodBook.price"/></span>
										<span class="originalprice_label">￥<s:property value="#goodBook.originalPrice"/></span>
									</li>
								</ul>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div id="booombook">
					<ul class="part_title">
						<li class="part_left">畅销书</li>
						<li class="part_right"><a href="bestsellbooklist.action">更多&gt;&gt;</a></li>
					</ul>
					<ul class="book_list">
						<s:iterator id="bestSellBook" value="#request.bestSellBooks" status="status">
							<li class="book_item">
								<ul class="book_info">
									<li><a href="book.action?bookId=<s:property value="#bestSellBook.bookId"/>"><img src="<s:property value="#bestSellBook.imageUrl"/>" height="150px" width="120px"/></a></li>
									<li>
										<a href="book.action?bookId=<s:property value="#bestSellBook.bookId"/>">
										<s:if test="#bestSellBook.name.length() > 18">
												<s:property value="%{#bestSellBook.name.substring(0,16) }"/>...
										</s:if>
										<s:else>
												<s:property value="#bestSellBook.name"/>
										</s:else>
										</a>
									</li>
									<li>
										<span class="price_label">￥<s:property value="#bestSellBook.price"/></span>
										<span class="originalprice_label">￥<s:property value="#bestSellBook.originalPrice"/></span></li>
								</ul>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div id="arrangebook">
					<ul class="part_title">
						<li class="part_left">排行榜</li>
						<li class="part_right"><a href="bestsalebookList.action">更多&gt;&gt;</a></li>
					</ul>
					<ul class="book_list">
						<s:iterator id="mostSellBook" value="#request.mostSellBooks" status="status">
							<li class="book_item">
								<ul class="book_info">
									<li><a href="book.action?bookId=<s:property value="#mostSellBook.bookId"/>"><img src="<s:property value="#mostSellBook.imageUrl"/>" height="150px" width="120px"/></a></li>
									
									<li>
										<a href="book.action?bookId=<s:property value="#mostSellBook.bookId"/>">
										<s:if test="#mostSellBook.name.length() > 18">
												<s:property value="%{#mostSellBook.name.substring(0,16) }"/>...
										</s:if>
										<s:else>
												<s:property value="#mostSellBook.name"/>
										</s:else>
										</a>
									</li>
									<li>
										<span class="price_label">￥<s:property value="#mostSellBook.price"/></span>
										<span class="originalprice_label">￥<s:property value="#mostSellBook.originalPrice"/></span></li>
								</ul>
							</li>
						</s:iterator>
					</ul>
				</div>
              </div>
			</div>
			<div id="footer">
				<s:include value="common/footer.jsp"></s:include>
			</div>
		</div>
		
<!-- JiaThis Button BEGIN -->
<script type="text/javascript" >
	var jiathis_config={
		url:"http://t.cn/zOErWV5",
		summary:"  2012年5月15日正式上线",
		pic:"http://localhost:8080/bs/image/logo.gif",
		showClose:false,
		hideMore:false
	}
</script>
<script type="text/javascript" src="http://v2.jiathis.com/code/jiathis_r.js?btn=r3.gif" charset="utf-8"></script>
<!-- JiaThis Button END -->

<!-- UJian Button BEGIN -->
<!-- 
	<script type="text/javascript" src="http://v1.ujian.cc/code/ujian.js?type=slide&icon=3"></script>
 -->
<!-- UJian Button END -->

		
</body>
</html>