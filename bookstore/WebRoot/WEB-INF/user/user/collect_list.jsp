<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>${sessionScope.container.user.username}的收藏-<%=getServletContext().getServletContextName()%></title>
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/gotop.js"></script>
    	<link rel="stylesheet" href="../style/user/user/collect_list.css" type="text/css">
    	<script type="text/javascript">
    		$(function() {
        		$(".edittag").click(function(){
                	$(this).parent(".title").next(".addtitletag").show();
                	$(this).parent(".title").hide();
            	});
        		$(".canceledit").click(function(){
        			$(this).parent(".addtitletag").hide();
                	$(this).parent(".addtitletag").prev(".title").show();
            	});
        		$(".addtitlebutton").click(function(){
        			var title = $(this).siblings(".title_value").val().trim();
                	var collectId = $(this).prev(".collectId").val().trim();
                	var url = "modifycollecttitle.action?collectId=" + collectId + "&title=" + title;
            		$.ajax({
                		url: url,
                		type: "POST",
                		dataType: "text",
            		});
            		$(this).parent(".addtitletag").hide();
                    $(this).parent(".addtitletag").prev(".title").show();
                    if(title == null || title == "") {
                         $(this).parent(".addtitletag").prev(".title").children(".title_add").show();
                         $(this).parent(".addtitletag").prev(".title").children(".title_real").hide();
                         $(this).parent(".addtitletag").prev(".title").children(".title_edit").hide();                    	
                    } else {
            	         $(this).parent(".addtitletag").prev(".title").children(".title_add").hide();
                 	     $(this).parent(".addtitletag").prev(".title").children(".title_real").show();
                         $(this).parent(".addtitletag").prev(".title").children(".title_edit").show();
            	         $(this).parent(".addtitletag").prev(".title").children(".title_real").empty();
                	     $(this).parent(".addtitletag").prev(".title").children(".title_real").append(title);
                    }
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
					<div id="nav_panel">
						<div class="nav_item1"><a href="homepage.action">我的主页</a></div>
						<div class="nav_item1"><a href="tocart.action">我的购物车</a></div>
						<div class="nav_item1">订单管理</div>
						<div class="nav_item2"><a href="undeliveredorderlist.action">待发货</a></div>
						<div class="nav_item2"><a href="deliveredorderlist.action">待确认收货</a></div>
						<div class="nav_item2"><a href="finishedorderlist.action">交易成功</a></div>
						<div class="current_nav"><a href="collectlist.action">我的收藏</a></div>
						<div class="nav_item1"><a href="purchasedbooks.action">已购商品</a></div>
						<div class="nav_item1"><a href="recipientlist.action">收货地址管理</a></div>
						<div class="nav_item1">评价管理</div>
						<div class="nav_item2"><a href="nocomment.action">待评价</a></div>
						<div class="nav_item2"><a href="allcomments.action">所有评价</a></div>
					</div>
              </div>
              <div id="right">
				<div id="temp_nav">
					<span>我的收藏</span>
					<span>(共有<s:property value="#request.collects.allRecords"/>件商品)</span>
				</div>
				<div class="clearall"><a href="clearcollect.action">清空收藏夹</a></div>
				<div id="collect_list">
					<s:if test="#request.collects.list.size > 0">
						<s:iterator id="collect" value="#request.collects.list">
						<ul class="book_list">
							<li class="row1">
								<a href="book.action?bookId=<s:property value="#collect.book.bookId" />"><img height="80px" width="60px" src="<s:property value="#collect.book.imageUrl" />"/></a>
							</li>
							<li class="row2">
									<div class="bookname">
										<a href="book.action?bookId=<s:property value="#collect.book.bookId" />"><s:property value="#collect.book.name" /></a>
									</div>
									<div class="collect_about">
										<ul>
											<li>
												<span>收藏时间：
													<s:date name="#collect.collectDate" format="yyyy-MM-dd" id="cd"/>
													<s:property value="#cd" />
												</span>
											</li>
											<li>
												<span>收藏人气：<s:property value="#collect.book.bookStatistics.collectCount" /></span>
											</li>
										</ul>
									</div>
									<div class="title_label">
										<span>标签：</span>								
										<span class="title">
											<c:if test="${collect.title == null || collect.title == '' }">
												<a class="edittag title_add" href="javascript::void(0)">[添加]</a>
												<span class="title_real" style="display: none;"><s:property value="#collect.title"/></span>
												<a class="edittag title_edit" style="display: none;" href="javascript::void(0)">[编辑]</a>
											</c:if>
											<c:if test="${collect.title != null && collect.title != '' }">											
												<a class="edittag title_add" style="display: none;" href="javascript::void(0)">[添加]</a>
												<span class="title_real"><s:property value="#collect.title"/></span>
												<a class="edittag title_edit" href="javascript::void(0)">[编辑]</a>
											</c:if>
										</span>
										<span class="addtitletag" style="display: none;">
											<input class="title_value" type="text" value="<s:property value="#collect.title" />" size="18"/>
											<input class="collectId" type="hidden" value="<s:property value="#collect.collectId" />"/>
											<a class="addtitlebutton" href="javascript::void(0)">提交</a>
											<a class="canceledit title_operate" href="javascript::void(0)">[取消]</a>
										</span>
									</div>
							</li>
							<li class="row3">
								<span class="price_label">￥<s:property value="#collect.book.price" /></span>
								<span class="discount_label"><s:property value="#collect.book.discount" />折</span>
							</li>
							<li class="row4">
								<a href="addcart.action?bookId=<s:property value="#collect.book.bookId" />"><image alt="购买" src="../image/buybook.gif" height="30px"></image></a><br/><br/>
								<a href="deletecollect.action?collectId=<s:property value="#collect.collectId" />">
									<image alt="删除" src="../image/deletebook.gif" height="30px"></image>
								</a>
							</li>
						</ul>
					</s:iterator>
					</s:if>
					<s:else>
						<p id="nullnotice"><a href="index.action">暂无收藏，点此去别处</a></p>
					</s:else>
				</div>
				<div class="clearall"><a href="clearcollect.action">清空收藏夹</a></div>
				<div id="paginating">
				  <form action="collectlist.action" method="post">
					<c:if test="${requestScope.page_index >1 }">
						<span><a href="collectlist.action?page_index=${requestScope.page_index - 1 }">上一页</a></span>
					</c:if>
					<c:if test="${requestScope.page_index <= 1 }">
						<span>上一页</span>
					</c:if>
					<a href="collectlist.action?page_index=${requestScope.page_index }">
						${requestScope.page_index }
					</a>
					<c:if test="${requestScope.page_index < requestScope.collects.allPages }">
						<span><a href="collectlist.action?page_index=${requestScope.page_index + 1 }">下一页</a></span>
					</c:if>
					<c:if test="${requestScope.page_index >= requestScope.collects.allPages }">
						<span>下一页</span>
					</c:if>
					<span>共${requestScope.collects.allPages }页</span>
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