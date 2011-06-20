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
    
    td,th{
      padding: 0px auto 0px auto;
    }
    
    </style>
    
  
  
  </head>
  
  <body>
  
  

<table  cellspacing="0" cellpadding="0" style="width:100%;table-layout:auto;font-size: 0.85em;" class="editTable" >
<tbody>

<tr >
<td style="width: 120px">证件名称</td>
<td style="width: 120px">
<select name="cardname" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="volvo">A:居民身份证</option>
<option value="saab">B:军官证</option>
<option value="fiat" selected="selected">C:士兵证</option>
<option value="saab">D:军官离退休证</option>
<option value="saab">E:境外人员身份证</option>
<option value="audi">F:外交人员身份证</option>
</select>
</td>
<td style="width: 120px">证件号码</td>
<td style="width: 250px">
<input type="text" name="Sfzmhm" value="${Sfzmhm}"/>
</td>
<td style="width: 100px">国籍</td>
<td style="width: 150px">
<select name="CGj" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="1">中国</option>
<option value="2">美国</option>
<option value="3" selected="selected">沙特阿拉伯</option>
<option value="4">阿富汗</option>
</select>
</td>
<td colspan="2" rowspan="6">
haha
</td>
</tr>
<tr >
<td >姓名</td>
<td >
<input type="text" name="CXm" value="${CXm}"/>
</td>
<td >性别</td>
<td >
<select name="IXb" class="<%=EasyUiModel.ComboBox.CLASS %>" style="width:50px">
<option value="1">男</option>
<option value="2" selected="selected">女</option>

</select>
</td>
<td>出生年月</td>
<td>
<input type="text" name="CCsrq" value="${CCsrq}"/>
</td>
</tr>
<tr>
</td>
<td>登记住所</td>
<td>
<select name="CDjzsxzqh" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="1">广州</option>
<option value="2">深圳</option>
<option value="3" selected="selected">山东</option>
<option value="4">北京</option>
</select>
</td>
<td colspan="4"><a>查询</a><input type="text" style="width: 80%" /></td>
</tr>
<tr>
</td>
<td>联系住所</td>
<td>
<select name="CLxzsxzqh" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="1">广州</option>
<option value="2">北京</option>
<option value="3" selected="selected">上海</option>
<option value="4">深圳</option>
</select>
</td>
<td colspan="4"><input type="text" style="width: 100%"/></td>
</tr>
<tr>

<td>邮政编码</td>
<td>
<input type="text" name="CLxzsyzbm"/ value="${CLxzsyzbm }">
</td>
<td>联系电话</td>
<td ><input type="text" name="CLxdh" value="${CLxdh }"/></td>
<td>行政区划</td>
<td >
<select name="CXzqh" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="1">北京</option>
<option value="2">上海</option>
<option value="3" selected="selected">深圳</option>
<option value="4">广州</option>
</select>
</td>
</tr>
<tr >
<td >申请车型</td>
<td >
<select name="CZkcx" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="volvo">小车</option>
<option value="saab" selected="selected">客车</option>
</select>
</td>
<td >驾驶人来源</td>
<td >
<select name="CLy" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="1">本地</option>
<option value="2" selected="selected">外地</option>
</select>
</td>
<td>暂住证号</td>
<td>
<input type="text" name="CZzzm" value="${CZzzm}"/>
</td>
</tr>
<tr >
<td>准考证编号</td>
<td>
${CZkzmbh}
</td>
<td>驾校名称</td>
<td colspan="5">
${CJxmc}
</td>
</tr>
<tr >
<td>身高</td>
<td>
<input type="text" style="width: 50%" name="CSg" value="${CSg}">CM
</td>
<td>视力</td>
<td>
左
<input type="text" style="width: 50px" class="<%=EasyUiModel.NumberSpinner.CLASS%>" 
  <%=EasyUiModel.NumberBox.Properties.PRECISION(1) %>
  increment="0.1"
  <%=EasyUiModel.NumberBox.Properties.MIN(0) %>
name="IZsl" value="${IZsl}">
右
<input type="text" style="width: 50px" class="<%=EasyUiModel.NumberSpinner.CLASS%>" 
  <%=EasyUiModel.NumberBox.Properties.PRECISION(1) %>
  <%=EasyUiModel.Spinner.Properties.INCREMENT(1) %>
  <%=EasyUiModel.NumberBox.Properties.MIN(0) %> name="IYsl" value="${IYsl}">
</td>
<td>辨色力</td>
<td>
<select name="IBsl" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="1">合格</option>
<option value="2" selected="selected">不合格</option>
</select>
</td>
<td style="width: 120px">听力</td>
<td>
<select name="ITl" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="1">合格</option>
<option value="2" selected="selected">不合格</option>
</select>
</td>
</tr>
<tr>
<td>
上肢
</td>
<td>
<select name="ISz" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="1">合格</option>
<option value="2" selected="selected">不合格</option>
</select>
</td>
<td>
左下肢
</td>
<td>
<select name="IZxz" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="1">合格</option>
<option value="2" selected="selected">不合格</option>
</select>
</td>
<td>
右下肢
</td>
<td>
<select name="IYxz" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="1">合格</option>
<option value="2" selected="selected">不合格</option>
</select>
</td>
<td>
躯干颈部
</td>
<td>
<select name="IQgjb" class="<%=EasyUiModel.ComboBox.CLASS %>">
<option value="1">合格</option>
<option value="2" selected="selected">不合格</option>
</select>
</td>
</tr>
<tr>
<td>
体检医院
</td>
<td colspan="2">
<select name="CTjyymc">
<option value="1">湛江</option>
<option value="2" selected="selected">深圳医院</option>
</select>
</td>
<td colspan="3" >
<input type="text" style="width: 80%"/>
</td>
<td  >
体检日期
</td>
<td  style="width: 120px">
<input class="<%=EasyUiModel.DateBox.CLASS %>" style="width: 100%" name="CTjrq"/>
</td>
</tr>
<tr>
<td style="text-align: center;" colspan="8">
<input type="button" value="保存" style="width:10%"/>
<input type="button" value="打印申请表" style="width:10%"/>
<input type="button" value="关闭" style="width:10%"/>
</td>
</tr>
</tbody>
</table>
  </body>
</html>
