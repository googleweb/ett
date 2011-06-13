<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.drv.model.booked.BookedLimitModel"%>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bookedWeekPbPath=basePath+"booked/ExamPreasign";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'extraAssign.jsp' starting page</title>
    
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
   String inputTpNum="inputTpNum";
   
   JsFunctionModel clickSearchLimitHandler=new JsFunctionModel("clickSearchLimitHandler",null);
   clickSearchLimitHandler
   .appendContext("var ksrq={0}.datebox(\"getValue\");",JQueryModel.id(BookedLimitModel.F.DateKsrq.name()))
   .appendContext("{0}.datagrid(\"reload\",'{'ksrq:ksrq'}');",JQueryModel.id(tableLimits))
   ;
   
   JsFunctionModel clickExtraAssignHandler=new JsFunctionModel("clickExtraAssignHandler",new String[]{"id"});
   clickExtraAssignHandler
   .appendContext("var tpNum={0}.numberspinner(\"getValue\");",JQueryModel.id(inputTpNum))
   .appendContext("var url=\"{0}\";",bookedWeekPbPath+"/do/extraAssign.action")
   .appendContext("$.get(url,{id:id,tpNum:tpNum},function(str){str.messager();$('#tableLimits').datagrid('reload'); }); ")
   ;
   
   JsListModel cols=new JsListModel();
   JsListModel row1=new JsListModel();
   
   JsMapModel colDateKsrq =EasyUiUtil.createTextColumn(BookedLimitModel.F.DateKsrq);
   colDateKsrq.put(EasyUiModel.DataGrid.Properties.TITLE,"考试日期",true);
   
   JsMapModel colSchoolName =EasyUiUtil.createTextColumn(BookedLimitModel.F.CSchoolName);
   colSchoolName.put(EasyUiModel.DataGrid.Properties.TITLE,"驾校名字",true);
   
   JsMapModel colITotal =EasyUiUtil.createTextColumn(BookedLimitModel.F.ITotal);
   colITotal.put(EasyUiModel.DataGrid.Properties.TITLE,"考试人数",true);
   
   JsMapModel colITptotal =EasyUiUtil.createTextColumn(BookedLimitModel.F.ITptotal);
   colITptotal.put(EasyUiModel.DataGrid.Properties.TITLE,"特批人数",true);
   
   JsMapModel colICheckedNum =EasyUiUtil.createTextColumn(BookedLimitModel.F.ICheckedNum);
   colICheckedNum.put(EasyUiModel.DataGrid.Properties.TITLE,"已审核人数",true);
   
   JsMapModel colCKsdd =EasyUiUtil.createTextColumn(BookedLimitModel.F.CKsdd);
   colCKsdd.put(EasyUiModel.DataGrid.Properties.TITLE,"考试地点",true);
   
   JsMapModel colCKscc =EasyUiUtil.createTextColumn(BookedLimitModel.F.CKscc);
   colCKscc.put(EasyUiModel.DataGrid.Properties.TITLE,"考试场次",true);
   
   JsMapModel colIKm =EasyUiUtil.createTextColumn(BookedLimitModel.F.IKm);
   colIKm.put(EasyUiModel.DataGrid.Properties.TITLE,"考试科目",true);
   colIKm.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER,
		   new JsFunctionModel(new String[]{"value","rowData","rowIndex"})
           .appendContext("if(value==1) return '科目一';")
           .appendContext("else if(value==2) return '科目二';")
           .appendContext("else if(value==3) return '科目三';")
   );
   
   JsMapModel colExtraAssgin=EasyUiUtil.createTextColumn(BookedLimitModel.F.Id);
   colExtraAssgin.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"特批",true);
   colExtraAssgin.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER,
		   new JsFunctionModel(new String[]{"value","rowData","rowIndex"})
           .appendContext("var aExtraAssgin=\"{0}\";","<a class='kia-icon edit' onclick='"+clickExtraAssignHandler.getFunName()+"(\"+value+\");'></a>")
           .appendContext("")
           .appendContext("return aExtraAssgin;")
   );
   
   row1.add(colCKsdd);
   row1.add(colCKscc);
   row1.add(colSchoolName);
   row1.add(colITotal);
   row1.add(colITptotal);
   row1.add(colDateKsrq);
   

   //row1.add(colICheckedNum);

   row1.add(colIKm);
   row1.add(colExtraAssgin);
   
   /**
   	i_km ,
	c_school_code ,
	c_school_name,
    date_ksrq ,
	c_kscc ,
    c_ksdd ,
    i_total,
    i_tptotal,
    c_operator 
   **/
   
   cols.add(row1);

   EasyUiModel datagridLimits=new EasyUiModel(JQueryModel.id(tableLimits),EasyUiModel.DataGrid.NAME);
   datagridLimits
   .appendAttrs(EasyUiModel.DataGrid.Properties.URL,bookedWeekPbPath+"/datagrid/extraAssignLimits.action",true)
   .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
   ;

   JsContextModel jsFun=new JsContextModel();
   jsFun.appendScript(clickExtraAssignHandler);
   jsFun.appendScript(clickSearchLimitHandler);
   JsContextModel jsContext=new JsContextModel();
   jsContext.appendScript(datagridLimits);
   %>

   <script type="text/javascript">
     <%=jsFun.toScirpt() %>
     <%=JQueryModel.DOC_READY_START%>
     <%=jsContext.toScirpt()%>
     <%=JQueryModel.DOC_READY_END%>
   </script>

  </head>
  
  <body>
    <div style="height: 8%;text-align: right;">

     <table class="editTable" style="width: 100%" cellspacing="0">
        <tr>
         <th>    查看日期&nbsp; 
                   <input name="<%=BookedLimitModel.F.DateKsrq %>"  id="<%=BookedLimitModel.F.DateKsrq %>" 
                   class="<%=EasyUiModel.DateBox.CLASS %>" />
                   <a class="<%=EasyUiModel.LinkButton.CLASS %>" 
                   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>
                       onclick="<%=clickSearchLimitHandler.getFunName() %>()"
                   >查看</a>
                   &nbsp;&nbsp;特批数量&nbsp; 
                   <input class="<%=EasyUiModel.NumberSpinner.CLASS %>" id="<%=inputTpNum %>" value="0" 
                          <%=EasyUiModel.Spinner.Properties.INCREMENT(10) %>
                   />
           </th>
       </tr>
     </table>

    </div>
  
    <div style="width: 100%;height: 90%">
      <table id="<%=tableLimits %>"></table>
    </div>
  </body>
</html>
