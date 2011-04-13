<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>打印回执功能选择界面</title>
</head>
<body>
<div
			style="height: 72px; vertical-align:middle;text-align:center;; line-height:72px; background-image: url('<s:url value="/images/hint2.jpg"/>'); background-repeat: no-repeat;">
			 <img style="margin-top:10px;" src="<s:url value="/images/bustypehint.jpg"/>" width="800" border="0px" height="50" alt="提示语"/>
			
			</div>
		<div
			style="text-align: center; height: 502px; background-image: url('<s:url value="/images/bottom3.jpg"/>'); background-repeat: no-repeat;">
			<br />
			<br /> 
			<input onclick="javascript:document.location.href='<s:url value="/self/print/print!car.action"/>';" type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background-image: url('<s:url value="/images/fun8-1.jpg"/>')" width="341" height="55"/> <br />
			<br /> <input onclick="javascript:document.location.href='<s:url value="/self/print/print!person.action"/>';" type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background-image: url('<s:url value="/images/fun8-2.jpg"/>')" width="341" height="55"/>
			<br />
			<br /> <input onclick="javascript:document.location.href='<s:url value="/self/print/print!hospital.action"/>';" type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background-image: url('<s:url value="/images/fun8-3.jpg"/>')" width="341" height="55"/>
			<br />
			<br />
			<input onclick="javascript:document.location.href='<s:url value="/self/print/print!vio.action"/>';" type="button" style="line-height:55px;background-position:center;width:341px;height:55px;background-image: url('<s:url value="/images/fun8-4.jpg"/>')" width="341" height="55"/>
		</div>
</body>
</html>