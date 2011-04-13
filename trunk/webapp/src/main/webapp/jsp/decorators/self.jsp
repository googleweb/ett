<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title><decorator:title default="Struts Starter"/></title>
    <link href="<s:url value='/styles/main.css'/>" rel="stylesheet" type="text/css" media="all"/>
	<script type="text/javascript" src="<s:url value="/js/jquery-1.5.2.min.js"/>"></script>
	<script type="text/javascript" src="<s:url value="/js/jquery.popup.js"/>"></script>
	<script type="text/javascript" src="<s:url value="/js/common.js"/>"></script>
    <decorator:head/>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	<div style="width: 1024px; height: 768px; border: 0px;">
		<div
			style="position: relative; height: 194px; background-image: url('<s:url value="/images/header1.jpg"/>'); background-repeat: no-repeat;">
			<img src="<s:url value="/images/jhui.jpg"/>"
				style="position: absolute; left: 21px; top: 46px;" width="101"
				height="95" /> <img src="<s:url value="/images/logo.jpg"/>"
				style="position: absolute; left: 123px; top: 46px;" width="143"
				height="95"/>
				<input onclick="javascript:document.location.href='<s:url value="/self/index!logout.action"/>';" type="button" style="position: absolute; left: 830px; top: 56px;line-height:55px;background-position:center;width:144px;height:58px;background-image: url('<s:url value="/images/returnhome.jpg"/>')" />
		</div>
		<decorator:body/>
		

	</div>

</body>

    
</html>
