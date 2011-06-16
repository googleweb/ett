<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <jsp:include page="/plugin/index.jsp">
      <jsp:param value="jquery,easyui" name="plugin"/>
    </jsp:include>
    <jsp:include page="/css/index.jsp"></jsp:include>
    <jsp:include page="/js/index.jsp"></jsp:include>
    <style type="text/css">
    select
    {
    width:100%;
    }
    input
    {
    width:80%;
    }
    
    </style>
    
  
  
  </head>
  
  <body>
  
  
 



<p><h3>驾驶人详细信息:<h3/></p>
<table  cellspacing="0" cellpadding="1" style="width:100%;table-layout:auto;" class="editTable" >
<tbody>

<tr >
<td style="width: 120px">证件名称</td>
<td style="width: 120px">
<select name="cardname">
<option value="volvo">Volvo</option>
<option value="saab">Saab</option>
<option value="fiat" selected="selected">Fiat</option>
<option value="audi">Audi</option>
</select>
</td>
<td style="width: 120px">证件号码</td>
<td style="width: 120px">
<input type="text" name="cardNo"/>
</td>
<td style="width: 120px">国籍</td>
<td style="width: 120px">
<select name="country">
<option value="volvo">Volvo</option>
<option value="saab">Saab</option>
<option value="fiat" selected="selected">Fiat</option>
<option value="audi">Audi</option>
</select>
</td>
<td colspan="2" rowspan="6">
haha
</td>
</tr>
<tr >
<td >姓名</td>
<td >
<input type="text" name="cardNo"/>
</td>
<td >性别</td>
<td >
<select name="cardname">
<option value="volvo">男</option>
<option value="saab" selected="selected">女</option>

</select>
</td>
<td>出生年月</td>
<td>
<input type="text" name="cardNo"/>
</td>
</tr>
<tr>
</td>
<td>登记住所</td>
<td>
<select name="country">
<option value="volvo">Volvo</option>
<option value="saab">Saab</option>
<option value="fiat" selected="selected">Fiat</option>
<option value="audi">Audi</option>
</select>
</td>
<td colspan="4"><a>查询</a><input type="text" style="width: 80%" /></td>
</tr>
<tr>
</td>
<td>联系住所</td>
<td>
<select name="country">
<option value="volvo">Volvo</option>
<option value="saab">Saab</option>
<option value="fiat" selected="selected">Fiat</option>
<option value="audi">Audi</option>
</select>
</td>
<td colspan="4"><input type="text" style="width: 100%"/></td>
</tr>
<tr>

<td>邮政编码</td>
<td>
<input type="text"/>
</td>
<td>联系电话</td>
<td ><input type="text"/></td>
<td>行政区划</td>
<td >
<select name="country">
<option value="volvo">Volvo</option>
<option value="saab">Saab</option>
<option value="fiat" selected="selected">Fiat</option>
<option value="audi">Audi</option>
</select>
</td>
</tr>
<tr >
<td >申请车型</td>
<td >
<select name="cardname">
<option value="volvo">小车</option>
<option value="saab" selected="selected">客车</option>
</select>
</td>
<td >驾驶人来源</td>
<td >
<select name="cardname">
<option value="volvo">本地</option>
<option value="saab" selected="selected">外地</option>
</select>
</td>
<td>暂住证号</td>
<td>
<input type="text" name="cardNo"/>
</td>
</tr>
<tr >
<td>准考证编号</td>
<td>
&nbsp;
</td>
<td>驾校名称</td>
<td colspan="5">
&nbsp;
</td>
</tr>
<tr >
<td>身高</td>
<td>
<input type="text" style="width: 50%">CM
</td>
<td>视力</td>
<td>
左
<input type="text" style="width: 20%">
右
<input type="text" style="width: 20%">
</td>
<td>辨色力</td>
<td>
<select name="cardname">
<option value="volvo">合格</option>
<option value="saab" selected="selected">不合格</option>
</select>
</td>
<td style="width: 120px">听力</td>
<td>
<select name="cardname">
<option value="volvo">合格</option>
<option value="saab" selected="selected">不合格</option>
</select>
</td>
</tr>
<tr>
<td>
上肢
</td>
<td>
<select name="cardname">
<option value="volvo">合格</option>
<option value="saab" selected="selected">不合格</option>
</select>
</td>
<td>
左下肢
</td>
<td>
<select name="cardname">
<option value="volvo">合格</option>
<option value="saab" selected="selected">不合格</option>
</select>
</td>
<td>
右下肢
</td>
<td>
<select name="cardname">
<option value="volvo">合格</option>
<option value="saab" selected="selected">不合格</option>
</select>
</td>
<td>
躯干颈部
</td>
<td>
<select name="cardname">
<option value="volvo">合格</option>
<option value="saab" selected="selected">不合格</option>
</select>
</td>
</tr>
<tr>
<td>
体检医院
</td>
<td colspan="2">
<select name="cardname">
<option value="volvo">湛江</option>
<option value="saab" selected="selected">深圳医院</option>
</select>
</td>
<td colspan="3" >
<input type="text" style="width: 80%"/>
</td>
<td  >
体检日期
</td>
<td  style="width: 120px">
<input class="<%=EasyUiModel.DateBox.CLASS %>" style="width: 100%"/>
</td>
</tr>
<tr>
<td style="text-align: center;" colspan="8">
<input type="button" value="保存" style="width:10%"/>
<input type="button" value="审核" style="width:10%"/>
<input type="button" value="打印申请表" style="width:10%"/>
<input type="button" value="关闭" style="width:10%"/>
</td>
</tr>
</tbody>
</table>
  </body>
</html>
