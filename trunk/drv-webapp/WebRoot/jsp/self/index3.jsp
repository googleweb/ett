<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String selfVehiclePath=basePath+"self/Vehicle";
String selfDriverPath=basePath+"self/Driver";
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
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/self/style.css">

    <% 
      request.getSession().invalidate();
    %>
  </head>
  
  <body>
      <div class="divHeader">
        <a href="<%=basePath%>jsp/self/main.jsp" target="frameMain">
           <div class="btnReturn" style="position: relative; left: 820px;top: 50px">
           </div>
        </a>
      </div>
 
      <iframe name="frameMain" style="width: 1024px;height: 502px" src="<%=basePath%>jsp/self/main.jsp" frameborder="0" scrolling="no">
      </iframe>
  </body>
</html>
