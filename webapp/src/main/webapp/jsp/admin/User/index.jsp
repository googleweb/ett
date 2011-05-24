<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.admin.UserModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.model.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menuConfig-success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<jsp:include page="/plugin/index.jsp">
	 	<jsp:param value="jquery,easyui" name="plugin"/>
	</jsp:include>
   <jsp:include page="/css/index.jsp"></jsp:include>
   <jsp:include page="/js/index.jsp"></jsp:include>  
  </head>
<script type="text/javascript">
function operaFormatter(value,rowData,rowIndex){
    	var aEidt="<a title='编辑' href='javascript:void(0)' class='kia-icon edit' onclick='clickEditHandler("+rowData["id"]+");'></a>";
        return aEidt;
    }
function clickAddHandler(){ 
  		var href='<%=basePath%>'+"admin/User/to/editUser.action";
  		$("#divEditUser").dialog({
  			title:"新增用户",
			height:400,
			width:600,
			onClose:function(){ $('#test').datagrid('reload'); },
	    	modal:true,
			onBeforeOpen:function(){$(this).kiaIframe(href);}} 
		);    //   end:$("#divEdit").dialog
 }
function dblClickRowHandler(rowIndex,rowData){ 
	    var id=rowData["id"];
	    var fullname=rowData["<%=UserModel.F.fullName%>"];
  		var href='<%=basePath%>'+"admin/User/to/editUser.action?id="+id;
  		$("#divEditUser").dialog({
  			title:"修改用户:"+fullname,
			height:400,
			width:600,
			onClose:function(){ $('#test').datagrid('reload'); },
	    	modal:true,
			onBeforeOpen:function(){$(this).kiaIframe(href);}} 
		);//   end:$("#divEdit").dialog
 }
function clickRemoveHandler(){ 
 		 $.messager.confirm('操作提示','确认删除用户?',function(yes){		 		
					var selectsRows=$("#test").datagrid("getSelections");
					var ids="";
					$.each(selectsRows,function(index,row){
							ids+=','+row['id'];  
							});
					var action="<%=basePath%>"+"admin/User/do/deleteUser.action";
					$.post(action,{ids:ids},
							function(str){
									var json=Kia.util.strToJson(str);
									Kia.util.handleJsonResult(json);
									$("#test").datagrid("reload");
					});
		});  //$.messager
}
$(document).ready(function(){   
	$("#test").datagrid({fit:true,
	toolbar:[ 
			{text:"新增用户",
			iconCls:"icon-add",
			handler:clickAddHandler}
	, 
			{text:"删除用户",
			iconCls:"icon-remove",
			handler:clickRemoveHandler}
	] 
    ,
	columns:[ 
	[ 
	{field:"id",checkbox:true},
	{field:"loginName",title:"用户名",width:150},
	{field:"beginip",title:"开始IP",width:150},
	{field:"workid",title:"工作号",width:150},
	{field:"roleid",title:"角色号",width:150},
	{field:"state",title:"状态",width:150},
	{field:"idcard",title:"卡号",width:150},
	{field:"depid",title:"部门编号",width:150},
	{field:"fullName",title:"全名",width:150},
	{field:"endip",title:"结束IP",width:150}	
	]
	] 
	,
	pagination:true,
	onDblClickRow:dblClickRowHandler
	,
	url:'<%=basePath%>'+"admin/User/datagrid/users.action"} 
);    //   end:$("#tableDG").datagrid
}); //$(document).ready
</script>
  <body>
    <div class="innerDiv">
	<table id="test"></table>
	</div>
	<div id="divEditUser"></div>	
  </body>
</html>