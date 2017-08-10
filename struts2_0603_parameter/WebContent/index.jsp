<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="useradd?name=tom&age=10">添加用户</a> 
	
	<a href="user!add?name=tom&age=10">DMI添加用户</a><br>
	
	<a href="useradd?user.name=tom&user.age=10">域模型添加用户</a><br>
	
	<a href="useradd?name=tom&age=10">ModelDrivern拦截器添加用户</a><br>
	
	
	
</body>
</html>