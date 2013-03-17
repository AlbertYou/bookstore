<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>图书分类-<%=getServletContext().getServletContextName()%></title>
        <link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
        <link href="../style/admin/common/apprise.css" type="text/css" rel="stylesheet"/>
        <link rel="stylesheet" type="text/css" href="../style/admin/category/category_list.css">
        <script type="text/javascript" src="../js/jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="../js/apprise.js"></script>
    	<script type="text/javascript" src="../js/gotop.js"></script>
    	<script type="text/javascript" src="../js/category_list.js"></script>
	</head>
	<body>
		<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="operate_catetgory_result">
					<span id="operate_result"></span>
				</div>
				<div id="topcatetgory_add_panel">
					<span id="addtopcategorybutton" onclick="addcategory();">增加一级分类</span>
				</div>
				<div id="category_panel">
					<ul id="firstlevel">
						<s:iterator id="category" value="#request.categories">
							<li class="firstlevel_item">
								<ul class="firstlevel_info">
									<li class="showsecondlevel">+</li>
									<li class="firstlevel_name"><s:property value="#category.name"/></li>
									<li class="firstlevel_modify"><span onclick="moidfytopcategory('<s:property value="#category.categoryId"/>', '<s:property value="#category.name"/>');">修改</span></li>
									<li class="firstlevel_delete"><span onclick="deletetopcategory(this, '<s:property value="#category.categoryId"/>');">删除</span></li>
									<li class="firstlevel_addchild"><span onclick="addchildcategory('<s:property value="#category.categoryId"/>', '<s:property value="#category.name"/>');">增加子分类</span></li>
								</ul>
								<ul class="secondlevel">
									<s:iterator id="c" value="#category.children">
										<li class="secondlevel_item">
											<ul class="secondlevel_info">
												<li class="secondlevel_name"><s:property value="#c.name"/></li>
												<li class="secondlevel_modify"><span onclick="moidfylowcategory('<s:property value="#c.categoryId"/>', '<s:property value="#c.name"/>', '<s:property value="#category.categoryId"/>');">修改</span></li>
												<li class="secondlevel_delete"><span onclick="deletechildcategory(this, '<s:property value="#c.categoryId"/>');">删除</span></li>
											</ul>
										</li>
									</s:iterator>
								</ul>
							</li>
 						</s:iterator>
					</ul>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>
	</body>
</html>