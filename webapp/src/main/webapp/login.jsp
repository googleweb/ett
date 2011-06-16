<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminUserPath=basePath+"admin/User";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<jsp:include page="/plugin/index.jsp">
	 <jsp:param value="jquery,easyui" name="plugin"/>
	</jsp:include>
     <jsp:include page="/css/index.jsp"></jsp:include>
     <jsp:include page="/js/index.jsp"></jsp:include>

   
   <script type="text/javascript">
   
   </script>

  </head>
  
  <body style="padding-top: 5%">
 <center>
   <div id="loginDiv" style=" background-image: url('<%=basePath %>images/mainback.jpg'); width:595px;height:53px;padding-top: 230px;">
        <form action="<%=adminUserPath %>/do/login.action" method="post">

          用户帐号<input name="CLoginName" style="width: 150px" type="text" class="easyui-validatebox" required="true" value="" ></td>  &nbsp;&nbsp;
         密码 <input name="CPwd" style="width: 150px" type="password" class="easyui-validatebox" required="true" value=""></td>  &nbsp;&nbsp;          
   <input type="image" src="<%=basePath %>images/login_btn.gif" style="width: 74px;height: 24px"/>
    </form>
    </div>
</center>
  </body>
</html>
