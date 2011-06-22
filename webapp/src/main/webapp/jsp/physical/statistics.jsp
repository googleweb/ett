<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.ett.drv.view.HospitalGroupView"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.drv.biz.IHospitalBiz"%>
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

<script type="text/javascript">
$(document).ready(function(){   
	$("#test").datagrid({fit:true,
	columns:[ 
	[ 
	{field:"<%=HospitalGroupView.F.Hospital%>",title:"医院名称",width:150},
	{field:"<%=HospitalGroupView.F.Sum1%>",title:"已受理未体检",width:150},
	{field:"<%=HospitalGroupView.F.Sum2%>",title:"已年度体检",width:150},
	{field:"<%=HospitalGroupView.F.Sum3%>",title:"车管所已核对",width:150},
	{field:"<%=HospitalGroupView.F.Sum4%>",title:"受理退办",width:150}
	]
	] 
	,
	pagination:true,
	url:'<%=basePath%>'+"physical/HospitalMessage/datagrid/hospital.action"
	} 
);
	
}); //$(document).ready
function searchform(){
	//$("#searchform").form("submit",{
	//  	url:'<%=basePath%>'+"physical/HospitalMessage/datagrid/busAllLog.action",
	 //  	success:function(str){
	 // 			var json=Kia.util.strToJson(str); 
	 //  			$("#test").datagrid("loadData",json); 
	   	//	}
	
	//});
	
    var beginDate=$("#beginDate").datebox("getValue");
	var endDate=$("#endDate").datebox("getValue");
	$("#test").datagrid("reload",{
	 qbeginDate:beginDate
	 ,qendDate:endDate
	});
	
	
}		
</script>
	</head>
	<body  class="<%=EasyUiModel.Layout.CLASS %>" >
	 <div    <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_NORTH) %> style="padding: 10px;overflow: hidden;">
	<form method="post" id="searchform">
		<table style="text-align: center ;width: 100%">
				<tr>
				<td style="background-color: rgb(208,227,248);">
				体检日期起：
				</td>
					<td style="text-align: left;width: 40%">
					<input type="text" name="beginDate"
					id="beginDate"
					class="<%=EasyUiModel.DateBox.CLASS%>"   
					
					/>
				</td>
				<td style="background-color: rgb(208,227,248);">
				体检日期止：
				</td>
				<td style="text-align: left;width: 40%;">
					<input type="text" name="endDate"
					id="endDate"
					class="<%=EasyUiModel.DateBox.CLASS%>"   
					style="width: 80%"
					/>
				</td>
			</tr>
				<tr>
				<td style="background-color: rgb(208,227,248);">
				 统计方式：
				</td>
				 <td style="text-align: left;">
                 	<select name="statistics_type" id=""  style="width: 40% ;">
						<option selected="selected" value="<%=IHospitalBiz.TYPE_HOSPITAL %>">按医院名称</option>
						<option value="<%=IHospitalBiz.TYPE_HOSPITAL %>">按医院用户</option>
					</select>
                </td>
				<td style="background-color: rgb(208,227,248);">
				</td>
				<td style="text-align: left;">
					<input type="button" value="统计" onclick="searchform()" />
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
