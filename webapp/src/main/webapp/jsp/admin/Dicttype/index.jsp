<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.admin.DictTypeModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.model.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminDictTypePath=basePath+"admin/Dicttype";
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

    <%
      String tableDictType="tableDictType";
    
      JsListModel cols=new JsListModel();
      JsListModel row1=new JsListModel();
      
      JsMapModel colId=EasyUiUtil.createCheckBoxColumn(DictTypeModel.F.Id);
      
      JsMapModel colTypeName=EasyUiUtil.createTextColumn(DictTypeModel.F.CTypename);
      colTypeName.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"类型名称",true);
      colTypeName.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,null));
      
      JsMapModel colCDescription=EasyUiUtil.createTextColumn(DictTypeModel.F.CDescription);
      colCDescription.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"类型描述",true);
      colCDescription.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,null));
      row1.add(colId);
      row1.add(colTypeName);
      row1.add(colCDescription);
      
      cols.add(row1);
      
      JsListModel formCols=new JsListModel();
      formCols.add(colTypeName);
      formCols.add(colCDescription);
    
      EasyUiModel datagridDictType=new EasyUiModel(JQueryModel.id(tableDictType),EasyUiModel.DataGrid.NAME);
      datagridDictType
      .appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"字典类型管理",true)
      .appendAttrs(EasyUiModel.DataGrid.Properties.URL,adminDictTypePath+"/datagrid/dict.action",true)
      .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
      .appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,"toolbar")
      ;

      JsContextModel jsContext=new JsContextModel();
      jsContext.appendScript(datagridDictType);

    
      DictTypeModel initRow=new DictTypeModel();
      
    %> 

    
    var opts={};
    opts["urlAdd"]="<%=adminDictTypePath%>/do/addDict.action";
    opts["urlUpdate"]="<%=adminDictTypePath%>/do/modifyDict.action";
    opts["urlRemove"]="<%=adminDictTypePath%>/do/deleteDict.action";
    opts["regexp"]="#<%=tableDictType%>";
    opts["initRow"]=function(){return <%=initRow.toJson().toString()%>; };
    opts["editors"]=<%=formCols.toScirpt() %>;
    
    var crud= new CrudDatagrid(opts);
    var formOpts={};
    var toolbar=crud.getToolbar(formOpts);

    <%=JQueryModel.DOC_READY_START %>
    <%=jsContext.toScirpt()%>
    <%=JQueryModel.DOC_READY_END %>

</script>
  <body>
    <div class="innerDiv">
	<table id="<%=tableDictType %>"></table>
	</div>
	<div id="divEditDict"></div>	
  </body>
</html>