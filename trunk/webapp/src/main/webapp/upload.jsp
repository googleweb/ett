<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.upload.jsp' starting page</title>
    
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
   <script type="text/javascript">
   
     function doUpload(){
    	 
    	 /**
    	 var opts={};
    	 var uploadUrl=opts["uploadUrl"]||"#";
    	 var inputName=opts["inputName"]||"file";
    	 var muti=opts["muti"]||true;
    	 var div=$("<div></div>");
    	 var table=$("<table></table>");
    	 var ol=$("<ol type='1'></ol>");
    	 var form=$("<form method='post' enctype='multipart/form-data'></form>");
    	 form.attr("action",uploadUrl);
    	 var btnNew={
    		  text:"新增"
    		  ,iconCls:'icon-add'
    		  ,handler:function(){
    		    var tr=$("<tr></tr>");
    		    var span=$("<span></span>");
    		    var li=$("<li></li>");
    		    var inputFile=$("<input type='file' />");
    		    inputFile.attr("name",inputName);
    		    var btnRemove=$("<button type='button'>删除</button>");
    		    btnRemove.click(function(){
    		    	li.remove();
    		    });
    		    li.append(inputFile).append("&nbsp;&nbsp;").append(btnRemove);
    		    ol.append(li);
    		  }
    	 };
    	 var btnUpload={
    		 text:"上传"
    		 ,iconCls:'icon-save'
    		 ,handler:function(){
    		   form.form("submit");
    		   div.dialog("close");
    		 }
    		 
    	};
    	 var btns=[];
    	 if(muti){
    		 btns=[btnNew,btnUpload];
    	 }else{
    		 btns=[btnUpload];
    	 }
    	 var li=$("<li></li>");
    	 var inputFile=$("<input type='file' />");
    	 inputFile.attr("name",inputName);
    	 li.append(inputFile);
    	 ol.append(li);
    	 form.append(ol);
    	 div.append(form);
    	 div.dialog({
    		 width:400
    		 ,buttons:btns
    	 });
    	 
    	 **/
    	 var opts={};
    	 opts["muti"]=true;
    	 opts["inputName"]="photo";
    	 var div=$("<div></div>");
    	 div.kiaUploadForm(opts);
    	 div.dialog({width:380});
     }
    
   </script>

  </head>
  
  <body>
      <a  class="<%=EasyUiModel.LinkButton.CLASS %>" 
          <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SAVE) %>
          onclick="doUpload()"
      >上传</a>
      <form action="" enctype=""></form>
  </body>
</html>
