<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>是否代理人申请选择</title>
</head>
<body bgcolor="red" style="background-color: red" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	<s:form name="subform" id="subform">
<div class="selfmaintophint">请选择是否本人申请</div>
<div class="selfmaincontent">
			<ul>
			<li>
			<input class="btnmain" value="本人申请"  onclick="selfApply();" type="button" />
			</li><li>
			<input class="btnmain" value="代理人申请"  onclick="agentApply();" type="button" />
			</li>
			
			</ul>
			
			<script type="text/javascript">
			function agentApply() {
				//var url= location.href.split("?")[1];
				//var url2= location.href.split("?")[2];
				//alert(url);
				//alert(url2);
				//document.location.href = '<s:url value="/jsp/fee!cash.action"/>?'+url+"?"+url2;
				//document.location.href = '<s:url value="/self/fee!cash.action"/>';
				$("#subform").attr("action",'<s:url value="/self/idCardReader.action?agent=true"/>');
				$("#subform").submit();
			}
			function selfApply() {
                //var url= location.href.split("?")[1];	
                //var url2= location.href.split("?")[2];
				//document.location.href = '<s:url value="/jsp/fee!visa.action"/>?'+url+"?"+url2;
				//document.location.href = '<s:url value="/self/fee!visa.action"/>';
				$("#subform").attr("action",'<s:url value="/self/idCardReader.action?agent=false"/>');
				$("#subform").submit();
			}
			</script>
			
</div></s:form>
</body>

</html>