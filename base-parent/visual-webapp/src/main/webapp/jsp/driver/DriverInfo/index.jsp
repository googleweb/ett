<%@page import="com.smartken.toyz4j.model.impl.BaseAction"%>
<%@page import="com.ett.visual.action.BaseVisualAction"%>
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

var colFileNo = { title:"FileNo" , field:"FileNo", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colPhone = { title:"Phone" , field:"Phone", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colIdcardNo = { title:"IdcardNo" , field:"IdcardNo", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colId = { title:"Id" , field:"Id", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colSchoolCode = { title:"SchoolCode" , field:"SchoolCode", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 


var editorsDriverInfoModel=[ colName,colFileNo,colPhone,colIdcardNo,colId,colSchoolCode ] ; 
var optsDriverInfoModel = { }; 
optsDriverInfoModel["regexp"] = "#tableDriverInfoModel"; 
optsDriverInfoModel["id"] = "Id"; 
optsDriverInfoModel["urlUpdate"] ="<%=basePath %>/driver/DriverInfo/do/update.action" ; 
optsDriverInfoModel["urlAdd"]="<%=basePath %>/driver/DriverInfo/do/add.action" ; 
optsDriverInfoModel["urlRemove"]="<%=basePath %>/driver/DriverInfo/do/remove.action"; 
optsDriverInfoModel["editors"] = editorsDriverInfoModel; 

var crudDriverInfoModel = new CrudDatagrid(optsDriverInfoModel); 
var toolbarDriverInfoModel = crudDriverInfoModel.getToolbar(); 
var editRowDriverInfoModel = crudDriverInfoModel.getEditRowHandler(); 

$(document).ready(function(){ 
$("#tableDriverInfoModel").datagrid({ 
url:"<%=basePath %>/driver/DriverInfo/datagrid/list.action" 
, idField:"Id" 
, columns:[[colName,colFileNo,colPhone,colIdcardNo,colId,colSchoolCode]] 
, toolbar:toolbarDriverInfoModel 
, onDblClickRow:editRowDriverInfoModel 
}) ;  
}); 


</script>

</head>
<body class="easyui-layout">
  <div region="center" >
    <table id="tableDriverInfoModel"></table>
  </div>
</body>
</html>