<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core-rt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>驾驶人车辆选择界面</title>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	
		<div
			class="selfmaintophint"/>
			请选择您要查看的车辆
			</div>
		<div
		class="selfmaincontent">
			<br />
			<br />
<table width="900" border="0" class="selftable" cellPadding="0" cellSpacing="0" >  
    <tr class="selftableheader" style="text-align: center">  
     <Th align="center" style="text-align: center">序号</Th>  
        <Th align="center" style="text-align: center">车辆品牌</Th>  
        <Th align="center" style="text-align: center">机动车<br/>号牌号码</Th>  
        <Th align="center" style="text-align: center">所有人</Th>  
        <Th align="center" style="text-align: center">身份证明号码</Th>  
        <Th align="center" style="text-align: center">车辆识别代号</Th>  
        <Th align="center" style="text-align: center">操作</Th> 
    </tr>  
    <s:iterator id="entity" value="lists" status="stuts">   
<tr class="<s:if test="#stuts.even==true">selftablecontentEven</s:if>">   
    <td >${stuts.count }&nbsp;</td>   
    <td ><s:property value="clpp1"/>&nbsp;</td>   
    <td ><s:property value="hphm"/>
    </td>   
    <td ><s:property value="syr"/></td>   
    <td ><s:property value="sfzmhm"/></td>   
    <td >   
 <s:property value="clsbdh"/>
    </td>   
    <td >  <input type="button" style="width:200px" class="btnmain"  onclick="document.location.href='<s:url value="/self/vio!vehicleVioList.action?xh=" /><s:property value="xh"/>';"  value="查看本车" alt="查看本车未处理的违法记录！"/></td>   
</tr>   
</s:iterator> 
    </table>  
			
		</div>
</body>

</html>