<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String selfIdentifyPath=basePath+"self/Identity";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'collect_image.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
   <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/self/style.css">

  </head>
  
  <body>
    
      <div class="selfmaintophint">
           请对准摄像头，点击拍照
     </div>
  
    <div class="selfmaincontent" style="padding-left: 50px">
    
    <table class="selftable" style="width: 100%" >
      <tr>
        <td style="text-align: center;width: 50%"><img id="a" style="width: 200px;height: 240px" src="<%=basePath %>/images/test/captureImg.jpg" /></td>
        <td style="text-align: center;width: 50%"><img id="b" style="width: 200px;height: 240px"  /></td>
      </tr>
      <tr>
        <td style="text-align: center;">
           <button type="button" class="btnmain" onclick="document.getElementById('b').src=document.getElementById('a').src;">拍摄</button>
        </td>
        <td style="text-align: center;">
         <form action="<%=selfIdentifyPath %>/do/collect_image.action" method="post">
           <button type="submit" class="btnmain">确认</button>
         </form>
         </td>
      </tr>
    </table>
    
    </div>
  </body>
</html>
