<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>打印提示</title>
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
			<!--是否打印公司名称<s:property  value="device.printCompany" />-->
</p>
			<br />
			<input value="返回首页" onclick="javascript:document.location.href='<s:url value="/self/index!logout.action"/>';" type="button" class="btnmain" />
		</div>
		<OBJECT ID="ETTSelfHotPrinterActiveX1" WIDTH=100 HEIGHT=51
 CLASSID="CLSID:CADA7DA3-25C6-43E6-B5C5-7A5E949A5296">
    <PARAM NAME="_Version" VALUE="65536">
    <PARAM NAME="_ExtentX" VALUE="2646">
    <PARAM NAME="_ExtentY" VALUE="1323">
    <PARAM NAME="_StockProps" VALUE="0">
</OBJECT>
		<div style="display:none">
		<input type="text" id="textglbm" value='<s:property	value="device.glbmName" />'/>
		<input type="text" id="textksrq" value='<s:date name="printObject.ksrq" format="yyyy-MM-dd"/>'/>
		<input type="text" id="textyyrq" value='<s:date name="printObject.yyrq" format="yyyy-MM-dd HH:mm:ss"/>'/>
		<input type="text" id="textlsh" value='<s:property	value="printObject.lsh" />'/>
		<input type="text" id="textsfzmhm" value='<s:property	value="printObject.sfzmhm" />'/>
		<input type="text" id="textxm" value='<s:property	value="printObject.xm" />'/>
		<script type="text/javascript">
		//alert("begin!");
		
		var glbm=$("#textglbm").attr("value");
		//alert("GLBM"+glbm);
		var lineupid=$("#textlineupid").attr("value");
		var yyrq=$("#textyyrq").attr("value");
		var ksrq=$("#textksrq").attr("value");
		var lsh=$("#textlsh").attr("value");
		lsh=lsh.replace(/(^\s*)|(\s*$)/g, ""); 
		var sfzmhm=$("#textsfzmhm").attr("value");
		var xm=$("#textxm").attr("value");
	var date=new Date();
	var datestr=formatDate(date,"yyyy年MM月dd日");
	//alert("增加字符串进打印控件开始");	
	ETTSelfHotPrinterActiveX1.FontStyle="DoubleHeight|DoubleWidth";
	ETTSelfHotPrinterActiveX1.AddString("    "+glbm );
ETTSelfHotPrinterActiveX1.AddString("      科目一预约签到凭证");
ETTSelfHotPrinterActiveX1.AddString(" ");

ETTSelfHotPrinterActiveX1.AddString("流 水 号：*"+lsh+"*");
ETTSelfHotPrinterActiveX1.AddString("姓   名："+xm);
ETTSelfHotPrinterActiveX1.AddString("证件号码：");
ETTSelfHotPrinterActiveX1.AddString(sfzmhm);
ETTSelfHotPrinterActiveX1.AddString("考试日期："+ksrq);
ETTSelfHotPrinterActiveX1.AddString("签到时间：");
ETTSelfHotPrinterActiveX1.AddString(yyrq);
ETTSelfHotPrinterActiveX1.AddString("所需资料：身份证原件、驾校培训记录单");
ETTSelfHotPrinterActiveX1.AddString("请提前十分钟进场等候考试。");

ETTSelfHotPrinterActiveX1.AddString(" ");


//ETTSelfHotPrinterActiveX1.AddString("         "+datestr);
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