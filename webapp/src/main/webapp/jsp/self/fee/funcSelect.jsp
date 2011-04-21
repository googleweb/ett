<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>缴费功能选择界面</title>
</head>
<body>
<div
			class="selfmaincontent">
			 <img style="margin-top:10px;" src="<s:url value="/images/bustypehint.jpg"/>" width="800" border="0px" height="50" alt="提示语"/>
			
			</div>
		<div
			style="text-align: center; height: 502px; background: url('<s:url value="/images/bottom3.jpg"/>')  no-repeat center; background-repeat: no-repeat;">
			<br />
			<br /> 
			<input class="btnmain" value="机动车业务缴费" onclick="javascript:document.location.href='<s:url value="/self/fee!vehicleList.action"/>';" type="button" /> <br />
			<br /> <input  class="btnmain" value="驾驶证业务缴费" onclick="javascript:document.location.href='<s:url value="/self/fee!personList.action"/>';" type="button" />
			<br />
			<br /> <input  class="btnmain" value="违法业务缴费" onclick="javascript:document.location.href='<s:url value="/self/fee!vioList.action"/>';" type="button" />

		</div>
</body>
</html>