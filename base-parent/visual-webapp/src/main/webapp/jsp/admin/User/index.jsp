<%@page import="com.ett.visual.action.BaseVisualAction"%>
<%@page import="com.smartken.toyz4j.model.impl.BaseAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String basePath=BaseVisualAction.getRootPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<%=BaseVisualAction.importPageResourceContext() %>
<script type="text/javascript">
var colRoleFk = { title:"RoleFk" , field:"RoleFk", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colPrivateToken = { title:"PrivateToken" , field:"PrivateToken", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colPersonName = { title:"PersonName" , field:"PersonName", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colSignName = { title:"SignName" , field:"SignName", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colLoginName = { title:"LoginName" , field:"LoginName", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colLoginPwd = { title:"LoginPwd" , field:"LoginPwd", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colBeginIp = { title:"BeginIp" , field:"BeginIp", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colState = { title:"State" , field:"State", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colPublicToken = { title:"PublicToken" , field:"PublicToken", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colEndIp = { title:"EndIp" , field:"EndIp", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colId = { title:"Id" , field:"Id", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colDepFk = { title:"DepFk" , field:"DepFk", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colWorkId = { title:"WorkId" , field:"WorkId", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	
 var editorsUserModel=[ colRoleFk,colPrivateToken,colPersonName,colSignName,colLoginName,colLoginPwd,colBeginIp,colState,colPublicToken,colEndIp,colId,colDepFk,colWorkId ] ; 
var optsUserModel = { }; 
optsUserModel["regexp"] = "#tableUserModel"; 
optsUserModel["id"] = "Id"; 
optsUserModel["urlUpdate"] ="<%=basePath %>/admin/User/do/update.action" ; 
optsUserModel["urlAdd"]="<%=basePath %>/admin/User/do/add.action" ; 
optsUserModel["urlRemove"]="<%=basePath %>/admin/User/do/remove.action"; 
optsUserModel["editors"] = editorsUserModel; 

var crudUserModel = new CrudDatagrid(optsUserModel); 
var toolbarUserModel = crudUserModel.getToolbar(); 
var editRowUserModel = crudUserModel.getEditRowHandler(); 

$(document).ready(function(){ 
$("#tableUserModel").datagrid({ 
 url:"<%=basePath %>/admin/User/datagrid/list.action" 
 , idField:"Id" 
 , columns:[[colRoleFk,colPrivateToken,colPersonName,colSignName,colLoginName,colLoginPwd,colBeginIp,colState,colPublicToken,colEndIp,colId,colDepFk,colWorkId]] 
 , toolbar:toolbarUserModel 
, onDblClickRow:editRowUserModel 
 }) ;  
}); 





</script>
</head>


<body class="easyui-layout">
    <div region="center">
      <table id="tableUserModel"></table>
    </div>
</body>
</html>