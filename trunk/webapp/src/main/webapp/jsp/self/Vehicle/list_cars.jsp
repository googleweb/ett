<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.web.action.self.ESessionKey"%>
<%@page import="com.ett.drv.model.self.VehicleModel"%>
<%@page import="com.ett.drv.model.self.DrivingLicenseModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String selfVehiclePath=basePath+"self/Vehicle";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list_cars.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/self/style.css">
     <%
        ArrayList<VehicleModel> driverCars=(ArrayList<VehicleModel>)session.getAttribute(ESessionKey.driverCars.name());
        if(driverCars.size()==1){
        	VehicleModel vehModel=driverCars.get(0);
        	String xh=vehModel.getXh();
        	String href=selfVehiclePath+"/to/transact.action?xh="+xh;
        	response.sendRedirect(href);
        }
        DrivingLicenseModel drvLinModel=(DrivingLicenseModel)session.getAttribute(ESessionKey.drivinglicense.name());
     %>
  </head>
  
  <body>
    
      <div class="selfmaintophint">
       请选择需要办理业务的机动车
  </div>
  
    <div class="divFun">
    
    <table class="selftable" cellspacing="0">
     <tr>
        <th style="width: 15%">车主身份证号码</th>
        <td style="width: 15%"><%=drvLinModel.getSfzmhm() %></td>
        <th style="width: 20%">车主姓名</th>
        <td style="width: 15%"><%=drvLinModel.getXm() %></td>
     </tr>
      <tr>
        <th >档案编号 </th>
        <td><%=drvLinModel.getDabh() %></td>
        <th>准驾车型</th>
        <td><%=drvLinModel.getZjcx() %></td>
     </tr>

   </table>
    <br/>
      
     <table  class="selftable"  cellspacing="0" style="width: 100%" >
      <thead class="selftableheader">
        <tr>
          <td style="30%">号牌号码</td>
          <td style="30%">号牌种类</td>
          <td style="15%">机动车状态</td>
          <td ></td>
        </tr>
      </thead>
      <tbody>
      <%
        for(Iterator<VehicleModel> it=driverCars.iterator();it.hasNext();){
        	VehicleModel tmpVeh=it.next();
      %>
         <tr>
          <td><%=tmpVeh.getHphm() %></td>
          <td><%=tmpVeh.getHpzlName() %></td>
          <td><%=tmpVeh.getZtName() %></td>
          <td>
          <form action="<%=selfVehiclePath %>/to/transact.action" method="post">
            <input type="hidden" name="<%=VehicleModel.F.xh %>" value="<%=tmpVeh.getXh() %>" />
            <button type="submit" class="btnmain">办理业务</button>
          </form>
        </tr>
      <%
        }
      %>
       
 
      </tbody>
    </table>
    </div>
  </body>
</html>
