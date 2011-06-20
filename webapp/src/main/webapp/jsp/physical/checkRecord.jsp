<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.ett.drv.model.admin.BusAllInfoModel"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
	{field:"<%=BusAllInfoModel.F.CXm%>",title:"姓名",width:150},
	{field:"<%=BusAllInfoModel.F.CBirthday%>",title:"出生日期",width:150},
	{field:"<%=BusAllInfoModel.F.CCarType%>",title:"车辆类型",width:150},
	{field:"<%=BusAllInfoModel.F.CDabh%>",title:"档案编号",width:150},
	{field:"<%=BusAllInfoModel.F.Checkdate%>",title:"审核日期",width:150},
	{field:"<%=BusAllInfoModel.F.Regdate%>",title:"受理日期",width:150 },
	{field:"<%=BusAllInfoModel.F.CHeight%>",title:"体重",width:150},
	{field:"<%=BusAllInfoModel.F.CHospital%>",title:"医院",width:150},
	{field:"<%=BusAllInfoModel.F.CIdcard%>",title:"身份证明号码",width:150},
	{field:"<%=BusAllInfoModel.F.CIdcardtype%>",title:"身份证明名称",width:150},
	{field:"<%=BusAllInfoModel.F.CLsh%>",title:"流水号",width:150},
	{field:"<%=BusAllInfoModel.F.CPhone%>",title:"联系电话",width:150},
	{field:"<%=BusAllInfoModel.F.CNation%>",title:"国籍",width:150},
	{field:"<%=BusAllInfoModel.F.COperator%>",title:"操作者",width:150},
	{field:"<%=BusAllInfoModel.F.CPostcode%>",title:"邮政编码",width:150},
	{field:"<%=BusAllInfoModel.F.CQgjb%>",title:"躯干颈部",width:150},
	{field:"<%=BusAllInfoModel.F.CRegarea%>",title:"登记住所",width:150},
	{field:"<%=BusAllInfoModel.F.CRegareaCode%>",title:"登记住所代码",width:150},
	{field:"<%=BusAllInfoModel.F.CSex%>",title:"性别",width:150},
	{field:"<%=BusAllInfoModel.F.CSz%>",title:"身高",width:150},
	{field:"<%=BusAllInfoModel.F.CTl%>",title:"听力",width:150},
	{field:"<%=BusAllInfoModel.F.CBsl%>",title:"辨色力",width:150},
	{field:"<%=BusAllInfoModel.F.CYsl%>",title:"右视力",width:150},
	{field:"<%=BusAllInfoModel.F.CYxz%>",title:"左视力",width:150},
	{field:"<%=BusAllInfoModel.F.CZsl%>",title:"左下肢",width:150},
	{field:"<%=BusAllInfoModel.F.CZxz%>",title:"右下肢",width:150}
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
	  	url:'<%=basePath%>'+"physical/HospitalMessage/do/bizsearch.action",
	   	success:function(str){
	  			var json=Kia.util.strToJson(str); 
	   			$("#test").datagrid("loadData",json); 
	   			}
	
	});
	
}		
</script>
	</head>
	<body>
	<form method="post" id="searchform">
		<table style="text-align: center ;">
			<tr>
				<td style="background-color: rgb(208,227,248);" colspan="4">
					业务流水查询
				</td>
			</tr>
			<tr>
				<td style="background-color: rgb(208,227,248);">
				证件号码：
				</td>
				<td>
					<input type="text" name="CIdcard"/>
				</td>
				<td style="background-color: rgb(208,227,248);">
				档案编号：
				</td>
				<td>
					<input type="text" name="CDabh"/>
				</td>
			</tr>
				<tr>
				<td style="background-color: rgb(208,227,248);">
				姓名：
				</td>
				<td>
					<input type="text" name="CXm"/>
				</td>
				<td style="background-color: rgb(208,227,248);">
				车型:
				</td>
				<td>
					<input type="text" name="CCarType"/>
				</td>
			</tr>
				<tr>
				<td style="background-color: rgb(208,227,248);">
				体检日期起：
				</td>
					<td>
					<input type="text" name="Regdate"
					class="<%=EasyUiModel.ValidateBox.CLASS%>"   
					/>
				</td>
				<td style="background-color: rgb(208,227,248);">
				体检日期止：
				</td>
				<td>
					<input type="text" name="Checkdate"
					class="<%=EasyUiModel.ValidateBox.CLASS%>"   
					/>
				</td>
			</tr>
				<tr>
				<td style="background-color: rgb(208,227,248);">
				操  作  者：
				</td>
					<td>
					<input type="text" name="COperator"/>
				</td>
				<td style="background-color: rgb(208,227,248);">
					<input type="checkbox" name=""/>包含受理信息
				</td>
				<td style="background-color: rgb(208,227,248);">
					<input type="button" value="查询" onclick="searchform()" />
					<input type="button" value="打印体检信息"/>
				</td>
			</tr>
		</table>
		<table id="test"></table>
		</form>
	</body>
</html>
