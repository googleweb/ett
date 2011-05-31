<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.ett.drv.model.booked.BookedDayLimitModel"%>
<%@page import="com.ett.drv.model.booked.BookedOrderInfoModel"%>
<%@page import="com.ett.drv.model.admin.DictModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bookedExamPreasgin=basePath+"/booked/ExamPreasign";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'preasign.jsp' starting page</title>
    
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
       String tablePass="tablePass";
       String tableFail="tableFail";
    
       JsListModel cols=new JsListModel();
       JsListModel row1=new JsListModel();
       
       JsMapModel colId=EasyUiUtil.createCheckBoxColumn(BookedOrderInfoModel.F.Id);
       
       JsMapModel colCLsh=EasyUiUtil.createTextColumn(BookedOrderInfoModel.F.CLsh);
       colCLsh.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"流水号",true);
       
       JsMapModel colCIdcard=EasyUiUtil.createTextColumn(BookedOrderInfoModel.F.CIdcard);
       colCIdcard.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"身份证明号码",true);
       
       JsMapModel colCXm=EasyUiUtil.createTextColumn(BookedOrderInfoModel.F.CXm);
       colCXm.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"姓名",true);
       
       JsMapModel colDatePxshrq=EasyUiUtil.createTextColumn(BookedOrderInfoModel.F.DatePxshrq);
       colDatePxshrq.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"培训审核日期",true);
       
       JsMapModel colCHmhp=EasyUiUtil.createTextColumn(BookedOrderInfoModel.F.CHmhp);
       colCHmhp.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"号码号牌",true);
       
       JsMapModel colCJbr=EasyUiUtil.createTextColumn(BookedOrderInfoModel.F.CJbr);
       colCJbr.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"经办人",true);
       
       JsMapModel colIChecked=EasyUiUtil.createTextColumn(BookedOrderInfoModel.F.IChecked);
       colIChecked.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"审核结果",true);
       
       JsMapModel colCCheckResult=EasyUiUtil.createTextColumn(BookedOrderInfoModel.F.CCheckResult);
       colCCheckResult.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"审核信息",true);
       
       row1.add(colId);
       row1.add(colCLsh);
       row1.add(colCIdcard);
       row1.add(colCXm);
       row1.add(colDatePxshrq);
       row1.add(colCHmhp);
       row1.add(colCJbr);
       row1.add(colIChecked);
       row1.add(colCCheckResult);
       
       cols.add(row1);
       
       JsListModel toolbarPass=new JsListModel();
       JsMapModel btnCanclePreasign=new JsMapModel();
       btnCanclePreasign.put("text","撤销预约",true);
       btnCanclePreasign.put("iconCls","icon-cancel",true);
       //btnCanclePreasign.put("handler","");
       
       toolbarPass.add(btnCanclePreasign);
       
       EasyUiModel datagridPass=new EasyUiModel(JQueryModel.id(tablePass),EasyUiModel.DataGrid.NAME);
       EasyUiModel datagridFail=new EasyUiModel(JQueryModel.id(tableFail),EasyUiModel.DataGrid.NAME);
       
       datagridPass
       .appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"审核通过的人员名单",true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.FIT,true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.URL,bookedExamPreasgin+"/datagrid/passOrderInfo.action",true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
       .appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,toolbarPass)
       .appendAttrs(EasyUiModel.DataGrid.Properties.ROWNUNMBERS,true)
       ;
       
       datagridFail
       .appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"审核不过的人员名单",true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.FIT,true)
              .appendAttrs(EasyUiModel.DataGrid.Properties.URL,bookedExamPreasgin+"/datagrid/failOrderInfo.action",true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
       ;
       
       
       JsContextModel jsContext=new JsContextModel();
       jsContext.appendScript(datagridPass);
       jsContext.appendScript(datagridFail);
    %>
    
    <script type="text/javascript">
    <%=JQueryModel.DOC_READY_START %>
    <%=jsContext.toScirpt() %>
    <%=JQueryModel.DOC_READY_END %>
    </script>
  </head>
  
  <body>
     <div>
      <table class="editTable" cellspacing="0"
      >
       <tr>
         <td style="text-align: center; font-size: 1.2em" 
         >约考日期${limit.dateKsrq}&nbsp;驾校 ${limit.CSchoolName } 预约申请名单
         <p/>
                      科目&nbsp;<input
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
   	                 <%=EasyUiModel.ComboBox.Properties.URL(bookedExamPreasgin+"/combobox/kskm.action") %>
  	                 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.REQUIRED(true) %>
  	                  <%=EasyUiModel.ComboBox.Properties.EDITABLE(false) %>
                      />
        &nbsp;地点&nbsp;<input
          	                 class="<%=EasyUiModel.ComboBox.CLASS %>"
   	                 <%=EasyUiModel.ComboBox.Properties.URL(bookedExamPreasgin+"/combobox/ksdd.action") %>
  	                 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.REQUIRED(true) %>
  	                  <%=EasyUiModel.ComboBox.Properties.EDITABLE(false) %>
                     />
        &nbsp;场次&nbsp;<input
                  	  class="<%=EasyUiModel.ComboBox.CLASS %>"
   	                 <%=EasyUiModel.ComboBox.Properties.URL(bookedExamPreasgin+"/combobox/kscc.action") %>
  	                 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.REQUIRED(true) %>
  	                  <%=EasyUiModel.ComboBox.Properties.EDITABLE(false) %>
        />
         </td>
       </tr>
       <tr>
         <td style="text-align: right;padding-right: 20px">
                  证件号码&nbsp;<input  class="<%=EasyUiModel.ValidateBox.CLASS %>"
                       <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                       <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("idCard") %>
                  />
       &nbsp;培训审核日期&nbsp;<input class="<%=EasyUiModel.DateBox.CLASS %>" 
                       <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
       />
       &nbsp;号码号牌&nbsp;<input class="<%=EasyUiModel.ValidateBox.CLASS %>"
                        <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                       <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("carno") %>
       /> &nbsp;<button>约考</button>
         </td>
       </tr>
      </table>
    </div>
    <div style="height: 40%;">
      <table id="<%=tablePass %>"></table>  
    </div>
   <div style="height: 40%">
      <table id="<%=tableFail %>"></table>  
    </div>
  
  </body>
</html>
