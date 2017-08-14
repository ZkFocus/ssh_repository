<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello springmvc
	<br><br>
	<a href="method">首页</a>
	<br><br>
	<a href="testRequestMappingValues">测试 RequestMapping Values属性</a>
	<br><br>
	<a href="testRequestMappingValuesAgain">测试 RequestMapping Values属性again</a>
	
	<br><br>
	<a href="testRequestMappingValuesA12">测试 RequestMapping Values属性Ant风格</a>
	
	<br><br>
	<form action="testRequestMappingMethod" method="post">
		<input type="submit" value="testRequestMappingMethod">
	</form>	
	<br><br>
	<a href="testRequestMappingMethod">测试 RequestMapping Method属性GET方式</a>
	
	<br><br>
	<a href="testRequestMappingHeaders">测试 RequestMapping Headers属性</a>
	
	<br><br>
	<a href="testRequestMappingParams?name=admin">测试 RequestMapping Params属性</a>
	
	
	<br><br>
	<a href="testRequestParams?name=admin">测试 RequestParams </a>
	
	<br><br>
	<a href="testPathVariable/123">测试 PathVariable </a>
	<br><br>
	<form action="testRegister" method="post">
		name:<input type="text" name="name"><br>
		tel:<input type="text" name="tel"><br>
		password:<input type="password" name="password"><br>
		<input type="submit" value="提交">
	</form>
	<br><br>
	<a href="testList">获取用户列表</a>
	<br><br>
	<a href="testRedirect">redirect</a>
	<br><br>
	<a href="testForward">forward</a>
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