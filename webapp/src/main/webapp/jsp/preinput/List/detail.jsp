<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@page import="com.ett.drv.model.preinput.*"%>
<%@page import="com.ett.drv.model.admin.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <jsp:include page="/plugin/index.jsp">
      <jsp:param value="jquery,easyui" name="plugin"/>
    </jsp:include>
    <jsp:include page="/css/index.jsp"></jsp:include>
    <jsp:include page="/js/index.jsp"></jsp:include>
    <style type="text/css">
    select
    {
    width:100%;
    }
    
    
    td,th{
      padding: 0px auto 0px auto;
    }
    
    </style>
    
  
  <script type="text/javascript">
  function searcharea(){
  
  var href='<%=basePath%>'+"preinput/List/to/searcharea.action";
       //alert(href);
        $("#edit").dialog(
           {
  	 	    title:"查询区域地址:",
  	 	    width:400,
  	 	    height:200,
	//	    fit:true,
	//		onClose:function(){ $('#test').datagrid('reload'); },
	//    	modal:true,
			onOpen:function(){$(this).kiaIframe(href);}} 
		);//   end:$("#divEdit").dialog
		return false;
  }
  
  function uploadphoto(){
  var href='<%=basePath%>'+"preinput/List/upload/photo.action";
  var opts={};
  opts["muti"]=true;
  opts["inputName"]="photo";
  opts["uploadUrl"]=href;
  var div=$("<div></div>");
  div.kiaUploadForm(opts);
  div.dialog({
	  title:"上传照片:"
	  ,width:380
	  ,onClose:function(){document.location.href="<%=basePath%>preinput/List/to/detail.action";}
  });
      return false;
  }
  
  function test(){
  var f=$("#f").val();
  $.messager.confirm('操作提示','确认上传',function(yes){
  		if(yes){
  		$("#detail").form('submit',{
  		url:"<%=basePath%>preinput/List/upload/photo.action",
  		onsubmit:function(){return $(this).form("validate");},
  		success:function(str){
  		$(this).form("clear");
		str.messager();
  		}
  		
  		});
  		}
  
  });
  
  
  }
  
  function clicksave(){
   $.messager.confirm('操作提示','确认保存',function(yes){
		   if(yes){
			   $("#detail").form('submit',{
				   url:"<%=basePath%>preinput/List/do/save.action"
				   ,onSubmit:function(){ return $(this).form("validate"); }
				   ,success:function(str){
				    $(this).form("clear");
				     str.messager();
				   }
			   });
		   }
	     });
 			 
	     
   }
  </script>
  </head>
  
  <body>
  
  
<form id="detail" method="post">
<input type="hidden" name="Id" value="${id}" />
<table  cellspacing="0" cellpadding="0" style="width:100%;table-layout:auto;font-size: 0.85em;" class="editTable" >
<tbody>

<tr >
<td style="width: 120px">证件名称</td>
<td style="width: 120px">
<input name="Sfzmmc" type="text"  value="${Sfzmmc}"
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/sfzm.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
				
				  
				  
				    />
</td>
<td style="width: 120px">证件号码</td>
<td style="width: 250px">
<input type="text" name="Sfzmhm" value="${Sfzmhm}"/>
</td>
<td style="width: 100px">国籍</td>
<td style="width: 150px">
<input name="CGj" type="text"  value="${CGj}"
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/gj.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
				
				  
				  
				    />
</td>

<td colspan="2" rowspan="6">

<img width="200" height="225" src="<%=basePath%>preinput/List/stream/photo.action"  alt="审核人照片" />
<input type="button" value="上传照片" onclick="uploadphoto()"/>


</td>
</tr>
<tr >
<td >姓名</td>
<td >
<input type="text" name="CXm" value="${CXm}"/>
</td>
<td >性别</td>
<td >
<input name="IXb" type="text"  value="${IXb}" style="width:50px"
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/xb.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
<td>出生年月</td>
<td>
<input type="text" class="<%=EasyUiModel.DateBox.CLASS %>" name="CCsrq" value="${CCsrq}"/>
</td>
</tr>
<tr>
</td>
<td>登记住所</td>
<td>
<input name="CDjzsxzqh" type="text"  value="${CDjzsxzqh}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/djzs.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
<td colspan="4"><a onclick="searcharea()">查询</a><input type="text" style="width: 80%" /></td>
</tr>
<tr>
<td>联系住所</td>
<td>
<input name="CLxzsxzqh" type="text"  value="${CLxzsxzqh}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/djzs.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
<td colspan="4"><input type="text" style="width: 100%"/></td>
</tr>
<tr>

<td>邮政编码</td>
<td>
<input type="text" name="CLxzsyzbm"/ value="${CLxzsyzbm }">
</td>
<td>联系电话</td>
<td ><input type="text" name="CLxdh" value="${CLxdh }"/></td>
<td>行政区划</td>
<td >
<input name="CXzqh" type="text"  value="${CXzqh}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/djzs.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
</tr>
<tr >
<td >申请车型</td>
<td >
<input name="CZkcx" type="text"  value="${CZkcx}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/cartype.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
<td >驾驶人来源</td>
<td >
<input name="CLy" type="text"  value="${CLy}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/driverfrom.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
<td>暂住证号</td>
<td>
<input type="text" name="CZzzm" value="${CZzzm}"/>
</td>
</tr>
<tr >
<td>准考证编号</td>
<td>
<input type="text" name="CZkzmbh" value="${CZkzmbh}"/>
</td>
<td>驾校名称</td>
<td colspan="5">
<input name="CJxmc" type="text"  value="${CJxmc}" 
   class="<%=EasyUiModel.ComboBox.CLASS %>"
	<%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
	<%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/school.action") %>
	<%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
	<%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DepartmentModel.F.CDepnickname.name()) %>
	<%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DepartmentModel.F.CDepnickname.name()) %>                 
  />
</td>
</tr>
<tr >
<td>身高</td>
<td>
<input type="text" style="width: 50%" name="CSg" value="${CSg}">CM
</td>
<td>视力</td>
<td>
左
<input type="text" style="width: 50px" class="<%=EasyUiModel.NumberSpinner.CLASS%>" 
  <%=EasyUiModel.NumberBox.Properties.PRECISION(1) %>
  <%=EasyUiModel.Spinner.Properties.INCREMENT(0.1) %>
  <%=EasyUiModel.NumberBox.Properties.MIN(0) %>
name="IZsl" value="${IZsl}">
右
<input type="text" style="width: 50px" class="<%=EasyUiModel.NumberSpinner.CLASS%>" 
  <%=EasyUiModel.NumberBox.Properties.PRECISION(1) %>
  <%=EasyUiModel.Spinner.Properties.INCREMENT(0.1) %>
  <%=EasyUiModel.NumberBox.Properties.MIN(0) %> name="IYsl" value="${IYsl}">
</td>
<td>辨色力</td>
<td>
<input name="IBsl" type="text"  value="${IBsl}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/ifok.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
<td style="width: 120px">听力</td>
<td>
<input name="ITl" type="text"  value="${ITl}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/ifok.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
</tr>
<tr>
<td>
上肢
</td>
<td>
<input name="ISz" type="text"  value="${ISz}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/ifok.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
<td>
左下肢
</td>
<td>
<input name="IZxz" type="text"  value="${IZxz}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/ifok.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
<td>
右下肢
</td>
<td>
<input name="IYxz" type="text"  value="${IYxz}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/ifok.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
<td>
躯干颈部
</td>
<td>
<input name="IQgjb" type="text"  value="${IQgjb}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/ifok.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
</tr>
<tr>
<td>
体检医院
</td>
<td colspan="2">
<input name="CTjyymc" type="text"  value="${CTjyymc}" 
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/hospital.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
</td>
<td colspan="3" >
<input type="text" style="width: 80%"/>
</td>
<td  >
体检日期
</td>
<td  style="width: 120px">
<input class="<%=EasyUiModel.DateBox.CLASS %>" style="width: 100%" name="CTjrq" value="${CTjrq}"/>
</td>
</tr>
<tr>
<td style="text-align: center;" colspan="8">
<input type="button" value="保存" style="width:10%" onclick="clicksave() "/>
<input type="button" value="打印申请表" style="width:10%"/>
</td>
</tr>
</tbody>
</table>
</form>
<div id="edit"></div>
  </body>
</html>
