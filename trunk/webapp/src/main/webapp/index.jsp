<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎使用自助车管所</title>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	
		<div
			style="height: 72px; vertical-align:middle;text-align:center;; line-height:72px; background: url('<s:url value="/images/hint2.jpg"/>') no-repeat center">
			 <img style="margin-top:10px;" src="<s:url value="/images/bustypehint.jpg"/> " width="800" border="0px" height="50" alt="提示语"/>
			
			</div>
		<div
			style="text-align: center; height: 502px; background: url('<s:url value="/images/bottom3.jpg"/>')  no-repeat center; ">
			<br />
			<br /> 
			<input onclick="javascript:document.location.href='<s:url value="/self/Driver/to/index.action"/>';" type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background: url('<s:url value="/images/car.jpg"/>')  no-repeat center" width="341" height="55"/>
			
			
			<br />
			<br /> <input  onclick="javascript:document.location.href='<s:url value="/self/Vehicle/to/index.action"/>';" type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background: url('<s:url value="/images/person.jpg"/>')  no-repeat center" width="341" height="55"/> <br />
			<br /> <input  type="button" onclick="javascript:document.location.href='<s:url value="/self/preasign!func.action"/>';" style="line-height:55px;background-position:center;width:341px;height:55px;background: url('<s:url value="/images/preasign.jpg"/>')  no-repeat center" width="341" height="55"/> <br />
			<br /> <input onclick="javascript:document.location.href='<s:url value="/jsp/self/idCardReader.jsp"/>?returnurl=<s:url value="/self/vio!vehicleSelectList.action"/>';" type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background: url('<s:url value="/images/vio.jpg"/>')  no-repeat center" width="341" height="55"/>
			<br />
			<br /> <input onclick="javascript:document.location.href='<s:url value="/jsp/self/idCardReader.jsp"/>?returnurl=<s:url value="/self/fee!func.action"/>';" type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background: url('<s:url value="/images/fee.jpg"/>')  no-repeat center" width="341" height="55"/>
			<br />
			<br />
			<input onclick="javascript:document.location.href='<s:url value="/jsp/self/idCardReader.jsp"/>?returnurl=<s:url value="/self/print!func.action"/>';" type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background: url('<s:url value="/images/print.jpg"/>')  no-repeat center" width="341" height="55"/>
		</div>
		<script type="text/javascript">
		//fullScreen();
		</script>
</body>

</html>