<%@page import="com.ett.visual.action.BaseVisualAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   String basePath=BaseVisualAction.GetRootPath();
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%=BaseVisualAction.importPageResourceContext() %>


<script type="text/javascript">

var colOperPk = { title:"OperPk" , field:"OperPk", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colLastModifyDate = { title:"LastModifyDate" , field:"LastModifyDate", width:120,editor:{type:"datebox",options:{  } } } ; 

var colId = { title:"Id" , field:"Id", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colDriverPk = { title:"DriverPk" , field:"DriverPk", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colRemark = { title:"Remark" , field:"Remark", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colCreateDate = { title:"CreateDate" , field:"CreateDate", width:120,editor:{type:"datebox",options:{  } } } ; 

var colTitle = { title:"Title" , field:"Title", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colType = { title:"Type" , field:"Type", width:120,editor:{type:"combobox",options:{ required:false,missingMessage:"",invalidMessage:"" } }  } ; 

var colStatus = { title:"Status" , field:"Status", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colCompleteInd = { title:"CompleteInd" , field:"CompleteInd", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colCleanInd = { title:"CleanInd" , field:"CleanInd", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colIndexInd = { title:"IndexInd" , field:"IndexInd", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colLastCheckDate = { title:"LastCheckDate" , field:"LastCheckDate", width:200,editor:{type:"datebox",options:{  } } } ; 

var querys=[
    {column:colTitle,queryTypes:["eq","notlike","isnull"]}
    ,{column:colCreateDate,queryTypes:["isin","neq","like"]}
    ,{column:colType,queryTypes:["isin","neq","like"]}
];

var editorsDriverFileModel=[ colOperPk,colLastModifyDate,colDriverPk,colRemark,colCreateDate,colTitle,colType,colStatus,colCompleteInd,colCleanInd,colIndexInd,colLastCheckDate ] ; 
var optsDriverFileModel = { }; 
optsDriverFileModel["regexp"] = "#tableDriverFileModel"; 
optsDriverFileModel["id"] = "Id"; 
optsDriverFileModel["urlUpdate"] ="<%=basePath %>/driver/DriverFile/do/update.action" ; 
optsDriverFileModel["urlAdd"]="<%=basePath %>/driver/DriverFile/do/add.action" ; 
optsDriverFileModel["urlRemove"]="<%=basePath %>/driver/DriverFile/do/removePks.action"; 
optsDriverFileModel["urlQuery"]="<%=basePath %>/driver/DriverFile/datagrid/query.action"; 
optsDriverFileModel["editors"] = editorsDriverFileModel; 
optsDriverFileModel["querys"]=querys;

var crudDriverFileModel = new CrudDatagrid(optsDriverFileModel); 
var toolbarDriverFileModel = crudDriverFileModel.getToolbar(); 
var editRowDriverFileModel = crudDriverFileModel.getEditRowHandler(); 

$(document).ready(function(){ 
$("#tableDriverFileModel").datagrid({ 
url:"<%=basePath %>/driver/DriverFile/datagrid/list.action" 
, idField:"Id" 
, columns:[[ colOperPk,colLastModifyDate,colDriverPk,colRemark,colCreateDate,colTitle,colType,colStatus,colCompleteInd,colCleanInd,colIndexInd,colLastCheckDate ]] 
, toolbar:toolbarDriverFileModel 
, onDblClickRow:editRowDriverFileModel 
}) ;  
}); 

</script>

</head>
<body class="easyui-layout">

   <div region="center">
      <table id="tableDriverFileModel"></table>
   </div>
</body>
</html>