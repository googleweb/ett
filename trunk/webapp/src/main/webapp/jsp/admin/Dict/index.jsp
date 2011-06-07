<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.admin.DictModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
         <jsp:include page="/plugin/index.jsp">
	 	    <jsp:param value="jquery,easyui" name="plugin"/>
	     </jsp:include>
         <jsp:include page="/css/index.jsp"></jsp:include>
         <jsp:include page="/js/index.jsp"></jsp:include>  
  
  <script type="text/javascript">
 
  function operaFormatter(value,rowData,rowIndex){
  var aEdit="<a title='编辑' href='javascript:void(0)' class='kia-iconedit' onclick='clickEditHandler("+rowData["id"]+");'></a>";
  return aEdit;
  }
  function clickAddHandler(){
  var href="<%=basePath%>admin/Dict/to/editDict.action";
  $("#divEditDict").dialog({
    title:"新增字典",
    height:400,
    width:600,
    onClose:function(){$('#test').datagrid('reload');},
    modal:true,
    onBeforeOpen:function(){$(this).kiaIframe(href);}
  });
  }
  
  function dblClickRowHandler(rowIndex,rowData){
  var id=rowData["Id"];
  var dictText=rowData["<%=DictModel.F.CDictText%>"];
  var title="修改字典："+dictText;
  var href="<%=basePath%>admin/Dict/to/editDict.action?id="+id;
            $("#divEditDict").dialog({
            title:title,
            height:400,
            width:600,
            onClose:function(){$('#test').datagrid('reload');},
            modal:true,
            onBeforeOpen:function(){$(this).kiaIframe(href);}
            
            });  //$("#divEditUser").dialog({
            
  }//function dbClickRowHandler(rowIndex,rowData){
            
  function clickRemoveHandler(){
            $.messager.confirm('操作提示','确认删除字典？',function(yes){
            var selectsRows=$("#test").datagrid("getSelections");
            var ids="";
            $.each(selectsRows,function(index,row){
            ids+=','+row['Id'];
            });
            var action="<%=basePath%>"+"admin/Dict/do/deleteDict.action";
            $.post(action,{ids:ids},
            				function(str){
                                   str.messager();
            					$("#test").datagrid("reload");}
            	   );  //$.post(action,{ids:ids},
 });   //$.messager.confirm('操作提示','确认删除用户？',function(yes){
 
 }//function clickRemoveHandler(){
 <%=JQueryModel.DOC_READY_START%>

  $("#test").datagrid({fit:true,
  toolbar:[
          {text:"新增字典",
           iconCls:"icon-add",
           handler:clickAddHandler},
           {text:"删除字典",
            iconCls:"icon-remove",
            handler:clickRemoveHandler}
  ],
  columns:[[
  {field:"Id",checkbox:true},
  {field:"<%=DictModel.F.CTypename%>",title:"字典类别名",width:150},
  {field:"<%=DictModel.F.CDictText%>",title:"字典名",width:150},
  {field:"<%=DictModel.F.CDictValue%>",title:"字典值",width:150},
  {field:"<%=DictModel.F.CDes1%>",title:"Des1",width:150},
  {field:"<%=DictModel.F.CDes2%>",title:"Des2",width:150},
  {field:"<%=DictModel.F.CDes3%>",title:"Des3",width:150},
  {field:"<%=DictModel.F.CState%>",title:"状态",width:150}
   
  ]],
  groupField:'<%=DictModel.F.CTypename%>',
  view: groupview,
  pagination:true,
  onDblClickRow:dblClickRowHandler
  ,
  groupFormatter:function(value, rows){
					return value + ' - ' + rows.length + ' 条';
				},
  url:"<%=basePath%>admin/Dict/datagrid/dicts.action"
    }
  );

  
  <%=JQueryModel.DOC_READY_END%>
  </script>
  
    </head>
  <body>
   <div class="innerDiv">
   <table id="test"></table>
   </div>
   <div id="divEditDict"></div>
  </body>
</html>
