<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>打印回执功能选择界面</title>
</head>
<body>
	<div class="selfmaintophint" />
	请选择您要补打的业务类型

	</div>
	<div class="selfmaincontent">
		<br /><input class="btnmain" value="申请医院体检回执补打"
			onclick="javascript:document.location.href='<s:url value="/self/addPrintApply!hospital.action"/>';"
			type="button" /> <br/> <input class="btnmain"
			value="申请处罚决定书补打"
			onclick="javascript:document.location.href='<s:url value="/self/addPrintApply!vio.action"/>';"
			type="button" /> <br />

	</div>
</body>
</html>