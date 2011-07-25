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
	$("#CRegareaCode").kiaCombogrid({
				    required:true,
				    url:"http://localhost:8080/webapp/physical/HospitalMessage/combobox/lxdz.action",
				    textField:"CDictText",
				    valueField:"CDictValue"
	});
	$("#commit").click(function(){
		try{
		   $("#searchform").form("validate");
		   var CIdcard1=$("#CIdcard1").val()||"";
		   var CIdcardtype1=$("#CIdcardtype1 option:selected").val()||"";
		   var CDabh1=$("#CDabh1").val()||"";
		   if(CIdcard1.length>0||CDabh1.length>0){
  			$("#searchform").form("submit",{
         		url:"<%=basePath%>/physical/HospitalMessage/do/searchimport.action",
	    		success:function(result1){ 
         			$.messager.progress("close");
         			var result=Kia.util.strToJson(result1); 
         			//alert(result['CIdcard']);
	   				if(result['CIdcard'].length<=0){
  						$.messager.alert('操作提示','没有符合条件的查询结果');
  					}
              		for(var key in result){
              						$("#"+key).val(result[key]);
              		}
              		$("#CIdcardtype").combobox("setValue",result['CIdcardtype']);
              		$("#CRegareaCode").combobox("setValue",result['CRegareaCode']);
              		$("#CNation").combobox("setValue",result['CNation']);
              		$("#CSex").combobox("setValue",result['CSex']);
              		$("#CCarType").combobox("setValue",result['CCarType']);
              		$("#Regdate").datebox("setValue",result['Regdate']);
              		$("#CBirthday").datebox("setValue",result['CBirthday']);
              		$("#CHospital").combobox("setValue",result['CHospital']);
	   			}
			});
  		  }else{
  			  $.messager.alert('操作提示','请输入查询条件');
  		  }
       }catch(ex){alert(ex);}
	});
});
function addform(){
	$("#addform").form("submit",{
			url:"<%=basePath%>physical/HospitalMessage/do/addimport.action",
	   	success:function(str){
				str.messager(str);
				$.messager.progress("close");
				$(":input").val("");
	  	}	
	});
}
</script>
	</head>
	<body>
		<div style="width: height :">
		
			<table style="width: 100%" class="editTable">
			
				<tr>
					<td>
						体检录入
					</td>
				</tr>
				<tr>
					<td>
					<form id="searchform" method="post" >
						<table  style="width: 100%" class="editTable">
							<tr>
								<td >
									证件名称：
								</td>
								<td>
									<input name="CIdcardtype1" type="text"  value=""
                     					class="<%=EasyUiModel.ComboBox.CLASS %>"
				    
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/sfzm.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %> />
								</td>
								<td >
									证件号码
								</td>
								<td>
									<input type="text" name="CIdcard1" id="CIdcard1"/>
								</td>
							</tr>
							<tr>
								<td >
									档案编号
								</td>
								<td>
									<input type="text" name="CDabh1" id="CDabh1"/>
								</td>
								<td >
									业务类型：
								</td>
								<td>
									<select name="" id="">
											<option value="A">年度检查</option>
											<option value="B">初学</option>
											<option value="C">增驾</option>
									</select>
									<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>  id="commit" >提交</a>
								</td>
							</tr>
							
							
						</table>
						</form>
					</td>
				
				</tr>
				</form>
				<tr>
					<td>
						体检详细信息
					</td>

				</tr>
				<form method="post"  id="addform">
				<tr>
					<td> 
					
						<table style="width: 100%"  cellspacing="1" class="editTable">

							<tr>
								<td >
									证件名称：
								</td>
								<td>
									<input type="hidden" name="Id" id="Id">
									<input type="text" name="CIdcardtype"   id="CIdcardtype" 
									class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/sfzm.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("证件名称必须输入 ") %>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
									/>
								</td>
								<td >
									证件号码
								</td>
								<td>
									
									<input type="text" name="CIdcard" id="CIdcard" 
									 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("证件号码必须输入") %>
                  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>/>
								</td>
								<td >
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
								<td >
									姓名
								</td>
								<td>
									
									<input type="text" name="CXm"  id="CXm" 
									 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("姓名必须输入") %>
                  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>/>
								</td>
								<td >
									性别
								</td>
								<td>
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
								<td >
									出生日期
								</td>
								<td>
									
									<input type="text" 
										   name="CBirthday"  
										   id="CBirthday" 
										   class="<%=EasyUiModel.DateBox.CLASS%>" 
										    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
									 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("体检日期必须输入") %>  
										   />
								</td>
							</tr>
							<tr>
								<td     >
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
								<td     >
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
								<td     >
									体检日期
								</td>
								<td>
									
									<input type="text" 
										   name="Regdate"  
										   id="Regdate" 
										   class="<%=EasyUiModel.DateBox.CLASS%>" 
										    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
									 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("体检日期必须输入") %>  
										   />
								</td>
							</tr>
							<tr>
								<td>
									登记住处
								</td>
								
								<td colspan="6">
									<input name="CRegareaCode" type="text"  id="CRegareaCode" />  
				     <input type="text" name="CRegarea" id="CRegarea" 
				      class="<%=EasyUiModel.ValidateBox.CLASS %>"
							<%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                 			<%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("姓名必须输入！ ") %>/>
								</td>
							</tr>
							<tr>
								<td>
									邮政编码
								</td>
								<td>
									<input type="text" name="CPostcode"  id="CPostcode" />
								</td>
								<td     >
									联系电话
								</td>
								
								<td>
								<input type="text" name="CPhone"  id="CPhone" />
								</td>
								<td colspan="3">
								&nbsp;
								</td>
							</tr>
							
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table style="width:100% " class="editTable">
							<tr>
								<td     >
									身高(cm)
								</td>
								<td>
									<input type="text" name="CHeight"  id="CHeight" />
								</td>
								<td     >
									视力
								</td>
								<td     >
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
								<td     >
									辨色力
								</td>
								<td>
									<select  name="CBsl" id="CBsl">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合格
										</option>
									</select>
								</td>
								<td     >
									听力
								</td>
								<td>
									<select name="CTl" id="CTl">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合格
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td     >
									上肢
								</td>
								<td>
									<select name="CSz" id="CSz">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合格
										</option>

									</select>
								</td>
								<td     >
									左下肢
								</td>
								<td>
									<select name="CZxz" id="CZxz">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合格
										</option>

									</select>
								</td>
								<td     >
									右下肢
								</td>
								<td>
									<select name="CYxz" id="CYxz">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合格
										</option>

									</select>
								</td>
								<td     >
									躯干颈部
								</td>
								<td>
									<select name="" id="CQgjb">
										<option value="1">
											合格
										</option>
										<option value="0">
											不合格
										</option>

									</select>
								</td>
							</tr>

							<tr class="">
								<td     >
									体检医院
								</td>
								<td colspan="7">
									<%--<input type="text" name="CHospital"  id="CHospital" />
								--%>
								<input name="CHospital"  id="CHospital"  
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				      <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("体检医院必须输入  ") %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/hospital.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>/>			
								</td>
							</tr>
							<tr>
								<td colspan="8" style="text-align: right">				
									<%--<input type="button" name="" value="保存" />									
									<input type="button" name="" value="打印回执单" />
								--%>
								<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_ADD) %>  onclick="addform()">提交</a>
								<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_PRINT) %>>打印回执单</a>
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
