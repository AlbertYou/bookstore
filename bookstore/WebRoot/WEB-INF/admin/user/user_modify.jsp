<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改用户信息-<%=getServletContext().getServletContextName()%></title>
		<script type='text/javascript' src='${pageContext.request.contextPath }/dwr/interface/userService.js'></script>
        <script type='text/javascript' src='${pageContext.request.contextPath }/dwr/engine.js'></script>
        <script type='text/javascript' src='${pageContext.request.contextPath }/dwr/util.js'></script>
        <script type="text/javascript">
        function modify() {
        	var u = { userId: dwr.util.getValue("userId"), username: dwr.util.getValue("username"), email: dwr.util.getValue("email"), sex: dwr.util.getValue("sex"), phone: dwr.util.getValue("phone") };
        	userService.update(u);
        	alert("修改成功");
            window.close();
        }
        function closeWin() {
            window.close();
        }
        </script>
	</head>
	<body>
	  <div id="page">
		<table width="350px">
             <tr><th colspan="2" align="left">修改用户信息:<br/><br/></th></tr>
             <tr><td colspan="2"><s:hidden id="userId" name="userId" value="%{#request.user.userId}"></s:hidden></td></tr>
             <tr><td align="right">用户名:</td><td align="left"><input id="username" name="username" type="text" value="<s:property value="#request.user.username"/>" /></td></tr>
             <tr><td align="right">邮箱:</td><td align="left"><input id="email" name="email" type="text" value="<s:property value="#request.user.email"/>" /></td></tr>
             <tr><td align="right">性别:</td>
             	<td align="left">
             		 <s:radio list="#{'0':'男','1':'女'}" name="sex" id="sex" value="%{#request.user.sex}" theme="simple"></s:radio>
             	</td>
             </tr>
             <tr><td align="right">电话:</td><td align="left"><input id="phone" name="phone" type="text"  value="<s:property value="#request.user.phone"/>"/></td></tr>
             <tr><td>&nbsp;</td><td align="center"><br/>&nbsp;&nbsp;&nbsp;<input type="button" value="修改" onclick="modify();" /></td></tr>
             <tr><td colspan="2" align="center"><br/><input type="button" value="关闭窗口" onclick="closeWin();" /></td></tr>
          </table>
		
	  </div>
	</body>
</html>