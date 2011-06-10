<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.admin.DepartmentModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.model.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminDictTypePath=basePath+"admin/Department";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menuConfig-success.jsp' starting page</title>
    
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
  </head>
<script type="text/javascript">

    <%
      String tableDictType="tableDictType";
    
      JsListModel cols=new JsListModel();
      JsListModel row1=new JsListModel();
      
      JsMapModel colId=EasyUiUtil.createCheckBoxColumn(DepartmentModel.F.Id);
      
      JsMapModel CDepnickname=EasyUiUtil.createTextColumn(DepartmentModel.F.CDepnickname);
      CDepnickname.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"类型名称",true);
      CDepnickname.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,null));
      
      JsMapModel CCompanycode=EasyUiUtil.createTextColumn(DepartmentModel.F.CCompanycode);
      CCompanycode.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"公司邮编",true);
      CCompanycode.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,null));
      
      JsMapModel CConnector=EasyUiUtil.createTextColumn(DepartmentModel.F.CConnector);
      CConnector.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"连接",true);
      CConnector.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,null));
      
      JsMapModel CDepcode=EasyUiUtil.createTextColumn(DepartmentModel.F.CDepcode);
      CDepcode.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"部门编号",true);
      CDepcode.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,null));
      
      JsMapModel CDepfullname=EasyUiUtil.createTextColumn(DepartmentModel.F.CDepfullname);
      CDepfullname.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"部门全名",true);
      CDepfullname.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,null));
      
      JsMapModel CDeptype=EasyUiUtil.createTextColumn(DepartmentModel.F.CDeptype);
      CDeptype.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"部门类型",true);
      CDeptype.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,null));
      
      JsMapModel CMobile=EasyUiUtil.createTextColumn(DepartmentModel.F.CMobile);
      CMobile.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"座机",true);
      CMobile.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,null));
      
      JsMapModel CParentcode=EasyUiUtil.createTextColumn(DepartmentModel.F.CParentcode);
      CParentcode.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"父类编号",true);
      CParentcode.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,null));
      
      
      JsMapModel CPhone=EasyUiUtil.createTextColumn(DepartmentModel.F.CPhone);
      CPhone.put(EasyUiModel.DataGrid.ColumnProperties.TITLE,"手机",true);
      CPhone.put(EasyUiModel.DataGrid.ColumnProperties.EDITOR,EasyUiUtil.createValidateboxEditor(true,null));
      
      
      row1.add(colId);
      row1.add(CDepnickname);
      row1.add(CCompanycode);
      row1.add(CConnector);
      row1.add(CDepcode);
      row1.add(CDepfullname);
      row1.add(CDeptype);
      row1.add(CMobile);
      row1.add(CParentcode);
      row1.add(CPhone);
   
      cols.add(row1);
      
      JsListModel formCols=new JsListModel();
      formCols.add(CDepnickname);
      formCols.add(CCompanycode);
      formCols.add(CConnector);
      formCols.add(CDepcode);
      formCols.add(CDepfullname);
      formCols.add(CDeptype);
      formCols.add(CMobile);
      formCols.add(CParentcode);
      formCols.add(CPhone);
    
    
      EasyUiModel datagridDictType=new EasyUiModel(JQueryModel.id(tableDictType),EasyUiModel.DataGrid.NAME);
      datagridDictType
      .appendAttrs(EasyUiModel.DataGrid.Properties.TITLE,"部门管理",true)
      .appendAttrs(EasyUiModel.DataGrid.Properties.URL,adminDictTypePath+"/datagrid/department.action",true)
      .appendAttrs(EasyUiModel.DataGrid.Properties.COLUMNS,cols)
      .appendAttrs(EasyUiModel.DataGrid.Properties.TOOLBAR,"toolbar")
      ;

      JsContextModel jsContext=new JsContextModel();
      jsContext.appendScript(datagridDictType);

    
      DepartmentModel initRow=new DepartmentModel();
      
    %> 

    
    var opts={};
    opts["urlAdd"]="<%=adminDictTypePath%>/do/modifDepartment.action";
    opts["urlUpdate"]="<%=adminDictTypePath%>/do/modifDepartment.action";
    opts["urlRemove"]="<%=adminDictTypePath%>/do/deleteDepartment.action";
    opts["regexp"]="#<%=tableDictType%>";
    opts["initRow"]=function(){return <%=initRow.toJson().toString()%>; };
    opts["editors"]=<%=formCols.toScirpt() %>;
    
    var crud= new CrudDatagrid(opts);
    var formOpts={};
    var toolbar=crud.getToolbar(formOpts);

    <%=JQueryModel.DOC_READY_START %>
    <%=jsContext.toScirpt()%>
    <%=JQueryModel.DOC_READY_END %>

</script>
  <body>
    <div class="innerDiv">
	<table id="<%=tableDictType %>"></table>
	</div>
	<div id="divEditDict"></div>	
  </body>
</html>