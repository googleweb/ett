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

 
var colText = { title:"Text" , field:"Text", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colValue = { title:"Value" , field:"Value", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colTypeFk = { title:"TypeFk" , field:"TypeFk", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colRemark = { title:"Remark" , field:"Remark", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colState = { title:"State" , field:"State", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colId = { title:"Id" , field:"Id", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 


var editorsDictModel=[ colText,colValue,colTypeFk,colRemark,colState] ; 
var optsDictModel = { }; 
optsDictModel["regexp"] = "#tableDictModel"; 
optsDictModel["id"] = "Id"; 
optsDictModel["urlUpdate"] ="<%=basePath %>/admin/Dict/do/update.action" ; 
optsDictModel["urlAdd"]="<%=basePath %>/admin/Dict/do/add.action"  ; 
optsDictModel["urlRemove"]="<%=basePath %>/admin/Dict/do/remove.action"; 
optsDictModel["editors"] = editorsDictModel; 

var crudDictModel = new CrudDatagrid(optsDictModel); 
var toolbarDictModel = crudDictModel.getToolbar(); 
var editRowDictModel = crudDictModel.getEditRowHandler(); 

$(document).ready(function(){ 
$("#tableDictModel").datagrid({ 
url:"<%=basePath %>/admin/Dict/datagrid/list.action" 
, idField:"Id" 
, columns:[[ colText,colValue,colTypeFk,colRemark,colState]] 
, toolbar:toolbarDictModel 
, onDblClickRow:editRowDictModel 
}) ;  
}); 

</script>
</head>
<body class="easyui-layout">
    <div region="center">
      <table id="tableDictModel"></table>
   </div>
</body>
</html>