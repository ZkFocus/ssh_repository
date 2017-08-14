<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		//1，获取a节点，并为其添加onclick响应函数
		document.getElementsByTagName("a")[0].onclick = function() {
			//3，创建XMLHttpRequest
			var request = new XMLHttpRequest();
			//4，准备发送请求的链接
			var url = this.href;
			var method = "GET";
			//5,调用XMLHttpRequest对象的open方法
			request.open(method, url);
			//6,调用XMLHttpRequest对象的send方法
			request.send();
			//7，为XMLHttpRequest对象添加onreadystatechange响应函数
			request.onreadystatechange = function() {
				//8,判断响应是否完成 
				if (request.readyState == 4) {
					//9,判断响应是否可用
					if (request.status == 200 || request.status == 304) {
						//10，打印结果
						//alert(request.responseText);
						document.getElementById("div").innerHTML=request.responseText;
					}
				}
			}
			//2，取消a节点的默认行为
			return false;
		}
	}	
</script>
</head>
<body>

	 <a href="ajax.txt">HelloAjax</a> 
	
	 <a href="hello.html">HelloAjax</a>
	<br>
	<div id="div"></div>
</body>
</html>