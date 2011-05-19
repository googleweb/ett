<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>机动车违法待缴费业务</title>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	
		<div
			class="selfmaincontent">
			 <img style="margin-top:10px;" src="<s:url value="/images/beginflowfeehint.jpg"/>" width="800" border="0px" height="50" alt="提示语"/>
			
			</div>
		<div
			style="text-align: center; height: 502px; background: url('<s:url value="/images/bottom3.jpg"/>')  no-repeat center; background-repeat: no-repeat;">
			<br />
			<input type="button" style="width:300px" class="btnmain"  onclick="document.location.href='<s:url value="/self/fee!feeTypeSelect.action?fee=allvio&xh="/><s:property value="#parameters.xh"/>';" value="进行处理"/>
			<br />您目前违法业务还有如下缴费的记录:<br/>
			
			
<table width="900" border="0" cellPadding="1"  cellSpacing="1" class="selftable">  
      <tr class="selftableheader">  
     <TD align="center">序号</TD>  
        <TD align="center">决定书编号</TD>  
        <TD align="center">当事人</TD>  
        <TD align="center">违法时间</TD>  
        <TD align="center">违法地点</TD>  
        <TD align="center">罚款金额</TD>  
        <TD align="center">滞纳金</TD> 
        <TD align="center">违法扣分值</TD> 
    </tr>  
     <s:iterator id="entity" value="lists" status="stuts">   
<tr class="<s:if test="#stuts.even==true">selftablecontentEven</s:if>">   
    <td >${stuts.count }</td>   
    <td ><s:property value="jdsbh"/></td>   
    <td ><s:property value="dsr"/>
    </td>   
    <td ><s:property value="wfsj"/></td>   
    <td ><s:property value="wfdz"/></td>   
    <td ><s:property value="fkje"/></td>   
     <td ><s:property value="znj"/></td> 
      <td ><s:property value="wfkfs"/></td> 
       
</tr>   
</s:iterator> 
    </table>  
			
		</div>
</body>

</html>