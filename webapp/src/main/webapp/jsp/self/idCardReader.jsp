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
<OBJECT ID="ETTSelfIDCardActiveX1" WIDTH=100 HEIGHT=51
 CLASSID="CLSID:447C4906-6678-461B-9E20-100BDE913828">
    <PARAM NAME="_Version" VALUE="65536">
    <PARAM NAME="_ExtentX" VALUE="2646">
    <PARAM NAME="_ExtentY" VALUE="1323">
    <PARAM NAME="_StockProps" VALUE="0">
</OBJECT>
<s:form name="subform" id="subform">
<div style="display:none">
姓名:<input type="text" value="贾名" name="name"/>
<br/>
性别:<input type="text" value="1" name="sex"/>
<br/>
民族:<input type="text" value="白族" name="national"/>
<br/>
出生:<input type="text" value="1983-03-03" name="csrq"/>
<br/>
住址:<input type="text" value="address" name="txtaddress"/>
<br/>
身份证号码:<input type="text" value="350128198403194910" name="sfzmhm"/>
<br/>
签发机关:<input type="text" value="中华人民共和国" name="fzjg"/>
<br/>
有效期起:<input type="text" value="1900-01-01" name="begindate"/>
<br/>
有效期止:<input type="text" value="2011-01-01" name="enddate"/>
</div>
	<div
		class="selfmaintophint">
		<span>
		<script type="text/javascript">
		
		var r = getParameter("readagent", location.href);
		var boolagent = r.split("=")[1]
		//测试输出，结果是：site=popasp  
		//alert(boolagent); 
		if(boolagent=="true")
		{
			document.write("请放置代理人的二代身份证到二代身份证阅读器上！");	
		}
		else
		{
			document.write("请放置申请人的二代身份证到二代身份证阅读器上！");
		}
		</script>
		
		</span>

	</div>
	<div
		class="selfmaincontent">
		<br/>
 <img width="600px" height="450px" src="<s:url value="/images/idcard.gif"/>"
			alt="身份证阅读器方位指示" />
	</div>
	</s:form>
	<script type="text/javascript">
	function nextStep() {
		//var r = getParameter("returnurl", location.href);
		//测试输出，结果是：site=popasp  
		//alert(r);   
		//根据得到的结果可以使用   
		//var url = r.split("=")[1]; //获取参数名  
		//document.location.href = url+"?idcard=350128198403194910";
		//document.location.href=document.location.href+"&idcard=350128198403194910";
		//alert($("#subform"));
		//alert($("#subform").attr("action"));
		//var url=document.location.href+"&idcard="+idcard;
		//alert(url);
		$("#subform").attr("action",document.location.href+"&idcard=350128198403194910");
		//alert($("#subform").attr("action"));
		$("#subform").submit();
	}
	var isReading=false;
	function readCard()
	{
		if(isReading)
		{
		  return;
		}
		isReading=true;
		ETTSelfIDCardActiveX1.ReadIDCard();
		var idcard=ETTSelfIDCardActiveX1.IDCard;
		//var r = getParameter("returnurl", location.href);
		//alert("获取的身份证明号："+idcard);
		//测试输出，结果是：site=popasp  
		//alert(r);   
		//根据得到的结果可以使用   
		//var url = r.split("=")[1]; //获取参数名  
		if(idcard&&idcard.length>0)
		{
			$("#subform").attr("action",document.location.href+"&idcard="+idcard);
			$("#subform").submit();
			//document.location.href = url+"?idcard="+idcard;
			//document.location.href=document.location.href+"&idcard="+idcard;
		}
		//alert("213");
		//alert(document.all);
		//document.all.txtname.value="name";
	/*
		document.all.txtname.value=ETTSelfIDCardActiveX1.Name;
		document.all.txtsex.value=ETTSelfIDCardActiveX1.SexName;
		document.all.txtnation.value=ETTSelfIDCardActiveX1.NationName;
		document.all.txtbirth.value=ETTSelfIDCardActiveX1.Birth;
		document.all.txtaddress.value=ETTSelfIDCardActiveX1.Address;
		document.all.txtidcard.value=ETTSelfIDCardActiveX1.IDCard;
		document.all.txtfzjg.value=ETTSelfIDCardActiveX1.Fzjg;
		document.all.txtstartdate.value=ETTSelfIDCardActiveX1.StartDate;
		document.all.txtenddate.value=ETTSelfIDCardActiveX1.EndDate;
		if(document.all.txtname.value.length>0)
		{
			document.all.txtphoto.src="c:\\zp.bmp";
		}
	*/
		isReading=false;

	}
	if(Whole_IdCardReader_Enable)
		{
	var interval=self.setInterval("readCard()",500) ;
		}
	else
		{
	setTimeout("nextStep()", 3000);
		}
</script>
</body>


</html>