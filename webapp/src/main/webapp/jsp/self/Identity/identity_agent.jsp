<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.self.BaseTransactModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String selfIdentifyPath=basePath+"self/Identity";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'identity_agent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/self/style.css">

  </head>
  
  <body>
  
  <div class="selfmaintophint">
       请将代理人身份证放置于下图所以位置
  </div>
  
  <div class="divFun">
   <form action="<%=selfIdentifyPath %>/do/identityAgent.action" method="post">
     <input type="hidden" name="<%=BaseTransactModel.F.AgentIdNo %>" value="350128198403194910" />
     <input type="hidden" name="<%=BaseTransactModel.F.AgentIdName %>" value="陈必武" />
     <input type="image" src="<%=basePath%>/images/idcardposition.jpg" style="width: 399px;height:262px " />
   </form>
   </div>
  </body>
</html>
