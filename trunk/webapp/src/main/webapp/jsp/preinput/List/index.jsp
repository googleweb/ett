<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.preinput.StudentApplyInfoModel"%>
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
function showdialog(id){
	var href='<%=basePath%>'+"preinput/List/to/detail.action?id="+id;
    $("#edit").dialog({
  			title:"详细信息:",
			fit:true,
			onClose:function(){ $('#test').datagrid('reload'); },
	    	modal:true,
			onOpen:function(){$(this).kiaIframe(href);}} 
		);//   end:$("#divEdit").dialog
		return false;
}

function operaFormatter(value,rowData,rowIndex){
	var id=rowData["Id"];
    
    return "<a class='kia-icon edit' onclick=\"showdialog("+id+")\" ></a>";
    
}




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
     var qIDCard=$("#qIDCard").val()||"";
     if(qIDCard==""){
       $.messager.alert("","身份证不能为空","error");
     }else{
       $("#test").datagrid("reload",{qIDCard:qIDCard});
     }
     
}

function clickAddHandler(){ 
  		var href='<%=basePath%>'+"preinput/List/to/detail.action?id=0";
  		$("#edit").dialog({
  			title:"新增",
			fit:true,
			onClose:function(){ $('#test').datagrid('reload'); },
	    	modal:true,
			onOpen:function(){$(this).kiaIframe(href);}} 
		);    //   end:$("#divEdit").dialog
		return false;
 }
function dblClickRowHandler(rowIndex,rowData){ 
	    var id=rowData["Id"];
	    var fullname=rowData["<%=StudentApplyInfoModel.F.CLsh%>"];
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
					//$.each(selectsRows,function(index,row){
					//		ids+=','+row['Id'];  
					//		});
					ids=selectsRows.getUnionStr("Id");
					var action="<%=basePath%>"+"preinput/List/do/delete.action";
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

function checkedFormatter(value,rowIndex,rowData){
    if(value==1){
      return "已审核";
    }else if(value==0){
      return "未审核";
    }else{
      return "";
    }
}

$(document).ready(function(){


   
	$("#test").datagrid({fit:true,
	toolbar:[ 
			{text:"新增",
			iconCls:"icon-add",
			handler:clickAddHandler}
	, 
			{text:"删除",
			iconCls:"icon-remove",
			handler:clickRemoveHandler}
	
	] 
    ,
	columns:[ 
	[ 
	{field:"Id",checkbox:true},
	{field:"<%=StudentApplyInfoModel.F.CLsh%>",title:"流水号",width:150},
	{field:"<%=StudentApplyInfoModel.F.Sfzmhm%>",title:"身份证明号码",width:150},
	{field:"<%=StudentApplyInfoModel.F.CXm%>",title:"姓名",width:150},
	{field:"<%=StudentApplyInfoModel.F.CJxmc%>",title:"驾校名称",width:150},
	{field:"<%=StudentApplyInfoModel.F.IChecked%>",title:"审核结果",width:150,formatter:checkedFormatter},
	{field:"<%=StudentApplyInfoModel.F.CCheckResult%>",title:"审核结果描述",width:150},
	{field:"<%=StudentApplyInfoModel.F.CCheckOperator%>",title:"经办人",width:150},
	{field:"xxx",title:"详细",formatter:operaFormatter,width:150}	
	]
	] 
	,
	pagination:true,
	url:"<%=basePath%>"+"preinput/List/datagrid/list.action"} 
);    //   end:$("#tableDG").datagrid
	
}); //$(document).ready
</script>
  <body  class="<%=EasyUiModel.Layout.CLASS %>" >
    <div   <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_NORTH) %>  
       style="height: 100px">
    <p style="text-align: center"><h3>初学+增驾申请名单列表</h3></p>
    <form method="post" id="formSearch">
         <table class="editTable" cellspacing="0" align="right">
         <tr>   
              <td style="width: 300px;">
              		身份证明号码:<input name="qIDCard" id="qIDCard" class="easyui-validatebox" />
              </td>
              <td>
                 <a class="easyui-linkbutton"  id="aSearch"
                    onclick="searchUser()"
                 >查询</a>
              </td>         
            </tr>
         </table>
      </form>
      
    </div>
    <div <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_CENTER) %> >
	<table id="test" ></table>
	</div>
	<div  id="edit"></div>
 </body>
</html>