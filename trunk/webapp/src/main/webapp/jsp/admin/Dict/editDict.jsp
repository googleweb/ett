<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.ett.drv.model.admin.DepartmentModel"%>
<%@page import="com.ett.drv.model.admin.DictModel"%>
<%@page import="com.ett.drv.model.admin.DictTypeModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminDictPath=basePath+"/admin/Dict";
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
			   $("#formDict").form('submit',{
				   url:"<%=adminDictPath%>/do/editDict.action"
				   ,onSubmit:function(){ return $(this).form("validate"); }
				   ,success:function(str){
				    $(this).form("clear");
				     str.messager();
				   }
			   });
		   }
	     });
   }
   
   </script>
   
  </head>
 
  <body>
  <div class="innerDiv">
     <form id="formDict"  method="post">
     <input type="hidden" name="Id" value="${id}" />
       <table class="editTable" cellspacing="0">
         <tbody>
          <tr>
             <th>字典类型</th>
             <td style="width: 35%">
                    <input name="CTypename" type="text"  value="${CTypename}"
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(adminDictPath+"/combobox/DictType.action") %>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictTypeModel.F.CTypename.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictTypeModel.F.CTypename.name()) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("字典类型必须输入！") %>
				   
				  
				    />
		     <th>&nbsp;</th><td>&nbsp;</td>
           
           </tr>
           <tr>
             <th>字典名</th>
             <td style="width: 35%">
               <input name="CDictText" type="text"  value="${CDictText}"
                 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                />
             </td>
            <th>字典值</th>
             <td style="width: 35%">
               <input name="CDictValue" type="text"  value="${CDictValue}" 
               	class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
               />
             </td>
           </tr>
           <tr>
            <th>CDes1</th>
             <td style="width: 35%">
               <input name="CDes1" type="text" value="${CDes1}" 
               class="<%=EasyUiModel.ValidateBox.CLASS %>"
               
               />
             </td>
           
          
            <th>CDes2</th>
             <td style="width: 35%">
               <input name="CDes2" type="text" value="${CDes2}" 
               class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 
               />
             </td>
            </tr>
            <tr>
            <th>CDes3</th>
             <td style="width: 35%">
               <input name="CDes3" type="text" value="${CDes3}" 
               class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 
               />
             </td>
          
            <th>状态</th>
             <td style="width: 35%">
               <input name="CState" type="text" value="${CState}" 
               class="<%=EasyUiModel.ValidateBox.CLASS %>"
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