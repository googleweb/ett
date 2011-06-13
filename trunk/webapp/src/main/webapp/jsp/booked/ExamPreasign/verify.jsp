<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsContextModel"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsListModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsMapModel"%>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.ett.drv.model.booked.BookedOrderInfoModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsFunctionModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bookedExamPreasignPath=basePath+"booked/ExamPreasign";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'verify.jsp' starting page</title>
    
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
	   String tablePreasign="tablePreasign";
	    
	   JsListModel cols=new JsListModel();
	   JsListModel row1=new JsListModel();
	   
	   JsMapModel colId=EasyUiUtil.createCheckBoxColumn(BookedOrderInfoModel.F.Id);
	   
	   JsMapModel colCLsh=EasyUiUtil.createTextareaColumn(BookedOrderInfoModel.F.CLsh);
	   colCLsh.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"流水号",true);
	   
	   JsMapModel colCIdcard=EasyUiUtil.createTextareaColumn(BookedOrderInfoModel.F.CIdcard);
	   colCIdcard.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"身份证明号码",true);
	   
	   JsMapModel colCXm=EasyUiUtil.createTextareaColumn(BookedOrderInfoModel.F.CXm);
	   colCXm.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"姓名",true);
	   
	   JsMapModel colDatePxshrq=EasyUiUtil.createTextareaColumn(BookedOrderInfoModel.F.DatePxshrq);
	   colDatePxshrq.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"培训审核日期",true);
	   
	   JsMapModel colDateKsrq=EasyUiUtil.createTextareaColumn(BookedOrderInfoModel.F.DateKsrq);
	   colDateKsrq.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"考试日期",true);
	   
	   JsMapModel colIKm=EasyUiUtil.createTextareaColumn(BookedOrderInfoModel.F.IKm);
	   colIKm.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"考试科目",true);
	   colIKm.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER,
			   new JsFunctionModel(new String[]{"value","rowData","rowIndex"})
	           .appendContext("if(value==1) return '科目一';")
	           .appendContext("else if(value==2) return '科目二';")
	           .appendContext("else if(value==3) return '科目三';")
	   );
	   
	   JsMapModel colCHmhp=EasyUiUtil.createTextareaColumn(BookedOrderInfoModel.F.CHmhp);
	   colCHmhp.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"号码号牌",true);
	   
	   JsMapModel colCJbr=EasyUiUtil.createTextareaColumn(BookedOrderInfoModel.F.CJbr);
	   colCJbr.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"经办人",true);
	   
	   JsMapModel colIChecked=EasyUiUtil.createTextareaColumn(BookedOrderInfoModel.F.IChecked);
	   colIChecked.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"流水号",true);
	   colIChecked.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER,
			   new JsFunctionModel(new String[]{"value","rowData","rowIndex"})
	           .appendContext("if(value==0) return '未审核';")
	           .appendContext("else if(value==1) return '已审核';")
	           .appendContext("else if(value==2) return '审核不过';")
	   );
	   

	   
	   row1.add(colId);
	   row1.add(colCLsh);
	   row1.add(colCIdcard);
	   row1.add(colCXm);
	   row1.add(colDatePxshrq);
	   row1.add(colDateKsrq);
	   row1.add(colIKm);
	   row1.add(colCHmhp);
	   row1.add(colCJbr);
	   row1.add(colIChecked);
	   
	   cols.add(row1);
	   
	   EasyUiModel datagridExam=new EasyUiModel(JQueryModel.id(tablePreasign),EasyUiModel.DataGrid.NAME);
	   datagridExam
	   .appendAttrs(EasyUiModel.DataGrid.Properties.URL,bookedExamPreasignPath+"/datagrid/orderInfo.action",true)
	   .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
	   .appendAttrs(EasyUiModel.DataGrid.Properties.VIEW,"groupview")
	   .appendAttrs(EasyUiModel.DataGrid.Properties.GROUP_FIELD,BookedOrderInfoModel.F.IChecked,true)
	   ;
	   
	   JsContextModel jsContext=new JsContextModel();
	   jsContext.appendScript(datagridExam);
	%>

    <script type="text/javascript">
     
    <%=JQueryModel.DOC_READY_START%>
    <%=jsContext.toScirpt()%>
    <%=JQueryModel.DOC_READY_END%>
    </script>	

  </head>
  
  <body>
     <div style="width: 100%;height: 100%">
      <table id="<%=tablePreasign %>"></table>
      </div>
  </body>
</html>
