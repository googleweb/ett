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
<title>Insert title here</title>

 <%=BaseVisualAction.importPageResourceContext() %>
<script type="text/javascript">

 
var colName = { title:"Name" , field:"Name", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colDescp = { title:"Descp" , field:"Descp", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colTokenArray = { title:"TokenArray" , field:"TokenArray", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colId = { title:"Id" , field:"Id", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 


var editorsRoleModel=[ colName,colDescp,colTokenArray] ; 
var optsRoleModel = { }; 
optsRoleModel["regexp"] = "#tableRoleModel"; 
optsRoleModel["id"] = "Id"; 
optsRoleModel["urlUpdate"] ="<%=basePath %>/admin/Role/do/update.action" ; 
optsRoleModel["urlAdd"]="<%=basePath %>/admin/Role/do/add.action"  ; 
optsRoleModel["urlRemove"]="<%=basePath %>/admin/Role/do/remove.action"; 
optsRoleModel["editors"] = editorsRoleModel; 

var crudRoleModel = new CrudDatagrid(optsRoleModel); 
var toolbarRoleModel = crudRoleModel.getToolbar(); 
var editRowRoleModel = crudRoleModel.getEditRowHandler(); 

$(document).ready(function(){ 
$("#tableRoleModel").datagrid({ 
url:"<%=basePath %>/admin/Role/datagrid/list.action" 
, idField:"Id" 
, columns:[[colName,colDescp,colTokenArray,colId]] 
, toolbar:toolbarRoleModel 
, onDblClickRow:editRowRoleModel 
}) ;  
}); 

</script>
</head>
<body class="easyui-layout">
    <div region="center">
      <table id="tableRoleModel"></table>
   </div>
</body>
</html>