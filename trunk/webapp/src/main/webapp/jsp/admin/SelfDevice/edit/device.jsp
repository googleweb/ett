<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.self.DeviceModel"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminDeviceActionPath=basePath+"admin/SelfDevice";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editdevice.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="/plugin/index.jsp">
	   <jsp:param  name="plugin" value="jquery,easyui"/>
	</jsp:include>
    <jsp:include page="/css/index.jsp"></jsp:include>
    <jsp:include page="/js/index.jsp"></jsp:include>

   <%
      String formEdit="formEdit";
   
   JsFunctionModel saveSucessHandler=new JsFunctionModel("saveSucessHandler",new String[]{"yes"});
   saveSucessHandler
   .appendContext("if(yes)'{' {0}.form(\"clear\"); '}'",JQueryModel.id(formEdit))
   ;
   
   JsFunctionModel clickSaveHandler=new JsFunctionModel("clickSaveHandler",new String[]{});
   clickSaveHandler
   .appendContext("var action=\"{0}\";",adminDeviceActionPath+"/do/editDevice.action")
   .appendContext("{0}.form(\"submit\",'{'",JQueryModel.id(formEdit))
   .appendContext("url:action")
   .appendContext(",success:function(str){ var json=Kia.util.strToJson(str);Kia.util.handleJsonResult(json,saveSucessHandler); }")
   .appendContext("});")
   ;
   
   JsContextModel context=new JsContextModel();
   
   JsContextModel funContext=new JsContextModel();
   funContext.appendScript(clickSaveHandler);
   funContext.appendScript(saveSucessHandler);
   %>
   
   
        <script type="text/javascript">
       <%=funContext.toScirpt()%> 
       <%=JQueryModel.DOC_READY_START%>
       <%=context.toScirpt()%>
       <%=JQueryModel.DOC_READY_END%>
    </script>

  </head>
  
  <body>
    <div class="innerDiv">
     <form id="<%=formEdit %>" method="post" >
       <table class="editTable" cellspacing="0">
         <tbody>
           <tr>
             <th>设备类型</th>
             <td style="width: 35%">
               <input name="device.<%=DeviceModel.F.CCatalog %>" value="${device.CCatalog}" />
             </td>
             <th>设备种类</th>
             <td style="width: 35%">
               <input name="device.<%=DeviceModel.F.Devicetype %>" value="${device.Devicetype}" />
             </td>
           </tr>
           <tr>
            <th>机器名</th>
             <td style="width: 35%">
               <input name="device.<%=DeviceModel.F.CMachineName %>" value="${device.CMachineName}" />
             </td>
            <th>终端地址</th>
             <td style="width: 35%">
               <input name="device.<%=DeviceModel.F.CPlaceAddress %>" value="${device.CPlaceAddress}" />
             </td>
           </tr>
           <tr>
            <th>MAC地址1</th>
             <td style="width: 35%">
               <input name="device.<%=DeviceModel.F.CMac1%>" value="${device.CMac1}" />
             </td>
            <th>MAC地址2</th>
             <td style="width: 35%">
               <input name="device.<%=DeviceModel.F.CMac2 %>" value="${device.CMac2}" />
             </td>
           </tr>
           <tr>
            <th>IP地址1</th>
             <td style="width: 35%">
               <input name="device.<%=DeviceModel.F.CIp1%>" value="${device.CIp1}" />
             </td>
            <th>IP地址2</th>
             <td style="width: 35%">
               <input name="device.<%=DeviceModel.F.CIp2 %>" value="${device.CIp2}" />
             </td>
           </tr>
           
           <tr>
             <td colspan="4" style="text-align: right">
               <a class="<%=EasyUiModel.LinkButton.CLASS %>"
                 <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SAVE) %>
                 onclick="<%=clickSaveHandler.getFunName() %>()"
               >保存</a>
             </td>
           </tr>
         </tbody>
       </table>
      </form>
    </div>
  </body>
</html>
