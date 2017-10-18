<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Users List Page</h4>
	
	<s:debug></s:debug>
		
	<s:if test="#request.computers == null || #request.computers.size() == 0">
		没有任何电脑信息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>computerId</td>
				<td>computerName</td>
				<td>memory</td>
				<td>cpu</td>
				<td>videocard</td>
				<td>display</td>
				<td>hdd</td>
				<td>price</td>
				<td colspan="2" align="center">编辑</td>
				
				
				
			</tr>
			<s:iterator value="#request.computers">
				<tr>
				<td>${computerId}</td>
					<td>${computerName }</td>
					<td>${memory }</td>
					<td>${cpu }</td>
					<td>${videocard }</td>
					<td>${display }</td>
					<td>${hdd }</td>
					<td>${price }</td>
					
					
					<td>
						<a href="computer-delete?computerId=${computerId}" >Delete</a>
					</td>
					<td>
						<a href="computer-input?computerId=${computerId }">Edit</a>
					</td>
					
				</tr>
			</s:iterator>
		</table>
	</s:else>
	
	<br/>
	<br/>
		<a href="index.jsp">返回首页</a>
</body>
</html>