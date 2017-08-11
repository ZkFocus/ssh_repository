<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.2/themes/icon.css">
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height:60px;"></div>
	<div data-options="region:'south'" style="height:20px;"></div>
	<div data-options="region:'west'" style="width:200px;">
		<div class="easyui-panel" data-options="title:'west',border:false,fit:true"></div>
	</div>
	<div data-options="region:'east',title:'east',split:true" style="width:200px;"></div>
	<div data-options="region:'center',title:'center'"></div>
		
	<div class="easyui-dialog" data-options="title:'登录',modal:true,closable:false,buttons:[{
				text:'登录',
				iconCls:'icon-edit',
				handler:function(){}
			},{
				text:'注册',
				iconCls:'icon-help',
				handler:function(){}
			}]">
		<table>
			<tr>
				<th>登录名</th>
				<td><input /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input /></td>
			</tr>
		</table>
	</div>	
	
</body>
</html>