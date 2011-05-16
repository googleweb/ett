<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>银联卡缴费页面</title>
</head>
<body>
<s:form cssClass="selfform">
		<div class="selfmain">
			<table border="0" style="width: 100%; height: 574px" cellpadding="0"
				cellspacing="0">
				<tr>
					<td class="selfhinttd" style="vertical-align: top;">
						<table class="selfhinttable" width="200px" border="0"
							cellpadding="0" cellspacing="0">
							<tr>
								<td class="headerleft">&nbsp;</td>
								<td class="headerright">&nbsp;</td>
							</tr>
							<tr>
								<td class="hintmsg" colspan="2">提示用语</td>
							</tr>
							<tr>
								<td  class="hintcontent" colspan="2"><div>1、您需要缴纳的费用总金额为<span id="feetotal" class="moneyhint" name="feetotal">
								<s:property value="feeObject.money"/>(不邮寄)
								
								</span>
								<input type="hidden" id="hiddenmoney" name="hiddenmoney" value='<s:property value="feeObject.money"/>'/>
								<input alt="邮寄费用" type="hidden" id="feeObject.postFee" name="feeObject.postFee" value='<s:property value="feeObject.postFee" />'/>
								</div>
									<div>
									2、请选择是否邮寄，邮寄费用
									<span id="postfeespan" class="moneyhint"><s:text name="Post.Fee"/></span>元
									<input type="button" class="btnmain" onclick="Post()" value="邮寄" />
									<input type="button" class="btnmain" onclick="SelfGet()" value="不邮寄" />
									<script type="text/javascript">
									function Post()
									{
										//alert($("#hiddenmoney").attr("value"));
										var money=parseInt($("#hiddenmoney").attr("value"));
										//alert("money:"+money);
										var postFee=parseInt($("#postfeespan").html());
										//alert("postFee:"+postFee);
										var total=money+postFee;
										//var total=money.toString()+"+"+postFee.toString()+"(邮寄费用)";
										//alert("total:"+total);
										//alert("span#:"+$("#feetotal"));
										//alert("获取span："+$("span[id='feetotal']"));
										$("#feetotal").html(total.toString()+"(邮寄费用"+postFee.toString()+")");
									}
									function SelfGet()
									{
										var total=parseInt($("#hiddenmoney").attr("value"));
										//alert("total:"+total);
										$("#feetotal").html(total.toString()+"(不邮寄)");
									}
									</script>
									</div></td>
							</tr>
							<tr>
								<td class="bottomleft">&nbsp;</td>
								<td class="bottomright">&nbsp;</td>
							</tr>
						</table></td>
					<td>
						<div style="text-align: center; height: 502px; line-height: 80px;">
						请输入密码<input type="password" alt="请输入密码" />
						<br/>
							<img src='<s:url value="/images/visafeehint.jpg" />' width="600px" height="250px"/>
						</div>
					</td>
				</tr>
			</table>
			<input class="btnmain" value="确 认"  onclick="confirmFee();" type="button" />
		</div>
	</s:form>
	<script type="text/javascript">
			function confirmFee() {
				$("#subform").attr("action",'<s:url value="/self/fee!fee.action"/>');
				$("#subform").submit();
			
			}
	</script>
	
	
</body>


</html>