<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.ett.drv.model.admin.DepartmentModel"%>
<%@page import="com.ett.drv.model.admin.UserModel"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String adminRolePath=basePath+"/admin/Role";
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
   
   <% %>
   <script type="text/javascript">
   
   
   function clickSave(){
			   $("#formUser").form('submit',{
				   url:"<%=adminRolePath%>/do/modifyRole.action"
				   ,onSubmit:function(){ return $(this).form("validate"); }
				   ,success:function(str){
				    $(this).form("clear");
				     str.messager();
				   }
			   });
 }
   
   var jsonMenus=${menus};
  
   
  <%=JQueryModel.DOC_READY_START%>
	     
        	 $.each(jsonMenus,function(index,item){
        		 var id=item["Menuid"]||"";
        		 if(id=="")return true;
        		 var fieldset=$("<fieldset></fieldset>");
        		 fieldset.attr("id","menu_"+id);
        		 var isparent=item["Isparent"];
	 	         if(isparent==1){
	 	        	var  topCheckbox=$("<input type='checkbox' />");
	 	        	topCheckbox.addClass("topMenu").attr("name","CRolestring").val(item["Menuid"]);
	 	        	var  legend=$("<legend>"+item["Menutext"]+"</legend>");
	 	        	legend.append(topCheckbox);
	 	            fieldset.append(legend);
	 	        	$("#fieldset").append(fieldset);
	 	         }      		 
        	 });
        	 $.each(jsonMenus,function(index,item){
        		 try{
        		 var isparent=item["Isparent"];
        		 var parentId=item["Parentid"]
                 if(isparent==1) return true;
                 var id=item["Menuid"];
	 	         var input= $("<input />");
	    		 var fieldset=$("#menu_"+parentId);
	    		 var text=item["Menutext"]||"";
	    		 input.attr("name","CRolestring").attr("type","checkbox").val(id);
	    		 var div=$("<div></div>");
	    		 div.append(text+":").append(input);
	    		 fieldset.append(div);    	
	    		 }catch(ex){alert(ex);}	    	
	    	 });	    		  	    	 				
	    
         var qxian=$("#cRolestring").val();
             var qxians=qxian.split(";");
	       	 $.each(qxians,function(n,item){
	    			if(item==null||item.length==0) return true;
	    			$(":checkbox[value="+item+"]").attr("checked","checked");	
	    	 });		
	       	 
	    $(".topMenu").each(function(){
	    	$(this).click(function(){
	    		var checked=$(this).attr("checked");
	    		var id=$(this).val();
	    		$("#menu_"+id).find(":checkbox").each(function(){
	    			 $(this).attr("checked",checked);
	    		});
	    	});
	    });   //$(".topMenu").change(function(){
	    			
			
<%=JQueryModel.DOC_READY_END%>
         

   </script>
  </head>
  <body>
  <div class="innerDiv">
     <form id="formUser"  method="post">
     <input type="hidden"  id="cRolestring" value="${CRolestring}" />
     <input type="hidden" name="Id" value="${Id}" />
       <table class="editTable" cellspacing="0">
         <tbody>
           <tr>
             <th>角色名</th>
             <td style="width: 35%">
               <input name="CName" type="text"  value="${CName}"
                 class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
                />
             </td>
            <th>描述</th>
             <td style="width: 35%">
               <input name="CDescription" type="text"  value="${CDescription}" 
               	class="<%=EasyUiModel.ValidateBox.CLASS %>"
                 <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
               />
             </td>
           </tr>
           <tr>
            <th>介绍</th>
             <td style="width: 35%"  colspan="3">
               <ul id="roledisplay" ></ul>  
               <div id="fieldset">
               </div>       
             </td>  
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