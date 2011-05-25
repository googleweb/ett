<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="com.ett.drv.model.self.VehicleModel"%>
<%@page import="com.ett.drv.web.action.self.ESessionKey"%>
<%@page import="com.ett.drv.model.self.BaseTransactModel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.smartken.kia.core.util.DateTimeUtil"%>
<%@page import="com.ett.drv.model.self.TransactVehicleModel"%>
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
	   TransactVehicleModel trVehModel=(TransactVehicleModel)session.getAttribute(ESessionKey.transact.name());
	   String hpzl=vehModel.getHpzl()==null?"":vehModel.getHpzl();
	   String hphm=vehModel.getHphm()==null?"":vehModel.getHphm();
	   String zt=vehModel.getZt()==null?"":vehModel.getZt();
	   String clxh= vehModel.getClxh()==null?"":vehModel.getClxh();
	   String fprq= DateTimeUtil.format(vehModel.getFprq(),"yyyy-MM-dd");
	   
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
       请选择业务办理原因
  </div>
  
  <div class="selfmaincontent">
 
  <form action="<%=selfVehiclePath %>/do/transact.action" method="post">
    <input type="hidden" name="reason" id="inputReason" />
  
  <table class="selftable" style="width: 100%" cellspacing="0" >

    <tbody>

      <tr>

        <th style="width: 20%">号牌种类</th>

        <td style="width: 20%"><%=vehModel.getHpzl() %></td>

        <th style="width: 15%">号牌号码</th>

        <td style="width: 20%"><%=vehModel.getHphm() %></td>

        <th style="width: 15%">机动车状态</th>

        <td ><%=vehModel.getZtName()  %></td>

      </tr>

<!-- 
  号牌种类、号牌号码、车辆型号、发牌日期、补换号牌次数
 -->

      <tr>


        <th>发牌日期</th>

        <td><%=fprq %></td>

        <th>补换号牌次数</th>
        <td><%=vehModel.getBpcs() %></td>
        
        <td colspan="2">&nbsp;</td>
      </tr>

      <tr>
         <th>申请原因</th>
         <td colspan="10"><span id="spanReason"></span></td>
      </tr>

    </tbody>

    

  </table>



   <table class="selftable" style="width: 100%" cellspacing="0" >
  
    <tr>
       <th style="width: 20%">申请原因及明细</th>
       <td style="text-align: left;">
             <% if(TransactVehicleModel.ETransact.exchange_plate.name().equalsIgnoreCase(trVehModel.getTransact()) ) {%>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('A',this.innerHTML)">丢失</button>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('B',this.innerHTML)" >灭失1面</button>
			        <br/>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('C',this.innerHTML)" >灭失2面</button>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('D',this.innerHTML)" >损坏1面</button>
			        <br/>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('E',this.innerHTML)" >损坏2面</button>
			           
			   <%} else if (TransactVehicleModel.ETransact.exchange_vehicle_license.name().equalsIgnoreCase(trVehModel.getTransact()) ) { %>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('F',this.innerHTML)" >丢失</button>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('G',this.innerHTML)" >灭失</button>
			        <br/>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('H',this.innerHTML)">换领</button>
			
			   <%} else if (TransactVehicleModel.ETransact.exchange_qualified.name().equalsIgnoreCase(trVehModel.getTransact()) ) { %>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('I',this.innerHTML)" >在登记地车辆管理所申请 </button>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('J',this.innerHTML)" >在登记地以外车辆管理所申请</button>
			        <br/>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('K',this.innerHTML)" >丢失</button>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('L',this.innerHTML)" >灭失</button>
			        <br/>
			        <button type="button" class="btnmain" onclick="clickReasonHandler('M',this.innerHTML)" >换领</button>
			   
			   <%} else {} %>
       </td>
    </tr>
      

   
   
      <tr>
       <td colspan="2" style="text-align: right">
          <button type="submit" class="btnmain">确认办理</button>
       </td>

     </tr>
   
    </tbody>
    


   </table>
   
   </form>
   </div>
  </body>
</html>
