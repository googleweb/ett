<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
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
		try{
		   var CIdcard1=$("#CIdcard1").val()||"";
		   var CIdcardtype1=$("#CIdcardtype1 option:selected").val()||"";
		   var CDabh1=$("#CDabh1").val()||"";
		   //$("#CIdcardtype1 option[vaule='士兵证']").attr("selected","selected");  
		   //$("#CIdcardtype1").combobox("setValue","士兵证");
  			$.getJSON("<%=basePath%>/physical/HospitalMessage/do/search.action",
  				{CIdcard1:CIdcard1
  				//,CIdcardtype1:CIdcardtype1
  				,CDabh1:CDabh1
  				},
  				function(result){
              		for(var key in result){
              						$("#"+key).val(result[key]);
              		}
              		alert(result['CBsl']);
              		$("#CBsl").combobox("setValue",result['CBsl']);
              		$("#CTl").combobox("setValue",result['CTl']);
              		$("#CSz").combobox("setValue",result['CSz']);
              		$("#CZxz").combobox("setValue",result['CZxz']);
              		$("#CYxz").combobox("setValue",result['CYxz']);
              		$("#CQgjb").combobox("setValue",result['CQgjb']);
  		});
       }catch(ex){alert(ex);}
	});
});
function addform(){
	alert('11');
	$("#addfrom").form("submit",{
			url:"<%=basePath%>physical/HospitalMessage/do/add.action",
	   	success:function(str){
	   				
	  	}	
	});
}
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
									<select name="" id="CIdcardtype1" class="<%=EasyUiModel.ComboBox.CLASS %>" >
											<option value="军官证">军官证</option>
											<option value="士兵证">士兵证</option>
											<option value="军官离退休证">军官离退休证</option>
											<option value="境外人员身份证明">境外人员身份证明</option>
											<option value="外交人员身份证明">外交人员身份证明</option>
											<option value="居民身份证" selected="selected">居民身份证</option>
									</select>
								</td>
								<td style="background-color: rgb(208,227,248);">
									证件号码
								</td>
								<td>
									<input type="text" name="" id="CIdcard1"/>
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									档案编号
								</td>
								<td>
									<input type="text" name="" id="CDabh1"/>
								</td>
								<td style="background-color: rgb(208,227,248);">
									业务类型：
								</td>
								<td>
									<select name="" id="">
											<option value="A">年度检查</option>
											<option value="B">初学</option>
											<option value="C">增驾</option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align: right;" >
									<%--<input type="button" value="提交" id="commit">
								--%>
								<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>  id="commit" >提交</a>
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
				<form method="post"  id="addform">
				<tr>
					<td> 
					
						<table style="width: 100%" class="" cellspacing="1">

							<tr>
								<td style="background-color: rgb(208,227,248);">
									证件名称：
								</td>
								<td>
									<input type="text" name="CIdcardtype"   id="CIdcardtype" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									证件号码
								</td>
								<td>
									
									<input type="text" name="CIdcard" id="CIdcard" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									档案编号
								</td>
								<td>
									
									<input type="text" name="CDabh"  id="CDabh" />
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
									
									<input type="text" name="CXm"  id="CXm" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									性别
								</td>
								<td>
									
									<input type="text" name="CSex"  id="CSex" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									出生日期
								</td>
								<td>
									
									<input type="text" name="CBirthday"  id="CBirthday" />
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									国籍
								</td>
								<td>
									<input type="text" name="CNation"  id="CNation" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									准驾车型
								</td>
								<td>
									<input type="text" name="CCarType"  id="CCarType" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									体检日期
								</td>
								<td>
									
									<input type="text" name="Regdate"  id="Regdate" />
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									登记住处
								</td>
								<td colspan="2">
									<input type="text" name="CRegarea"  id="CRegarea" />
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									邮政编码
								</td>
								<td>
									<input type="text" name="CPostcode"  id="CPostcode" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									联系电话
								</td>
								<td>
								<input type="text" name="CPhone"  id="CPhone" />
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
									<input type="text" name="CHeight"  id="CHeight" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									视力
								</td>
								<td style="background-color: rgb(208,227,248);">
									左
									<input type="text" name="CZsl"  id="CZsl" />
									右
									<input type="text" name="CYsl"  id="CYsl" />
								</td>
								<td style="background-color: rgb(208,227,248);">
									辨色力
								</td>
								<td>
									<select name="CBsl" id="CBsl">
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
									<select name="CTl" id="CTl">
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
									<select name="CSz" id="CSz">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合 格
										</option>

									</select>
								</td>
								<td style="background-color: rgb(208,227,248);">
									左下肢
								</td>
								<td>
									<select name="CZxz" id="CZxz">
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
									<select name="CYxz" id="CYxz">
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
									<select name="" id="CQgjb">
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
									体检医院
								</td>
								<td colspan="4">
									<input type="text" name="CHospital"  id="CHospital" />
								</td>
							</tr>
							<tr>
								<td colspan="8" style="text-align: right">
									
									<%--<input type="button" name="" value="保存" />
									
									<input type="button" name="" value="打印回执单" />
								--%>
								<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>  onclick="addform()">提交</a>
								<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>>打印回执单</a>
								</td>
							</tr>
							
						</table>
						
					</td>
					
				</tr>
				</form>
			</table>
			
		</div>
	</body>
</html>
