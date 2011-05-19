<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>科目一预约功能选择界面</title>
</head>
<body>
<div
		 class="selfmaintophint"/>
		 请选择您要办理的业务类型
			
			</div>
		<div
			class="selfmaincontent">
			<br />
			<br /> 
			<input  class="btnmain"  onclick="javascript:document.location.href='<s:url value="/self/idCardReader.action"/>?agent=false&returnurl=<s:url value="preasign!check.action"/>';" value="科目一自助签到" type="button" /> <br />
			<br /> <input  class="btnmain"  onclick="javascript:document.location.href='<s:url value="/self/idCardReader.action"/>?agent=false&returnurl=<s:url value="preasign!preparePreasign.action"/>';" value="科目一预约" type="button" />
			
		</div>
</body>
</html>