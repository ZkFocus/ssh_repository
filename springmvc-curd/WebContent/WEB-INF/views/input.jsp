<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- form表单通过modelAttribute属性指定绑定的模型属性，如果没有该属性，则默认从request域对象中读取command的表单bean 如果还没有 则报错 -->
	<form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">
			
		<c:if test="${employee.id ==null }">	
		<!-- path相当于HTML中的name属性 -->
		LastName:<form:input path="lastName" /><br>
		</c:if>
		<c:if test="${employee.id !=null }">
			<form:hidden path="id" />
			<!-- form表单作用用于表单回显，path所对应属性在modelAttribute对应bean必须对应  form:hidden没有value属性，应该使用input-->
			<input type="hidden" name="_method" value="PUT">
		</c:if>
		
		
		email:<form:input path="email" /><br>
		<% 
			Map<String,String> genders=new HashMap();
			genders.put("1", "male");
			genders.put("0", "female");
			
			request.setAttribute("genders", genders);
		%>
		<!-- genders不能直接显示 需要放入 域对象里-->
		gender:<form:radiobuttons path="gender" items="${genders }"/><br>
		<!-- path支持级联属性 -->
		departments:<form:select path="department.id" items="${departments }"
								itemLabel="departmentName" itemValue="id">
					</form:select><br>
		<!--  -->
		Birth:<form:input path="birth" />
		<br>
		Salary:<form:input path="salary" />

			<input type="submit" value="Submit"/>
		
					
	</form:form>


</body>
</html>