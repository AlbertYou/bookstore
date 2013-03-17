<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>公告管理-<%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link rel="stylesheet" type="text/css" href="../style/admin/billboard/billboard_current.css">
	</head>
	<body>
		<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="left">
					<ul id="left_nav">
						<li><a href="currentbillboards.action">当前公告</a></li>
						<li><a href="billboardlist.action">所有公告</a></li>
					  </ul>
				</div>
				<div id="right">
					<div id="add_billboard_panel"><a href="toaddbillboard.action">添加公告</a></div>
					<ul id="billboards_panel">
						<li class="billboard_item">
							<ul class="billboard_content billboard_title_panel">
								<li class="billboard_time">发布时间</li>
								<li class="billboard_title">标题</li>
								<li class="billboard_hide">隐藏</li>
							</ul>
						</li>
					    <s:iterator id="billboard" value="#request.billboards">
							<li class="billboard_item">
								<ul class="billboard_content">
									<li class="billboard_time">
										<s:date name="#billboard.publishTime" format="yyyy-MM-dd HH:mm" id="pt" />
                        				<s:property value="#pt"/>
									</li>
									<li class="billboard_title">
										<a href="billboardinfo.action?billboardId=<s:property value="#billboard.billboardId"/>">
											<s:property value="#billboard.title"/>
										</a>
									</li>
									<li class="billboard_hide"><a href="hidbillboard.action?billboardId=<s:property value="#billboard.billboardId"/>">隐藏</a></li>
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