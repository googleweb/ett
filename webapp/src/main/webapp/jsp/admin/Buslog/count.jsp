<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsContextModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsListModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsMapModel"%>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.ett.drv.model.admin.BusLogModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsFunctionModel"%>
<%@page import="com.ett.drv.model.admin.UserModel"%>
<%@page import="com.ett.drv.model.admin.RoleModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String buslogActionPath=basePath+"admin/Buslog";
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
	<jsp:include page="/plugin/index.jsp">
	   <jsp:param  name="plugin" value="jquery,easyui"/>
	</jsp:include>
    <jsp:include page="/css/index.jsp"></jsp:include>
    <jsp:include page="/js/index.jsp"></jsp:include>
    
    <%
      String tableBusLog="tableBusLog";
      String inputStratRegDate="inputStratRegDate"; 
      String inputEndRegDate="inputEndRegDate";
      String inputOperator="inputOperator";
     
      JsFunctionModel clickSearchHandler=new JsFunctionModel("clickSearchHandler",null);
      clickSearchHandler
      .appendContext("var qStartRegDate={0}.datebox(\"getValue\")||\"\";",JQueryModel.id(inputStratRegDate))
      .appendContext("var qEndRegDate={0}.datebox(\"getValue\")||\"\";",JQueryModel.id(inputEndRegDate))
      .appendContext("var qOperator={0}.combobox(\"getValue\")||\"\";",JQueryModel.id(inputOperator))
      .appendContext("{0}.datagrid(\"reload\",'{'qStartRegDate:qStartRegDate,qEndRegDate:qEndRegDate,qOperator:qOperator'}');",JQueryModel.id(tableBusLog))
      ;
      
      JsListModel cols=new JsListModel();
      JsListModel row1=new JsListModel();
      
      /**
                                  <asp:BoundColumn DataField="id" HeaderText="编号"></asp:BoundColumn>
                            <asp:BoundColumn DataField="c_operator" HeaderText="操作者"></asp:BoundColumn>
                            <asp:BoundColumn DataField="c_bustype" HeaderText="业务类别"></asp:BoundColumn>
                            <asp:BoundColumn DataField="c_content" HeaderText="操作内容"></asp:BoundColumn>
                            <asp:BoundColumn DataField="regdate" HeaderText="操作时间"></asp:BoundColumn>
                            <asp:BoundColumn DataField="c_des1" HeaderText="预留字段1"></asp:BoundColumn>
                            <asp:BoundColumn DataField="c_des2" HeaderText="预留字段2"></asp:BoundColumn>
                            <asp:BoundColumn DataField="c_des3" HeaderText="预留字段3"></asp:BoundColumn>
      **/
      
      JsMapModel colId=EasyUiUtil.createTextColumn(BusLogModel.F.Id);
      colId.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"编号",true);
      colId.put(EasyUiModel.DataGrid.ColumnProperties.WIDTH,80);
      
      JsMapModel colCOperator=EasyUiUtil.createTextColumn(BusLogModel.F.COperator);
      colCOperator.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"操作者",true);
      
      JsMapModel colCBustype=EasyUiUtil.createTextColumn(BusLogModel.F.CBustype);
      colCBustype.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"业务类别",true);
      
      JsMapModel colCContent=EasyUiUtil.createTextColumn(BusLogModel.F.CContent);
      colCContent.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"操作内容",true);
      
      JsMapModel colRegdate=EasyUiUtil.createTextColumn(BusLogModel.F.Regdate);
      colRegdate.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"操作时间",true);
      
      JsMapModel colDes1=EasyUiUtil.createTextColumn(BusLogModel.F.CDes1);
      colDes1.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"预留字段1",true);
      
      JsMapModel colDes2=EasyUiUtil.createTextColumn(BusLogModel.F.CDes2);
      colDes2.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"预留字段2",true);
      
      JsMapModel colDes3=EasyUiUtil.createTextColumn(BusLogModel.F.CDes3);
      colDes3.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"预留字段3",true);
      
      JsMapModel colCount=EasyUiUtil.createTextColumn("count",true);
      colCount.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"数量",true);

      //row1.add(colId);
      row1.add(colCOperator);
      row1.add(colCBustype);
      //row1.add(colCContent);
      //row1.add(colRegdate);
      //row1.add(colDes1);
      //row1.add(colDes2);
      //row1.add(colDes3);
      row1.add(colCount);

      cols.add(row1);
      
      EasyUiModel datagridBuslog=new EasyUiModel(JQueryModel.id(tableBusLog),EasyUiModel.DataGrid.NAME);
      
      datagridBuslog
      .appendAttrs(EasyUiModel.DataGrid.Properties.URL,buslogActionPath+"/datagrid/buslogCount.action",true)
      .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
      ;
      
      JsContextModel jsFun=new JsContextModel();
      jsFun.appendScript(clickSearchHandler);
      
      JsContextModel jsContext=new JsContextModel();
       jsContext.appendScript(datagridBuslog);
    %>
    
    <script type="text/javascript">
    <%=jsFun.toScirpt()%>
    <%=JQueryModel.DOC_READY_START%>
    <%=jsContext.toScirpt()%>
    <%=JQueryModel.DOC_READY_END%>
    
    </script>
    
  </head>
  
  <body class="<%=EasyUiModel.Layout.CLASS %>" >
    <div <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_NORTH) %> >
       <table class="editTable" style="width: 100%" cellspacing="0">
         <tr>
           <td style="text-align: right;"
           >
                                  操作时间起 &nbsp; <input class="<%=EasyUiModel.DateBox.CLASS %>" id="<%=inputStratRegDate %>"  />
                                  操作时间止 &nbsp; <input class="<%=EasyUiModel.DateBox.CLASS %>"  id="<%=inputEndRegDate %>" />
           </td>
         </tr>
         <tr>
           <td style="text-align: right;">
                                 操作者    <input class="<%=EasyUiModel.ComboBox.CLASS %>"  id="<%=inputOperator %>" 
                       <%=EasyUiModel.ComboBox.Properties.URL(buslogActionPath+"/combobox/roles.action") %>  
                       <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(RoleModel.F.CName.name()) %>    
                       <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(RoleModel.F.CName.name()) %>           
                    />
            <a class="<%=EasyUiModel.LinkButton.CLASS %>"
                <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>
                onclick="<%=clickSearchHandler.getFunName() %>()"
             >
            </a>
           </td>
         </tr>
       </table>
    </div>
    
    <div <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_CENTER) %> >
       <table id="<%=tableBusLog %>" ></table>
    </div>
  </body>
</html>
