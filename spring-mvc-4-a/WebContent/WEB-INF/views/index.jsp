<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="testModelAttributtes?name=admin">测试 ModelAttributtes</a>
<br/><br/>
	
	<form action="testRegister" method="post">
		username:<input type="text" name="username"><br>
		tel:<input type="text" name="tel"><br>
		password:<input type="password" name="password"><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>