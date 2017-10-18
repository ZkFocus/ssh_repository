<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function(){
		$("#typeId").change(function(){
			var typeid=$(this).val();
			if(typeid==2||typeid==4){
				//$("#capacityId").show();
				alert(typeid+"---");
				$("table tr:eq(2)").show();
				//$("tr").eq(2).show();
			}else {
				//$("#capacityId").hide();
				alert(typeid+"===");
				$("table tr:eq(2)").hide();
				//$("tr").eq(2).hide();
			}
		})
	});

	$(function(){
		$("#capacityId").change(function(){
			var $typeid= $("#typeId");
			var typeid=$typeid.val();
			var $capacityId=$("#capacityId");
			var capacityId=$capacityId.val()
			//内存计算方法
			if(typeid==2){
				//alert(typeid);
				if(capacityId<=2){
					//alert(capacityId);
					$("#priceId").val(100);
				}if(capacityId>2){
					$("#priceId").val(capacityId*40);
				}
			}
			//硬盘计算方法
			if(typeid==4){
				if(capacityId<=200){
					//alert(capacityId);
					$("#priceId").val(200);
				}if(capacityId>200){
					$("#priceId").val(capacityId*1.2);
				}
			}
		})
	});
$(function(){
	$("#componentName").change(function(){
		var val=$(this).val();
		val =$.trim(val);
		if(val !=""){
			var url= "${pageContext.request.contextPath}/web/component-verify";
			var args={"componentName":val,"time":new Date()};
			$.post(url,args,function(data){
				$("#info").html(data.result);
			})
		}
	})
})
</script>
</head>
<body>

	<s:debug></s:debug>
	<s:form action="component-save">

		<s:if test="componentId != null">
			<s:textfield name="componentName" label="配件名称" disabled="true"></s:textfield>
			<s:hidden name="componentId"></s:hidden>
		</s:if>
		<s:else>
			<s:textfield name="componentName" label="配件名称" id="componentName"></s:textfield>
			<div id="info" style="color: green;"></div>
		</s:else>


		<s:select id="typeId" list="#request.componentTypes" listKey="typeId"
			listValue="typeName" name="componentType.typeId" label="配件类型">
		</s:select>
		

		<s:textfield id="capacityId" name="capacity" label="配件容量"></s:textfield>

		<s:textfield id="priceId" name="price" label="配件价格"></s:textfield>


		<s:submit></s:submit>


	</s:form>
</body>
</html>