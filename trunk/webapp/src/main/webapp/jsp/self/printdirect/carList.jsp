<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>机动车受理回执凭证打印确认</title>
</head>
<body>
<body bgcolor="#FFFFFF" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	
		<div
			style="height: 72px; vertical-align:middle;text-align:center;; line-height:72px; background: url('<s:url value="/images/hint2.jpg"/>')  no-repeat center; background-repeat: no-repeat;">
			 <img style="margin-top:10px;" src="<s:url value="/images/printviewhint.jpg"/>" width="800" border="0px" height="50" alt="提示语"/>
			
			</div>
		<div
			style="text-align: center; height: 502px; background: url('<s:url value="/images/bottom3.jpg"/>')   center; ">
			<br />
			
			
			
<table width="900" border="0" cellPadding="1"  cellSpacing="1" class="selftable">  
      <tr class="selftableheader">  
     <TD align="center">序号</TD>  
        <TD align="center">流水号</TD>  
        <TD align="center">业务原因</TD>  
        <TD align="center">所有人</TD>  
        <TD align="center">号牌号码</TD>  
        <TD align="center">开始时间</TD>  
        <TD align="center">结束时间</TD> 
        <TD align="center">操作</TD> 
    </tr>  
     <s:iterator id="entity" value="lists" status="stuts">   
<tr class="<s:if test="#stuts.even==true">selftablecontentEven</s:if>">   
    <td >${stuts.count }</td>   
    <td ><s:property value="lsh"/></td>   
    <td ><s:property value="ywlx"/>
    </td>   
    <td ><s:property value="xm"/></td>   
    <td ><s:property value="hphm"/></td>   
    <td ><s:date name="yyrq" format="yyyy-MM-dd"/></td>   
     <td ><s:date name="ksrq" format="yyyy-MM-dd"/></td>
     <td >  <input type="button" style="width:200px" class="btnmain"  onclick="document.location.href='<s:url value="/self/print!carPrint.action?lsh=" /><s:property value="lsh"/>';" value="查看"/></td>  
</tr>   
</s:iterator> 
    </table>  
			
		</div>
</body>


</body>
</html>