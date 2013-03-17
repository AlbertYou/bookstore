<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>${requestScope.book.name }-<%=getServletContext().getServletContextName()%></title>
    	<link rel="stylesheet" type="text/css" href="../style/user/book/book_info.css">
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
    	<script type="text/javascript">
    		function showcomment() {
        		$("#book_description").hide();
        		$("#book_comment").show()
        		$("#comment_nav").addClass("current_nav");
        		$("#description_nav").removeClass("current_nav");
    		}
    		function showdescription() {
        		$("#book_description").show();
        		$("#book_comment").hide();
        		$("#description_nav").addClass("current_nav");
        		$("#comment_nav").removeClass("current_nav");
    		}
    		/*	$(function() {        		
        		$("#buyForm").validate( {
            		rules: {
        				bookCount: "number"
        			},
        			messages: {
        				bookCount: "请输入正确的数量"
        			}
        		});
    		});
    		*/
    		function checkstock(stock) {
    			/*
        		$("#buyForm").validate( {
            		rules: {
        				bookCount: "number";
        			},
        			message: {
        				bookCount: "请输入正确的数量";
        			}
        		});
*/
            	var bookcount = $("#bookCount").val();
        		var b = new Number(bookcount);
        		var s = new Number(stock);
        		if(b<1) {
            		alert("请输入正确的数量");
            		return false;
        		}
        		if(b > s) {
            		alert("库存不够");
            		return false;
        		}
        		return true;
    		}
    	</script>
	</head>
	<body>
<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="bookinfo">
					<div id="book_show">
						<img src="<s:property value="#request.book.imageUrl"/>" id="bookImage" height="350px" width="270px"/>
							<p id="collectcount_label">
								收藏人气：<s:property value="#request.book.bookStatistics.collectCount"/>
							</p>
							<p>
								<a href="addcollect.action?bookId=<s:property value="#request.book.bookId"/>">
									<img alt="收藏宝贝" src="../image/collectbook_button.gif">
								</a>
							</p>
					</div>
					<div id="book_detail">
						<p id="book_title"><s:property value="#request.book.name"/></p>
						<p>价格：<span id="price_label">￥<s:property value="#request.book.price"/></span>
							<s:if test="#request.book.status == 1">(已下架)</s:if>
						</p>
						<p>定价：￥<s:property value="#request.book.originalPrice"/>&nbsp;&nbsp;&nbsp;&nbsp;
							折扣：<span id="discount_label"><s:property value="#request.book.discount"/>折</span></p>
						<p>顾客评分：
							<s:if test="#request.book.bookStatistics.avgCommentScore > 0">
												<s:property value="#request.book.bookStatistics.avgCommentScore"/>&nbsp;&nbsp;
												已有<s:property value="#request.book.bookStatistics.commentCount"/>人评论
							</s:if>
							<s:else>暂无评论</s:else>
						</p>
						<p>已售出：<s:property value="#request.book.bookStatistics.sellCount"/>本</p>
						<p>库存：
										<s:if test="#request.book.stock > 100">有货</s:if>
										<s:elseif test="#request.book.stock <= 0"><span style="color: red;">无货</span></s:elseif>
										<s:else><s:property value="#request.book.stock"/>本</s:else></p>
						<hr/>
						<p>作者：<s:property value="#request.book.author"/>著</p>
						<p>出版日期：
									<s:date id="pud" name="#request.book.publishDate" format="yyyy-MM-dd"/>
									<s:property value="#pud"/>&nbsp;&nbsp;
							出版社：<s:property value="#request.book.publisher.publisher"/>
						</p>
						<p>印刷日期：
									<s:date id="prd" name="#request.book.printDate" format="yyyy-MM-dd"/>
									<s:property value="#prd"/>&nbsp;&nbsp;
								印次：<s:property value="#request.book.printCount"/>	
						</p>
						<form action="buybook.action" id="buyForm" method="post" onsubmit="return checkstock('<s:property value="#request.book.stock"/>');">
							<div id="buy_panel">
								<p>我要买：
									<input type="hidden" id="bookId" name="bookId" value="<s:property value="#request.book.bookId"/>"/>
									<input type="text" id="bookCount" name="bookCount" value="1" size="2" onblur="return checkstock('<s:property value="#request.book.stock"/>');"/>&nbsp;件
								</p>
								<p>&nbsp;&nbsp;
									<input type="image" src="../image/buynow_button.gif" height="40px" alt="立刻购买">&nbsp;&nbsp;&nbsp;
									<a href="addcart.action?bookId=<s:property value="#request.book.bookId"/>">
										<img alt="加入购物车" src="../image/addtocart.gif" height="40px">
									</a>
								</p>
							</div>
						</form>
					</div>
				</div>
				<div id="table_title">
					<ul>
						<li id="description_nav" class="current_nav"><span onclick="showdescription();">商品详情</span></li>
						<li id="comment_nav"><span onclick="showcomment();">商品评论(<s:property value="#request.book.bookStatistics.commentCount"/>条)</span></li>
					</ul>
				</div>
				<div id="book_description">
					<p id="description_title">内容简介</p>
					<p id="description_panel"><s:property value="#request.book.description"/></p>
				</div>
				<div id="book_comment">
					<ul id="comment_list">
						<s:iterator id="comment" value="#request.comments" status="status">
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
						<span id="seeallcomments_label"><a href="commentsofbook.action?bookId=<s:property value="#request.book.bookId"/>">查看所有评论&gt;&gt;</a></span>
					</s:elseif>
					<s:else>
						<p>&nbsp;</p>
					</s:else>
					</p>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/footer.jsp"></s:include>
			</div>
		</div>
		
<!-- JiaThis Button BEGIN -->
<script type="text/javascript" >
	var jiathis_config={
		showClose:false,
		hideMore:false
	}
</script>
<script type="text/javascript" src="http://v2.jiathis.com/code/jiathis_r.js?btn=r3.gif" charset="utf-8"></script>
<!-- JiaThis Button END -->

	</body>
</html>