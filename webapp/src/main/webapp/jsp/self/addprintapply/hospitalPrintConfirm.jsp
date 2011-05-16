<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>医院体检回执打印凭条确认</title>
</head>
<body>
	<div class="selfmaintophint" />
	请确认您的补打申请资料
	</div>
	<div class="selfmaincontent">
	<br/>
		<table id="idprint" class="selftable" cellpadding="0" cellspacing="0"
			style="text-align: left; width: 480px" border="0">
			<tr>
				<td style="text-align: center"><s:property
						value="printObject.glbmName" /></td>
			</tr>
			<tr>
				<th class="header" colspan="3" >医院体检回执补打申请</th>
			</tr>
			<tr>
				<th>流 水 号：</th>
				<td>*<s:property value="printObject.lsh" />*</td>
				<th style="text-align: center">申请人照片</th>
				
			<tr>
				<th>体检医院：</th>
				<td><s:property value="printObject.ywlx" />&nbsp;</td>
				<td rowspan="4"><img src="c://video.bmp" id="imgPhoto" width="133px" height="160px" border="0" /></td>
			</tr>
			<tr>
				<th>身份证明号码：</th>
				<td><s:property value="printObject.sfzmhm" />&nbsp;</td>
			</tr>
			<tr>
				<th>姓名：</th>
				<td><s:property value="printObject.xm" />&nbsp;</td>
			</tr>
			<tr>
				<th>体检日期：</th>
				<td><s:date name="printObject.slrq"
						format="yyyy-MM-dd hh:mm:ss" />&nbsp;</td>
			</tr>
			

		</table>
		<br /> <input type="button" class="btnmain"
			onclick="javascript:document.location.href='<s:url value="/self/addPrintApply!hospitalPrint.action"/>?lsh=<s:property value="printObject.lsh"/>';"
			value="确         认" width="341" height="55" />
	</div>
</body>
</html>