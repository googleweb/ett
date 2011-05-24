<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.smartken.kia.core.util.StringUtil"%>
<%@page import="com.ett.drv.model.self.FeeLogModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String feeActionPath=basePath+"admin/SelfTransactFee";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'feeLog.jsp' starting page</title>
    
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
       
        String tableDG="tableDG";
    String aSearch="aSearch";
    String formSearch="formSearch";
    
        JsListModel cols=new JsListModel();
        JsListModel c1=new JsListModel();
        
        
        JsMapModel rowFeewaytype=new JsMapModel();
        rowFeewaytype.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,FeeLogModel.F.Feewaytype,true);
        rowFeewaytype.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
        rowFeewaytype.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"缴费方式",true);
        
        JsMapModel rowMoney=new JsMapModel();
        rowMoney.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,FeeLogModel.F.Money,true);
        rowMoney.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
        rowMoney.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"业务费用",true);
        
        JsMapModel rowCreatetime=new JsMapModel();
        rowCreatetime.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,FeeLogModel.F.TCreatetime,true);
        rowCreatetime.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
        rowCreatetime.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"缴费日期",true);
        rowCreatetime.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER,"dateboxFormatter");
        
        JsMapModel rowBustype=new JsMapModel();
        rowBustype.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,FeeLogModel.F.Bustype,true);
        rowBustype.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
        rowBustype.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"业务类型",true);
        
        JsMapModel rowDetail=new JsMapModel();
        rowDetail.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,FeeLogModel.F.Detail,true);
        rowDetail.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
        rowDetail.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"明细",true);
        
        
        JsMapModel rowSfzmhm=new JsMapModel();
        rowSfzmhm.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,FeeLogModel.F.Sfzmhm,true);
        rowSfzmhm.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
        rowSfzmhm.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"身份证号码",true);
        
        JsMapModel rowXm=new JsMapModel();
        rowXm.put(EasyUiModel.DataGrid.ColumnProperties.FIELD,FeeLogModel.F.Xm,true);
        rowXm.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,150);
        rowXm.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"姓名",true);
        

        
        
        c1.add(rowSfzmhm);
        c1.add(rowXm);
        c1.add(rowBustype);
        c1.add(rowFeewaytype);
        c1.add(rowMoney);
        c1.add(rowDetail);
        c1.add(rowCreatetime);
        
        cols.add(c1);
    
    
        EasyUiModel dataGrid=new EasyUiModel(JQueryModel.id(tableDG),EasyUiModel.DataGrid.NAME);
        dataGrid.appendAttrs(EasyUiModel.DataGrid.Properties.FIT,true);
        dataGrid.appendAttrs(EasyUiModel.DataGrid.Properties.URL,feeActionPath+"/datagrid/feeLog.action",true);
        dataGrid.appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols);
        dataGrid.appendAttrs(EasyUiModel.DataGrid.Properties.ID_FIELD,"Id",true);
        dataGrid.appendAttrs(EasyUiModel.DataGrid.Properties.PAGINATION,true);
        dataGrid.appendAttrs(EasyUiModel.DataGrid.Properties.SINGLE_SELECT,true);
        
        
        JsFunctionModel clickSearchHanlder= new JsFunctionModel("clickSearchHanlder",new String[]{});
        clickSearchHanlder
        .appendContext("{0}.form(\"submit\",'{'",JQueryModel.id(formSearch))
        .appendContext("url:{0}",StringUtil.quota(feeActionPath+"/search/feeLog.action"))
        .appendContext(",success:function(str)'{'var json=Kia.util.strToJson(str); {0}.datagrid(\"loadData\",json); '}'",JQueryModel.id(tableDG))
        .appendContext("});")
        ;
        
        JQueryModel btnSearchClick=new JQueryModel(JQueryModel.id(aSearch),"click");
        btnSearchClick.appendParma(clickSearchHanlder.getFunName());
        
        
        JsContextModel funContext=new JsContextModel();
        funContext.appendScript(clickSearchHanlder);
        
        JsContextModel context=new JsContextModel();
        context.appendScript(dataGrid);
        context.appendScript(btnSearchClick);
    %>
   
   
    <script type="text/javascript">
       <%=funContext.toScirpt()%>
       <%=JQueryModel.DOC_READY_START%>
       <%=context.toScirpt()%>
       <%=JQueryModel.DOC_READY_END %>
    </script>
   

  </head>
  
  <body>
   <div style="height: 10%">
    <form  method="post" id="<%=formSearch %>">
    
         <table class="editTable">
            <tr>
              <td style="width: 350px;">身份证号码:<input name="Sfzmhm"/></td>
              <td style="width: 300px;">姓名:<input name="Xm"/></td>
              <td style="width: 300px;">缴费方式:
                 <select name="<%=FeeLogModel.F.Feewaytype %>" class="<%=EasyUiModel.ComboBox.CLASS %>">
                   <option value="" selected="selected"></option>
                   <option value="现金缴费">现金缴费</option>
                   <option value="银行pos缴费">银行pos缴费</option>
                 </select>
              </td>
              <td style="width: 300px;">缴费时间:<input name="TCreatetime" class="<%=EasyUiModel.DateBox.CLASS %>" /></td>
              <td>
                 <a class="<%=EasyUiModel.LinkButton.CLASS %>"  id="<%=aSearch %>"
                    <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>
                 >查询</a>
              </td>         
            </tr>
         </table>
       </form>
     </div>  
  
      <div class="innerDiv" style="height: 90%">
   <table id="<%=tableDG %>"></table>
   </div>
      
  </body>
</html>
