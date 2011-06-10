<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ett.drv.model.admin.DictModel"%>
<%@ page import="com.ett.drv.model.admin.DictTypeModel"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@ page import="com.smartken.kia.core.model.impl.*"%>
<%@ page import="com.ett.model.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminDictPath=basePath+"/admin/Dict";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
  String Dict="Dict";
  JsListModel cols=new JsListModel();
  JsListModel row1=new JsListModel();
  
  JsMapModel colId=EasyUiUtil.createCheckBoxColumn(DictModel.F.Id);
 
  JsMapModel colCDictText=EasyUiUtil.createTextColumn(DictModel.F.CDictText);
  colCDictText.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"字典名",true);
  JsMapModel colCDictValue=EasyUiUtil.createTextColumn(DictModel.F.CDictValue);
  colCDictValue.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"字典值",true);
  JsMapModel colCDes1=EasyUiUtil.createTextColumn(DictModel.F.CDes1);
  colCDes1.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"CDes1",true);
  JsMapModel colCDes2=EasyUiUtil.createTextColumn(DictModel.F.CDes2);
  colCDes2.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"CDes2",true);
  JsMapModel colCDes3=EasyUiUtil.createTextColumn(DictModel.F.CDes3);
  colCDes3.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"CDes3",true);
  JsMapModel colCState=EasyUiUtil.createTextColumn(DictModel.F.CState);
  colCState.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"状态",true);
  
  JsMapModel optKm=new JsMapModel();
  optKm.put(EasyUiModel.ComboBox.Properties.URL,adminDictPath+"/combobox/DictType.action",true);
  optKm.put(EasyUiModel.ComboBox.Properties.TEXT_FIELD,DictTypeModel.F.CTypename.name(),true);
  optKm.put(EasyUiModel.ComboBox.Properties.VALUE_FIELD,DictTypeModel.F.CTypename.name(),true);
  optKm.put(EasyUiModel.ComboBox.Properties.EDITABLE,"false");
  
  JsMapModel colCTypename=EasyUiUtil.createTextColumn(DictModel.F.CTypename);
  colCTypename.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"字典类别",true);
  colCTypename.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createComboboxEditor(true,optKm));
  
  
  row1.add(colId);
  row1.add(colCTypename);
  row1.add(colCDictText);
  row1.add(colCDictValue);
  row1.add(colCDes1);
  row1.add(colCDes2);
  row1.add(colCDes3);
  row1.add(colCState);
  
  cols.add(row1);
  
  JsListModel formCols=new JsListModel();
  formCols.add(colCTypename);
  formCols.add(colCDictText);
  formCols.add(colCDictValue);
  formCols.add(colCDes1);
  formCols.add(colCDes2);
  formCols.add(colCDes3);
  formCols.add(colCState);
  
  EasyUiModel datagridDict=new EasyUiModel(JQueryModel.id(Dict),EasyUiModel.DataGrid.NAME);
  datagridDict.appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"字典管理",true)
  				  .appendAttrs(EasyUiModel.DataGrid.Properties.URL,basePath+"admin/Dict/datagrid/dicts.action",true)
  				  .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
  				  .appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,"toolbar")
  				  .appendAttrs(EasyUiModel.DataGrid.Properties.VIEW,"groupview")
  				  .appendAttrs("groupFormatter",
  				     new JsFunctionModel(new String[]{"value","rows"})
  				     .appendContext("return value +'-'+ rows.length + '条';")
  				  )
  				  .appendAttrs("groupField",DictTypeModel.F.CTypename,true)
  ;				  
  JsContextModel jsContext=new JsContextModel();
  jsContext.appendScript(datagridDict);
  
  DictModel initRow=new DictModel();
  
  %>
  var opts={};
  opts["urlAdd"]="<%=adminDictPath%>/do/add.action";
  opts["urlUpdate"]="<%=adminDictPath%>/do/modify.action";
  opts["urlRemove"]="<%=adminDictPath%>/do/delete.action";
  opts["regexp"]="#<%=Dict%>";
  opts["initRow"]=function(){return <%=initRow.toJson().toString()%>;};
  opts["editors"]=<%=formCols.toScirpt()%>;
  
  var crud=new CrudDatagrid(opts);
  var formOpts={};
  var toolbar=crud.getToolbar(formOpts);
  
  <%=JQueryModel.DOC_READY_START%>
  <%=jsContext.toScirpt()%>
  <%=JQueryModel.DOC_READY_END%>
  
  </script>
  <body> 
    <div class="innerDiv">
    <table id="<%=Dict%>"></table>
    </div>
    <div id="divEditBookLimit"></div>
  </body>
</html>
