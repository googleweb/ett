<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.drv.model.self.DeviceSnModel"%>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminDeviceActionPath=basePath+"/admin/SelfDevice";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deviceSn.jsp' starting page</title>
    
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
    
    String divEdit="divEdit";
    
    /**
    JsFunctionModel clickAddHandler=new JsFunctionModel("clickAddHandler",new String[]{});
    clickAddHandler
    .appendContext("var href=\"{0}\";",adminDeviceActionPath+"/edit/deviceSn.action")
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
    .appendContext("var href=\"{0}?id=\"+id;",adminDeviceActionPath+"/edit/deviceSn.action")
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
    .appendContext("var action=\"{0}\";",adminDeviceActionPath+"/do/removeDeviceSn.action")
    .appendContext("$.post(action,{ids:ids},function(str){")
    .appendContext("var json=Kia.util.strToJson(str);Kia.util.handleJsonResult(json);")
    .appendContext("{0}.datagrid(\"reload\");",JQueryModel.id(tableDG))
    .appendContext("});")
    .appendContext("});  //$.messager")
    ;
    **/
    
    JsListModel cols=new JsListModel();
    
    JsListModel row1=new JsListModel();
    
    JsMapModel colId=EasyUiUtil.createCheckBoxColumn(DeviceSnModel.F.Id);
    
    JsMapModel colJkname=EasyUiUtil.createTextColumn(DeviceSnModel.F.CJkname);
    colJkname.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"接口名",true);

    JsMapModel colJkxlh=EasyUiUtil.createIntColumn(DeviceSnModel.F.CJkxlh);
    colJkxlh.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"接口序列号",true);

    JsMapModel colJkid=EasyUiUtil.createIntColumn(DeviceSnModel.F.CJkid);
    colJkid.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"接口ID",true);
    
    JsMapModel optkm1=new JsMapModel();
   // optkm1.put(EasyUiModel.ValidateBox.Properties.REQUIRED,"true");
    optkm1.put(EasyUiModel.ValidateBox.Properties.VALID_TYPE,"ip",true);
    JsMapModel colDeviceIp=EasyUiUtil.createTextColumn(DeviceSnModel.F.CDeviceIp);
    colDeviceIp.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"设备IP",true);
    colDeviceIp.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,optkm1));

    JsMapModel colSn=EasyUiUtil.createTextColumn(DeviceSnModel.F.CSn);
    colSn.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"sn",true);

    JsMapModel colKeywords=EasyUiUtil.createTextColumn(DeviceSnModel.F.CKeywords);
    colKeywords.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"keywords",true);
    
    //JsMapModel colOpera=EasyUiUtil.createTextColumn("xxx",true);
    //colOpera.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"opera",true);
    //colOpera.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER,"operaFormatter");
    
    row1.add(colId);
    row1.add(colJkxlh);
    row1.add(colJkid);
    row1.add(colJkname);
    row1.add(colDeviceIp);
    //row1.add(colOpera);
    
    cols.add(row1);
    
    JsListModel formCols=new JsListModel();
    formCols.add(colJkxlh);
    formCols.add(colJkid);
    formCols.add(colJkname);
    formCols.add(colDeviceIp);
    /**
    JsListModel toolbar=new JsListModel();
    
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
    //.appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"xxxx",true)
    //.appendAttrs(EasyUiModel.DataGrid.Properties.FIT,true)
    .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
    //.appendAttrs(EasyUiModel.DataGrid.Properties.PAGINATION,true)
    .appendAttrs(EasyUiModel.DataGrid.Properties.URL,adminDeviceActionPath+"/datagrid/deviceSn.action",true)
    //.appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,toolbar.toScirpt())
    //.appendAttrs(EasyUiModel.DataGrid.Events.ON_DBL_CLICK_ROW,"dblClickRowHandler")
    .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
    .appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,"toolbar")
    .appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"自助设备接口管理",true)
    ;
    
    DeviceSnModel initRow=new DeviceSnModel();
    //initRow.setStaffNo(ObjectUtil.formatString(request.getAttribute("staffNo"),"10086"));
    
    JsContextModel context=new JsContextModel();
    context.appendScript(datagrid);
    
    JsContextModel funContext=new JsContextModel();
   // funContext.appendScript(clickAddHandler);
   // funContext.appendScript(clickEditHandler);
   // funContext.appendScript(clickRemoveHandler);
    %>
    
     <script type="text/javascript">
    var opts={};
    opts["urlAdd"]="<%=adminDeviceActionPath%>/do/editDeviceSn.action";
    opts["urlUpdate"]="<%=adminDeviceActionPath%>/do/editDeviceSn.action";
    opts["urlRemove"]="<%=adminDeviceActionPath%>/do/removeDeviceSn.action";
    opts["regexp"]="#<%=tableDG%>";
    opts["initRow"]=function(){return <%=initRow.toJson().toString()%>; };
    opts["editors"]=<%=formCols.toScirpt() %>;
    
    var crud= new CrudDatagrid(opts);
    var formOpts={};
    formOpts["prefix"]="deviceSn.";
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
