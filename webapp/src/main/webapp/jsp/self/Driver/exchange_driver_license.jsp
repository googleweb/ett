<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.self.DrivingLicenseModel"%>
<%@page import="com.ett.drv.web.action.self.ESessionKey"%>
<%@page import="com.ett.drv.model.self.BaseTransactModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String selfDriverPath=basePath+"self/Driver";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'exchange_license.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/self/style.css">
    <%
      DrivingLicenseModel drvlModel=(DrivingLicenseModel)session.getAttribute(ESessionKey.drivinglicense.name());
    %>

  </head>
  
  <body>
  <div class="divFun">
     <h2>驾驶证到期更换</h2>
     <form action="<%=selfDriverPath %>/do/transact.action"  method="post">
      <table border="1" class="tableFun">
         <tr>
           <th>档案编号</th>
           <td><%=drvlModel.getDabh() %></td>
           <th>身份证号码</th>
           <td><%=drvlModel.getSfzmhm() %></td>
         </tr>
         
         <tr>
           <th>姓名</th>
           <td><%=drvlModel.getXm() %></td>
           <th>驾证期限</th>
           <th><%=drvlModel.getJzqx() %></th>
         </tr>
         
         <tr>
           <th>准驾车型</th>
           <td><%=drvlModel.getZjcx() %></td>
           <th>补证次数</th>
           <td><%=drvlModel.getBzcs() %></td>
         </tr>
      </table>
      <p>
      <table class="tableFun" border="1">
          <tr>
            <td>更换原因:        
             <select name="<%=BaseTransactModel.F.Reason %>">
               <option value="A">A:灭失</option>
               <option value="G">G:签满换领登记证书</option>
             </select> 
            </td>
            <td><button type="submit">确认办理</button></td>
          </tr>
      </table>
      </form>
  </div>
  

  <!-- 档案编号、姓名、驾证期限、补证次数、准驾车型 -->

  </body>
</html>
