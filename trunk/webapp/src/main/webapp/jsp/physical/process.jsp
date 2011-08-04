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
	String excelTemplatePath=basePath+"js/print/excel.physical.xls";
	String excelTemplatePathother=basePath+"js/print/excel.physical.other.xls";
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
		<script type="text/javascript" src="<%=basePath+"js/print/excel.physical.js" %>"></script>
		<script type="text/javascript" src="<%=basePath+"js/print/excel.physical.other.js" %>"></script>
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
         		url:"<%=basePath%>/physical/HospitalMessage/do/search.action",
	    		success:function(result1){ 
         			$.messager.progress("close");
         			var result=Kia.util.strToJson(result1); 
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
              		//$(".easyui-combobox").combobox()
              		
              		
              		//设置驾驶人照片
              		 var CIdcard=result['CIdcard'];
              		 var CIdcardtype=result['CIdcardtype'];
              		 var url="<%=basePath%>physical/HospitalMessage/get/photo.action";
              		 url+="?CIdcard="+CIdcard;
              		 url+="&CIdcardtype="+CIdcardtype;
		   			// $("#imgPerson").attr("src",url);
	   			}
			});
  			}else{
  				$.messager.alert('操作提示','请输入查询条件');
  			}
       	}
		catch(ex){alert(ex);}
	});
});
function addform(){
	$("#addform").form("submit",{
	  	url:'<%=basePath%>'+"physical/HospitalMessage/do/add.action",
	   	success:function(str){
	  		str.messager();
	  		$.messager.progress("close");
	  		$(":input").val("");
	  		
	  	}
	});
}
function cancel(){
	var CIdcard=$("#CIdcard").val()||"";
	var Id=$("#Id").val()||"";
	if(CIdcard.length==""){
		$.messager.alert('操作提示','请输入要退办的详细信息');		
	}else{
		var url="<%=basePath%>/physical/HospitalMessage/do/cancel.action?Id="+Id ;
		var timstamp = (new Date()).valueOf();   
   		if (url.indexOf("?") >= 0) {   
        	url= url+"&t="+timstamp;   
    	}else {   
         url=url+"?t="+timstamp;   
    	}   
		$.ajax({	
            url:url,             
            success:function(str){
	  			str.messager();
            }
        });
	}
}
function printMessage(){
	var excelTemplatePath="<%=basePath%>js/print/excel.physical.xls";
	var Id=$("#Id").val()||"";
	if(Id.length==""){
		$.messager.alert('操作提示','请输入要打印的详细信息');
	}	
	else{
		var url="<%=basePath%>/physical/HospitalMessage/do/print.action?Id="+Id ;
		var timstamp = (new Date()).valueOf();  
		if (url.indexOf("?") >= 0) {   
        	url=url+"&t="+timstamp;   
    	}else {   
         url=url+"?t="+timstamp;   
    	}   
		$.ajax({		
            url:url,  
			success:function(str){
				var json=str.toJson();
				printExcel(excelTemplatePath,json);
			}
		});
	}	
}
function printMessageother(){
	
	var excelTemplatePathother="<%=basePath%>js/print/excel.physical.other.xls";
	var Id=$("#Id").val()||"";
	
	if(Id.length==""){
		$.messager.alert('操作提示','请输入要打印的详细信息');
	}	
	else{
		var url="<%=basePath%>/physical/HospitalMessage/do/print.action?Id="+Id ;
		var timstamp = (new Date()).valueOf();  
		if (url.indexOf("?") >= 0) {   
        	url = url + "&t=" + timstamp;   
    	}else {   
         url = url + "?t=" + timstamp;   
    	}   
		$.ajax({		
            url:url,  
			success:function(str){
				var json=str.toJson();
				//alert(json['CIdcardtype']);
				//alert(json);
				printExcelother(excelTemplatePathother,json);
			}
		});
	}	
}
function uploadPhotos(){
   
}
</script>
	</head>
	<body>
		<div   <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_CENTER) %> >
			<table style="width: 100%" class="editTable">
				<tr>
					<td height="1%">
						体检录入
					</td>
				</tr>
				<tr>
					<td>
						<form id="searchform" method="post" >
						<table style="width: 100%" class="editTable">
							<tr>
								<td>
									证件名称：
								</td>
								<td>
							<input name="CIdcardtype1" type="text"  value=""
                     					class="<%=EasyUiModel.ComboBox.CLASS %>"    					
				    					<%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/sfzm.action") %>
				    					<%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				   						 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				   						 <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %> 
				   						
				   						 />
								</td>
								<td>
									证件号码
								</td>
								<td>
									<input type="text" name="CIdcard1" id="CIdcard1"	
									/>
								</td>
							</tr>
							<tr>
								<td >
									档案编号
								</td>
								<td>
									
									<%--<input type="text" value="${authUser.departmentModel.CParentcode}">
									--%><input type="text" name="CDabh1" id="CDabh1"
									class="<%=EasyUiModel.ValidateBox.CLASS %>"
									/>
								</td>
								<td     >
									业务类型：
								</td>
								<td>
									
									<select name="CCarType"  >
											<option value="A">年度检查</option>
											<option value="B">初学</option>
											<option value="C">增驾</option>
									</select>
								

									<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %> id="commit">提交</a>
								</td>
							</tr>
						</table>
						</form>
					</td>
				</tr>
				<tr>
					<td     >
						体检详细信息
					</td>
				</tr>
				<tr>
					<td>
					<form id="addform" method="post">
						<table style="width: 100%" class="editTable" >
							<tr>
								<td     >
									证件名称：
								</td>
								<td>
									<input type="hidden" name="Id" id="Id">
									<input type="text" name="CIdcardtype"  id="CIdcardtype"
									class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/sfzm.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("证件名称必须输入 ") %>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
									/>
								</td>
								<td     >
									证件号码
								</td>
								<td>
									<input type="text" name="CIdcard" id="CIdcard"
									 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("证件号码必须输入 ") %>
                  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
									/>
								</td>
								<td     >
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
									<img id="imgPerson" 
										style="border-width: 1px; border-style: Solid; height: 160px; width: 133px;" />
								</td>
							</tr>
							<tr>
								<td     >
									姓名
								</td>
								<td>
									<input type="text" name="CXm" id="CXm"
									 class="<%=EasyUiModel.ValidateBox.CLASS %>"
									  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("姓名必须输入！ ") %>
                 
									/>
								</td>
								<td     >
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
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>/>
								</td>
								<td     >
									出生日期
								</td>
								<td>
									
									<input type="text" name="CBirthday"  id="CBirthday"
									 class="<%=EasyUiModel.DateBox.CLASS%>"
									  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
									  <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("出生日期必须输入") %>     
									/>
								</td>
							</tr>
							<tr>
								<td     >
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
								<td     >
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
								<td     >
									体检日期
								</td>
								<td>
									
									<input type="text" name="Regdate"  id="Regdate"
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
								<td colspan="3">
									<input name="CRegareaCode" type="text"  id="CRegareaCode" />  
				     <input type="text" name="CRegarea" id="CRegarea" 
				      class="<%=EasyUiModel.ValidateBox.CLASS %>"
							<%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                 			<%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("姓名必须输入！ ") %>/>
								</td>
								<td>
								&nbsp;
								</td>
									<td>
								&nbsp;
								</td>
							</tr>
							
							<tr>
								<td     >
									邮政编码
								</td>
								<td>
									<input type="text" name="CPostcode" id="CPostcode">
								</td>
								<td     >
									联系电话
								</td>
								<td>
									<input type="text" name="CPhone" id="CPhone">
								</td>
								<td>
								&nbsp;
								</td>
									<td>
								&nbsp;
								</td>
								<td>
								&nbsp;
								</td>
								
							</tr>
							<tr>
								<td     >
									备注
								</td>
								<td>
									<input type="text" name="">
								</td>
								<td  style="text-align: right" colspan="6">
								<%--<input type="button" value="提交"  onclick="addform()" />
								--%>
									<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_ADD) %>  onclick="addform()">提交</a>
								</td>
							</tr>
						</table>
					</form>	
					</td>
				</tr>
				<tr>
								<td  style="text-align: right">								
										<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_PRINT) %> onclick="printMessageother()">打印</a>
										<a class="easyui-linkbutton"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_CANCEL)%> onclick="cancel()">退办</a>
								</td>
				</tr>
			</table>
		</div>
	</body>
</html>
