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
</style>
		<script type="text/javascript">
$(document).ready(function(){	
	$("#commit").click(function(){
		   var CIdcard1=$("#CIdcard1").val();
  			$.getJSON("<%=basePath%>/physical/HospitalMessage/do/search.action",{CIdcard1:CIdcard1},function(result){
    			$.each(result, function(i, field){
      					alert(field);
    			});
  		});
	});
});
</script>
	</head>
	<body>
		<div style="width: height :">
		
			<table style="width: 100%">
			
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
									<select name="">
											<option value="C">军官证</option>
											<option value="D">士兵证</option>
											<option value="E">军官离退休证</option>
											<option value="F">境外人员身份证明</option>
											<option value="G">外交人员身份证明</option>
											<option value="居民身份证" selected="selected">居民身份证</option>
									</select>
								</td>
								<td style="background-color: rgb(208,227,248);">
									证件号码
								</td>
								<td>
									&nbsp;
									<input type="text" name="CIdcard" id="CIdcard1"/>
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
									<select name="" id="">
											<option value="A">年度检查</option>
											<option value="B">初学</option>
											<option value="C">增驾</option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align: right;" >
									<input type="button" value="提交" id="commit">
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
									<input type="text" name="" value="${busAllInfoModel.CIdcardtype}"  />
								</td>
								<td style="background-color: rgb(208,227,248);">
									证件号码
								</td>
								<td>
									&nbsp;
									<input type="text" name="" id="CIdcard2" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									档案编号
								</td>
								<td>
									&nbsp;
									<input type="text" name="" value="${busAllInfoModel.CDabh}" />
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
									<input type="text" name="" value="${busAllInfoModel.CXm}" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									性别
								</td>
								<td>
									&nbsp;
									<input type="text" name="" value="${busAllInfoModel.CSex}" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									出生日期
								</td>
								<td>
									&nbsp;
									<input type="text" name="" value="${busAllInfoModel.CBirthday}" />
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									国籍
								</td>
								<td>
									&nbsp;
									<input type="text" name="" value="${busAllInfoModel.CNation}" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									准驾车型
								</td>
								<td>
									&nbsp;
									<input type="text" name="" value="${busAllInfoModel.CCarType}" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									体检日期
								</td>
								<td>
									&nbsp;
									<input type="text" name="" value="" />
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									登记住处
								</td>
								<td colspan="2">
									<input type="text" name="" value="${busAllInfoModel.CRegareaCode}">    <input type="text" name="" value="${busAllInfoModel.CRegarea}" >
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									邮政编码
								</td>
								<td>
									<input type="text" name="" value="${busAllInfoModel.CPostcode}" >
								</td>
								<td style="background-color: rgb(208,227,248);">
									联系电话
								</td>
								<td>
									<input type="text" name="" value="${busAllInfoModel.CPhone}" >
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
									<input name="" type="text" value="${busAllInfoModel.CHeight}" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									视力
								</td>
								<td style="background-color: rgb(208,227,248);">
									左
									<input name="" type="text" value="${busAllInfoModel.CZsl}" />
									右
									<input name="" type="text" value="${busAllInfoModel.CYsl}" />
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
									<input name="" type="text" id=""  value="" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									体检医院
								</td>
								<td colspan="4">
									<input name="" type="text" value="" value="${busAllInfoModel.CHospital}" />
								</td>
							</tr>
							<tr>
								<td colspan="8" style="text-align: right">
									&nbsp;
									<input type="button" name="" value="保存" />
									&nbsp;
									<input type="button" name="" value="打印回执单" />
								</td>
							</tr>
						</table>
					</td>
				</tr>

			</table>
		</div>
	</body>
</html>