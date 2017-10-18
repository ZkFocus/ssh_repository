<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#cpuPrice").change(function(){
		alert($(this).val());
	})
});
</script>
</head>
<body>

	<s:debug></s:debug>

	<h4>Computer Input Page</h4>

	<s:form action="computer-save" method="post">
	
	
	<s:if test="computerId != null">
			<s:textfield name="computerName" label="电脑名称" disabled="true"></s:textfield>
			<s:hidden name="computerId"></s:hidden>
		</s:if>
		<s:else>
			<s:textfield name="computerName" label="电脑名称"></s:textfield>
		</s:else>
	
	
		<s:select id="cpuPrice" list="#request.componentCPU" listKey="componentId"
			listValue="componentName" name="cpu" label="CPU" value="#request.cpuValue">
		</s:select>
		<s:select  list="#request.componentNC" listKey="componentId"
			listValue="componentName" name="memory" label="内存" value="#request.ncValue">
		</s:select>
		<s:select  list="#request.componentXK" listKey="componentId"
			listValue="componentName" name="videocard" label="显卡"  value="#request.xkValue">
		</s:select>
		<s:select  list="#request.componentYP" listKey="componentId"
			listValue="componentName" name="hdd" label="硬盘" value="#request.ypValue">
		</s:select>
		<s:select  list="#request.componentXSQ" listKey="componentId"
			listValue="componentName" name="display" label="显示器" value="#request.xsqValue">
		</s:select>
		<s:textfield name="price" label="价钱"></s:textfield>
		<s:submit></s:submit>	
	</s:form>

</body>
</html>