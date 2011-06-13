<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.JsContextModel"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsListModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsMapModel"%>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.ett.drv.model.booked.SchoolCarModel"%>
<%@page import="com.ett.drv.model.admin.DepartmentModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsFunctionModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bookedSchoolCarPath=basePath+"booked/SchoolCar";
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
      <jsp:param value="jquery,easyui" name="plugin"/>
    </jsp:include>
    <jsp:include page="/css/index.jsp"></jsp:include>
    <jsp:include page="/js/index.jsp"></jsp:include>

   <%
      String tableSchoolCar="tableSchoolCar";
   
      JsListModel cols=new JsListModel();
      JsListModel row1=new JsListModel();
 
     JsMapModel colId=EasyUiUtil.createCheckBoxColumn(SchoolCarModel.F.Id);
      
  	 JsMapModel colClpp=EasyUiUtil.createTextColumn(SchoolCarModel.F.Clpp);
  	 colClpp.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"车辆品牌",true);
  	 
  	 JsMapModel colHmhp=EasyUiUtil.createTextColumn(SchoolCarModel.F.Hmhp);
  	 colHmhp.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"号码号牌",true);
  	 
  	 JsMapModel colName=EasyUiUtil.createTextColumn(SchoolCarModel.F.Name);
  	 colName.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"教练名",true);
  	 
  	 JsMapModel colIdcard=EasyUiUtil.createTextColumn(SchoolCarModel.F.Idcard);
  	 colIdcard.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"身份证号",true);
  	 
  	 JsMapModel colCoachno=EasyUiUtil.createTextColumn(SchoolCarModel.F.Coachno);
  	 colCoachno.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"教练证号",true);
  	 
  	 JsMapModel colMobile=EasyUiUtil.createTextColumn(SchoolCarModel.F.Mobile);
  	 colMobile.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"联系电话",true);
  	 
  	 JsMapModel colDepname=EasyUiUtil.createTextColumn(SchoolCarModel.F.Depname);
  	 colDepname.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"驾校名称",true);
  	 
  	 
  	 JsMapModel optDepcode=new JsMapModel();
  	 optDepcode.put(EasyUiModel.ComboBox.Properties.URL,bookedSchoolCarPath+"/combobox/school.action",true);
  	 optDepcode.put(EasyUiModel.ComboBox.Properties.VALUE_FIELD,DepartmentModel.F.CDepcode,true);
  	 optDepcode.put(EasyUiModel.ComboBox.Properties.TEXT_FIELD,DepartmentModel.F.CDepnickname,true);
  	 JsMapModel colDepcode=EasyUiUtil.createTextColumn(SchoolCarModel.F.Depcode);
  	 colDepcode.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"驾校名称",true);
  	 colDepcode.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createComboboxEditor(true,optDepcode));
  	 
  	 row1.add(colId);
  	 row1.add(colClpp);
  	 row1.add(colHmhp);
  	row1.add(colName);
  	row1.add(colIdcard);
  	row1.add(colCoachno);
  	row1.add(colMobile);
  	row1.add(colDepname);

  	 cols.add(row1);
  	 
  	 JsListModel editors=new JsListModel();
  	 editors.add(colClpp);
  	editors.add(colHmhp);
  	editors.add(colName);
  	editors.add(colIdcard);
  	editors.add(colCoachno);
  	editors.add(colMobile);
  	editors.add(colDepcode);
  	
  	SchoolCarModel initRow=new SchoolCarModel();
   
      EasyUiModel datagridSchoolCar=new EasyUiModel(JQueryModel.id(tableSchoolCar),EasyUiModel.DataGrid.NAME);
      datagridSchoolCar
      .appendAttrs(EasyUiModel.DataGrid.Properties.URL,bookedSchoolCarPath+"/datagrid/schoolCar.action",true)
      .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
      .appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,"toolbar")
      .appendAttrs(EasyUiModel.DataGrid.Events.ON_DBL_CLICK_ROW,"dblClickRowHandler")
      .appendAttrs("view","groupview")
      .appendAttrs("groupField",SchoolCarModel.F.Depcode,true)
      .appendAttrs("groupFormatter",new JsFunctionModel(new String[]{"value","rows"})
                                       .appendContext("return value + ' - ' + rows.length + ' 条';")
      )
      ;
      
      JsContextModel jsContext=new JsContextModel();
      jsContext.appendScript(datagridSchoolCar);
   %>

    <script type="text/javascript">
       var opts={};
       opts["regexp"]="#<%=tableSchoolCar%>";
       opts["urlAdd"]="<%=bookedSchoolCarPath%>/do/saveSchoolCar.action";
       opts["urlUpdate"]=opts["urlAdd"];
       opts["urlRemove"]="<%=bookedSchoolCarPath%>/do/removeSchoolCar.action";
       opts["editors"]=<%=editors.toScirpt()%>;
       opts["initRow"]=function(){return <%=initRow.toJson().toString() %>;};
       var crud=new CrudDatagrid(opts);
       var formOpts={};
       var toolbar=crud.getToolbar();
       var dblClickRowHandler=crud.getEditRowHandler();
       <%=JQueryModel.DOC_READY_START%>
       <%=jsContext.toScirpt() %> 
       <%=JQueryModel.DOC_READY_END%>
    </script>

  </head>
  
  <body>
     <div style="width: 100%;height: 100%">
     <table id="<%=tableSchoolCar %>" ></table>
     </div>
  </body>
</html>
