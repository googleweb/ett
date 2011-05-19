<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>机动车未处理违法记录列表</title>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	
		<div
			class="selfmaintophint" >
			您号牌<span style="color:red"><s:property value="vehicle.hphm"/></span>有未处理违法信息，请进行违法处理
			</div>
		<div
			class="selfmaincontent">
			<br />
			<input type="button"  class="btnmain" style="width:300px" onclick="document.location.href='<s:url value="/self/fee!feeTypeSelect.action?fee=allvio&xh="/><s:property value="#parameters.xh"/>';" value="违法处理"/>
			<br />: <br/>
			
			
<table width="900" border="0" cellPadding="0"  cellSpacing="0" class="selftable">  
      <tr class="selftableheader">  
     <TD align="center">序号</TD>  
        <TD align="center">决定书编号</TD>  
        <TD align="center">当事人</TD>  
        <TD align="center">违法时间</TD>  
        <TD align="center">违法地点</TD>  
        <TD align="center">罚款金额</TD>  
        <TD align="center">操作</TD> 

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
     <td ><input type="button" style="width:200px" class="btnmain"  onclick="document.location.href='<s:url value="/self/vio!vehicleVioDetail.action?jdsbh=" /><s:property value="jdsbh"/>';"  value="详情" alt="查看条详细的违法记录！"/></td> 
       
</tr>   
</s:iterator> 
    </table>  
			
		</div>
</body>

</html>