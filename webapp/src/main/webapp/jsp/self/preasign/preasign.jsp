<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>科目一考试预约</title>
</head>
<body>
<div
		style="height: 72px; vertical-align:middle;text-align:center;; line-height:72px; background: url('<s:url value="/images/hint2.jpg"/>')  no-repeat center; background-repeat: no-repeat;">
		<img style="margin-top: 10px;"
			src="<s:url value="/images/sureprinthint.jpg"/>" width="800"
			border="0px" height="50" alt="提示语" />

	</div>
	<div
		class="maincontent">
<br/>
<table id="idprint" class="selftable"  cellpadding="0" cellspacing="0" style="text-align:left;width:980px" border="0">
<tr>
<th  style="text-align:center"><s:property value="device.glbmName"/></th>
<th>选择考场</th><th>选择预约时间</th>
</tr>
<tr>
<td  style="text-align:center">科目一预约凭证</td>
<td rowspan="6">

<div id="ksddbtns" style="width:320px;">
<script type="text/javascript">
var tmp2;
<s:iterator id="entity" value="ksddList" status="stuts">   
document.write("<input type='button' class='btnmain' style='flow:left;display:inline;width:150px;font-size:12pt;' value='<s:property value="text"/>' alt='<s:property value="value"/>' onclick='clickksdd(this);'/>");
</s:iterator> 

function createKsddBtn(ksddlist)
{
	
	 
	//alert("要创建的按钮数:"+mydays);
	var tmp;
	var value;
	var date=new Date();
	//alert("date"+date);
	for(var i=0;i<mydays;i++)
	{
		//alert("开始循环 ");
		//alert(date.getDate());
		addDays(date,1);
		//date.setDate(date.getDate()+1);
		//alert("要创建的预约日期:"+date);
		value=formatDate(date,"yyyy-MM-dd");
		//alert("要创建的预约日期:"+value);
		tmp=$("<input type='button' class='btnmain' style='width:150px;font-size:12pt;' value='"+value+"' onclick='clickdate(this);'/>");
		$('#datebtns').append(tmp);
	}
}

function clickksdd(obj)
{
	$('#ksdd').html($(obj).attr('value'));
	$('#ksddCode').attr('value',$(obj).attr('alt'));
}

createKsddBtn(ksddlists);
</script>

</div>

</td><td rowspan="6" style="width:250px;">

<div id="datebtns">
<script type="text/javascript">

var days=<s:property value="device.allowPreasignDays"/>;
//alert("允许约考的天数！"+days);
//writeNowDate();

function createDynBtn(mydays)
{
	//alert("要创建的按钮数:"+mydays);
	var tmp;
	var value;
	var date=new Date();
	//alert("date"+date);
	for(var i=0;i<mydays;i++)
	{
		//alert("开始循环 ");
		//alert(date.getDate());
		addDays(date,1);
		//date.setDate(date.getDate()+1);
		//alert("要创建的预约日期:"+date);
		value=formatDate(date,"yyyy-MM-dd");
		//alert("要创建的预约日期:"+value);
		tmp=$("<input type='button' class='btnmain' style='width:110px;font-size:12pt;' value='"+value+"' onclick='clickdate(this);'/>");
		$('#datebtns').append(tmp);
	}
}

function clickdate(obj)
{
	$('#ykrq').attr('value',$(obj).attr('value'));
	$('#ykrqShow').html($(obj).attr('value'));
}

createDynBtn(days);
</script>

</div>
</td>
</tr>
<tr>
<td>流   水  号：*<s:property value="user.lsh"/>* </td>
</tr>
<tr>
<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<s:property value="user.xm"/> </td>
</tr>
<tr>
<td>身份证明号码：<s:property value="user.sfzmhm"/> </td>
</tr>
<tr><td>考试地点:<input type="hidden" value='<s:property value="device.ksddCode"/>' name="ksddCode"/> 
<span id="ksdd" name="ksdd"><s:property value="device.ksddName"/></span>
</td>
</tr>

<tr>
<td>约考日期：
<span id="ykrqShow" name="ykrqShow"></span>
<input type="hidden" id="ykrq" name="ykrq" value=""/>

</td>
 
</tr>




</table>


<input type="button"  onclick="javascript:surePreasign();" class="btnmain"  value="确        认"  width="341" height="55"/>
	</div>
	<script type="text/javascript">
	function surePreasign()
	{
//alert("执行预约确定"+$('#ykrq').attr('value'));
		if($('#ykrq').attr('value').length==0)
		{
			alert("请选择考试日期！");
			return ;
	    }
		document.location.href='<s:url value="/self/preasign!preasign.action"/>';
		
	}
	</script>
</body>
</html>