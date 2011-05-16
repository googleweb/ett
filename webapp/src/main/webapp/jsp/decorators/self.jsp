<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title><decorator:title default="Struts Starter" />
</title>
<link href="<s:url value='/css/selfmain.css'/>" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<s:url value="/js/jquery-1.5.2.min.js"/>"></script>
<script type="text/javascript"
	src="<s:url value="/js/jquery.popup.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/common.js"/>"></script>
<decorator:head />
</head>
<body bgcolor="#FEFEFE" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	<div style="width: 1024px; height: 768px; border: 0px;">
		<div class="selfmainheader">
			<img src="<s:url value="/images/logo.jpg"/>"
				style="position: absolute; left: 80px; top: 60px;" width="72"
				height="50" /> <input value="<<返回首页"
				onclick="javascript:document.location.href='<s:url value="/self/index!logout.action"/>';"
				type="button" class="btnmain"
				style="position: absolute; left: 840px; text-indent: -15px; top: 36px; width: 160px;" />
		</div>
		<decorator:body />
	</div>
</body>

<script type="text/javascript">
		//fullScreen();
		
		//setInterval("goFirst()",10000) ;
</script>
</html>
