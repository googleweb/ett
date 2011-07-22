<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@page import="com.ett.drv.model.admin.UserModel"%>
<%@page import="com.ett.drv.model.admin.RoleModel"%>
<%@page import="com.ett.drv.model.admin.DepartmentModel"%>
<%@page import="com.ett.drv.web.rule.AuthUserRule"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bookedExamPreasgin=basePath+"booked/ExamPreasign";
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

  
   <script type="text/javascript">
   function printviewex()
{

var obj=document.getElementById("wb");
obj.ExecWB(7,1);

//alert('2');

}
   
     <%=JQueryModel.DOC_READY_START %>   
     // printviewex();
     <%=JQueryModel.DOC_READY_END%>
   </script>


  </head>
  
  <body>
  <object id="wb" height="0" width="0"  
      classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" name="wb">
     </object>
  <a class="<%=EasyUiModel.LinkButton.CLASS %>"
     <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_PRINT) %> 
     onclick="printviewex()"
   >打印</a>
  <br/>
<table id="Table1"  class="editTable" cellspacing="0" cellpadding="4"  >
<tbody>
<tr >
<td rowspan="2">星期\科目</td>
<td colspan="2">科目一</td>
<td colspan="2">科目二</td>
<td colspan="2">科目三</td>
</tr>
<tr >
<td>总数</td>
<td>分配</td>
<td>总数</td>
<td>分配</td>
<td>总数</td>
<td>分配</td>
</tr>



<s:iterator value="#{'一':1,'二':2,'三':3,'四':4,'五':5,'六':6,'日':7}" id="dw" >
<tr>
	<th style="width: 200px">星期<s:property value="#dw.key"/>(
	  	             <s:if test="#dw.value eq 1"><s:date name="weekRecord.monday" format="yyyy-MM-dd"/></s:if>
  	             <s:elseif test="#dw.value eq 2"><s:date name="weekRecord.tuesday" format="yyyy-MM-dd"/></s:elseif>
  	             <s:elseif test="#dw.value eq 3"><s:date name="weekRecord.wednesday" format="yyyy-MM-dd"/></s:elseif>
  	             <s:elseif test="#dw.value eq 4"><s:date name="weekRecord.thursday" format="yyyy-MM-dd"/></s:elseif>
  	             <s:elseif test="#dw.value eq 5"><s:date name="weekRecord.friday" format="yyyy-MM-dd"/></s:elseif>
  	             <s:elseif test="#dw.value eq 6"><s:date name="weekRecord.saturday" format="yyyy-MM-dd"/></s:elseif>
  	             <s:elseif test="#dw.value eq 7"><s:date name="weekRecord.sunday" format="yyyy-MM-dd"/></s:elseif>
  	             )
	</th>
	<s:iterator value="#{'一':1,'二':2,'三':3}" id="km" >
	 <td style="width: 14%">
	   &nbsp;<s:property  value="#request['weekRecord.IWeek'+#dw.value+'Km'+#km.value+'Num']" />
	 </td>
	 <td style="width: 14%" >
	   <span class="spanFp">
	   <s:property escape="false" value="#request['weekRecord.IWeek'+#dw.value+'Km'+#km.value+'Fp']" />
	   </span>
	 </td>
	</s:iterator>

</tr>
</s:iterator>
</tbody>
</table>
  </body>
</html>
