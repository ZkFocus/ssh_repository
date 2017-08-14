<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("a").click(function() {
			//get方法
			var url = this.href;
			var args = {
				"time" : new Date()
			};
			//get 与post方式一样
			//args 为json格式
			//function为回调函数，响应结束后，回调函数触发。响应结果在data里
			$.get(url, args, function(data, status) {
				alert("数据：" + data + "\n状态：" + status);
				$("#div").append(data)
			});
			return false;
		});
	});
</script>
</head>
<body>

	<a href="ajax.txt">HelloAjax</a>
	<div id="div"></div>
</body>
</html>