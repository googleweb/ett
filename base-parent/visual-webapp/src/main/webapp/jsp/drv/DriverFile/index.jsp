<%@page import="com.ett.visual.action.BaseVisualAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   String basePath=BaseVisualAction.GetRootPath();
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%=BaseVisualAction.importPageResourceContext() %>


<script type="text/javascript">


var colDrvId = { title:"DrvId" , field:"DrvId", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colId = { title:"Id" , field:"Id", width:100,editor:{type:"numberspinner",options:{ increment:1,precision:0 } } } ; 

var colResId = { title:"ResId" , field:"ResId", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 


var editorsDriverFileModel=[ colDrvId,colResId ] ; 
var optsDriverFileModel = { }; 
optsDriverFileModel["regexp"] = "#tableDriverFileModel"; 
optsDriverFileModel["id"] = "Id"; 
optsDriverFileModel["urlUpdate"] ="drv/DriverFile/do/update.action" ; 
optsDriverFileModel["urlAdd"]="drv/DriverFile/do/add.action" ; 
optsDriverFileModel["urlRemove"]="drv/DriverFile/do/removePks.action"; 
optsDriverFileModel["urlExportExcel"]="drv/DriverFile/excel/list.action"; 
optsDriverFileModel["urlQuery"]="drv/DriverFile/datagrid/query.action"; 
optsDriverFileModel["editors"] = editorsDriverFileModel; 

var crudDriverFileModel = new CrudDatagrid(optsDriverFileModel); 
var toolbarDriverFileModel = crudDriverFileModel.getToolbar(); 
var editRowDriverFileModel = crudDriverFileModel.getEditRowHandler(); 

$(document).ready(function(){ 
$("#tableDriverFileModel").datagrid({ 
url:"drv/DriverFile/datagrid/list.action" 
, idField:"Id" 
, columns:[[colDrvId,colId,colResId]] 
, toolbar:toolbarDriverFileModel 
, onDblClickRow:editRowDriverFileModel 
}) ; //$("#tableDriverFileModel").datagrid 
}); 



</script>

</head>
<body class="easyui-layout">

   <div region="center">
      <table id="tableDriverFileModel"></table>
   </div>
</body>
</html>