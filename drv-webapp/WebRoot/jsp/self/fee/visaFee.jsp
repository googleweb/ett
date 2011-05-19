<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>银联卡缴费缴费</title>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	<s:form name="subform" id="subform" >
<div class="selfmaincontent">
			 <img style="margin-top:10px;" src="<s:url value="/images/beginflowfeehint.jpg"/>" width="800" border="0px" height="50" alt="提示语"/>

			需要缴纳的费用金额为：<s:property value="feeObject.money"/>
			<ul>
			<li>
			<input class="btnmain" value="确 认"  onclick="confirmFee();" type="button" />
			</li><li>
			
			</li>
			
			</ul>
			
			<script type="text/javascript">
			function confirmFee() {
				$("#subform").attr("action",'<s:url value="/self/fee!visaFeeHint.action"/>');
				$("#subform").submit();
				
				//document.location.href='<s:url value="/self/fee!visaFee.action"/>';
				//var url= location.href.split("returnurl")[1];
				//var url=url.substring(1);
				//alert("返回的url为："+url);
				//var url = r.split("=")[1]; //获取参数
				//document.location.href = url+"&feetype=visa";
			}
			//var r = getParameter("money", location.href);  
			//var money = r.split("=")[1];
			//$("money").attr("value",money);
			</script>
			
</div>
</s:form>
</body>

</html>