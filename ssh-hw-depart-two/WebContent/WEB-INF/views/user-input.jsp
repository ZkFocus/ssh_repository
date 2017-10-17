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
  <s:form action="user-save" method="post">
  		<s:if test="id !=null">
  			<s:textfield name="name" label="name" disabled="true"></s:textfield>
  			<s:hidden name="id"></s:hidden>
  		</s:if>
  		<s:else>
  			<s:textfield name="name" label="name"></s:textfield>
  		</s:else>
  		<s:textfield name="tel" label="tel"> </s:textfield>
  		<s:submit value="submit"></s:submit>
  </s:form>
</body>
</html>