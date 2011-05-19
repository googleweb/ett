<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.self.HardwareModel"%>
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
    
    <title>My JSP 'editHardware.jsp' starting page</title>
    
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
   .appendContext("if(yes){  }")
   ;
   
   JsFunctionModel clickSaveHandler=new JsFunctionModel("clickSaveHandler",new String[]{});
   clickSaveHandler
   .appendContext("var action=\"{0}\";",adminDeviceActionPath+"/do/editHardware.action")
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
             <th>硬件类型</th>
             <td style="width: 35%">
               <input name="hardware.<%=HardwareModel.F.catalog %>" value="${hardware.catalog}" />
             </td>
             <th>硬件品牌</th>
             <td style="width: 35%">
               <input name="hardware.<%=HardwareModel.F.brand %>" value="${hardware.brand}" />
             </td>
           </tr>
           <tr>
            <th>比特率</th>
             <td style="width: 35%">
               <input name="hardware.<%=HardwareModel.F.baud %>" value="${hardware.baud}" />
             </td>
            <th>端口号</th>
             <td style="width: 35%">
               <input name="hardware.<%=HardwareModel.F.com %>" value="${hardware.com}" />
             </td>
           </tr>
           <tr>
            <th>关联ID</th>
             <td style="width: 35%">
               <input name="hardware.<%=HardwareModel.F.deviceId %>" value="${hardware.deviceId}" />
             </td>
            <th>停止位</th>
             <td style="width: 35%">
               <input name="hardware.<%=HardwareModel.F.stopbits %>" value="${hardware.stopbits}" />
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
