<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.ett.drv.model.admin.DepartmentModel"%>
<%@page import="com.ett.drv.model.admin.UserModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminUserPath=basePath+"/admin/User";
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
			   $("#formUser").form('submit',{
				   url:"<%=adminUserPath%>/do/editUser.action"
				   ,onSubmit:function(){ return $(this).form("validate"); }
				   ,success:function(str){
				    $(this).form("clear");
				     str.messager();
				   }
			   });
			   
   }
   
   </script>
   
  </head>
 
  <body>
  <div class="innerDiv">
     <form id="formUser"  method="post">
     <input type="hidden" name="Id" value="${Id}" />
       <table class="editTable" cellspacing="0">
         <tbody>
           <tr>
             <th>用户名</th>
             <td style="width: 35%">
               <input name="CLoginName" type="text"  value="${CLoginName}"
                 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("用户名必须输入！") %>
                />
             </td>
           <th>全名</th>
             <td style="width: 35%">
               <input name="CFullName" value="${CFullName}" 
               class="<%=EasyUiModel.ValidateBox.CLASS %>"
               <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("全名必须输入！") %>
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
               />
             </td>
           </tr>
           <tr>
            <th>工作号</th>
             <td style="width: 35%">
               <input name="CWorkid" type="text" value="${CWorkid}" 
               class="<%=EasyUiModel.ValidateBox.CLASS %>"
               <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("工作号必须输入！") %>
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
               />
             </td>
            <th>角色号</th>
            <td style="width: 35%">
             <input name="<%= UserModel.F.IRoleid %>" 
                       valuefield="Id"
                   textfield="CName"
                     url="<%=adminUserPath %>/combobox/roleid.action" 
                 value="${IRoleid}"
  	         editable="false"
  	                  class="<%=EasyUiModel.ComboBox.CLASS %>"
  	                <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("角色号必须输入！") %>   
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                   />
             </td>
           </tr>
           <tr>
            <th>状态</th>
             <td style="width: 35%">
             <input class="<%=EasyUiModel.ComboBox.CLASS %>" 
                 name="CState"   
                 value="${CState}"
                 valuefield="CDictValue"
                 textfield="CDictValue"
                 editable="false"
                 url="<%=adminUserPath %>/combobox/state.action"
                 	<%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("状态必须输入！") %>
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
             />
             </td>
            <th>卡号</th>
             <td style="width: 35%">
               <input name="CIdcard"  type="text" value="${CIdcard}" 
               class="<%=EasyUiModel.ValidateBox.CLASS %>"
                <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("卡号必须输入！") %>
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
               />
             </td>
           </tr>
          
           <tr>
           <th>开始IP</th>
             <td style="width: 35%">
               <input name="CBeginip" type="text" value="${CBeginip}" 
               class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("开始IP必须输入！") %>
                   <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("ip") %>
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
               />
             </td>
              <th>结束IP</th> 
             <td style="width: 35%">
               <input name="CEndip" type="text" value="${CEndip}" 
               class="<%=EasyUiModel.ValidateBox.CLASS %>"
               <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("结束IP必须输入！") %>
                 <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("ip") %>
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
               />
             </td>
           </tr>
            <tr>
            <th>部门编号</th>
             <td style="width: 35%">
             <input name="IDepid" 
                       valuefield="Id"
                   textfield="CDepnickname"
                     url="<%=adminUserPath %>/combobox/deptid.action" 
                 value="${IDepid}"
  	         editable="false"
  	                  class="<%=EasyUiModel.ComboBox.CLASS %>"
  	                  <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("部门编号必须输入！") %>
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                   />
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