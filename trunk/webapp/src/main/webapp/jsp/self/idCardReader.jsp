<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>身份证阅读界面</title>
</head>
<body>
	<div
		class="selfmaincontent">
		<img style="margin-top: 10px;"
			src="<s:url value="/images/idcardhint.jpg"/>" width="800"
			border="0px" height="50" alt="提示语" />

	</div>
	<div
		style="text-align: center; height: 502px; background: url('<s:url value="/images/bottom3.jpg"/>')  no-repeat center; background-repeat: no-repeat;">
		<br /> <br /> <img width="500px" height="500px" src="<s:url value="/images/idcardposition.jpg"/>"
			alt="身份证阅读器方位指示" />
	</div>
	<script type="text/javascript">
	function nextStep() {
		var r = getParameter("returnurl", location.href);

		//测试输出，结果是：site=popasp  
		//alert(r);   
		//根据得到的结果可以使用   
		var url = r.split("=")[1]; //获取参数名  
		document.location.href = url+"?idcard=350128198403194910";
	}
	setTimeout("nextStep()", 3000);
</script>
</body>


</html>