<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	hahahaha<br>
	<a href="struts/useradd?name=tom&age=10">添加用户</a> <a href="struts/userdel">删除用户</a><br>
	
	<form action="struts/useradd" method="post">
		姓名：<input type="text" name="name"><br>
		年龄：<input type="text" name="age"><br>
			<input type="submit" value="submit">
	</form>
	<br>
	<a href="struts/web">web</a><br>
	<a href="struts/dynamic?type=1">hello1</a><br>
	<a href="struts/dynamic?type=2">hello2</a><br>
	<a href="struts/dynamic?type=3">hello3</a><br>
	
	<a href="struts/ognl?name=tom&age=10">ognl</a><br>
	<a href="struts/ognl?user.name=jim&user.age=20">ognlObject</a><br>
	<a href="struts/ognl?user.address.city=zhengzhou">ognlDeep</a><br>
	<a href="struts/tag?person.name=tom&person.age=10">tag</a><br>
</body>
</html>