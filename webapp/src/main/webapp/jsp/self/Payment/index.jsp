<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String selfPaymentPath=basePath+"self/Payment";

String href=basePath+"self/fee!feeTypeSelect.action?money=35&returnurl="+selfPaymentPath+"/do/payment_success.action";

response.sendRedirect(href);
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
     请选择支付方式
  </div>
  
   <div class="divFun">

      <br /><br /> <input onclick="javascript:document.location.href='<%=selfPaymentPath %>/to/payment_cash.action';" type="button"  class="divMainBtn bgXjzf"  />
	  <br /><br /> <input onclick="javascript:document.location.href='<%=selfPaymentPath %>/to/payment_pos.action';" type="button"  class="divMainBtn bgYlkzf"  />
  
   </div>
  </body>
</html>
