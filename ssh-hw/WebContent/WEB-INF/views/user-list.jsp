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
	
	<s:if test="#request.users == null || #request.users.size() == 0">
		没有任何人员信息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>TEL</td>
				<td>DELETE</td>
				<td>EDIT</td>
				
			</tr>
			<s:iterator value="#request.users">
				<tr>
					<td>${id }</td>
					<td>${name }</td>
					<td>${tel }</td>
					<td>
						<a href="user-delete?id=${id }" class="delete">Delete</a>
						<input type="hidden" value="${name }"/>
					</td>
					<td>
						<a href="user-input?id=${id }">Edit</a>
					</td>
					
				</tr>
			</s:iterator>
		</table>
	</s:else>
	
	<br/>
	<br/>
		<a href="user-input">Add New User</a>

	
</body>
</html>