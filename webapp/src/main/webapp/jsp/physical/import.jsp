<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
						<table style="width: 100%" class="" cellspacing="1">

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
								<td style="background-color: rgb(208,227,248);">
									档案编号
								</td>
								<td>
									&nbsp;
									<input type="text" name="" />
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
									<input type="text" name="" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									性别
								</td>
								<td>
									&nbsp;
									<input type="text" name="" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									出生日期
								</td>
								<td>
									&nbsp;
									<input type="text" name="" />
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									国籍
								</td>
								<td>
									&nbsp;
									<input type="text" name="" />
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
									<input type="text" name="" />
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									登记住处
								</td>
								<td colspan="2">
									<input type="text" name="">    <input type="text" name="">
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									邮政编码
								</td>
								<td>
									<input type="text" name="">
								</td>
								<td style="background-color: rgb(208,227,248);">
									联系电话
								</td>
								<td>
									<input type="text" name="">
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									备注
								</td>
								<td>
									<input type="text" name="">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table style="width:100% ">
							<tr>
								<td style="background-color: rgb(208,227,248);">
									身高(cm)
								</td>
								<td>
									<input name="" type="text" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									视力
								</td>
								<td style="background-color: rgb(208,227,248);">
									左
									<input name="" type="text" />
									右
									<input name="" type="text" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									辨色力
								</td>
								<td>
									<select name="" id="">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合 格
										</option>
									</select>
								</td>
								<td style="background-color: rgb(208,227,248);">
									听力
								</td>
								<td>
									<select name="" id="">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合 格
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									上肢
								</td>
								<td>
									<select name="" id="">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合 格
										</option>

									</select>
								</td>
								<td>
									左下肢
								</td>
								<td>
									<select name="" id="">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合 格
										</option>

									</select>
								</td>
								<td style="background-color: rgb(208,227,248);">
									右下肢
								</td>
								<td>
									<select name="" id="">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合 格
										</option>

									</select>
								</td>
								<td style="background-color: rgb(208,227,248);">
									躯干颈部
								</td>
								<td>
									<select name="" id="">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合 格
										</option>

									</select>
								</td>
							</tr>

							<tr class="">
								<td style="background-color: rgb(208,227,248);">
									体检日期
								</td>
								<td colspan="2">
									<input name="" type="text" id="" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									体检医院
								</td>
								<td colspan="4">
									<input name="" type="text" value="" />
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
					</td>
				</tr>

			</table>
		</div>
	</body>
</html>
