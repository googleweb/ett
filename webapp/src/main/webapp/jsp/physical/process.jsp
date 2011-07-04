<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.model.*" %>
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
		   $("#CIdcardtype1 option[vaule='士兵证']").attr("selected","selected");  
  			$.getJSON("<%=basePath%>/physical/HospitalMessage/do/search.action",
  				{CIdcard1:CIdcard1
  				//,CIdcardtype1:CIdcardtype1
  				,CDabh1:CDabh1
  				},
  				function(result){
              		for(var key in result){
              						$("#"+key).val(result[key]);
              		}
              		$("#CNation").combobox("setValue",result['CNation']);
              		$("#CSex").combobox("setValue",result['CSex']);
              		$("#CCarType").combobox("setValue",result['CCarType']);
              		$("#Regdate").datebox("setValue",result['Regdate']);
              		$("#CBirthday").datebox("setValue",result['CBirthday']);
              		
  		});
       }catch(ex){alert(ex);}
	});
});
function addform(){
	$("#addform").form("submit",{
	  	url:'<%=basePath%>'+"physical/HospitalMessage/do/add.action",
	   	success:function(str){
	  	}
	});
}
</script>
	</head>
	<body>
		<div style="width: height :">
			<table style="width: 100%" >
				<tr>
					<td style="background-color: rgb(208,227,248);">
						体检录入
					</td>
				</tr>

				<tr>
					<td>
						<form id="searchform" method="post">
						<table style="width: 100%">
							<tr>
								<td style="background-color: rgb(208,227,248);">
									证件名称：
								</td>
								<td>
									<%--<select  id="CIdcardtype1">
											<option value="C">军官证</option>
											<option value="D">士兵证</option>
											<option value="E">军官离退休证</option>
											<option value="F">境外人员身份证明</option>
											<option value="G">外交人员身份证明</option>
											<option value="A">居民身份证</option>
									</select>
								--%>
								
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
									
									<input type="text" value="4404">
									<input type="text" name="" id="CDabh1"/>
								</td>
								<td style="background-color: rgb(208,227,248);">
									业务类型：
								</td>
								<td>
									
									<select name="CCarType"  >
											<option value="A">年度检查</option>
											<option value="B">初学</option>
											<option value="C">增驾</option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="text-align: right;" >
									<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %> id="commit">提交</a>
								</td>
							</tr>

						</table>
						</form>
					</td>
				</tr>
				<tr>
					<td style="background-color: rgb(208,227,248);">
						体检详细信息
					</td>

				</tr>
				<tr>
					<td>
					<form id="addform" method="post">
						<table style="width: 100%" class="" cellspacing="1">

							<tr>
								<td style="background-color: rgb(208,227,248);">
									证件名称：
								</td>
								<td>
									<input type="hidden" name="Id" id="Id">
									<input type="text" name="CIdcardtype"  id="CIdcardtype"
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
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("证件号码必须输入 ") %>
                  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
									/>
								</td>
								<td style="background-color: rgb(208,227,248);">
									档案编号
								</td>
								<td>
									
									<input type="text" name="CDabh" id="CDabh"
									 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("档案编号必须输入") %>
                  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
									/>
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
									
									<input type="text" name="CXm" id="CXm"
									 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("姓名必须输入！ ") %>
                  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
									/>
								</td>
								<td style="background-color: rgb(208,227,248);">
									性别
								</td>
								<td>
									
									<%--<input type="text" name="CSex" id="CSex"/>
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
									
									<input type="text" name="CBirthday"  id="CBirthday"
									 class="<%=EasyUiModel.DateBox.CLASS%>"
									  <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("出生日期必须输入") %>     
									/>
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									国籍
								</td>
								<td>
									
									<%--<input type="text" name="CNation" id="CNation"/>
								--%>
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
									
									<input type="text" name="Regdate"  id="Regdate"
									class="<%=EasyUiModel.DateBox.CLASS%>"
									 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("体检日期必须输入") %>  
									/>
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									登记住处
								</td>
								<td colspan="2">
									<input name="CRegareaCode" type="text"  id="CRegareaCode"
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/djzs.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %> />   <input type="text" name="CRegarea" id="CRegarea">
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									邮政编码
								</td>
								<td>
									<input type="text" name="CPostcode" id="CPostcode">
								</td>
								<td style="background-color: rgb(208,227,248);">
									联系电话
								</td>
								<td>
									<input type="text" name="CPhone" id="CPhone">
								</td>
							</tr>
							<tr>
								<td style="background-color: rgb(208,227,248);">
									备注
								</td>
								<td>
									<input type="text" name="">
								</td>
								<td  style="text-align: right" colspan="10">
								<%--<input type="button" value="提交"  onclick="addform()" />
								--%>
									<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>  onclick="addform()">提交</a>
								</td>
							</tr>
						</table>
					</form>	
					</td>
				</tr>
				<tr>
								<td colspan="8" style="text-align: right">
									
										<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>>打印</a>
									
										<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>>退办</a>
								</td>
				</tr>
			</table>
		</div>
	</body>
</html>
