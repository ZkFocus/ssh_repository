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
<s:debug></s:debug>
	<h4>Users List Page</h4>
	<s:if test=" #request.pageBean.list.size() == 0">
		没有任何组件信息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>componentId</td>
				<td>componentName</td>
				<td>capacity</td>
				<td>price</td>
				<td>type</td>
				<td colspan="2" align="center">编辑</td>
				
			</tr>
			<s:iterator value="#request.pageBean.list" id="component">
				<tr>
					<td>${component.componentId }</td>
					<td>${component.componentName }</td>
					<s:if test="#component.capacity=='' ">
						<td>----</td>
					</s:if>
					<s:else>
						<td>${component.capacity }</td>
					</s:else>
					<td>${component.price }</td>
					<td>${component.componentType.typeName }</td>
					
					
					<td>
						<a href="component-delete?componentId=${component.componentId }">Delete</a>
					</td>
					<td>
						<a href="component-input?componentId=${component.componentId }">Edit</a>
					</td>
					
				</tr>
			</s:iterator>
				
			 <a href="component-list">首页,</a>共<s:property value="#request.pageBean.totalPage"/>页,<s:property value="#request.pageBean.allRows"/>条记录
			 <a href="component-list?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
			  <a href="component-list?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
			
		</table>
			<%-- 总<s:property value=#request.pageSize />页 --%>
			<%-- 共<s:property value="#request.total"/>条记录 --%>
	</s:else>
	<br/>
		
	<br/>
	<br/>
		<a href="index.jsp">返回首页</a>
</body>
</html>