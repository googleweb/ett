<%@page import="com.smartken.toyz4j.model.impl.BaseAction"%>
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


  function doScan(rowData,rowIndex){
	  var name=rowData["Name"];
	  var id=rowData["Id"];
	  var div=$("<div></div>");
	  div.toyzIframe("drv/DriverFile/to/scan.action?driverId="+id);
	  div.window({width:1024
		  ,height:500
		  ,title:"扫描文件:"+name
		  ,modal:true
		  ,onClose:function(){
			  div.dialog("destroy",true);
		  } 
	  });
	  
  }

	var colName = { title:"Name" , field:"Name", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colPhone = { title:"Phone" , field:"Phone", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colIdcard = { title:"Idcard" , field:"Idcard", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colSchoolName = { title:"SchoolName" , field:"SchoolName", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colId = { title:"Id" , field:"Id", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colDabh = { title:"Dabh" , field:"Dabh", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colSyn = { title:"Syn" , field:"Syn", width:100,editor:{type:"numberspinner",options:{ increment:1,precision:0 } } } ; 

	var colSynResult = { title:"SynResult" , field:"SynResult", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

	var colSchoolCode = { title:"SchoolCode" , field:"SchoolCode", width:200,editor:{type:"combobox",options:{ url:"",textField:"",valueField:"",editable:false,multiple:false } } } ; 

	
 var editorsDriverInfoModel=[ colName,colPhone,colIdcard,colSchoolName,colId,colDabh,colSyn,colSynResult,colSchoolCode ] ;  
var optsDriverInfoModel = { }; 
optsDriverInfoModel["regexp"] = "#tableDriverInfoModel"; 
optsDriverInfoModel["id"] = "Id"; 
optsDriverInfoModel["urlUpdate"] ="drv/DriverInfo/do/update.action" ; 
optsDriverInfoModel["urlAdd"]="drv/DriverInfo/do/add.action" ; 
optsDriverInfoModel["urlRemove"]="drv/DriverInfo/do/removePks.action"; 
optsDriverInfoModel["urlExportExcel"]="drv/DriverInfo/excel/list.action"; 
optsDriverInfoModel["urlQuery"]="drv/DriverInfo/datagrid/query.action"; 
optsDriverInfoModel["editors"] = editorsDriverInfoModel; 

var crudDriverInfoModel = new CrudDatagrid(optsDriverInfoModel); 
var toolbarDriverInfoModel = crudDriverInfoModel.getToolbar(); 
var editRowDriverInfoModel = crudDriverInfoModel.getEditRowHandler(); 

$(document).ready(function(){ 
$("#tableDriverInfoModel").datagrid({ 
url:"drv/DriverInfo/datagrid/list.action" 
, idField:"Id" 
, columns:[[colName,colPhone,colIdcard,colSchoolName,colId,colDabh,colSyn,colSynResult,colSchoolCode]] 
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