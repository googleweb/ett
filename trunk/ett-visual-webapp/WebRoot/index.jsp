<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath %>js3rd/jquery-easyui-1.2.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>js3rd/jquery-easyui-1.2.5/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>js3rd/jquery-easyui-1.2.5/demo/demo.css">
	<script type="text/javascript" src="<%=basePath %>js3rd/jquery-easyui-1.2.5/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>js3rd/jquery-easyui-1.2.5/jquery.easyui.min.js"></script>
	<!--  
	<script>
		$(function(){
			var p = $('body').layout('panel','west').panel({
				onCollapse:function(){
					alert('collapse');
				}
			});
			setTimeout(function(){
				$('body').layout('collapse','east');
			},0);
		});
	</script>
	-->
	
  </head>
  
  <body class="easyui-layout">
	<div region="north" border="false" style="height:110px;background:#B3DFDA;padding:10px">
	<p>影像化系统<p/>
	<div style="padding:5px;background:#fafafa;width:500px;text-align: right;float:right">
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel">Cancel</a>
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-reload">Reload</a>
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">Search</a>
		<a href="#" class="easyui-linkbutton" plain="true">Text Button</a>
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-print">Print</a>
	</div>

	</div>
	<div region="west" split="true" title="West" style="width:150px;padding:10px;">
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-cancel">Cancel</a><br>
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-reload">Reload</a><br>
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">Search</a><br>
		<a href="#" class="easyui-linkbutton" plain="true">Text Button</a><br>
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-print">Print</a><br>
	</div>
	<div region="center" title="Main Title">
	</div>
</body>

</html>
