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
<script type="text/javascript"><%--
$(document).ready(function(){   
	$("#test").datagrid({fit:true,
	columns:[ 
	[ 
		
	{field:"Id",checkbox:true},
	{field:"<%=%>",title:"驾校名称",width:150},
	{field:"<%=%>",title:"年受理数",width:150},
	{field:"<%=%>",title:"科目一合格",width:150},
	{field:"<%=%>",title:"科目一不合格",width:150},
	{field:"<%=%>",title:"科目一合格率",width:150},
	{field:"<%=%>",title:"科目一C1待考",width:150},
	{field:"<%=%>",title:"科目一非C1待考",width:150},
	
	{field:"<%=%>",title:"桩考合格",width:150},
	{field:"<%=%>",title:"桩考不合格",width:150},
	{field:"<%=%>",title:"桩考合格率",width:150},
	{field:"<%=%>",title:"桩考C1待考",width:150},
	{field:"<%=%>",title:"桩考非C1待考",width:150},
	
	{field:"<%=%>",title:"场地合格",width:150},
	{field:"<%=%>",title:"场地不合格",width:150},
	{field:"<%=%>",title:"场地合格率",width:150},
	{field:"<%=%>",title:"场地C1待考",width:150},
	{field:"<%=%>",title:"场地非C1待考",width:150},
	
	{field:"<%=%>",title:"科目三合格",width:150},
	{field:"<%=%>",title:"科目三不合格",width:150},
	{field:"<%=%>",title:"科目三合格率",width:150},
	{field:"<%=%>",title:"科目三C1待考",width:150},
	{field:"<%=%>",title:"科目三非C1待考",width:150},
	
	{field:"<%=%>",title:"总合格率",width:150}
	
	]
	] 
	,
	pagination:true,
	url:'<%=basePath%>'+""
	} 
);
	
}); //$(document).ready
function searchform(){
	
	var =$("#").val()||"";
	
	var =$("#").val()||"";
	
    
	$("#test").datagrid("reload",{
			:
	 ,      :
	});
	
	
}		
--%></script>
  </head>
  
  <body  class="<%=EasyUiModel.Layout.CLASS %>" >
	 <div    <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_NORTH) %> style="overflow: hidden;">
	<form method="post" id="searchform">
		<table style="text-align: center ;width: 100%">
			<tr>
				<td style="background-color: rgb(208,227,248);" colspan="5">
					驾校状况统计
				</td>
			</tr>
			<tr>
				<td style="background-color: rgb(208,227,248)">
				开始日期：
				</td>
				<td style="text-align: left;">
					<input type="text" name=""
					id=""
					class="<%=EasyUiModel.DateBox.CLASS%>"   
					/>
				</td>
				<td style="background-color: rgb(208,227,248);">
				结束日期：
				</td>
				<td style="text-align: left">
					<input type="text" name=""  id=""  
					class="<%=EasyUiModel.DateBox.CLASS%>"   
					/>
				</td>
				<td style="background-color: rgb(208,227,248);text-align:center;">
					<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>  onclick="searchform()" >查询</a>
					</td>
			</tr>				
		</table>
		</form>
		</div>
		<div   <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_CENTER) %> >
		<table id="test"></table>
		</div>		
	</body>
</html>
