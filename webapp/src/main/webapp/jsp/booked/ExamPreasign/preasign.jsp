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
       String formPreasign="formPreasign";
       
       
       JsFunctionModel clickPreasginHander=new JsFunctionModel("clickPreasginHander",null);
       clickPreasginHander
       .appendContext("url=\"{0}\";",bookedExamPreasgin+"/do/preasign.action")
       .appendContext("{0}.form(\"submit\",'{'url:url '}');",JQueryModel.id(formPreasign))
       ;
    
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
       btnCanclePreasign.put(EasyUiModel.DataGrid.ToolbarProperties.TEXT,"撤销预约",true);
       btnCanclePreasign.put(EasyUiModel.DataGrid.ToolbarProperties.ICON_CLS,EasyUiModel.ICON_CANCEL,true);
       btnCanclePreasign.put(EasyUiModel.DataGrid.ToolbarProperties.HANDLER,
    	       new JsFunctionModel(null)
               .appendContext("var rows={0}.datagrid(\"getSelections\");",JQueryModel.id(tablePass))
               .appendContext("var count=rows.length; ")
               .appendContext("if(count==0) {$.messager.alert('','没有记录被选中','error'); return;} ")
               .appendContext("$.messager.confirm('操作提示','确认取消'+count+'条预约记录?',function(yes){ if(yes){  ")
               .appendContext("var url=\"{0}\";",bookedExamPreasgin+"/do/cancelPreasign.action")
               .appendContext("var ids=rows.getUnionStr('Id');")
               .appendContext("$.get(url,{ids:ids},function(str){ str.messager();});")
               .appendContext("} });")
       );
       
       toolbarPass.add(btnCanclePreasign);
       
       EasyUiModel datagridPass=new EasyUiModel(JQueryModel.id(tablePass),EasyUiModel.DataGrid.NAME);
       EasyUiModel datagridFail=new EasyUiModel(JQueryModel.id(tableFail),EasyUiModel.DataGrid.NAME);
       
       datagridPass
       .appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"审核通过的人员名单",true)
       //.appendAttrs(EasyUiModel.DataGrid.Properties.FIT,true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.URL,bookedExamPreasgin+"/datagrid/passOrderInfo.action",true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
       .appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,toolbarPass)
       //.appendAttrs(EasyUiModel.DataGrid.Properties.ROWNUNMBERS,true)
       //.appendAttrs(EasyUiModel.DataGrid.Properties.ID_FIELD,"Id",true)
       ;
       
       datagridFail
       .appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"审核不过的人员名单",true)
       //.appendAttrs(EasyUiModel.DataGrid.Properties.FIT,true)
              .appendAttrs(EasyUiModel.DataGrid.Properties.URL,bookedExamPreasgin+"/datagrid/failOrderInfo.action",true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
       ;
       
       
       JsContextModel jsFun=new JsContextModel();
       jsFun.appendScript(clickPreasginHander);
       
       JsContextModel jsContext=new JsContextModel();
       jsContext.appendScript(datagridPass);
       jsContext.appendScript(datagridFail);
    %>
    
    <script type="text/javascript">
    <%=jsFun.toScirpt() %>
    <%=JQueryModel.DOC_READY_START %>
    <%=jsContext.toScirpt() %>
    <%=JQueryModel.DOC_READY_END %>
    </script>
  </head>
  
  <body>
     <div>
      <form  id="<%=formPreasign %>" method="post" >
      
      <table class="editTable" cellspacing="0"
      >
       <tr>
         <td style="text-align: center; font-size: 1.2em" 
         >约考日期${limit.dateKsrq}&nbsp;驾校 ${limit.CSchoolName } 预约申请名单
         <p/>
         <input type="hidden" value="${limit.id}" name="<%=BookedOrderInfoModel.F.IPaibanid %>" />
                      科目&nbsp;<input  name="<%=BookedOrderInfoModel.F.IKm %>"
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
   	                 <%=EasyUiModel.ComboBox.Properties.URL(bookedExamPreasgin+"/combobox/kskm.action") %>
  	                 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.REQUIRED(true) %>
  	                  <%=EasyUiModel.ComboBox.Properties.DISABLED(false) %>
  	                  value="${limit.IKm}"
                      />
        &nbsp;地点&nbsp;<input  name="<%=BookedOrderInfoModel.F.CKsddCode %>"
          	                 class="<%=EasyUiModel.ComboBox.CLASS %>"
   	                 <%=EasyUiModel.ComboBox.Properties.URL(bookedExamPreasgin+"/combobox/ksdd.action") %>
  	                 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.REQUIRED(true) %>
  	                  <%=EasyUiModel.ComboBox.Properties.DISABLED(false) %>
  	                  value="${limit.CKsddCode}"
                     />
        &nbsp;场次&nbsp;<input  name="<%=BookedOrderInfoModel.F.CKsccCode %>"
                  	  class="<%=EasyUiModel.ComboBox.CLASS %>"
   	                 <%=EasyUiModel.ComboBox.Properties.URL(bookedExamPreasgin+"/combobox/kscc.action") %>
  	                 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.REQUIRED(true) %>
  	                  <%=EasyUiModel.ComboBox.Properties.DISABLED(false) %>
  	                  value="${limit.CKsccCode}"
        />
         </td>
       </tr>
       <tr>
         <td style="text-align: left;padding-left: 50px">
                  证件号码&nbsp;<input   name="<%=BookedOrderInfoModel.F.CIdcard %>"  
                      class="<%=EasyUiModel.ValidateBox.CLASS %>"
                       <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                       <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("idCard") %>
                      />
       &nbsp;培训审核日期&nbsp;<input class="<%=EasyUiModel.DateBox.CLASS %>"  name="<%=BookedOrderInfoModel.F.DatePxshrq %>" 
                       <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                     />
       &nbsp;号牌号码&nbsp;<input class="<%=EasyUiModel.ValidateBox.CLASS %>" name="<%=BookedOrderInfoModel.F.CHmhp %>"
                        <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                       <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("carno") %>
                     /> 
       &nbsp;<a  class="<%=EasyUiModel.LinkButton.CLASS %>"
                    <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_OK) %>
                    onclick="<%=clickPreasginHander.getFunName() %>()"
               >约考</a>
         </td>
       </tr>
      </table>
      </form>
    </div>
    <div style="height: 40%;">
      <table id="<%=tablePass %>">
       <tfoot>
         <tr>
           <td colspan="100">xxxx</td>
         </tr>
       </tfoot>
      </table>  
    </div>
   <div style="height: 40%">
      <table id="<%=tableFail %>">

      </table>  
    </div>
  
  </body>
</html>
