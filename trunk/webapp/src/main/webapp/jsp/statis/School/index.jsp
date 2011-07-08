<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>驾校状况查询</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<jsp:include page="/plugin/index.jsp">
			<jsp:param value="jquery,easyui" name="plugin" />
		</jsp:include>
		<jsp:include page="/css/index.jsp"></jsp:include>
		<jsp:include page="/js/index.jsp"></jsp:include>
		<style type="text/css">
</style>
<script type="text/javascript">
$(document).ready(function(){   
	$("#test").datagrid({fit:true,
	columns:[ 
	[ 
		
	//{field:"Id",checkbox:true},
	{field:"Jxmc",title:"驾校名称",width:150},
	{field:"CountDate",title:"年受理数",width:150},
	{field:"Km1hg",title:"科目一合格",width:150},
	{field:"Km1bhg",title:"科目一不合格",width:150},
	{field:"Km1hgl",title:"科目一合格率",width:150},
	{field:"Km1c1dk",title:"科目一C1待考",width:150},
	{field:"Km1nc1dk",title:"科目一非C1待考",width:150},
	
	{field:"Zkhg",title:"桩考合格",width:150},
	{field:"Zkbhg",title:"桩考不合格",width:150},
	{field:"Zkhgl",title:"桩考合格率",width:150},
	{field:"Zkc1dk",title:"桩考C1待考",width:150},
	{field:"Zknc1dk",title:"桩考非C1待考",width:150},
	
	{field:"Cdhg",title:"场地合格",width:150},
	{field:"Cdbhg",title:"场地不合格",width:150},
	{field:"Cdhgl",title:"场地合格率",width:150},
	{field:"Cdc1dk",title:"场地C1待考",width:150},
	{field:"Cdnc1dk",title:"场地非C1待考",width:150},
	
	{field:"Km3hg",title:"科目三合格",width:150},
	{field:"Km3bhg",title:"科目三不合格",width:150},
	{field:"Km3hgl",title:"科目三合格率",width:150},
	{field:"Km3c1dk",title:"科目三C1待考",width:150},
	{field:"Km3nc1dk",title:"科目三非C1待考",width:150},
	
	{field:"Zhgl",title:"总合格率",width:150}
	]
	] 
	,
	pagination:true,
	url:"<%=basePath%>statis/School/datagrid/School"
	} 
);
	
});

function searchform(){	
	
$("#searchform").form("validate");
	 var begindate=$("#begindate").datebox("getValue");
	  var enddate=$("#enddate").datebox("getValue");
	$("#test").datagrid("reload",{
	 begindate:begindate
	 ,enddate:enddate
	});
}		
</script>
  </head> 
  <body  class="<%=EasyUiModel.Layout.CLASS %>" >
	 <div    <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_NORTH) %> style="overflow: hidden;">
	<form method="post" id="searchform">
		<table class="editTable" cellspacing="0" align="right">
			<tr>
				<td>
				开始日期：
				</td>
				<td>
					<input type="text" name="" id="begindate"  
				     class="<%=EasyUiModel.DateBox.CLASS%>"  
					 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
					 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("请输入开始日期 ") %>
					/>
				</td>
				<td>
				结束日期：
				</td>
				<td>
					<input type="text" name=""  id="enddate"  
					class="<%=EasyUiModel.DateBox.CLASS%>"
					 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
					 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("请输入结束日期 ") %>
					  />
				</td>
				<td>
					<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>  onclick="searchform()" >查询</a>
					</td>
			</tr>				
		</table></form>
		</div>
		<div   <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_CENTER) %> >
		<table id="test"></table>
		</div>		
	</body>
</html>
