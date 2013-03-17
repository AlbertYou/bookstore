<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>所有公告-<%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link rel="stylesheet" type="text/css" href="../style/admin/billboard/billboard_list.css">
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
					<ul id="billboards_panel">
						<li class="billboard_item">
							<ul class="billboard_content billboard_title_panel">
								<li class="billboard_time">发布时间</li>
								<li class="billboard_title">标题</li>
								<li class="billboard_status">状态</li>
								<li class="billboard_delete">删除</li>
							</ul>
						</li>
					    <s:iterator id="billboard" value="#request.billboards.list">
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
									<li class="billboard_status">
										<s:if test="#billboard.status == 0">显示</s:if>
					    				<s:else>隐藏</s:else>
									</li>
									<li class="billboard_delete"><a href="deletebillboard.action?billboardId=<s:property value="#billboard.billboardId"/>">删除</a></li>
								</ul>
							</li>
 					    </s:iterator>
 					 </ul>
 					 <div id="paginating">
						<s:if test="#request.page_index > 1">
							<span><a href="billboardlist.action?page_index=<s:property value="#request.page_index - 1"/>">上一页</a></span>
						</s:if>
						<s:if test="#request.page_index <= 1">
							<span>上一页</span>
						</s:if>
						<a href="billboardlist.action?page_index=<s:property value="#request.page_index"/>">
							<s:property value="#request.page_index"/>
						</a>
						<s:if test="#request.page_index < #request.billboards.allPages">
							<span><a href="billboardlist.action?page_index=<s:property value="#request.page_index + 1"/>">下一页</a></span>
						</s:if>
						<s:if test="#request.page_index >= #request.billboards.allPages">
							<span>下一页</span>
						</s:if>
						共<s:property value="#request.billboards.allPages"/>页
					</div>
				</div>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>
	</body>
</html>