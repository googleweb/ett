<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>执行结果</title>
</head>
<body>

<div><input type="hidden" name="method" id="method" value="edit" />
<table width="800" border="0" cellpadding="4" cellspacing="1"
	class="table">
	<tr>
	<td class="table_view_header">
<s:property value="hintMessage"/></td>
</tr>
<tr>
	<td class="table_view_header">
	<a href='<s:url value="%{returnUrl}"/>'>返回</a>
</td>
</tr>
</table>
</div>
</body>
</html>