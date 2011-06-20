<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.model.*" %>
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
	border-width: 1px;
	border-color: rgb(208,227,248);
}

td {
	
	border-width: 1px;
}
</style>
		<script type="text/javascript">
function searchform(){
	$("#searchform").form("submit",{
	  	url:'<%=basePath%>'+"physical/HospitalMessage/do/add.action",
	   	success:function(str){
		  		alert(str);
	   			}
	
	});
}
</script>
	</head>
	<body>
		<div style="width: height :">
			<table style="width: 100%" border="1">
				<tr>
					<td style="background-color: rgb(208,227,248);">
						体检录入
					</td>
				</tr>

				<tr>
					<td>
						<table style="width: 100%">
							<tr>
								<td style="background-color: rgb(208,227,248);">
									证件名称：
								</td>
								<td>
									&nbsp;
									<input type="text" name="" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									证件号码
								</td>
								<td>
									&nbsp;
									<input type="text" name="" />
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									档案编号
								</td>
								<td>
									&nbsp;
									<input type="text" value="4404">
									<input type="text" name="" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									业务类型：
								</td>
								<td>
									&nbsp;
									<input type="text" name="" />
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align: right;" >
									<input type="button" value="提交">
								</td>
							</tr>

						</table>
					</td>
				</tr>
				<tr>
					<td style="background-color: rgb(208,227,248);">
						体检详细信息
					</td>

				</tr>
				<tr>
					<td>
					<form id="searchform" method="post">
						<table style="width: 100%" class="" cellspacing="1">

							<tr>
								<td style="background-color: rgb(208,227,248);">
									证件名称：
								</td>
								<td>
									&nbsp;
									<input type="text" name="CIdcardtype" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									证件号码
								</td>
								<td>
									&nbsp;
									<input type="text" name="CIdcard" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									档案编号
								</td>
								<td>
									&nbsp;
									<input type="text" name="CDabh" />
								</td>
								<td rowspan="4" style="border-bottom: none">
									<img id="imgPerson" src=""
										style="border-width: 1px; border-style: Solid; height: 160px; width: 133px;" />
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									姓名
								</td>
								<td>
									&nbsp;
									<input type="text" name="CXm" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									性别
								</td>
								<td>
									&nbsp;
									<input type="text" name="CSex" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									出生日期
								</td>
								<td>
									&nbsp;
									<input type="text" name="CBirthday" 
									 class="<%=EasyUiModel.ValidateBox.CLASS%>"    
									/>
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									国籍
								</td>
								<td>
									&nbsp;
									<input type="text" name="CNation" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									准驾车型
								</td>
								<td>
									&nbsp;
									<input type="text" name="" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									体检日期
								</td>
								<td>
									&nbsp;
									<input type="text" name="Checkdate" 
									class="<%=EasyUiModel.ValidateBox.CLASS%>"   
									/>
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									登记住处
								</td>
								<td colspan="2">
									<input type="text" name="">    <input type="text" name="CRegareaCode">
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									邮政编码
								</td>
								<td>
									<input type="text" name="CPostcode">
								</td>
								<td style="background-color: rgb(208,227,248);">
									联系电话
								</td>
								<td>
									<input type="text" name="CPhone">
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									备注
								</td>
								<td>
									<input type="text" name="">
								</td>
								<td>
								<input type="button" value="提交"  onclick="searchform()" />
								</td>
							</tr>
						</table>
					</form>	
					</td>
				</tr>
				<tr>
								<td colspan="8" style="text-align: right">
									&nbsp;
									<input type="button" name="" value="打印" />
									&nbsp;
									<input type="button" name="" value="退办" />
								</td>
					
				</tr>

			</table>
		</div>
	</body>
</html>
