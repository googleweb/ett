<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.ett.drv.model.admin.DictModel"%>
<%@page import="com.ett.drv.model.booked.BookedDayLimitModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminDictPath=basePath+"/booked/YuyueDayLimit";
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
             <th>车类型</th>
             <td style="width: 35%">
               <input name="CCartype" type="text"  value="${CCartype}"
                 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                />
             </td>
             <th>间隔时间</th>
             <td style="width: 35%">
               <input name="IDays" type="text"  value="${IDays}"
                 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                />
             </td>
          </tr>   
          <tr>
             <th>科目</th>
             <td style="width: 35%">
                    <input name="IKm" type="text"  value="${IKm}"
                     class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(adminDictPath+"/combobox/Km.action") %>
				 
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("科目类型必须输入！") %>
				  
				  
				    />
				 </td>
				 <th>&nbsp;</th>
                 <td>&nbsp;</td>
				</tr>
		    
             <tr>
             <td colspan="4" style="text-align: right">
             <a class="<%=EasyUiModel.LinkButton.CLASS %>"
                <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SAVE) %>
                onclick="clickSave()" 
             >保存</a>
            </td>
           </tr>
         </tbody>
       </table>
      </form>
    </div>
</body>
</html>