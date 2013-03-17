<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title><%=getServletContext().getServletContextName()%></title>
		<link rel="stylesheet" type="text/css" href="../style/user/common/category.css">
		<script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$(".category_item").click(function () {
					$(this).children(".topcategory").addClass("currenttopcategory").end()
						.children(".lowcategory").show().end()
						.siblings().children(".topcategory").removeClass("currenttopcategory").end()
						.children(".lowcategory").hide();
				});
				$(".lowcategory").mouseover(function() {
					$(this).addClass("currentcategory");
				});
				$(".lowcategory").mouseout(function() {
					$(this).removeClass("currentcategory");
				});
			})
		</script>
	</head>
	<body>
	<div id="category_panel">
		<div id="category_title">图书分类</div>
		<s:iterator id="ca" value="#request.categories">
							<div class="category_item">
							    <s:if test="#request.category.parent.categoryId == #ca.categoryId">
									<div class="topcategory" style="font-weight: bold;color: red;"><s:property value="#ca.name"/></div>
									<s:iterator id="c" value="#ca.children">
											<div class="lowcategory" style="display: block;">
											    <s:if test="#request.category.categoryId == #c.categoryId">
													<a href="categorybooks.action?categoryId=<s:property value="#c.categoryId"/>" style="color: #04f363;"><s:property value="#c.name"/></a>
												</s:if>
												<s:else>
													<a href="categorybooks.action?categoryId=<s:property value="#c.categoryId"/>"><s:property value="#c.name"/></a>
												</s:else>
											</div>
									</s:iterator>
							    </s:if>
							    <s:else>
									<div class="topcategory"><s:property value="#ca.name"/></div>
									<s:iterator id="c" value="#ca.children">
										<div class="lowcategory">
											<a href="categorybooks.action?categoryId=<s:property value="#c.categoryId"/>"><s:property value="#c.name"/></a>
										</div>
									</s:iterator>
							    </s:else>
   							</div>
 						</s:iterator>
	</div>
</body>
</html>