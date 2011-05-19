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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/self/style.css">
    <%
      DrivingLicenseModel drvlModel=(DrivingLicenseModel)session.getAttribute(ESessionKey.drivinglicense.name());
    %>
    
        <SCRIPT type="text/javascript">
     
      function clickReasonHandler(value,html){
    	  document.getElementById("inputReason").value=value;
    	  document.getElementById("spanReason").innerHTML=html;
      }
          </SCRIPT>
    
  </head>
  
  <body>
  
    <div class="selfmaintophint">
       请确认业务办理信息
  </div>
  
  <div class="divFun">
     <form action="<%=selfDriverPath %>/do/transact.action"  method="post">
     <input type="hidden" name="reason" id="inputReason" />
      <table  class="selftable" style="width:100%" cellspacing="0">
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
           <td><%=drvlModel.getJzqx() %></td>
         </tr>
         
         <tr>
           <th>准驾车型</th>
           <td><%=drvlModel.getZjcx() %></td>
           <th>补证次数</th>
           <td><%=drvlModel.getBzcs() %></td>
         </tr>
        
       <tr>
       <td colspan="4" style="text-align: right">
          <button type="submit" class="btnmain">确认办理</button>
       </td>

     </tr> 
      </table>
      
 
    
      </form>
  </div>
  

  <!-- 档案编号、姓名、驾证期限、补证次数、准驾车型 -->


  </body>
</html>
