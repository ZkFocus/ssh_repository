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
	<s:if test="#request.users==null||#request.users.size()==0">
		No anyone User
	</s:if>
	<s:else>
		<table cellpadding="10" cellspacing="0" border="1">
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>电话</td>
				<td>EDIT</td>
				<td>DEL</td>
			</tr>
			<s:iterator value="#request.users">
				<tr>
					<td>${id }</td>
					<td>${name }</td>
					<td>${tel }</td>
					<td><a href="user-input?id=${id}">edit</a></td>
					<td><a href="user-delete?id=${id}">del</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
	<br>
	<br>
	<a href="user-input"> 添加用户</a>

</body>
</html>