<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  %>
<%@page import="com.ett.drv.model.self.BaseTransactModel"%>
<%@page import="com.ett.drv.web.action.self.ESessionKey"%>
<%@page import="com.ett.drv.model.self.TransactVehicleModel"%>
<%@page import="com.smartken.kia.core.util.DateTimeUtil"%>
<%@page import="com.ett.drv.model.self.TransactDriverModel"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'print_receipt.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/self/style.css">
    <script type="text/javascript" src="<%=basePath %>/js/jquery-1.5.2.min.js"></script>
    <%
      BaseTransactModel btrModel=(BaseTransactModel)session.getAttribute(ESessionKey.transact.name());
    %>
    
    <script type="text/javascript">
       
    <%=JQueryModel.DOC_READY_START %>
    try{
   /**  

    var flowNo=$("#spanFlowNo").html();
    var transact=$("#spanTransact").html();
    var driverIdName=$("#spanDriverIdName").html();
    var flowNo=$("#spanNo").html();
    var flowNo=$("#spanCreateDate").html();

    **/
	var printline="";	
    
    ETTSelfHotPrinterActiveX1.LoadReceiptDll();
    ETTSelfHotPrinterActiveX1.OpenDeviceEx(1);
    ETTSelfHotPrinterActiveX1.SetTextStyleEx("DoubleWidth|DoubleHeight|Boldface");
    var glbm=$("#inputGlbm").val()||"";
    printline=glbm;
    ETTSelfHotPrinterActiveX1.PrintLineEx(printline);
    printline="\t机动车受理凭证";
    ETTSelfHotPrinterActiveX1.PrintLineEx(printline);
    ETTSelfHotPrinterActiveX1.SetTextStyleEx("Normal");
    ETTSelfHotPrinterActiveX1.PrintLineEx("");
    $("#printTable tr").each(function(index){
       var thText=$(this).find("th:eq(0)").text();
       var tdText=$(this).find("span:eq(0)").text();
       
       if(thText==""){
    	   printline=tdText;
       }else{
    	   printline=thText+":"+tdText;
       }
       //alert(printline);
       //ETTSelfHotPrinterActiveX1.AddString(printline);
       ETTSelfHotPrinterActiveX1.PrintLineEx(printline);
       
    });
     ETTSelfHotPrinterActiveX1.CutPaperEx();
     ETTSelfHotPrinterActiveX1.CloseDeviceEx();
     ETTSelfHotPrinterActiveX1.Destro+yDll();
    //ETTSelfHotPrinterActiveX1.AddString(" ");
    //ETTSelfHotPrinterActiveX1.PrintHot(1,10);
    
    }catch(ex){alert(ex);}
    <%=JQueryModel.DOC_READY_END %>
    
    </script>
    
  </head>
  
  <body>
  <!-- 
    	XX交警支队车辆管理所
	          机动车受理凭证
	流 水 号：*1101009007479*
	业务类型：补领检验合格标志
	所 有 人：陈斌
	号牌号码：苏B**356
	受理日期：2010-09-09 09:10:02
	所需资料：身份证明复印件
	检验合格标志、行驶证或临时号牌请到1号窗口
	等候领取。
	邮寄费22元，费用将在上门后收取(如果选择邮寄)。
   -->
   <OBJECT ID="ETTSelfHotPrinterActiveX1" 
 CLASSID="CLSID:CADA7DA3-25C6-43E6-B5C5-7A5E949A5296">
    <PARAM NAME="_Version" VALUE="65536">
    <PARAM NAME="_ExtentX" VALUE="2646">
    <PARAM NAME="_ExtentY" VALUE="1323">
    <PARAM NAME="_StockProps" VALUE="0">
</OBJECT>
<input id="inputGlbm" value="${device.glbmName}" type="hidden" />
      <div class="selfmaintophint">
     请获取业务受理凭证
  </div>
    <div class="selfmaincontent">

      <table class="selftable" style="width: 100%" id="printTable">
        <tr>
          <th>流水号</th>
          <td><span id="spanFlowNo">${flowNo }</span></td>
        </tr>
       
      <% if(btrModel instanceof TransactVehicleModel) {
    	  TransactVehicleModel trvModel=(TransactVehicleModel)btrModel;
      %>
       
       <tr>
          <th>业务类型</th>
          <td><span id="spanTransact"><%=trvModel.getTransact() %></span></td>
        </tr>
        <tr>
          <th>所 有 人</th>
          <td><span id="spanDriverIdName"><%=trvModel.getDriverIdName() %></span></td>
        </tr>
        <tr>
          <th>号牌号码</th>
          <td><span id="spanNo"><%=trvModel.getPlateNo() %></span></td>
        </tr>
        <tr>
          <th>受理日期</th>
          <td><span id="spanCreateDate"><%=DateTimeUtil.format(trvModel.getCreateDate(),DateTimeUtil.DATE_TIME_FORMAT_DB) %></span></td>
        </tr>
    <%} else if(btrModel instanceof TransactDriverModel ){
        TransactDriverModel trdModel=(TransactDriverModel)btrModel;
    %>
        <tr>
          <th>业务类型</th>
          <td><span id="spanTransact"><%=trdModel.getTransact() %></span></td>
        </tr>
        <tr>
        <th>所 有 人</th>
          <td><span id="spanDriverIdName"><%=trdModel.getDriverIdName() %></span></td>
        </tr>
        <tr>
        <th>驾驶证号码</th>
          <td><span id="spanNo"><%=trdModel.getLicenseNo() %></span></td>
        </tr>
        <tr>
          <th>受理日期</th>
          <td><span id="spanCreateDate"><%=DateTimeUtil.format(trdModel.getCreateDate(),DateTimeUtil.DATE_TIME_FORMAT_DB) %></span></td>
        </tr>
 
         <%} %>
        <tr>
          <th>所需资料</th>
          <td><span>身份证明复印件</span></td>
        </tr>
        <tr>
        <td></td>
          <td>
            <span>
           	检验合格标志、行驶证或临时号牌请到1号窗口等候领取。<br/>
	                    邮寄费22元，费用将在上门后收取(如果选择邮寄)。
	        </span>
          </td>
        </tr>
      </table>
    

    </div>
  </body>
</html>
