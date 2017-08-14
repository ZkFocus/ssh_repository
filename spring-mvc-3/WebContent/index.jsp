<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<br/><br/>
<a href="testModelAttributtes?name=admin">测试 ModelAttributtes</a>
<br/><br/>
<a href="testSessionAttributes">测试  SessionAttributes</a>
<br/><br/>
<a href="user">测试  save</a>
<br/><br/>
<a href="testView">testView</a>
<!-- TODO 自定义的servlet filter -->
<!-- 处理multipart形式的数据 -->
<br/><br/>
<a href="register">注册上传图片</a>
<!-- TODO 跨重定向请求数据 -->
<br><br>
<a href="product">Test RequestBody</a>
<br><br>
	<form action="testRegister" method="post">
		userName:<input type="text" name="userName"><br>
		tel:<input type="text" name="tel"><br>
		password:<input type="password" name="password"><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>