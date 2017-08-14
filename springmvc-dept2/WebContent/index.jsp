<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="home">首页</a>
	<br><br>
	<a href="testRequestMappingValues">Test RequestMapping Values</a>
	<br><br>
	<a href="testValues">Test RequestMapping Values Arrays</a>
	<br><br>
	<a href="testRequestMappingValuesAntABCD!@#$">Test testRequestMappingValuesAnt Style</a>
	<br><br>
	<form action="testMethod" method="post">
		<input type="submit" value="testMethod">
	</form>
	<br><br>
	<a href="testHeaders">Test RequestMapping Headers</a>
	<br><br>
	<a href="testRequestMappingParams?name=admin">Test RequestMapping Params</a>
	<br><br>
	<a href="testRequestParams?name=admin">Test RequestParams</a>
	<br><br>
	<a href="getUser/123456">Test PathVariable</a>
	<br><br>
	<form action="testRegister" method="post">
		name:<input type="text" name="name"><br>
		tel:<input type="text" name="tel"><br>
		password:<input type="password" name="password"><br>
		<input type="submit" value="注册">
	</form>
	<br><br>
	<a href="testListUsers">获取用户列表</a>
	<br><br>
	<a href="testView">Test View</a>
	<br><br>
	<!-- REST风格的API操作 -->
	<a href="testRestGet/1">Test Rest Get 获取对象</a>
	<!-- 测试REST风格的POST方式 -->
	<form action="testRestPost" method="post">
		name:<input type="text" name="name"><br>
		tel:<input type="text" name="tel"><br>
		password:<input type="password" name="password"><br>
		<input type="submit" value="提交">
	</form>
	<!--REST风格的put操作 浏览器目前只支持get/post方式  -->
	<form action="testRestPut/2" method="post">
		<input type="hidden" name="_method" value="put">
		<input type="submit" value="put提交">
	</form>
	<br>
	<!--REST风格的delete 操作 浏览器目前只支持get/post方式  -->
	<form action="testRestDelete/3" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="delete提交">
	</form>
	<br><br>
	<a href="testView">Test View</a>
	
	<br><br>
</body>
</html>