<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.ett.drv.model.admin.UserModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.ett.model.*" %>
<%@page import="com.ett.drv.model.preinput.StudentApplyInfoModel"%>
<%@page import="com.ett.drv.model.admin.DictModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searcharea.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<jsp:include page="/plugin/index.jsp">
      <jsp:param value="jquery,easyui" name="plugin"/>
    </jsp:include>
    <jsp:include page="/css/index.jsp"></jsp:include>
    <jsp:include page="/js/index.jsp"></jsp:include>
  </head>
  <script type="text/javascript">
  $(document).ready(function(){ 
  
	$("#test").datagrid({fit:true,
	pagination:false,
	
	columns:[ 
	[ 
	{field:"",title:"Id",width:100},
	{field:"",title:"省份",width:100},
	{field:"",title:"行政区划",width:100},
	{field:"",title:"地点名称",width:100}
	
		
	]
	],
	pagination:true,
	url:"<%=basePath%>"+"preinput/List/search/area.action"
	
	
	
	} 
);    //   end:$("#tableDG").datagrid
	
}); //$(document).ready
  </script>
  
  <body class="<%=EasyUiModel.Layout.CLASS %>">
    <div  <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_NORTH) %>  
       style="height: 50px">
    
    <form method="post" id="formSearch">
         <table class="editTable" cellspacing="0" >
         <tr>   
              <td style="width: 260px;font-size: small"> 
              		行政区划名称: <input name="IChecked" type="text"  />
              </td>
              <td>
                 <a class="easyui-linkbutton"  id="aSearch"
                    onclick="searchCheck()"
                 >查询</a>
              </td>      
            </tr>
         </table>
      </form>
      </div>
      <div  <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_CENTER) %>>
	<table id="test" ></table>
	</div>
	<div id="edit"></div>
 </body>
</html>
