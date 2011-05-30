<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bookedExamPreasgin=basePath+"/booked/ExamPreasign";
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
  



  </head>
  
  <body>
  
  
   <div style=" width:100%;padding-left: 200px">
<br>

<form id="formDate" action="<%=bookedExamPreasgin %>/to/index.action" method="post">
<span>
查看日期&nbsp;&nbsp;&nbsp;&nbsp;<input id="inputDate"   name="inputDate"  
  class="<%=EasyUiModel.DateBox.CLASS %>"
>
  <a  class="<%=EasyUiModel.LinkButton.CLASS %>"
    <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>
    onclick="document.getElementById('formDate').submit();"
>查看</a>
</span>


</form>


(输入想预约的日期，并点击查看按钮，查看相应的排班，然后根据排班分配给本驾校
<br>
的预约数量点击进入到预约界面，在预约界面输入身份证明号码，并点击预约，预约的结果可在1-2个工作日在预约反馈中查看)
<br>
<br>
</div>
<table id="Table1" class="editTable" cellspacing="0" cellpadding="4"  >
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
	   &nbsp;<s:property value="#request['weekRecord.IWeek'+#dw.value+'Km'+#km.value+'Num']" />
	 </td>
	 <td style="width: 14%">
	   &nbsp;<s:property value="#request['weekRecord.IWeek'+#dw.value+'Km'+#km.value+'Fp']" />
	   </br><a href="<%=bookedExamPreasgin %>/to/preasign.action?Id=${weekRecord.id}">预约</a>
	 </td>
	</s:iterator>

</tr>
</s:iterator>
</tbody>
</table>
  </body>
</html>
