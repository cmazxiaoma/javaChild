<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功</title>
	<link rel="shortcut icon" href="background/logo.ico" type="image/x-icon" />
</head>
<body >
<table align="center">
<tr><td height="100"></td></tr>
<tr><td align="center"><img src="background/success.jpg"width="200" height="150" /></td></tr>
<tr><td height="100" align="center"><font color="#707070" size="5">
 3秒后自动跳转到登陆页面<br/>
 
点击<a href='login.jsp'>跳转</a>快速跳转到登陆页面</font>
	<%response.setHeader("refresh","3,url=login.jsp"); %>
</td></tr>
</table>
</body>
</html>