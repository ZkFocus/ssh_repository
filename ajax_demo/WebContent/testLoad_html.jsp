<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("a").click(function(){
			//二，添加选择器
			var url=this.href + " h4";
			var args={"time":new Date()};
			//一，加参数则为load方式 不加参数则为get方式
			$("#div").load(url,args);

			return false;
			});
		});
	
</script>
</head>
<body>

<a href="hello.html">HelloAjax</a>
	<br>
	<div id="div"></div>
</body>
</html>