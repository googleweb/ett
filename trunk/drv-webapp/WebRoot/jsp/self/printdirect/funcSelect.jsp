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
			style="height: 72px; vertical-align:middle;text-align:center;; line-height:72px; background: url('<s:url value="/images/hint2.jpg"/>')  no-repeat center; background-repeat: no-repeat;">
			 <img style="margin-top:10px;" src="<s:url value="/images/bustypehint.jpg"/>" width="800" border="0px" height="50" alt="提示语"/>
			
			</div>
		<div
			style="text-align: center; height: 502px; background: url('<s:url value="/images/bottom3.jpg"/>')  no-repeat center; background-repeat: no-repeat;">
			<br />
			<br /> 
			<input class="btnmain" value="申请检验合格标志补打" onclick="javascript:document.location.href='<s:url value="/self/print!car.action"/>';" type="button" /> <br />
			<br /> <input  class="btnmain" value="申请驾驶证体检回执补打" onclick="javascript:document.location.href='<s:url value="/self/print!person.action"/>';" type="button" />
			<br />
			<br /> <input  class="btnmain" value="申请处罚决定书补打" onclick="javascript:document.location.href='<s:url value="/self/print!hospital.action"/>';" type="button" />
			<br />
			
		</div>
</body>
</html>