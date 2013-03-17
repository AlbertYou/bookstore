<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>用户管理-<%=getServletContext().getServletContextName()%></title>
    	<link href="../style/admin/common/header.css" type="text/css" rel="stylesheet"/>
    	<link rel="stylesheet" type="text/css" href="../style/admin/user/user_list.css">
    	<script type="text/javascript">
/*
    	    function modifyuser(userId) {
    	    	var act = window.showModalDialog("userinfo.action?userId="+userId,"","dialogWidth=400px;dialogHeight=300px;location=0;scroll=no;width=300px;height=400px;");
    	    	var page_index = $("#current_page").val();
    	    	var username = $("#username").val();
	            location.href="searchuser.action?page_index=" + page_index + "&username=" + username;
            }
*/            
         </script>
	</head>
	<body>
		<div id="page">
			<div id="header">
				<s:include value="../common/header.jsp"></s:include>
			</div>
			<div id="content">
				<div id="search_panel">
					<ul id="search_label">
						<li id="search_form">
							<s:form action="searchuser" method="post">
								<label for="username">查找用户</label>
								<s:hidden id="current_page" value="%{#request.page_index }"></s:hidden>
					    		<input type="text" id="username" name="username" value="<s:property value="#request.username"/>"/>
					    		<input type="submit" value="查找"/>
					    	</s:form>
						</li>
						<li id="usercount_label">当前系统共有<s:property value="#request.userCount"/>个用户</li>
					</ul>
				</div>
				<div id="users_panel">
					<ul id="user_list">
						<li class="user_item">
							<s:if test="#request.users.allRecords > 0">
							<ul class="user_title">
								<li class="username_label">用户名</li>
								<li class="email_label">邮箱</li>
								<li class="sex_label">性别</li>
								<li class="phone_label">电话</li>
								<li class="status_label">状态</li>
								<!-- 
								<li class="modify_label">修改</li>
								 -->
								<li class="operate_label">启用/停用</li>
							</ul>
							</s:if>
						</li>
						<s:iterator id="user" value="#request.users.list" status="status">
						  <li class="user_item">
							<ul class="user_info">
								<li class="username_label"><s:property value="#user.username"/></li>
								<li class="email_label"><s:property value="#user.email"/></li>
								<li class="sex_label">
									<s:if test="#user.sex == 0">男</s:if>
					    			<s:else>女</s:else>
								</li>
								<li class="phone_label">
									<s:if test="#user.phone == null || #user.phone == ''">无</s:if>
									<s:property value="#user.phone"/>
								</li>
								<li class="status_label">
									<s:if test="#user.status == 0">正常</s:if>
					    			<s:else>已停用</s:else>
								</li>
								<!-- 
								<li class="modify_label"><span style="color: orange;cursor: pointer;" onclick="modifyuser('<s:property value="#user.userId"/>');">修改</span></li>
								 -->
								<li class="operate_label">
									<a href="changeuserstatus.action?userId=<s:property value="#user.userId"/>">
					    				<s:if test="#user.status == 0">停用</s:if>
					    				<s:else>启用</s:else>
					    			</a>
					    		</li>
							</ul>
						  </li>
 					    </s:iterator>
					</ul>
				</div>
				<s:if test="#request.users.allPages > 1">
					<div id="paginating">
						<s:if test="#request.page_index > 1">
							<span><a href="searchuser.action?page_index=<s:property value="#request.page_index - 1"/>&username=<s:property value="#request.username"/>">上一页</a></span>
						</s:if>
						<s:if test="#request.page_index <= 1">
							<span>上一页</span>
						</s:if>
						<a href="searchuser.action?page_index=<s:property value="#request.page_index"/>&username=<s:property value="#request.username"/>">
							<s:property value="#request.page_index"/>
						</a>
						<s:if test="#request.page_index < #request.users.allPages">
							<span><a href="searchuser.action?page_index=<s:property value="#request.page_index + 1"/>&username=<s:property value="#request.username"/>">下一页</a></span>
						</s:if>
						<s:if test="#request.page_index >= #request.users.allPages">
							<span>下一页</span>
						</s:if>
						共<s:property value="#request.users.allPages"/>页
					</div>
				</s:if>
			</div>
			<div id="footer">
				<s:include value="../common/bottom.jsp"></s:include>
			</div>
		</div>
	</body>
</html>