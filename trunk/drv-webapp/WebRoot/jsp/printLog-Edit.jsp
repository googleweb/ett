<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form id="userform" method="post" name="userform"
	action="printLog.action">
<div>
<table width="800" border="0" cellpadding="4" cellspacing="1"
	class="table">
	<tr>
		<input type="hidden" id="entity.id" name="entity.id"
			value="${entity.id}" />

		<td class="table_view_header" colspan="2">用户编辑 <span
			class="emphasize">(*为必填项)</span><span class="editadd"></span> <br />
		<span class="successmsg"><s:property value="hintMessage" /></span></td>
	</tr>
	<tr>
		<td class="table_view_left">打印日志用户的身份证明号码！：</td>
		<td class="table_content_tr"><s:textfield label=""
			key="entity.idCard" />&nbsp;<span class="emphasize">*</span></td>
	</tr>
	
</table>
</div>


</form>
</body>
</html>