<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>错误信息</title>
</head>
<body>
<table class="table" cellpadding="4" cellspacing="1" border="0"
	name="rolelist" style="width: 700px;">
	<tr class="table_header_tr">
		<td class="table_header_td" style="height:50px:text-align:center">提示信息</td>	
	</tr>
	<tr class="table_header_tr">
		
		<td class="table_content_td_even"><s:property value="exception.message"/></td>	
	</tr>
	<tr class="table_header_tr">
		
		<td class="table_content_td_even"><s:property value="hintMsg"/></td>	
	</tr>
</table>
<!--<s:property value="exceptionStack"/>-->
</body>
</html>