<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@page import="com.ett.drv.model.admin.BusLogModel"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String adminMenuPath = basePath + "admin/Menu";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
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
table {
	
	border-style: solid;
	border-width: 1px;
}

td {
	
	border-width: 1px;
}
</style>
		<script type="text/javascript">
		$(document).ready(function(){   
	$("#test").datagrid({fit:true,
	columns:[ 
	[ 
		
	{field:"Id",checkbox:true},
	{field:"<%=BusLogModel.F.CBustype%>",title:"车型",width:150},
	{field:"<%=BusLogModel.F.CContent%>",title:"",width:150},
	{field:"<%=BusLogModel.F.CDes1%>",title:"描述1",width:150},
	{field:"<%=BusLogModel.F.CDes2%>",title:"描述2",width:150},
	{field:"<%=BusLogModel.F.CDes3%>",title:"描述3",width:150},
	{field:"<%=BusLogModel.F.COperator%>",title:"操作者",width:150},
	{field:"<%=BusLogModel.F.IDepid%>",title:"标题",width:150},
	{field:"<%=BusLogModel.F.Regdate%>",title:"体检日期",width:150}
	]
	] 
	,
	pagination:true,
	url:'<%=basePath%>'+"physical/HospitalMessage/do/bizsearch.action"
	} 
);
	
}); //$(document).ready
function searchform(){
	$("#searchform").form("submit",{
	  	url:'<%=basePath%>'+"physical/HospitalMessage/do/searchLog.action",
	   	success:function(str){
	  			var json=Kia.util.strToJson(str); 
	   			$("#test").datagrid("loadData",json); 
	   			}
	
	});
	
}		
</script>
	</head>
	<body>
	<form id="searchform" action="post">
		<table style="text-align: center ;">
			<tr>
				<td style="background-color: rgb(208,227,248);" colspan="4">
						体检业务日志查询 
				</td>
			</tr>
			<tr>
				<td style="background-color: rgb(208,227,248);">
				证件号码：
				</td>
				<td>
					<input type="text" name=""/>
				</td>
				<td style="background-color: rgb(208,227,248);">
				档案编号：
				</td>
				<td>
					<input type="text" name=""/>
				</td>
			</tr>
				<tr>
				<td style="background-color: rgb(208,227,248);">
				体检日期起：
				</td>
					<td>
					<input type="text" name=""/>
				</td>
				<td style="background-color: rgb(208,227,248);">
				体检日期止：
				</td>
				<td>
					<input type="text" name=""/>
				</td>
			</tr>
				<tr>
				<td style="background-color: rgb(208,227,248);">
				操  作  者：
				</td>
					<td>
					<input type="text" name=""/>
				</td>
				<td style="background-color: rgb(208,227,248);">
					<input type="checkbox" name=""/>包含受理信息
				</td>
				<td style="background-color: rgb(208,227,248);">
					<input type="button" value="查询"  onclick="searchform()"/>
					<input type="button" value="打印体检信息"/>
				</td>
			</tr>
		</table>
		</form>
	</body>
</html>
