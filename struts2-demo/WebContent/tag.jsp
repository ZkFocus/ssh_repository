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
	<s:set var="personName" value="person.name"/>
	hello:<s:property value="#personName"/><br>
	<s:set var="janesName">Jane Doe</s:set>
	<s:property value="#janesName"/>
	<hr>
	<%-- <s:bean name="com.struts2.action.demo.Person" var="person">
		<s:param name="name" value="'Green'"></s:param>
	</s:bean>
	<s:property value="#person.name"/>
	<s:debug></s:debug> --%>
	<hr>
	<s:fielderror fieldName="fielderror" theme="simple"></s:fielderror>
	<hr>
 	<s:set var="personAge" value="#parameters.person.age[0]"/>
 	<s:if test="person.age > 18">adult</s:if>
	<s:elseif test=" 10 < person.age < 18 ">young</s:elseif>
	<s:debug></s:debug>
	<hr>
	<s:iterator value="{1,2,3,4,5}">
		<s:property />
	</s:iterator>
	<br>
	<s:iterator value="{'a','b','c','d','e'}" var="x">
		<s:property value="#x.toUpperCase()"/>
	</s:iterator>
	<br>
	<br />
		<s:iterator value="{'a', 'b', 'c'}" status="status">
			<s:property/> | 
			遍历过的元素总数：<s:property value="#status.count"/> |
			遍历过的元素索引：<s:property value="#status.index"/> |
			当前是偶数？：<s:property value="#status.even"/> |
			当前是奇数？：<s:property value="#status.odd"/> |
			是第一个元素吗？：<s:property value="#status.first"/> |
			是最后一个元素吗？：<s:property value="#status.last"/>
			<br />
		</s:iterator>
		<br>
		<s:iterator value="#{1:'a', 2:'b', 3:'c'}" >
			<s:property value="key"/> | <s:property value="value"/> <br />
		</s:iterator>
		<br>
		<s:iterator value="#{1:'a', 2:'b', 3:'c'}" var="x">
			<s:property value="#x.key"/> | <s:property value="#x.value"/> <br />
		</s:iterator>
		<br>
</body>
</html>