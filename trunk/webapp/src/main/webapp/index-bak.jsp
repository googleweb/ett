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
	<div style="width: 1024px; height: 768px; border: 0px;">
		<div
			style="position: relative; height: 194px; background-image: url('images/header1.jpg'); background-repeat: no-repeat;">
			<img src="<s:url value="/images/jhui.jpg"/>"
				style="position: absolute; left: 21px; top: 46px;" width="101"
				height="95" /> <img src="<s:url value="/images/logo.jpg"/>"
				style="position: absolute; left: 123px; top: 46px;" width="143"
				height="95"/>
				<input onclick="javascript:document.location.href='<s:url value="/index.jsp"/>';" type="button" style="position: absolute; left: 830px; top: 56px;line-height:55px;background-position:center;width:144px;height:58px;background-image: url('<s:url value="/images/returnhome.jpg"/>')" />
		</div>
		<div
			style="height: 72px; vertical-align:middle;text-align:center;; line-height:72px; background-image: url('images/hint2.jpg'); background-repeat: no-repeat;">
			 <img style="margin-top:10px;" src="images/bustypehint.jpg" width="800" border="0px" height="50" alt="提示语"/>
			
			</div>
		<div
			style="text-align: center; height: 502px; background-image: url('images/bottom3.jpg'); background-repeat: no-repeat;">
			<br />
			<br /> 
			<input type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background-image: url('images/car.jpg')" width="341" height="55"/>
			
			
			<br />
			<br /> <input type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background-image: url('images/person.jpg')" width="341" height="55"/> <br />
			<br /> <input type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background-image: url('images/preasign.jpg')" width="341" height="55"/> <br />
			<br /> <input type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background-image: url('images/vio.jpg')" width="341" height="55"/>
			<br />
			<br /> <input type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background-image: url('images/fee.jpg')" width="341" height="55"/>
			<br />
			<br /> <input type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background-image: url('images/print.jpg')" width="341" height="55"/>
		</div>

	</div>

</body>
</html>