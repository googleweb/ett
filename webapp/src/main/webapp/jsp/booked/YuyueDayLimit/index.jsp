<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ett.drv.model.booked.BookedDayLimitModel"%>
<%@ page import="com.ett.drv.model.admin.DictModel"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@ page import="com.smartken.kia.core.model.impl.*"%>
<%@ page import="com.ett.model.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bookedDayLimitPath=basePath+"booked/YuyueDayLimit";
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
  String bookedDayLimit="bookedDayLimit";
  JsListModel cols=new JsListModel();
  JsListModel row1=new JsListModel();
  
  JsMapModel colId=EasyUiUtil.createCheckBoxColumn(BookedDayLimitModel.F.Id);
  JsMapModel colCarType=EasyUiUtil.createTextColumn(BookedDayLimitModel.F.CCartype);
  colCarType.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"车类型",true);
  
  JsMapModel colDayLimit=EasyUiUtil.createIntColumn(BookedDayLimitModel.F.IDays);
  colDayLimit.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"间隔天数",true);
  
  
  JsMapModel optKm=new JsMapModel();
  optKm.put(EasyUiModel.ComboBox.Properties.URL,bookedDayLimitPath+"/combobox/Km.action",true);
  optKm.put(EasyUiModel.ComboBox.Properties.TEXT_FIELD,DictModel.F.CDictText.name(),true);
  optKm.put(EasyUiModel.ComboBox.Properties.VALUE_FIELD,DictModel.F.CDictValue.name(),true);
  optKm.put(EasyUiModel.ComboBox.Properties.EDITABLE,"false");
  
  JsMapModel colKm=EasyUiUtil.createTextColumn(BookedDayLimitModel.F.IKm);
  colKm.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"科目号",true);
  colKm.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createComboboxEditor(true,optKm));
  
  
  row1.add(colId);
  row1.add(colCarType);
  row1.add(colDayLimit);
  row1.add(colKm);
  
  cols.add(row1);
  
  JsListModel formCols=new JsListModel();
  formCols.add(colCarType);
  formCols.add(colDayLimit);
  formCols.add(colKm);
  
  EasyUiModel datagridDayLimit=new EasyUiModel(JQueryModel.id(bookedDayLimit),EasyUiModel.DataGrid.NAME);
  datagridDayLimit.appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"预约间隔限制管理",true)
  				  .appendAttrs(EasyUiModel.DataGrid.Properties.URL,bookedDayLimitPath+"/datagrid/yuyuedaylimit.action",true)
  				  .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
  				  .appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,"toolbar");
  				  
  JsContextModel jsContext=new JsContextModel();
  jsContext.appendScript(datagridDayLimit);
  
  BookedDayLimitModel initRow=new BookedDayLimitModel();
  
  %>
  var opts={};
  opts["urlAdd"]="<%=bookedDayLimitPath%>/do/add.action";
  opts["urlUpdate"]="<%=bookedDayLimitPath%>/do/modify.action";
  opts["urlRemove"]="<%=bookedDayLimitPath%>/do/deleteDayLimit.action";
  opts["regexp"]="#<%=bookedDayLimit%>";
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
    <table id="<%=bookedDayLimit%>"></table>
    </div>
    <div id="divEditBookLimit"></div>
  </body>
</html>
