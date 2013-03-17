<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>${requestScope.book.name }<%=getServletContext().getServletContextName()%></title>
    	<link href="../js/calendar/skins/aqua/theme.css" type="text/css" rel="stylesheet">
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link rel="stylesheet" type="text/css" href="../style/admin/book/book_modify.css">
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
						<li id="current_left_nav"><a href="searchbook.action">图书管理</a></li>
						<li><a href="lowstockbooklist.action">低库存图书</a></li>
						<li><a href="publisherlist.action">出版社管理</a></li>
					  </ul>
				</div>
				<div id="right">
					<div id="temp_nav">修改图书基本信息</div>
					<div id="book_statistics_panel">
						<ul>
							<li>
								购买人气：<s:property value="#request.book.bookStatistics.sellCount"/>
							</li>
							<li>
								评论总数：<s:property value="#request.book.bookStatistics.commentCount"/>
							</li>
							<li>
								收藏人气：<s:property value="#request.book.bookStatistics.collectCount"/>
							</li>
							<li>
								平均评分：<s:property value="#request.book.bookStatistics.avgCommentScore"/>
								<s:hidden id="bookId" name="bookId" value="%{#request.book.bookId}"></s:hidden>
							</li>
						</ul>
					</div>
					<div id="modify_form">
						<s:form action="modifybook.action" method="post" name="form1" theme="simple">
							<ul id="form_panel">
							<s:hidden id="bookId" name="bookId" value="%{#request.book.bookId }"></s:hidden>
								<li>书名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield id="name" name="name" label="书名" value="%{#request.book.name}"></s:textfield></li>
								<li>作者&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield id="author" name="author" label="作者" value="%{#request.book.author}"></s:textfield></li>
								<li>出版社&nbsp;&nbsp;
									<s:select id="publisherId" name="publisher.publisherId" 
					 	   				  list="#request.publishers" listKey="publisherId" 
					 	   				  listValue="publisher" label="出版社"
					 	   				  headerKey="" headerValue=""  value="%{#request.book.publisher.publisherId}"></s:select>
								</li>
								<li>出版日期
									<s:date name="#request.book.publishDate" format="yyyy-MM-dd" id="pd" />
									<s:textfield id="publishDate" name="publishDate" label="出版日期" readonly="true" value="%{#pd }" onclick="WdatePicker();"></s:textfield></li>
								<li>印刷日期
									<s:date name="#request.book.printDate" format="yyyy-MM-dd" id="prd" />
									<s:textfield id="printDate" name="printDate" label="印刷日期" readonly="true" value="%{#prd}" onclick="WdatePicker();"></s:textfield></li>
								<li>印次&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield id="printCount" name="printCount" label="印次" value="%{#request.book.printCount}"></s:textfield></li>
								<li>图书分类</li>
								<li style="padding-left: 73px;">
									<s:doubleselect id="topcategory" name="topcategory" 
					 	   						formName="form1" list="#request.topCategories" 
					 	   						listKey="categoryId" listValue="name" 
					 	   						doubleId="categoryId" doubleName="category.categoryId" 
					 	   						doubleList="#request.map.get(top.categoryId)" doubleListKey="categoryId" 
					 	   						doubleListValue="name" label="图书分类"
					 	   						value="%{#request.book.category.parent.categoryId}" doubleValue="%{#request.book.category.categoryId}"></s:doubleselect>
								</li>
								<li>购入价格&nbsp;<s:textfield id="bid" name="bid" label="购入价格" value="%{#request.book.bid}"></s:textfield></li>
								<li>定价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield id="originalPrice" name="originalPrice" label="定价" value="%{#request.book.originalPrice}"></s:textfield></li>
								<li>折扣&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:textfield id="discount" name="discount" label="折扣" value="%{#request.book.discount}"></s:textfield></li>
								<li>销售价格&nbsp;<s:textfield id="price" name="price" label="销售价格" value="%{#request.book.price}"></s:textfield></li>
								<li>图书描述<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<s:textarea rows="10" cols="60" id="description" name="description" label="图书描述" value="%{#request.book.description}"></s:textarea></li>
								<li><input type="image" src="../image/modify.gif" id="modifyinfo_label"/></li>
							</ul>
						</s:form>
					</div>
					<div id="modify_image_panel">
						<s:form action="modifyimage" method="post" enctype="multipart/form-data" theme="simple">
							<p id="image_title">修改图片</p>
							<p id="image_show"><img src="<s:property value="#request.book.imageUrl"/>" height="150px"/></p>
							<p id="new_image">
								<s:file id="image" name="image"></s:file>
								<s:hidden id="bookId" name="bookId" value="%{#request.book.bookId }"></s:hidden>
							</p>
							<p id="notice_label">小于1000KB</p>
							<p id="upload_button">
								<s:submit value="上传"></s:submit>
							</p>
						</s:form>
					</div>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>
	</body>
</html>