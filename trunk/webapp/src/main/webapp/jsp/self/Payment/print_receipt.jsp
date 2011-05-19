<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.self.BaseTransactModel"%>
<%@page import="com.ett.drv.web.action.self.ESessionKey"%>
<%@page import="com.ett.drv.model.self.TransactVehicleModel"%>
<%@page import="com.smartken.kia.core.util.DateTimeUtil"%>
<%@page import="com.ett.drv.model.self.TransactDriverModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'print_receipt.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/self/style.css">
    <%
      BaseTransactModel btrModel=(BaseTransactModel)session.getAttribute(ESessionKey.transact.name());
    %>
  </head>
  
  <body>
  <!-- 
    	XX交警支队车辆管理所
	          机动车受理凭证
	流 水 号：*1101009007479*
	业务类型：补领检验合格标志
	所 有 人：陈斌
	号牌号码：苏B**356
	受理日期：2010-09-09 09:10:02
	所需资料：身份证明复印件
	检验合格标志、行驶证或临时号牌请到1号窗口
	等候领取。
	邮寄费22元，费用将在上门后收取(如果选择邮寄)。
   -->
      <div class="selfmaintophint">
     请获取业务受理凭证
  </div>
    <div class="selfmaincontent">

      <table class="selftable" style="width: 100%">
        <tr>
          <th>流水号</th>
          <td>${flowNo }</td>
        </tr>
       
      <% if(btrModel instanceof TransactVehicleModel) {
    	  TransactVehicleModel trvModel=(TransactVehicleModel)btrModel;
      %>
       
       <tr>
          <th>业务类型</th>
          <td><%=trvModel.getTransactCN() %></td>
        </tr>
        <tr>
          <th>所 有 人</th>
          <td><%=trvModel.getDriverIdName() %></td>
        </tr>
        <tr>
          <th>号牌号码</th>
          <td><%=trvModel.getPlateNo() %></td>
        </tr>
        <tr>
          <th>受理日期</th>
          <td><%=DateTimeUtil.format(trvModel.getCreateDate(),DateTimeUtil.DATE_TIME_FORMAT_DB) %></td>
        </tr>
        <tr>
          <th>所需资料</th>
          <td>身份证明复印件</td>
        </tr>
        <tr>
        <td>&nbsp;</td>
          <td>
           	检验合格标志、行驶证或临时号牌请到1号窗口等候领取。<br/>
	                    邮寄费22元，费用将在上门后收取(如果选择邮寄)。
          </td>
        </tr>
    <%} else if(btrModel instanceof TransactDriverModel ){
        TransactDriverModel trdModel=(TransactDriverModel)btrModel;
    %>
        <tr>
          <th>业务类型</th>
          <td><%=trdModel.getTransact() %></td>
        </tr>
        <tr>
        <th>所 有 人</th>
          <td><%=trdModel.getDriverIdName() %></td>
        </tr>
        <tr>
        <th>驾驶证号码</th>
          <td><%=trdModel.getLicenseNo() %></td>
        </tr>
        <tr>
          <th>受理日期</th>
          <td><%=DateTimeUtil.format(trdModel.getCreateDate(),DateTimeUtil.DATE_TIME_FORMAT_DB) %></td>
        </tr>
        <tr>
          <th>所需资料</th>
          <td>身份证明复印件</td>
        </tr>
        <tr>
        <td>&nbsp;</td>
          <td>
           	检验合格标志、行驶证或临时号牌请到1号窗口等候领取。<br/>
	                    邮寄费22元，费用将在上门后收取(如果选择邮寄)。
          </td>
        </tr>
         <%} %>
      </table>
    

    </div>
  </body>
</html>
