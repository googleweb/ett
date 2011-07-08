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
    
    <title>一天内科目三次数超过50</title>
    
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
	{field:"Km3ksy1",title:"考试员",width:150},
	{field:"Num",title:"人数",width:150}
	]
	] 
	,
	pagination:true,
	url:"<%=basePath%>statis/Km/datagrid/km3kscc"
	} 
);	
}); //$(document).ready
function searchform(){
$("#searchform").form("validate");
	 var begindate=$("#begindate").datebox("getValue");
	  var enddate=$("#enddate").datebox("getValue");
	$("#test").datagrid("reload",{
			begindate:begindate
	 ,      enddate:enddate
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
				操作时间起：
				</td>
				<td>
					<input type="text" name="" id="begindate"  
				     class="<%=EasyUiModel.DateBox.CLASS%>"  
					 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
					 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("请输入开始日期 ") %>
					/>
				</td>
				<td>
				操作时间止：
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
		</table>
		</form>
		</div>
		<div   <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_CENTER) %> >
		<table id="test"></table>
		</div>		
	</body>
</html>
