<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>服务器端发生错误-<%=getServletContext().getServletContextName()%></title>
		<style type="text/css">
    		#logo {
    			position: absolute;
    			left: 100px;
    			top: 20px;
    		}
    		#notice {
    			position: absolute;
    			left: 550px;
    			top: 200px;
    			color: gray;
    			font-size: 25px;
    		}
    	</style>
	</head>
	<body>
		<div id="logo">
			<img src="${pageContext.request.contextPath }/image/logo.gif" height="80px" width="200px"/>
		</div>
		<div id="notice">
			服务器发生错误
		</div>
	</body>
</html>