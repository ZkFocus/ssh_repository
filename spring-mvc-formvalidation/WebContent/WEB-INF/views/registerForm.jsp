<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 
 <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sf:form  method="post" commandName="user">
	name:<sf:input path="name"/><sf:errors path="name"/>
		<br>
		tel:<sf:input path="tel"/><sf:errors path="tel"/>
		<br>
		password:<sf:password path="password"/><sf:errors path="password"/>
		<br>
		<input type="submit" value="register">
	</sf:form>
	
	<!-- <form action="testRegister" method="post">
		name:<input type="text" name="name"><br>
		tel:<input type="text" name="tel"><br>
		password:<input type="password" name="password"><br>
		<input type="submit" value="提交">
	</form> -->
</body>
</html>