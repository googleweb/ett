<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.ett.drv.model.admin.DictModel" %>
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
  			$.getJSON("<%=basePath%>/physical/HospitalMessage/do/search.action",
  				{CIdcard1:CIdcard1
  				//,CIdcardtype1:CIdcardtype1
  				,CDabh1:CDabh1
  				},
  				function(result){
              		for(var key in result){
              						$("#"+key).val(result[key]);
              		}
              		$("#CBsl").val(result['CBsl']);
              		$("#CTl").val(result['CTl']);
              		$("#CSz").val(result['CSz']);
              		$("#CZxz").val(result['CZxz']);
              		$("#CYxz").val(result['CYxz']);
              		$("#CQgjb").val(result['CQgjb']);
              		//$("#CCarType").val(result['CCarType']);
              		//$("#CSex").val(result['CSex']);
              		
              		$("#CNation").combobox("setValue",result['CNation']);
              		$("#CSex").combobox("setValue",result['CSex']);
              		$("#CCarType").combobox("setValue",result['CCarType']);
              		$("#CHospital").combobox("setValue",result['CHospital']);
              		
              		
              		$("#Regdate").datebox("setValue",result['Regdate']);
              		$("#CBirthday").datebox("setValue",result['CBirthday']);
  		});
       }catch(ex){alert(ex);}
	});
});
function addform(){
	$("#addform").form("submit",{
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
									<input name="" type="text"  value=""
                     					class="<%=EasyUiModel.ComboBox.CLASS %>"
				    					
				    					<%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/sfzm.action") %>
				    					<%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				   						 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				   						 <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %> />
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
									<input type="hidden" name="Id" id="Id">
									<input type="text" name="CIdcardtype"   id="CIdcardtype" 
									 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("证件名称必须输入") %>
                  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
									/>
								</td>
								<td style="background-color: rgb(208,227,248);">
									证件号码
								</td>
								<td>
									
									<input type="text" name="CIdcard" id="CIdcard" 
									 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("证件号码必须输入") %>
                  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>/>
								</td>
								<td style="background-color: rgb(208,227,248);">
									档案编号
								</td>
								<td>
									
									<input type="text" name="CDabh"  id="CDabh" 
									 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("档案编号必须输入") %>
                  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>/>
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
									
									<input type="text" name="CXm"  id="CXm" 
									 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("姓名必须输入") %>
                  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>/>
								</td>
								<td style="background-color: rgb(208,227,248);">
									性别
								</td>
								<td>
									
									<%--<input type="text" name="CSex"  id="CSex" />
								--%>
									<input name="CSex" type="text"  id="CSex" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/xb.action") %>
				   <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("性别必须输入 ！ ") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
								</td>
								<td style="background-color: rgb(208,227,248);">
									出生日期
								</td>
								<td>
									
									<input type="text" 
										   name="CBirthday"  
										   id="CBirthday" 
										   class="<%=EasyUiModel.DateBox.CLASS%>" />
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									国籍
								</td>
								<td>
									<input name="CNation" type="text" id="CNation"
                     						class="<%=EasyUiModel.ComboBox.CLASS %>"
				   							 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				  							  <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/gj.action") %>
				  							   <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("国籍输入") %>
				    							<%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				   								 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    							<%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %> />
								</td>
								<td style="background-color: rgb(208,227,248);">
									准驾车型
								</td>
								<td>
									<%--<input type="text" name="CCarType"  id="CCarType" />
								--%>
									<input name="CCarType"  id="CCarType" type="text"   
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/cartype.action") %>
				     <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("准驾车型必须输入 ") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %> />
								</td>
								<td style="background-color: rgb(208,227,248);">
									体检日期
								</td>
								<td>
									
									<input type="text" 
										   name="Regdate"  
										   id="Regdate" 
										   class="<%=EasyUiModel.DateBox.CLASS%>" />
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
									<input type="text" name="CZsl"  id="CZsl"  class="<%=EasyUiModel.NumberSpinner.CLASS%>" 
																							  <%=EasyUiModel.NumberBox.Properties.PRECISION(1) %>
																							  <%=EasyUiModel.Spinner.Properties.INCREMENT(0.1) %>
																							  <%=EasyUiModel.NumberBox.Properties.MIN(0) %>/>
									右
									<input type="text" name="CYsl"  id="CYsl" class="<%=EasyUiModel.NumberSpinner.CLASS%>" 
																							  <%=EasyUiModel.NumberBox.Properties.PRECISION(1) %>
																							  <%=EasyUiModel.Spinner.Properties.INCREMENT(0.1) %>
																							  <%=EasyUiModel.NumberBox.Properties.MIN(0) %>/>
								</td>
								<td style="background-color: rgb(208,227,248);">
									辨色力
								</td>
								<td>
									<select  name="CBsl" id="CBsl">
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
									<%--<input type="text" name="CHospital"  id="CHospital" />
								--%>
								<input name="CHospital"  id="CHospital"  
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				      <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("体检医院必须输入  ") %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/hospital.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
								
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
