<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.drv.model.self.HardwareModel"%>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminDeviceActionPath=basePath+"admin/SelfDevice";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'hardware.jsp' starting page</title>
    
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
   
    String tableDG="tableDG";
    String divAdd="divAdd";
    String divEdit="divEdit";
     /**
    
    
    JsFunctionModel clickAddHandler=new JsFunctionModel("clickAddHandler",new String[]{});
    clickAddHandler
    .appendContext("var href=\"{0}\";",adminDeviceActionPath+"/edit/hardware.action")
    .appendContext(
    		new EasyUiModel(JQueryModel.id(divEdit),EasyUiModel.Dialog.NAME)
    		.appendAttrs(EasyUiModel.Dialog.Properties.TITLE,"新增硬件",true)
    		.appendAttrs(EasyUiModel.Dialog.Properties.WIDTH,600)
    		.appendAttrs(EasyUiModel.Dialog.Properties.HEIGHT,400)
    		.appendAttrs(EasyUiModel.Dialog.Properties.MODAL,true)
    		.appendAttrs(EasyUiModel.Dialog.Events.ON_BEFORE_OPEN,"function(){$(this).kiaIframe(href);}")
            .appendAttrs(EasyUiModel.Dialog.Events.ON_CLOSE,"function(){ $('#"+tableDG+"').datagrid('reload'); }")
    )
    ;
    
    JsFunctionModel clickEditHandler=new JsFunctionModel("clickEditHandler",new String[]{"id"});
    clickEditHandler
    .appendContext("var href=\"{0}?id=\"+id;",adminDeviceActionPath+"/edit/hardware.action")
    .appendContext(
    		new EasyUiModel(JQueryModel.id(divEdit),EasyUiModel.Dialog.NAME)
    		.appendAttrs(EasyUiModel.Dialog.Properties.TITLE,"修改硬件",true)
    		.appendAttrs(EasyUiModel.Dialog.Properties.WIDTH,600)
    		.appendAttrs(EasyUiModel.Dialog.Properties.HEIGHT,400)
    		.appendAttrs(EasyUiModel.Dialog.Properties.MODAL,true)
    		.appendAttrs(EasyUiModel.Dialog.Events.ON_BEFORE_OPEN,"function(){$(this).kiaIframe(href);}")
            .appendAttrs(EasyUiModel.Dialog.Events.ON_CLOSE,"function(){ $('#"+tableDG+"').datagrid('reload'); }")
    )
    ;
    
    
    JsFunctionModel clickRemoveHandler=new JsFunctionModel("clickRemoveHandler",new String[]{});
    clickRemoveHandler
    .appendContext("$.messager.confirm('操作提示','确认删除硬件设备?',function(yes){")
    .appendContext("var selectsRows={0}.datagrid(\"getSelections\");",JQueryModel.id(tableDG))
    .appendContext("var ids=\"\";")
    .appendContext("$.each(selectsRows,function(index,row){")
    .appendContext("ids+=','+row['Id'];  });")
    .appendContext("var action=\"{0}\";",adminDeviceActionPath+"/do/removeHardware.action")
    .appendContext("$.post(action,{ids:ids},function(str){")
    .appendContext("var json=Kia.util.strToJson(str);Kia.util.handleJsonResult(json);")
    .appendContext("{0}.datagrid(\"reload\");",JQueryModel.id(tableDG))
    .appendContext("});")
    .appendContext("});  //$.messager")
    ;
    **/
    
    JsListModel cols=new JsListModel();
    
    JsListModel row1=new JsListModel();
    
    JsMapModel colId=EasyUiUtil.createCheckBoxColumn("Id",true);

    JsMapModel colBaud=EasyUiUtil.createIntColumn(HardwareModel.F.IBaud);
    colBaud.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"波特率",true);
    
    JsMapModel colBrand=EasyUiUtil.createTextColumn(HardwareModel.F.CBrand);
    colBrand.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"硬件品牌",true);
    
    JsMapModel colCatalog=EasyUiUtil.createTextColumn(HardwareModel.F.CCatalog);
    colCatalog.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"硬件类型",true);
    
    JsMapModel colCom=EasyUiUtil.createIntColumn(HardwareModel.F.ICom);
    colCom.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"硬件端口",true);
    
    JsMapModel colDeviceId=EasyUiUtil.createTextColumn(HardwareModel.F.IDeviceId);
    colDeviceId.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"关联设备ID",true);
    
    JsMapModel colStopbits=EasyUiUtil.createIntColumn(HardwareModel.F.IStopbits);
    colStopbits.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"停止位",true);
    
   //JsMapModel colOpera=EasyUiUtil.createTextColumn("xxx",true);
   // colOpera.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"opera",true);
   // colOpera.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER,"operaFormatter");
    
    row1.add(colId);
    //row1.add(EasyUiUtil.createOperaColumn());
    row1.add(colBaud);
    row1.add(colBrand);
    row1.add(colCatalog);
    row1.add(colCom);
    row1.add(colDeviceId);
    row1.add(colStopbits);
   // row1.add(colOpera);
    
    cols.add(row1);
    JsListModel formEditors=new JsListModel();
    formEditors.add(colBaud);
    formEditors.add(colBrand);
    formEditors.add(colCatalog);
    formEditors.add(colCom);
    formEditors.add(colDeviceId);
    formEditors.add(colStopbits);
   // formEditors.add(colOpera);
    
   // JsListModel toolbar=new JsListModel();
    /**
    JsMapModel btnAdd=new JsMapModel();
    btnAdd.put(EasyUiModel.DataGrid.ToolbarProperties.TEXT,"新增硬件",true);
    btnAdd.put(EasyUiModel.DataGrid.ToolbarProperties.ICON_CLS,EasyUiModel.ICON_ADD,true);
    btnAdd.put(EasyUiModel.DataGrid.ToolbarProperties.HANDLER,clickAddHandler.getFunName());
    
    JsMapModel btnRemove=new JsMapModel();
    btnRemove.put(EasyUiModel.DataGrid.ToolbarProperties.TEXT,"删除硬件",true);
    btnRemove.put(EasyUiModel.DataGrid.ToolbarProperties.ICON_CLS,EasyUiModel.ICON_REMOVE,true);
    btnRemove.put(EasyUiModel.DataGrid.ToolbarProperties.HANDLER,clickRemoveHandler.getFunName());
    
    toolbar.add(btnAdd);
    toolbar.add(btnRemove);
    **/
    
    EasyUiModel datagrid=new EasyUiModel(JQueryModel.id(tableDG),EasyUiModel.DataGrid.NAME);
    datagrid
    //.appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"硬件管理",true)
    .appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"自助设备硬件管理",true)
    //.appendAttrs(EasyUiModel.DataGrid.Properties.FIT,true)
    .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
    //.appendAttrs(EasyUiModel.DataGrid.Properties.PAGINATION,true)
    .appendAttrs(EasyUiModel.DataGrid.Properties.URL,adminDeviceActionPath+"/datagrid/hardware.action",true)
    //.appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,toolbar.toScirpt())
    //.appendAttrs(EasyUiModel.DataGrid.Events.ON_DBL_CLICK_ROW,"dblClickRowHandler")
    .appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,"toolbar")
    ;
    
    HardwareModel initRow=new HardwareModel();
    //initRow.setStaffNo(ObjectUtil.formatString(request.getAttribute("staffNo"),"10086"));
    
    
    JsContextModel context=new JsContextModel();
    context.appendScript(datagrid);
    
    //JsContextModel funContext=new JsContextModel();
    //funContext.appendScript(clickAddHandler);
   // funContext.appendScript(clickEditHandler);
    //funContext.appendScript(clickRemoveHandler);
    
    %>
    
     <script type="text/javascript">
   var opts={};
    opts["urlAdd"]="<%=adminDeviceActionPath%>/do/add.action";
    opts["urlUpdate"]="<%=adminDeviceActionPath%>/do/add.action";
    opts["urlRemove"]="<%=adminDeviceActionPath%>/do/removeHardware.action";
    opts["regexp"]="#<%=tableDG%>";
    opts["initRow"]=function(){return <%=initRow.toJson().toString()%>; };
    opts["editors"]=<%=formEditors.toScirpt() %>;
    
    var crud= new CrudDatagrid(opts);
    var formOpts={};
    formOpts["prefix"]="hardware.";
    var toolbar=crud.getToolbar(formOpts);
    

    <%=JQueryModel.DOC_READY_START %>
    <%=context.toScirpt()%>
    <%=JQueryModel.DOC_READY_END %>
    </script>

  </head>
  
  <body>
        <div class="innerDiv" >
   <table  id="<%=tableDG %>" ></table>
   </div>
   <div id="<%=divEdit %>"></div>
  </body>
</html>
