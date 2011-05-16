<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>错误提示页面</title>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">

	<div class="selfmaintophint" />
	操作异常提示信息
	</div>
	<div class="selfmaincontent">
	<br/><br/>
	<p
		style="color: #FFEEDD; font-family: 宋体; font-size: 22pt; font-weight: bolder; text-shadow: #FEFEFE;">
		<s:property value="exception.hint" />
		<br />
		<!--<s:property value="exceptionStack" />-->

	</p>
	<br />
	<input
		onclick="javascript:document.location.href='<s:url value="/self/index!logout.action"/>';"
		type="button"
		style="line-height:58px;background-position:center;width:144px;height:58px;background: url('<s:url value="/images/returnhome.jpg"/>')  no-repeat center" />
	</div>
</body>

</html>