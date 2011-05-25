<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="com.ett.drv.model.self.TransactDriverModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

  </head>
  
  <body>
  
      <div class="selfmaintophint">
           请选择驾驶证业务
     </div>
  
     <div class="divFun">

    <!--  
		<br /><br /> <input onclick="javascript:document.location.href='<s:url value="/self/Driver/do/select_transact.action?transact=exchange_driver_license" />';" type="button"  class="divMainBtn" style="background: url('<s:url value="/images/jszdqhz.jpg"/>')" />
		<br /><br /> <input onclick="javascript:document.location.href='<s:url value="/self/Driver/do/select_transact.action?transact=lost_driver_license" />';" type="button"  class="divMainBtn" style="background: url('<s:url value="/images/jszys.jpg"/>')" />
		<br /><br /> <input onclick="javascript:document.location.href='<s:url value="/self/Driver/do/select_transact.action?transact=destroy_driver_license" />';" type="button"  class="divMainBtn" style="background: url('<s:url value="/images/jszsh.jpg"/>')" />
  -->     
     
     		<input class="btnmain" value="驾驶证到期更换"
									onclick="javascript:document.location.href='<s:url value="/self/idCardReader!func.action"/>?capture=false&agent=true&returnurl=<s:url value="Identity/do/identityDriver.action?Transact=exchange_driver_license"/>';"
									type="button" />
		<p/>
		<input class="btnmain" value="驾驶证损坏"
									onclick="javascript:document.location.href='<s:url value="/self/idCardReader!func.action"/>?capture=false&agent=true&returnurl=<s:url value="Identity/do/identityDriver.action?Transact=destory_driver_license"/>';"
									type="button" />
        <p/>
		<input class="btnmain" value="驾驶证遗失"
									onclick="javascript:document.location.href='<s:url value="/self/idCardReader!func.action"/>?capture=false&agent=true&returnurl=<s:url value="Identity/do/identityDriver.action?Transact=lost_driver_license"/>';"
									type="button" />
     </div>
  </body>
</html>


