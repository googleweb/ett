<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>驾驶证受理凭证回执打印确认</title>
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
<td  style="text-align:center">驾驶证受理凭证</td>
</tr>
<tr>
<td><br/>流   水  号：*<s:property value="printObject.lsh"/>* </td>
</tr>
<tr>
<td>业务类型：<s:property value="printObject.ywlx"/> </td>
</tr>
<tr>
<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<s:property value="printObject.xm"/> </td>
</tr>
<tr><td>驾驶证号：<s:property value="printObject.sfzmhm"/> </td>
</tr>
<tr>
<td>受理日期：<s:date name="printObject.yyrq" format="yyyy-MM-dd hh:mm:ss"/> </td>
</tr>
<tr>
<td>收费金额：</td>
<td><s:property value="printObject.fee"/> </td>
</tr>
<tr>
<td >所需资料：身份证明复印件</td>
</tr>
<tr>
<td>驾驶证证请到1号窗口等候领取。</td>
</tr>

<tr>
<td >邮寄费22元，费用将在上门后收取(如果选择邮寄)。</td>
</tr>
</table>
<br/>
<br/>
<input type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background: url('<s:url value="/images/sureprint.jpg"/>')  no-repeat center" width="341" height="55"/>
	</div>
</body>
</html>