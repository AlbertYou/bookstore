<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>新书上架<%=getServletContext().getServletContextName()%></title>
    	<link href="../js/calendar/skins/aqua/theme.css" type="text/css" rel="stylesheet">
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link rel="stylesheet" type="text/css" href="../style/admin/book/book_add.css">
    	<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
    	<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
	        function cal() {
		        var price = document.getElementById("originalPrice").value * document.getElementById("discount").value / 100;
		        document.getElementById("price").value = price;
	        }
	        $(function() {
		        $("#discount").blur(function() {
		        	cal();
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
						<li id="current_left_nav"><a href="searchbook.action">图书管理</a></li>
						<li><a href="lowstockbooklist.action">低库存图书</a></li>
						<li><a href="publisherlist.action">出版社管理</a></li>
					  </ul>
				</div>
				<div id="right">
					<div id="temp_nav">新书上架</div>
					<div id="form_panel">
					  <s:actionerror/>
					  <s:form action="addbook.action" method="post" name="form1" enctype="multipart/form-data" theme="simple">
						<div id="form_title">
							<p>书名</p>
							<p>作者</p>
							<p>出版社</p>
							<p>出版日期</p>
							<p>印刷日期</p>
							<p>印次</p>
							<p>上传图片</p>
							<p>购入价格</p>
							<p>定价</p>
							<p>折扣</p>
							<p>销售价格</p>
							<p>库存</p>
							<p><br/>图书分类</p>
							<p><br/>图书描述</p>
						</div>
						<div id="form_field">
							<p><s:textfield id="name" name="name" label="书名"></s:textfield></p>
							<p><s:textfield id="author" name="author" label="作者"></s:textfield></p>
							<p>
								<s:select id="publisherId" name="publisher.publisherId" 
					 	   				  list="#request.publishers" listKey="publisherId" 
					 	   				  listValue="publisher" label="出版社"
					 	   				  headerKey="" headerValue=""></s:select>
							</p>
							<p><s:textfield id="publishDate" name="publishDate" label="出版日期" readonly="true" onclick="WdatePicker();"></s:textfield></p>
							<p><s:textfield id="printDate" name="printDate" label="印刷日期" readonly="true" onclick="WdatePicker();"></s:textfield></p>
							<p><s:textfield id="printCount" name="printCount" label="印次" size="5"></s:textfield></p>
							<p><s:file id="image" name="image" label="上传图片"></s:file>小于1000KB</p>
							<p><s:textfield id="bid" name="bid" label="购入价格" size="5"></s:textfield>元</p>
							<p><s:textfield id="originalPrice" name="originalPrice" label="定价" size="5"></s:textfield>元</p>
							<p><s:textfield id="discount" name="discount" label="折扣" size="5"></s:textfield>折&nbsp;&nbsp;例如：70折</p>
							<p><s:textfield id="price" name="price" label="销售价格" size="5"></s:textfield>元</p>
							<p><s:textfield id="stock" name="stock" label="库存" size="5"></s:textfield></p>
							<p>
								<s:doubleselect id="topcategory" name="topcategory" 
					 	   						formName="form1" list="#request.topCategories" 
					 	   						listKey="categoryId" listValue="name" 
					 	   						doubleId="categoryId" doubleName="category.categoryId" 
					 	   						doubleList="#request.map.get(top.categoryId)" doubleListKey="categoryId" 
					 	   						doubleListValue="name" label="图书分类"></s:doubleselect>
							</p>
							<p><s:textarea rows="8" cols="40" id="description" name="description" label="图书描述"></s:textarea></p>
							<p id="submit_label"><input type="image" src="../image/sure.gif"/></p>
						</div>
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