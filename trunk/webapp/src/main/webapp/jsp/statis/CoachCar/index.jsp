<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.drv.view.StatisCoachCarView"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教练车查询</title>
    
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
	{field:"Jxnc",title:"驾校名称",width:150},
	{field:"Jlzh",title:"教练证号",width:150},
	{field:"Sfzmhm",title:"身份证明名称",width:150},
	{field:"Xm",title:"姓名",width:150},
	{field:"Clpp",title:"车辆品牌",width:150},
	{field:"Hphm",title:"号牌号码",width:150},
	{field:"Regdate",title:"入场日期",width:150},
	{field:"Sj",title:"联系手机",width:150}
	]
	] 
	,
	pagination:true,
	url:"<%=basePath%>statis/CoachCar/datagrid/CoachCar"
	} 
);
	
}); //$(document).ready
  
function searchform(){
	$("#searchform").form("validate");
	var cardnum=$("#cardnum").val()||"";
	var carnum=$("#carnum").val()||"";
	$("#test").datagrid("reload",{
			cardnum:cardnum
	 ,      carnum:carnum
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
				身份证明号码：
				</td>
				<td>
					<input type="text" name="" id="cardnum"  
					 class="<%=EasyUiModel.ValidateBox.CLASS%>"
					 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
					 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("请输入身份证号码 ") %>
					/>
				</td>
				<td>
				号码号牌：
				</td>
				<td>
					<input type="text" name=""  id="carnum"  
					 class="<%=EasyUiModel.ValidateBox.CLASS%>"
					 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
					 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("请输入号码号牌") %>
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
