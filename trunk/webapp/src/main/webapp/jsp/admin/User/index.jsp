<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.admin.UserModel"%>
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
function fuweiMiMa(){
	var selectsRows=$("#test").datagrid("getSelections");
	var obj=selectsRows.length;
	if(obj!=0){
 		 $.messager.confirm('操作提示','确认复位密码 ?',function(yes){		 		
					var ids="";
					$.each(selectsRows,function(index,row){
							ids+=','+row['Id'];  
							});
					var action="<%=basePath%>"+"admin/User/do/fuweiUser.action";
					$.post(action,{ids:ids},
							function(str){
									var json=Kia.util.strToJson(str);
									Kia.util.handleJsonResult(json);
									$("#test").datagrid("reload");
									$("#test").datagrid("clearSelections");
							
					});
		});  //$.messager
	}
	else
		{
		$.messager.alert('操作提示','请选择要删除的记录！');
		}
}
function searchUser(){
	$("#formSearch").form("submit",{
	  	url:'<%=basePath%>'+"admin/User/search/User.action",
	   	success:function(str){
	  			var json=Kia.util.strToJson(str); 
	   			$("#test").datagrid("loadData",json); 
	   			}
  		}
  );
}

function clickAddHandler(){ 
  		var href='<%=basePath%>'+"admin/User/to/editUser.action?id=0";
  		$("#divEditUser").dialog({
  			title:"新增用户",
			height:400,
			width:600,
			onClose:function(){ $('#test').datagrid('reload'); },
	    	modal:true,
			onOpen:function(){$(this).kiaIframe(href);}} 
		);    //   end:$("#divEdit").dialog
		return false;
 }
function dblClickRowHandler(rowIndex,rowData){ 
	    var id=rowData["Id"];
	    var fullname=rowData["<%=UserModel.F.CFullName%>"];
  		var href='<%=basePath%>'+"admin/User/to/editUser.action?id="+id;
  		$("#divEditUser").dialog({
  			title:"修改用户:"+fullname,
			height:400,
			width:600,
			onClose:function(){ $('#test').datagrid('reload'); },
	    	modal:true,
			onOpen:function(){$(this).kiaIframe(href);}} 
		);//   end:$("#divEdit").dialog
		return false;
 }
function clickRemoveHandler(){ 
	var selectsRows=$("#test").datagrid("getSelections");
	var obj=selectsRows.length;
	//alert(obj);
	if(obj!=0){
 		 $.messager.confirm('操作提示','确认删除用户?',function(yes){		 		
					var ids="";
					$.each(selectsRows,function(index,row){
							ids+=','+row['Id'];  
							});
					var action="<%=basePath%>"+"admin/User/do/deleteUser.action";
					$.post(action,{ids:ids},
							function(str){
									var json=Kia.util.strToJson(str);
									Kia.util.handleJsonResult(json);
									$("#test").datagrid("reload");
									$("#test").datagrid("clearSelections");
									
									
					});
		});  //$.messager
	}
	else
		{
		$.messager.alert('操作提示','请选择要删除的记录！');
		}
}
$(document).ready(function(){   
	$("#test").datagrid({fit:true,
	toolbar:[ 
			{text:"新增用户",
			iconCls:"icon-add",
			handler:clickAddHandler}
	, 
			{text:"删除用户",
			iconCls:"icon-remove",
			handler:clickRemoveHandler}
	, 
			{text:"密码复位",
			iconCls:"icon-remove",
			handler:fuweiMiMa}
	] 
    ,
	columns:[ 
	[ 
	{field:"Id",checkbox:true},
	{field:"<%=UserModel.F.CLoginName%>",title:"用户名",width:150},
	{field:"<%=UserModel.F.CPwd%>",title:"密码",width:150},
	{field:"<%=UserModel.F.CWorkid%>",title:"工作号",width:150},
	{field:"<%=UserModel.V.RoleName%>",title:"角色号",width:150},
	{field:"<%=UserModel.F.CState%>",title:"状态",width:150},
	{field:"<%=UserModel.F.CIdcard%>",title:"卡号",width:150},
	{field:"<%=UserModel.F.IDepid%>",title:"部门编号",width:150},
	{field:"<%=UserModel.F.CFullName%>",title:"全名",width:150},
	{field:"<%=UserModel.F.CBeginip%>",title:"开始IP",width:150},
	{field:"<%=UserModel.F.CEndip%>",title:"结束IP",width:150}	
	]
	] 
	,
	pagination:true,
	onDblClickRow:dblClickRowHandler
	,
	url:'<%=basePath%>'+"admin/User/datagrid/users.action"} 
);    //   end:$("#tableDG").datagrid
	
}); //$(document).ready
</script>
  <body>
    <div class="innerDiv">
    <form method="post" id="formSearch">
         <table class="editTable" cellspacing="0">
            <tr>
              <td style="width: 300px;">
              		用户名:<input name="Username" class="easyui-validatebox" />
              </td>
              <td style="width: 300px">
                 	角色名:<input name="<%= UserModel.F.IRoleid %>" 
                       valuefield="Id"
                   textfield="CName"
                     url="<%=basePath%>admin/User/combobox/roleid.action" 
                 value="${IRoleid}"
                  editable="true"
  	                  class="<%=EasyUiModel.ComboBox.CLASS %>"      
                   />
             </td>
              <td>
                 <a class="easyui-linkbutton"  id="aSearch"
                    onclick="searchUser()"
                 >查询</a>
              </td>         
            </tr>
         </table>
      </form>
	<table id="test"></table>
	</div>
	<div id="divEditUser"></div>	
  </body>
</html>