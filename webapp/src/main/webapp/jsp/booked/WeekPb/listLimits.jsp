<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsContextModel"%>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsMapModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsListModel"%>
<%@page import="com.ett.drv.model.booked.BookedLimitModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bookedWeekPbPath=basePath+"booked/WeekPb";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listLimits.jsp' starting page</title>
    
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

    <%
       String tableLimits="tableLimits";
    
       JsListModel cols=new JsListModel();
       JsListModel row1=new JsListModel();
       
       
       /**
       2010-12-13  锦骏  总人数 50  已用 0  已审核 0 
 汕头大学路考场   上午第一场   科目一 

       **/
       JsMapModel colDateKsrq =EasyUiUtil.createTextColumn(BookedLimitModel.F.DateKsrq);
       colDateKsrq.put(EasyUiModel.DataGrid.Properties.TITLE,"考试日期",true);
       
       JsMapModel colSchoolName =EasyUiUtil.createTextColumn(BookedLimitModel.F.CSchoolName);
       colSchoolName.put(EasyUiModel.DataGrid.Properties.TITLE,"驾校",true);
       
       JsMapModel colITotal =EasyUiUtil.createTextColumn(BookedLimitModel.F.ITotal);
       colITotal.put(EasyUiModel.DataGrid.Properties.TITLE,"总人数",true);
       
       JsMapModel colIUsedNum =EasyUiUtil.createTextColumn(BookedLimitModel.F.IUsedNum);
       colIUsedNum.put(EasyUiModel.DataGrid.Properties.TITLE,"已用人数",true);
       
       JsMapModel colICheckedNum =EasyUiUtil.createTextColumn(BookedLimitModel.F.ICheckedNum);
       colICheckedNum.put(EasyUiModel.DataGrid.Properties.TITLE,"已审核人数",true);
       
       JsMapModel colCKsdd =EasyUiUtil.createTextColumn(BookedLimitModel.F.CKsdd);
       colCKsdd.put(EasyUiModel.DataGrid.Properties.TITLE,"考试地点",true);
       
       JsMapModel colCKscc =EasyUiUtil.createTextColumn(BookedLimitModel.F.CKscc);
       colCKscc.put(EasyUiModel.DataGrid.Properties.TITLE,"考试场次",true);
       
       JsMapModel colIKm =EasyUiUtil.createTextColumn(BookedLimitModel.F.IKm);
       colIKm.put(EasyUiModel.DataGrid.Properties.TITLE,"考试科目",true);
       
       row1.add(colDateKsrq);
       row1.add(colSchoolName);
       row1.add(colITotal);
       row1.add(colIUsedNum);
       row1.add(colICheckedNum);
       row1.add(colCKsdd);
       row1.add(colCKscc);
       row1.add(colIKm);
       
       
       cols.add(row1);
    
       EasyUiModel datagridLimits=new EasyUiModel(JQueryModel.id(tableLimits),EasyUiModel.DataGrid.NAME);
       datagridLimits
       .appendAttrs(EasyUiModel.DataGrid.Properties.URL,bookedWeekPbPath+"/datagrid/limits.action",true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
       ;
    
       JsContextModel jsContext=new JsContextModel();
       jsContext.appendScript(datagridLimits);
    %>
  <script type="text/javascript">
    <%=JQueryModel.DOC_READY_START %>
    <%=jsContext.toScirpt() %>
    <%=JQueryModel.DOC_READY_END %>
</script>
  </head>
  
  <body>
      <div style="width: 100%;height: 100%">
        <table id="<%=tableLimits %>"></table>
      </div>
  </body>
</html>
