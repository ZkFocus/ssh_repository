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
 	<!-- 测试requestValue属性 -->
 	<a href="testRequestMappingValue">测试RequestMapping Value属性</a>
 	 <br><br>
   	<a href="testValue">测试RequestMapping Value属性</a>
  	<br><br>
  
  	<!-- 测试requestMapping method属性 GET方式 -->
  	<a href="testRequestMappingMethod">测试RequestMapping Method属性GET方式</a>
  	<br><br>
  	<form action="testRequestMappingMethod" method="post">
		<input type="submit" value="POST方式"/>
	</form>
	
  	<!-- 测试requestmapping params属性 -->
  <a href="testRequestMappingParams?password=123456">测试RequestMapping Params属性</a>
  	<br><br>
  		<!-- 测试requestmapping header属性 -->
  <a href="testRequestMappingHeaders">测试RequestMapping Headers属性</a>
  	<br><br>
  	
  	
  		<!-- 测试requestmapping ant风格 -->
  <a href="testRequestMappingAnt/abc">测试RequestMapping Ant风格</a>
  	<br><br>
  	
  	
  	
  	<a href="user/1">测试 RequestMapping&PathVariable</a>
  	<br><br>
  	
  	<!-- REST风格的API -->
  	<!-- 得到id为1的user -->
	<a href="user/1">Test Rest GET</a>

	<!-- 新建id为1的user -->
	<form action="user" method="post">
	        <input type="hidden" name="_method" value="POST"/>
		<input type="submit" value="Test Rest POST"/>
	</form>
	
	<!-- 删除id为1的user -->
	<form action="user/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="Test Rest DELETE"/>
	</form>
	
	<!-- 更新id为1的user -->
	<form action="user/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="Test Rest PUT"/>
	</form>
</body>
</html>