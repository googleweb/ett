<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.self.VehicleModel"%>
<%@page import="com.ett.drv.web.action.self.ESessionKey"%>
<%@page import="com.ett.drv.model.self.BaseTransactModel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.smartken.kia.core.util.DateTimeUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String selfVehiclePath=basePath+"self/Vehicle";
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
	   VehicleModel vehModel=(VehicleModel)session.getAttribute(ESessionKey.vehicle.name());
	   String hpzl=vehModel.getHpzl()==null?"":vehModel.getHpzl();
	   String hphm=vehModel.getHphm()==null?"":vehModel.getHphm();
	   String zt=vehModel.getZt()==null?"":vehModel.getZt();
	   String clxh= vehModel.getClxh()==null?"":vehModel.getClxh();
	   String fprq= DateTimeUtil.format(vehModel.getFprq(),DateTimeUtil.DATE_TIME_FORMAT_DB);
	   
	%>
 
  </head>
  
  <body>
  
  <div class="divFun">
 
  <form action="<%=selfVehiclePath %>/do/transact.action" method="post">
  <table class="tableFun" border="1">



    

    <tbody>

      <tr>

        <th style="width: 15%">号牌种类</th>

        <td style="width: 20%"><%=vehModel.getHpzl() %></td>

        <th style="width: 15%">号牌号码</th>

        <td style="width: 20%"><%=vehModel.getHphm() %></td>

        <th style="width: 15%">机动车状态</th>

        <td ><%=vehModel.getZt() %></td>

      </tr>

<!-- 
  号牌种类、号牌号码、车辆型号、发牌日期、补换号牌次数
 -->

      <tr>

        <th>车辆型号</th>

        <td><%=vehModel.getClxh() %></td>

        <th>发牌日期</th>

        <td><%=vehModel.getFprq() %></td>

        <th>补换号牌次数</th>
        <td><%=vehModel.getBpcs() %></td>
      </tr>

      

    </tbody>

    

  </table>

  <p>

   <table class="tableFun" border="1">
    <thead>
	    <tr>
	       <td style="width:20%;text-align: center;">申请事项</td>
	       <td style="width:80%;text-align: center;">申请原因及明细</td>
	    </tr>
    </thead>
    
    <tbody>
        <tr>
           <td style="text-align: center;">补领</td>
           <td style="text-align: center;">
                <input type="radio" class="radio" name="reason" />丢失  
                <input type="radio" class="radio" name="reason"/>灭失1面
                <input type="radio" class="radio" name="reason"/>灭失2面
           </td>
        </tr>
        <tr>
           <td style="text-align: center;">换领</td>
           <td style="text-align: center;">
               <input type="radio" class="radio" name="reason" />损坏1面
               <input type="radio" class="radio" name="reason"/>损坏2面
           </td>
        </tr>
        
       <tr>
       <td></td>
       <td style="text-align: right">
          <button type="submit">确认办理</button>
       </td>

     </tr>
    </tbody>
    


   </table>
   
   </form>
   </div>
  </body>
</html>
