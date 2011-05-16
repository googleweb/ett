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
		class="selfmaintophint" />
请确认您的补打申请资料
	</div>
	<div class="selfmaincontent">
		<br /> 

<table id="idprint"  class="selftable" cellpadding="0" cellspacing="0" style="text-align:left;width:480px" border="0">
<tr>
<th  style="text-align:center" colspan="2"><s:property value="device.glbmName"/></th>
</tr>
<tr>
<th  style="text-align:center" colspan="2">公安交通管理简易程序处罚回执</th>
</tr>

<tr>
<th >被处罚人：</th><td><s:property value="printObject.xm"/> </td>
</tr>
<tr>
<th >机动车驾驶证档案编号：</th><td><s:property value="printObject.dabh"/> </td>
</tr>
<tr><th colspan="2">机动车驾驶证号/居民身份证号码:</th></tr>
<tr><td colspan="2"><s:property value="printObject.sfzmhm"/></td></tr>
<tr>
<th>准驾车型：</th><td><s:property value="printObject.zjcx"/> </td>
</tr>
<tr><th>车辆牌号：</th><td><s:property value="printObject.hphm"/> </td>
</tr>
<tr>
<th>决定书编号：</th><td><s:property value="printObject.jdsbh"/> </td>
</tr>
<tr>
<td style="text-align:right"><s:date name="testDate" nice="false" format="yyyy年MM月dd日 "/></td>
</tr>

</table>
<br/>
<input type="button" class="btnmain" onclick="javascript:document.location.href='<s:url value="/self/addPrintApply!vioPrint.action"/>?lsh=<s:property value="printObject.lsh"/>';" value="确         认" width="341" height="55"/>
	</div>
</body>
</html>