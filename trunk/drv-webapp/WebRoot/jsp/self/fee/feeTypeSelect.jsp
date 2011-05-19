<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core-rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>收费方式选择</title>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	<s:form name="subform" id="subform">
	<div class="selfmaintophint">您需要缴纳的费用总金额为<span style="color:red" id="feetotal" name="feetotal">
								<s:property value="feeObject.money"/>元</span>,请选择缴费方式</div>
<div class="selfmaincontent">
			<ul>
			<li>
			<input class="btnmain" value="现金缴费"  onclick="cashFee();" type="button" />
			</li><li>
			<input class="btnmain" value="银联卡缴费"  onclick="visaFee();" type="button" />
			</li>
			<!--<s:property value="allowGuiTai"/>-->
			<s:if  test="allowGuiTai">
			<li>
			<input class="btnmain" value="柜台缴费"  onclick="guitaiFee();" type="button" />
			</li>
			</s:if>
			</ul>
			
			<script type="text/javascript">
			function guitaiFee() {
				//var url= location.href.split("?")[1];
				//var url2= location.href.split("?")[2];
				//alert(url);
				//alert(url2);
				//document.location.href = '<s:url value="/jsp/fee!cash.action"/>?'+url+"?"+url2;
				//document.location.href = '<s:url value="/self/fee!cash.action"/>';
				$("#subform").attr("action",'<s:url value="/self/fee!guitaiFeeHint.action"/>');
				$("#subform").submit();
			}
			function cashFee() {
				//var url= location.href.split("?")[1];
				//var url2= location.href.split("?")[2];
				//alert(url);
				//alert(url2);
				//document.location.href = '<s:url value="/jsp/fee!cash.action"/>?'+url+"?"+url2;
				//document.location.href = '<s:url value="/self/fee!cash.action"/>';
				$("#subform").attr("action",'<s:url value="/self/fee!cashFeeHint.action"/>');
				$("#subform").submit();
			}
			function visaFee() {
                //var url= location.href.split("?")[1];	
                //var url2= location.href.split("?")[2];
				//document.location.href = '<s:url value="/jsp/fee!visa.action"/>?'+url+"?"+url2;
				//document.location.href = '<s:url value="/self/fee!visa.action"/>';
				$("#subform").attr("action",'<s:url value="/self/fee!visaFeeHint.action"/>');
				$("#subform").submit();
			}
			</script>
			
</div>
</s:form>
</body>

</html>