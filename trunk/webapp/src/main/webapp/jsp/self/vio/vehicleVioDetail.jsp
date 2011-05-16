<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>机动车违法记录详情</title>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	
		<div
			class="selfmaintophint" >
			可点击按钮查看您的违法图片
			</div>
		<div
			class="selfmaincontent">
			<table class="selftable"  border="0" cellpadding="0" cellspacing="0">
			
			<tr><td colspan="4" style="text-align:center">
			决定书编号<span style="color:red"><s:property value="vioFlowObject.jdsbh"/></span>违法信息</td></tr>
			<tr>
			<th>当事人</th>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="vioFlowObject.dsr"/>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<th>违法时间</th>
			<td><s:date name="vioFlowObject.wfsj" format="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
			<tr>
			<th>违法地点</th>
			<td><s:property value="vioFlowObject.wfdz"/></td>
			<th>罚款金额</th>
			<td><s:property value="vioFlowObject.fkje"/></td>
			</tr>
			
			<tr>
			<th>滞纳金</th>
			<td><s:property value="vioFlowObject.znj"/></td>
			<th>违法扣分值</th>
			<td><s:property value="vioFlowObject.wfkfz"/>&nbsp;</td>
			</tr>
			<tr><td><input type="button" style="width:140px" class="btnmain" value="上一张" /></td><td colspan="2">共<a style="color:red">1/10</a>张违法图片</td><td><input type="button"  style="width:140px"  class="btnmain" value="下一张" /></td></tr>
			<tr><td colspan="4">
			<img src='<s:url value="/images/car.jpg"/>' height="200px" width="500px" />
			</td></tr>
			<tr><td colspan="4"><input type="button" value="返回" onclick="javascript:history.go(-1);" class="btnmain"/></td></tr>
			
			</table>
			
		</div>
</body>

</html>