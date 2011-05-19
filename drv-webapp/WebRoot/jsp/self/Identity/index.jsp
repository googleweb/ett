<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="com.ett.drv.model.self.BaseTransactModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String selfIdentityPath=basePath+"self/Identity";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'select_applicat.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/self/style.css">

  </head>
  
  <body>
  
      <div class="selfmaintophint">
       请选择业务申请方式
  </div>
  
    <div class="divFun"> 
       
      <br /><br /> 
      <input onclick="javascript:document.location.href='<s:url value="/self/idCardReader.action"/>?capture=false&agent=false&returnurl=<%=selfIdentityPath %>/do/identityDriver.action?applicat=<%=BaseTransactModel.EApplicat.driver %>';" 
      type="button"  class="divMainBtn bgCzbrsq"  />
	  <br /><br /> 
	  <input onclick="javascript:document.location.href='<s:url value="/self/idCardReader.action"/>?capture=false&agent=true&returnurl=<%=selfIdentityPath %>/do/identityDriver.action?applicat=<%=BaseTransactModel.EApplicat.agent %>';" 
      type="button"  class="divMainBtn bgDlrsq"  /> 
      
    </div>
    </body>
</html>
