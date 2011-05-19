<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.self.TransactVehicleModel"%>
<%@page import="com.ett.drv.web.action.self.ESessionKey"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String selfVehiclePath=basePath+"self/Vehicle";
//TransactVehicleModel.ETransact.exchange_vehicle_license
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
           请选择机动车业务
     </div>
		<div class="divFun">
		<input class="btnmain" value="<%=TransactVehicleModel.Transact.EXCHANGE_PLATE %>"
									onclick="javascript:document.location.href='<s:url value="/self/idCardReader!func.action"/>?capture=false&agent=true&returnurl=<s:url value="Identity/do/identityDriver.action"/>?transact=<%=TransactVehicleModel.ETransact.exchange_plate %>';"
									type="button" />
		<p/>
		<input class="btnmain" value="<%=TransactVehicleModel.Transact.EXCHANGE_QUALIFIED %>"
									onclick="javascript:document.location.href='<s:url value="/self/idCardReader!func.action"/>?capture=false&agent=true&returnurl=<s:url value="Identity/do/identityDriver.action"/>?transact=<%=TransactVehicleModel.ETransact.exchange_qualified %>';"
									type="button" />
        <p/>
		<input class="btnmain" value="<%=TransactVehicleModel.Transact.EXCHANGE_VEHICLE_LICENSE %>"
									onclick="javascript:document.location.href='<s:url value="/self/idCardReader!func.action"/>?capture=false&agent=true&returnurl=<s:url value="Identity/do/identityDriver.action"/>?transact=<%=TransactVehicleModel.ETransact.exchange_vehicle_license %>';"
									type="button" />

		</div>
  </body>
</html>
