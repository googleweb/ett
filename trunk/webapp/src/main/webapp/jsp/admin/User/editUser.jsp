<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menuConfig-success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<jsp:include page="/plugin/index.jsp">
	 <jsp:param value="jquery,easyui" name="plugin"/>
	</jsp:include>
	<jsp:include page="/js/index.jsp"></jsp:include>
   <jsp:include page="/css/index.jsp"></jsp:include>
   
   
   <script type="text/javascript">
    
   function clickSave(){
	   
	   $.messager.confirm('操作提示','确认保存',function(yes){
		   if(yes){
			   $("#formUser").form('submit',{
				   url:"http://localhost:8080/webapp/admin/User/do/editUser.action"
				   ,
				   success:function(str){
					   var json=Kia.util.strToJson(str);
					   Kia.util.handleJsonResult(json);
				   }
			   });
		   }
	   })
   }
   
   </script>
   
  </head>
 
  <body><%--
   修改用户页面 ${fullName}
   <form name="form">
   		<input name="name" type="text" value="${loginName}">
   </form>
   --%><div class="innerDiv">
     <form id="formUser"  method="post">
       <table class="editTable" cellspacing="0">
         <tbody>
           <tr>
             <th>用户名</th>
             <td style="width: 35%">
               <input name="loginName" type="text"  value="${loginName}" />
             </td>
            <th>密码</th>
             <td style="width: 35%">
               <input name="pwd" type="text"  value="${pwd}" />
             </td>
           </tr>
           <tr>
            <th>工作号</th>
             <td style="width: 35%">
               <input name="workid" type="text" value="${workid}" />
             </td>
            <th>角色号</th>
             <td style="width: 35%">
              <input name="roleid" value="${roleid}" />
             </td>
           </tr>
           <tr>
            <th>状态</th>
             <td style="width: 35%">
               <input name="state"  type="text" value="${state}" />
             </td>
            <th>卡号</th>
             <td style="width: 35%">
               <input name="idcard"  type="text" value="${idcard}" />
             </td>
           </tr>
           <tr>
            <th>部门编号</th>
             <td style="width: 35%">
               <input name="workid"  type="text" value="${workid}" />
             </td>
            <th>全名</th>
             <td style="width: 35%">
               <input name="fullName" value="${fullName}" />
             </td>
           </tr>
           <tr>
           <th>开始IP</th>
             <td style="width: 35%">
               <input name="beginip" type="text" value="${beginip}" />
             </td>
              <th>结束IP</th> 
             <td style="width: 35%">
               <input name="endip" type="text" value="${endip}" />
             </td>
           </tr>
           <tr>
             <td colspan="4" style="text-align: right">
             <a class="<%=EasyUiModel.LinkButton.CLASS %>"
                <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SAVE) %>
                onclick="clickSave()" 
             >保存</a>
           </tr>
         </tbody>
       </table>
      </form>
    </div>
</body>
</html>