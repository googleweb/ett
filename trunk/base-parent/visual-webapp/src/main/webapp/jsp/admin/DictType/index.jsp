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

var colRemark = { title:"Remark" , field:"Remark", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 

var colId = { title:"Id" , field:"Id", width:200,editor:{type:"validatebox",options:{ required:false,missingMessage:"",invalidMessage:"" } } } ; 


var editorsDictTypeModel=[ colText,colRemark] ; 
var optsDictTypeModel = { }; 
optsDictTypeModel["regexp"] = "#tableDictTypeModel"; 
optsDictTypeModel["id"] = "Id"; 
optsDictTypeModel["urlUpdate"] ="<%=basePath %>/admin/DictType/do/update.action" ; 
optsDictTypeModel["urlAdd"]="<%=basePath %>/admin/DictType/do/add.action"  ; 
optsDictTypeModel["urlRemove"]="<%=basePath %>/admin/DictType/do/remove.action"; 
optsDictTypeModel["editors"] = editorsDictTypeModel; 

var crudDictTypeModel = new CrudDatagrid(optsDictTypeModel); 
var toolbarDictTypeModel = crudDictTypeModel.getToolbar(); 
var editRowDictTypeModel = crudDictTypeModel.getEditRowHandler(); 

$(document).ready(function(){ 
$("#tableDictTypeModel").datagrid({ 
url:"<%=basePath %>/admin/DictType/datagrid/list.action" 
, idField:"Id" 
, columns:[[ colText,colRemark]] 
, toolbar:toolbarDictTypeModel 
, onDblClickRow:editRowDictTypeModel 
}) ;  
}); 

</script>
</head>
<body class="easyui-layout">
    <div region="center">
      <table id="tableDictTypeModel"></table>
   </div>
</body>
</html>