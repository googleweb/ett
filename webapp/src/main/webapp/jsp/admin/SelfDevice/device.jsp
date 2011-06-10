<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.drv.model.self.DeviceModel"%>
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
    
    <title>My JSP 'device.jsp' starting page</title>
    
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
    
    
    JsFunctionModel clickAddHandler=new JsFunctionModel("clickAddHandler",new String[]{});
    clickAddHandler
    .appendContext("var href=\"{0}\";",adminDeviceActionPath+"/edit/device.action")
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
    .appendContext("var href=\"{0}?id=\"+id;",adminDeviceActionPath+"/edit/device.action")
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
    .appendContext("ids+=','+row['id'];  });")
    .appendContext("var action=\"{0}\";",adminDeviceActionPath+"/do/removeDevice.action")
    .appendContext("$.post(action,{ids:ids},function(str){")
    .appendContext("var json=Kia.util.strToJson(str);Kia.util.handleJsonResult(json);")
    .appendContext("{0}.datagrid(\"reload\");",JQueryModel.id(tableDG))
    .appendContext("});")
    .appendContext("});  //$.messager")
    ;
    
       JsListModel cols=new JsListModel();
    
       JsListModel row1=new JsListModel();
       
       JsMapModel colId=EasyUiUtil.createCheckBoxColumn(DeviceModel.F.Id);
       
       JsMapModel colCatalog=EasyUiUtil.createTextColumn(DeviceModel.F.CCatalog);
       colCatalog.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"设备类型",true);
       
       JsMapModel colDevicetype=EasyUiUtil.createTextColumn(DeviceModel.F.Devicetype);
       colDevicetype.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"设备种类",true);
       
       JsMapModel colMachineName=EasyUiUtil.createTextColumn(DeviceModel.F.CMachineName);
       colMachineName.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"机器名",true);
       
       JsMapModel colPlaceAddress=EasyUiUtil.createTextColumn(DeviceModel.F.CPlaceAddress);
       colPlaceAddress.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"放置地点",true);
       
       JsMapModel colYlwgUrl=EasyUiUtil.createTextColumn(DeviceModel.F.CYlwgUrl);
       colYlwgUrl.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"网关地址",true);
       
       JsMapModel colCCreateip=EasyUiUtil.createTextColumn(DeviceModel.F.CCreateip);
       colCCreateip.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"设备Ip",true);
       
       JsMapModel colCDefaultKsccCode=EasyUiUtil.createTextColumn(DeviceModel.F.CDefaultKsccCode);
       colCDefaultKsccCode.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"默认考试场次代码",true);
       
        JsMapModel colCDefaultKsccName=EasyUiUtil.createTextColumn(DeviceModel.F.CDefaultKsccName);
       colCDefaultKsccName.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"默认考试场次名称",true);
       
       JsMapModel colCDrvInterfaceUrl=EasyUiUtil.createTextColumn(DeviceModel.F.CDrvInterfaceUrl);
       colCDrvInterfaceUrl.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"驾驶人接口URL",true);
       
       JsMapModel colCGlbmName=EasyUiUtil.createTextColumn(DeviceModel.F.CGlbmName);
       colCGlbmName.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"管理部门名称",true);
       
       JsMapModel colCGlbmCode=EasyUiUtil.createTextColumn(DeviceModel.F.CGlbmCode);
       colCGlbmCode.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"管理部门代码",true);
       
       JsMapModel colIDrvInterfaceTimeout=EasyUiUtil.createTextColumn(DeviceModel.F.IDrvInterfaceTimeout);
       colIDrvInterfaceTimeout.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"驾驶人接口timeout",true);
       
       JsMapModel colCFzjg=EasyUiUtil.createTextColumn(DeviceModel.F.CFzjg);
       colCFzjg.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"发证机关",true);
       
       JsMapModel colCIp1=EasyUiUtil.createTextColumn(DeviceModel.F.CIp1);
       colCIp1.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"机器内网IP",true);
       
       JsMapModel colCIp2=EasyUiUtil.createTextColumn(DeviceModel.F.CIp2);
       colCIp2.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"外网IP",true);
       
       JsMapModel colCKsddCode=EasyUiUtil.createTextColumn(DeviceModel.F.CKsddCode);
       colCKsddCode.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"考试地点代码",true);
       
       JsMapModel colCKsddName=EasyUiUtil.createTextColumn(DeviceModel.F.CKsddName);
       colCKsddName.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"考试地点名称",true);
       
       JsMapModel colCMac1=EasyUiUtil.createTextColumn(DeviceModel.F.CMac1);
       colCMac1.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"网卡地址",true);
       
       JsMapModel colCMac2=EasyUiUtil.createTextColumn(DeviceModel.F.CMac2);
       colCMac2.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"网卡地址2",true);
       
       JsMapModel colBoolIspreasignall=EasyUiUtil.createTextColumn(DeviceModel.F.BoolIspreasignall);
       colBoolIspreasignall.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"是否允许预约全部考场",true);
       
       JsMapModel colIVehInterfaceTimeout=EasyUiUtil.createTextColumn(DeviceModel.F.IVehInterfaceTimeout);
       colIVehInterfaceTimeout.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"机动车接口timeout",true);
       
       JsMapModel colCVehInterfaceUrl=EasyUiUtil.createTextColumn(DeviceModel.F.CVehInterfaceUrl);
       colCVehInterfaceUrl.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"机动车接口URL",true);
       
        JsMapModel colIVioInterfaceTimeout=EasyUiUtil.createTextColumn(DeviceModel.F.IVioInterfaceTimeout);
       colIVioInterfaceTimeout.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"违法接口timeout",true);
       
       JsMapModel colCVioInterfaceUrl=EasyUiUtil.createTextColumn(DeviceModel.F.CVioInterfaceUrl);
       colCVioInterfaceUrl.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"违法接口URL",true);
       
       JsMapModel colIAllowPreasignDays=EasyUiUtil.createTextColumn(DeviceModel.F.IAllowPreasignDays);
       colIAllowPreasignDays.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"允许预约的天数",true);
       
       JsMapModel colBoolIsFeeATime=EasyUiUtil.createTextColumn(DeviceModel.F.BoolIsFeeATime);
       colBoolIsFeeATime.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"是否一次交费",true);
       
       JsMapModel colBoolIsFeeByVisacard=EasyUiUtil.createTextColumn(DeviceModel.F.BoolIsFeeByVisacard);
       colBoolIsFeeByVisacard.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"是否允许通过银联卡缴费",true);
       
       JsMapModel colBoolIsPostFeeAll=EasyUiUtil.createTextColumn(DeviceModel.F.BoolIsPostFeeAll);
       colBoolIsPostFeeAll.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"收费允许邮政一次收费",true);
       
       JsMapModel colBoolIsPrintCompany=EasyUiUtil.createTextColumn(DeviceModel.F.BoolIsPrintCompany);
       colBoolIsPrintCompany.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"是否打印公司名称",true);
       
       JsMapModel colIFeeInterfaceTimeout=EasyUiUtil.createTextColumn(DeviceModel.F.IFeeInterfaceTimeout);
       colIFeeInterfaceTimeout.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"缴费接口timeout",true);
       
       JsMapModel colCFeeInterfaceUrl=EasyUiUtil.createTextColumn(DeviceModel.F.CFeeInterfaceUrl);
       colCFeeInterfaceUrl.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"缴费URL",true);
       
       
       
       JsMapModel colOpera=EasyUiUtil.createTextColumn("xxx",true);
       colOpera.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"opera",true);
       colOpera.put(EasyUiModel.DataGrid.ColumnProperties.FORMATTER,"operaFormatter");
       
       row1.add(colId);
       row1.add(colCatalog);
       row1.add(colDevicetype);
       row1.add(colMachineName);
       row1.add(colPlaceAddress);
       row1.add(colYlwgUrl);
       row1.add(colCCreateip);
       row1.add(colCDefaultKsccCode);
       row1.add(colCDefaultKsccName);
       row1.add(colCDrvInterfaceUrl);
       row1.add(colCGlbmCode);
       row1.add(colCGlbmName);
       row1.add(colIDrvInterfaceTimeout);
       row1.add(colCFzjg);
       row1.add(colCIp1);
       row1.add(colCIp2);
       row1.add(colCKsddCode);
       row1.add(colCKsddName);
       row1.add(colCMac1);
       row1.add(colCMac2);
       row1.add(colBoolIspreasignall);
       row1.add(colIVehInterfaceTimeout);
       row1.add(colCVehInterfaceUrl);
       row1.add(colIVioInterfaceTimeout);
       row1.add(colCVioInterfaceUrl);
       row1.add(colIAllowPreasignDays);
       row1.add(colBoolIsFeeATime);
       row1.add(colBoolIsFeeByVisacard);
       row1.add(colBoolIsPostFeeAll);
       row1.add(colBoolIsPrintCompany);
       row1.add(colIFeeInterfaceTimeout);
       row1.add(colCFeeInterfaceUrl);
       
       
       //row1.add(colOpera);
       
       cols.add(row1);
       
       JsListModel formEditors=new JsListModel();
       formEditors.add(colCatalog);
       formEditors.add(colDevicetype);
       formEditors.add(colMachineName);
       formEditors.add(colPlaceAddress);
       formEditors.add(colYlwgUrl);
       formEditors.add(colCCreateip);
       formEditors.add(colCDefaultKsccCode);
       formEditors.add(colCDefaultKsccName);
       formEditors.add(colCDrvInterfaceUrl);
       formEditors.add(colCGlbmCode);
       formEditors.add(colCGlbmName);
       formEditors.add(colIDrvInterfaceTimeout);
       formEditors.add(colCFzjg);
       formEditors.add(colCIp1);
       formEditors.add(colCIp2);
       formEditors.add(colCKsddCode);
       formEditors.add(colCKsddName);
       formEditors.add(colCMac1);
       formEditors.add(colCMac2);
       formEditors.add(colBoolIspreasignall);
       formEditors.add(colIVehInterfaceTimeout);
       formEditors.add(colCVehInterfaceUrl);
       formEditors.add(colIVioInterfaceTimeout);
       formEditors.add(colCVioInterfaceUrl);
       formEditors.add(colIAllowPreasignDays);
       formEditors.add(colBoolIsFeeATime);
       formEditors.add(colBoolIsFeeByVisacard);
       formEditors.add(colBoolIsPostFeeAll);
       formEditors.add(colBoolIsPrintCompany);
       formEditors.add(colIFeeInterfaceTimeout);
       formEditors.add(colCFeeInterfaceUrl);

       
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
       
       EasyUiModel datagrid=new EasyUiModel(JQueryModel.id(tableDG),EasyUiModel.DataGrid.NAME);
       datagrid
       //.appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"xxxx",true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.FIT,true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
       .appendAttrs(EasyUiModel.DataGrid.Properties.PAGINATION,true)
       .appendAttrs(EasyUiModel.DataGrid.Properties.URL,adminDeviceActionPath+"/datagrid/device.action",true)       
       .appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,"toolbar")
       .appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"自助设备管理",true)
       //.appendAttrs(EasyUiModel.DataGrid.Events.ON_DBL_CLICK_ROW,"dblClickRowHandler")
       ;
       
       
       DeviceModel initRow=new DeviceModel();
       //initRow.setStaffNo(ObjectUtil.formatString(request.getAttribute("staffNo"),"10086"));
       
       
       JsContextModel context=new JsContextModel();
       context.appendScript(datagrid);
       
       
       JsContextModel funContext=new JsContextModel();
      // funContext.appendScript(clickAddHandler);
       //funContext.appendScript(clickEditHandler);
      // funContext.appendScript(clickRemoveHandler);
    %>
    
     <script type="text/javascript">
       <%=funContext.toScirpt()%>
       try{
       var opts={};
       opts["regexp"]="#<%=tableDG %>";
       opts["editors"]=<%=formEditors.toScirpt() %>;
       opts["urlAdd"]="<%=adminDeviceActionPath %>/do/editDevice.action";
       opts["urlRemove"]="<%=adminDeviceActionPath %>/do/removeDevice.action";
       opts["urlUpdate"]=opts["urlAdd"];
       opts["initRow"]=function(){return <%=initRow.toJson().toString() %> ;};
       var toolbarOpts={};
       toolbarOpts["prefix"]="device.";
       var crud=new CrudDatagrid(opts);
       var toolbar=crud.getToolbar(toolbarOpts);
       }catch(ex) {alert(ex);}
       <%=JQueryModel.DOC_READY_START%>
       <%=context.toScirpt()%>
       <%=JQueryModel.DOC_READY_END%>
    </script>

  </head>
  
  <body>
        <div class="innerDiv" >
   <table  id="<%=tableDG %>" ></table>
   </div>
   <div id="<%=divEdit %>"></div>
  </body>
</html>
