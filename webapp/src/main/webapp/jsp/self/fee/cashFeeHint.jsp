<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>现金缴费方位指示页面</title>
</head>
<body>
<s:form cssClass="selfform" name="subform" id="subform">
		<div class="selfmain">
			<table border="0" style="width: 100%; height: 574px" cellpadding="0"
				cellspacing="0">
				<tr>
					<td class="selfhinttd"  style="vertical-align: top;">
						<table class="selfhinttable" width="200px"  border="0"
							cellpadding="0" cellspacing="0">
							<tr>
								<td class="headerleft">&nbsp;</td>
								<td class="headerright">&nbsp;</td>
							</tr>
							<tr>
								<td class="hintmsg" colspan="2">提示用语</td>
							</tr>
							<tr>
								<td  class="hintcontent" colspan="2"><div>1、您需要缴纳的费用总金额为<span class="moneyhint" id="feetotal" name="feetotal">
								<s:property value="feeObject.money"/>
								(不邮寄)
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
									var total=<s:property value="feeObject.money"/>;
									function Post()
									{
										//alert($("#hiddenmoney").attr("value"));
										var money=parseInt($("#hiddenmoney").attr("value"));
										//alert("money:"+money);
										var postFee=parseInt($("#postfeespan").html());
										$("#feeObject.postFee").attr("value",postFee);
										//alert("postFee:"+postFee);
										total=money+postFee;
										//var total=money.toString()+"+"+postFee.toString()+"(邮寄费用)";
										//alert("total:"+total);
										//alert("span#:"+$("#feetotal"));
										//alert("获取span："+$("span[id='feetotal']"));
										$("#feetotal").html(total.toString()+"(邮寄费用"+postFee.toString()+")");
									}
									function SelfGet()
									{
										total=parseInt($("#hiddenmoney").attr("value"));
										$("#feeObject.postFee").attr("value","0");
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
						<div style="text-align: left; height: 502px; line-height: 80px;">
						<table  border="0" cellpadding="0" cellspacing="0">
						<tr style="border-bottom: solid 1px;background-color: #EFF3F7;"><th style="width:350px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已经缴纳的金额为：</th><td style="width:300px" class="moneyhint">
						<span id="hasaccpetmoney">0</span>元
						</td></tr>
						<tr>
						<td colspan="2" style="text-align:center;padding-top: 15px;margin-top: 15px;">
						<img src='<s:url value="/images/cashcode.gif" />' width="450px" height="330px" />
						</td>
						</tr>
						</table>
							
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
<div style="display:none">
<OBJECT ID="ETTCashCodeActiveX1" WIDTH=100 HEIGHT=51
 CLASSID="CLSID:5A797850-BE8E-4939-8F6D-D9397B963765">
    <PARAM NAME="_Version" VALUE="65536">
    <PARAM NAME="_ExtentX" VALUE="2646">
    <PARAM NAME="_ExtentY" VALUE="1323">
    <PARAM NAME="_StockProps" VALUE="0">
</OBJECT>
	<script type="text/javascript">
	var ttt=ETTCashCodeActiveX1.InitCashCodeV2(2);
	//alert("initdevice:"+ttt);
	var acc=0;
	var tmp=0;
	var timer;
	var max=total;
	var money;
	var need=0;
	var postFee;

	function getMoney()
	{
		if(acc!=total)
		{
			max=total-acc;
	//alert("exe-identifyEx");
		   tmp=ETTCashCodeActiveX1.IdentifyExV2(max);
	//document.getElementById("divmoney").innerHTML+=tmp+";";
		   if(tmp>0)
		   {
	//alert("gettruemoney");
			 acc=acc+parseInt(tmp);
	//alert("all money "+acc);
			need=total-acc;
			document.getElementById("hasaccpetmoney").innerHTML=acc.toString()+"还差"+need.toString();
			 
		   }
		 setTimeout(getMoney,100);
	   }
	   if(acc==total&&ETTCashCodeActiveX1.IdentifyEx()==0)
	   {
	       //alert("收取足够的钱了！");
		   ttt=ETTCashCodeActiveX1.CloseCashCode();
		  
	        setTimeout(destroydll,200);
	        setTimeout(confirmFee,300);
			//();
	        //alert("closedevice:"+ttt);
		   //return;
	   }
	}
	setTimeout(getMoney,200);
	function destroydll()
	{
		 ETTCashCodeActiveX1.DestoryDll();
	}
	</script>


</div>
	
</body>


</html>