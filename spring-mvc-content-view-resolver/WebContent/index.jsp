<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function(){
		 $("#exportExcel").click(function () {
	            location.href = "${pageContext.request.contextPath}/excel/export" 
	     });
		 $("#exportPdf").click(function () {
	            location.href = "${pageContext.request.contextPath}/pdf/export" 
	     });
	})
</script>
</head>
<body>
	<button id="exportExcel">exportExcel</button>
	<button id="exportPdf">exportPdf</button>
	<br><br>
	<a href="user/login">用户登录</a>
</body>
</html>