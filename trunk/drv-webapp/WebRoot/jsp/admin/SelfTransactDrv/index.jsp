<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.smartken.kia.core.util.StringUtil"%>
<%@page import="com.ett.drv.model.self.TransactDriverModel"%>
<%@page import="com.ett.drv.model.self.BaseTransactModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminSelfTransactDrv=basePath+"admin/SelfTransactDrv";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
     
    <title>My JSP 'tranDrv.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<jsp:include page="/plugin/index.jsp">
	   <jsp:param  name="plugin" value="jquery,easyui"/>
	</jsp:include>
    <jsp:include page="/css/index.jsp"></jsp:include>
    <jsp:include page="/js/index.jsp"></jsp:include>
    <%
       String tableTranDrv="tableTranDrv";
       
    JsFunctionModel operaFormatter=new JsFunctionModel("operaFormatter",new String[]{"value","rowData","rowIndex"});
    operaFormatter
    .appendContext("var href=\"{0}/to/verify.action?flowNo=\"+rowData[\"flowNo\"];",adminSelfTransactDrv)
    .appendContext("return \"<a class='kia-icon edit' href='\"+href+\"' ></a>\";");
    
       JsListModel cols=new JsListModel();
       
       JsListModel c1=new JsListModel();
       
       JsMapModel rowId=new JsMapModel();
       rowId.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,BaseTransactModel.F.flowNo,true);
       rowId.put(EasyUiModel.DataGrid.ColumnProperties.CHECKBOX,true);
       rowId.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,30);
       
       JsMapModel rowFlowNo=new JsMapModel();
       rowFlowNo.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"流水号",true);
       rowFlowNo.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,BaseTransactModel.F.flowNo,true);
       rowFlowNo.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
       
       JsMapModel rowCreateDate=new JsMapModel();
       rowCreateDate.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"申请日期",true);
       rowCreateDate.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,BaseTransactModel.F.createDate,true);
       rowCreateDate.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
       rowCreateDate.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER,"dateboxFormatter");
       
       JsMapModel rowLicenseNo=new JsMapModel();
       rowLicenseNo.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"驾驶证号",true);
       rowLicenseNo.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,TransactDriverModel.F.licenseNo,true);
       rowLicenseNo.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,200);
       
       JsMapModel rowTransact=new JsMapModel();
       rowTransact.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"业务类型",true);
       rowTransact.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,BaseTransactModel.F.transact,true);
       rowTransact.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
       
       JsMapModel rowApplicat=new JsMapModel();
       rowApplicat.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"申请方式",true);
       rowApplicat.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,BaseTransactModel.F.applicat,true);
       rowApplicat.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
       
       JsMapModel rowSeqNo=new JsMapModel();
       rowSeqNo.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"排队号",true);
       rowSeqNo.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,BaseTransactModel.F.seqno,true);
       rowSeqNo.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,80);
       
       JsMapModel rowOpera=new JsMapModel();
       rowOpera.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"操作",true);
       rowOpera.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
       rowOpera.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,"xxx",true);
       rowOpera.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER,operaFormatter.getFunName());
       
       
       //c1.add(c1rId);
       c1.add(rowSeqNo);
       c1.add(rowFlowNo);
       c1.add(rowTransact);
       c1.add(rowApplicat);
       c1.add(rowLicenseNo);
       c1.add(rowCreateDate);
       c1.add(rowOpera);
       
       cols.add(c1);
       
       EasyUiModel datagridTranDrv=new EasyUiModel(JQueryModel.id(tableTranDrv),
    	                              EasyUiModel.DataGrid.NAME	   
       );
       datagridTranDrv.appendAttrs(EasyUiModel.DataGrid.Properties.URL,adminSelfTransactDrv+"/datagrid/all.action",true);
       datagridTranDrv.appendAttrs(EasyUiModel.DataGrid.Properties.FIT,true);
       datagridTranDrv.appendAttrs(EasyUiModel.DataGrid.Properties.PAGINATION,true);
       datagridTranDrv.appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"驾驶证业务",true);
       datagridTranDrv.appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols);
    
       JsContextModel jsContext=new JsContextModel();
       jsContext.appendScript(operaFormatter);
       jsContext.appendScript(datagridTranDrv);
    %>

    <script type="text/javascript">
       <%=JQueryModel.DOC_READY_START%>
       <%=jsContext.toScirpt()%>
       <%=JQueryModel.DOC_READY_END%>
    </script>

  </head>
  
  <body>
     <div class="innerDiv">
      <table id="<%=tableTranDrv %>"></table>
      </div>
  </body>
</html>
