<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>违法回执打印凭条确认</title>
</head>
<body>
<div
		style="height: 72px; vertical-align:middle;text-align:center;; line-height:72px; background: url('<s:url value="/images/hint2.jpg"/>')  no-repeat center; background-repeat: no-repeat;">
		<img style="margin-top: 10px;"
			src="<s:url value="/images/sureprinthint.jpg"/>" width="800"
			border="0px" height="50" alt="提示语" />

	</div>
	<div
		style="text-align: center; height: 502px; background: url('<s:url value="/images/bottom3.jpg"/>')  no-repeat center; background-repeat: no-repeat;">
		<br /> <br /> 

<table id="idprint"  cellpadding="0" cellspacing="0" style="text-align:left;width:480px" border="0">
<tr>
<td  style="text-align:center"><s:property value="printObject.glbmName"/></td>
</tr>
<tr>
<td  style="text-align:center">公安交通管理简易程序处罚回执</td>
</tr>

<tr>
<td><br/>被处罚人：<s:property value="printObject.xm"/> </td>
</tr>
<tr>
<td>机动车驾驶证档案编号：<s:property value="printObject.dabh"/> </td>
</tr>
<tr><td>机动车驾驶证号/居民身份证号码:</td></tr>
<tr><td><s:property value="printObject.sfzmhm"/></td></tr>
<tr>
<td>准驾车型：<s:property value="printObject.zjcx"/> </td>
</tr>
<tr><td>车辆牌号：<s:property value="printObject.hphm"/> </td>
</tr>
<tr>
<td>决定书编号：<s:property value="printObject.jdsbh"/> </td>
</tr>
<tr>
<td>请到1号窗口打印简易程序处罚决定书：</td>

</tr>
<tr>
<td style="text-align:right"><s:date name="testDate" nice="false" format="yyyy年MM月dd日 "/></td>
</tr>

</table>
<br/>
<br/>
<input type="button" class="btnmain" value="确认申请资料" width="341" height="55"/>
	</div>
</body>
</html>