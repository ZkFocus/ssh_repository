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

	<s:form action="">
		<!-- key方式 直接去资源文件中获取value值 -->
			<s:textfield name="username" key="username"></s:textfield>
			<s:textfield name="password" key="password"></s:textfield>
			<s:submit key="submit"></s:submit>
	</s:form>

</body>
</html>