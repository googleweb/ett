<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.self.DeviceSnModel"%>
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
    
    <title>My JSP 'editdeviceSn.jsp' starting page</title>
    
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
   .appendContext("var action=\"{0}\";",adminDeviceActionPath+"/do/editDeviceSn.action")
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
             <th>接口ID</th>
             <td style="width: 35%">
               <input name="deviceSn.<%=DeviceSnModel.F.jkid %>" value="${deviceSn.jkid}" />
             </td>
             <th>接口序列号</th>
             <td style="width: 35%">
               <input name="deviceSn.<%=DeviceSnModel.F.jkxlh %>" value="${deviceSn.jkxlh}" />
             </td>
           </tr>
           <tr>
            <th>接口名</th>
             <td style="width: 35%">
               <input name="deviceSn.<%=DeviceSnModel.F.jkname %>" value="${deviceSn.jkname}" />
             </td>
            <th>设备IP</th>
             <td style="width: 35%">
               <input name="deviceSn.<%=DeviceSnModel.F.deviceIp %>" value="${deviceSn.deviceIp}" />
             </td>
           </tr>
           <tr>
            <th>SN</th>
             <td style="width: 35%">
               <input name="deviceSn.<%=DeviceSnModel.F.sn %>" value="${deviceSn.sn}" />
             </td>
            <th>关键字</th>
             <td style="width: 35%">
               <input name="deviceSn.<%=DeviceSnModel.F.keywords %>" value="${deviceSn.keywords}" />
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
