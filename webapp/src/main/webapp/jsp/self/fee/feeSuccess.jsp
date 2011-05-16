<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>提示页面</title>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" style="text-align: center;"
	topmargin="0" marginwidth="0" marginheight="0">
	
		<div
			class="selfmaintophint"/>
			操作提示信息
			
			</div>
		<div
			style="text-align: center; height: 502px; background: url('<s:url value="/images/bottom3.jpg"/>')  no-repeat center; background-repeat: no-repeat;">
			<br />
			<br />
<p style="color:#FFEEDD;font-family:宋体;font-size:22pt;font-weight: bolder;text-shadow: #FEFEFE;">
			<s:property  value="hintMsg" />
			<br/>
			<!--<s:property value="exceptionStack" />-->

</p>
			<br />
			<input value="返回首页" onclick="javascript:document.location.href='<s:url value="/self/index!logout.action"/>';" type="button" class="btnmain" />
		</div>
		<div style="display:none">
		<OBJECT ID="ETTSelfHotPrinterActiveX1" WIDTH=100 HEIGHT=51
 CLASSID="CLSID:CADA7DA3-25C6-43E6-B5C5-7A5E949A5296">
    <PARAM NAME="_Version" VALUE="65536">
    <PARAM NAME="_ExtentX" VALUE="2646">
    <PARAM NAME="_ExtentY" VALUE="1323">
    <PARAM NAME="_StockProps" VALUE="0">
</OBJECT>
<input type="text" id="textglbm" value='<s:property	value="device.glbmName" />'/>
		<input type="text" id="textbustype" value='<s:property	value="feeObject.busType" />'/>
		<input type="text" id="textmoney" value='<s:property	value="feeObject.money" />'/>
		<input type="text" id="textfeetime" value='<s:date name="feeObject.createTime" format="yyyy-MM-dd HH:mm:ss"/>'/>
		<input type="text" id="textlsh" value='<s:property	value="feeObject.feeLsh" />'/>
		<input type="text" id="textsfzmhm" value='<s:property	value="feeObject.sfzmhm" />'/>
		<input type="text" id="textxm" value='<s:property	value="feeObject.xm" />'/>
		<script type="text/javascript">
		//alert("begin!");
		
		var glbm=$("#textglbm").attr("value");
		//alert("GLBM"+glbm);
		var bustype=$("#textbustype").attr("value");
		var money=$("#textmoney").attr("value");
		var lsh=$("#textlsh").attr("value");
		var feetime=$("#textfeetime").attr("value");
		var sfzmhm=$("#textsfzmhm").attr("value");
		var xm=$("#textxm").attr("value");
	var date=new Date();
	var datestr=formatDate(date,"yyyy年MM月dd日");
	//alert("增加字符串进打印控件开始");	
	ETTSelfHotPrinterActiveX1.FontStyle="DoubleHeight|DoubleWidth";
	ETTSelfHotPrinterActiveX1.AddString("    "+glbm );
ETTSelfHotPrinterActiveX1.AddString("      业务缴费凭证");
ETTSelfHotPrinterActiveX1.AddString("流水号：*"+lsh.replace(",","")+"*");
ETTSelfHotPrinterActiveX1.AddString("业务类型："+bustype);
ETTSelfHotPrinterActiveX1.AddString("缴费金额："+money);
ETTSelfHotPrinterActiveX1.AddString("证件号码：");
ETTSelfHotPrinterActiveX1.AddString(sfzmhm);
ETTSelfHotPrinterActiveX1.AddString("姓名："+xm);
ETTSelfHotPrinterActiveX1.AddString(" ");


ETTSelfHotPrinterActiveX1.AddString("  "+feetime);
ETTSelfHotPrinterActiveX1.AddString("            广州互信电子");
//<s:set name="printco" value="#device.printCompany"/>

//<s:if test='#device.printCompany==true'>
//ETTSelfHotPrinterActiveX1.AddString("    广州互信电子");
//alert("打印公司名称");
//</s:if>
//<s:else>
//</s:else>
ETTSelfHotPrinterActiveX1.AddString(" ");
ETTSelfHotPrinterActiveX1.PrintHot(1,10);

//alert("增加字符串进打印控件完成");
</script>
		</div>
</body>

</html>