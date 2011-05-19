<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String selfPaymentPath=basePath+"self/Payment";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'payment.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/self/style.css">

  </head>
  
  <body>
  
      <div class="selfmaintophint">
       请放入现金钞票
  </div>
  
       <div class="divFun" style="text-align: center;">
 
    <span class="spanMsg">本次需要支付金额为30元</span><p>
     
     <br /><br /> <input onclick="javascript:document.location.href='<%=selfPaymentPath %>/do/payment_cash.action';" type="button"  class="divMainBtn bgSurepay"  />
  </div>
  </body>
</html>
