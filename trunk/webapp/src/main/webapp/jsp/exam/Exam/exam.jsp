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
    
    <title>My JSP 'exam.jsp' starting page</title>
    
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
   
  </head>
  
  <script type="text/javascript">
  function beginexam(){
   	  var qIDCard=$("#idcard").val()||"";
     if(qIDCard==""){
       $.messager.alert("","身份证不能为空","error");
     }else{
       $.post("<%=basePath%>exam/Exam/check/idcard.action",{idcard:qIDCard},
       function(data){
       //alert(data);
      	if(data=="0"){
      	$.messager.alert("","您的身份证信息不存在","error");
      	}
      	else{
      	var cartype=$("#cartype").combobox("getValue")||"";
      	//alert(cartype);
      	if(cartype==""){
      	$.messager.alert("","车类型不能为空","error");
      	}
      	else{
      	document.getElementById("exam").submit();
      	//$.post("<%=basePath%>exam/Exam/to/topic.action",{cartype:cartype}
      	//);
      	}
      	}
       }
       );
     }
  
  }
  </script>
  
  <body>
  <form id="exam" action="<%=basePath%>exam/Exam/to/topic.action">
  <table cellspacing="0" cellpadding="0" style="width:100%;table-layout:auto;" class="editTable">
  <tr> 
  <td >请输入您的身份证号码：
  <input  type="text" name="IDcardNo" id="idcard"
  	class="easyui-validatebox" type="text" required="true"></td>
  </tr>
  <tr>
   <td>请输入驾照类型：
   <input name="cartype" id="cartype" type="text"  
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(basePath+"preinput/List/combobox/cartype.action") %>
				    <%=EasyUiModel.ComboBox.Properties.EDITABLE(false)%>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictValue.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  />
   </td>
  </tr>
  <tr>
  <td><a class="easyui-linkbutton" onclick="beginexam()" iconCls="icon-redo">开始考试</a>
  </td>
  </tr>
  </table>
  </form>
   
  </body>
</html>
