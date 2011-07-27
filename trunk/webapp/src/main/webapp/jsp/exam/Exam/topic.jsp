<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@page import="com.ett.drv.model.preinput.*"%>
<%@page import="com.ett.drv.model.admin.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'topic.jsp' starting page</title>
    
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
   
   <style type="text/css">
    .editTable2
{
	border-style: solid;
	border-width: 1px 0px 0px 1px;
	border-color: #66CCFF;
	width: auto;
	background-color: #B0E0E6;
	table-layout: auto;
}


</style>
  
  
  
  <body>
  <script type="text/javascript">
  function computescore(){
  		var score=0;
  		var inputanswer=$("input.inputAnswer");
  		inputanswer.each(
  		function(index){
  		var answer=$(this).val();
  		var corectanswer=$(this).next().val();
  		//alert(answer+":"+corectanswer);
  		if(corectanswer==answer){
  		score++;
  		
  		}
  		else{
  		$(this).parent().css("color","red"); 
  		}
  		$(this).next().next().next().html("正确答案："+corectanswer);
  		}
  		
  		);
  		//alert(score);
  		document.getElementById("score").innerHTML=score;
  		
  
  }
  

   <%=JQueryModel.DOC_READY_START%>
    
      $("button.selecter").each(function(index){
          $(this).click(function(){
             var val=$(this).val();
            // alert(val);
             var tdAnswer=$(this).parent().next();
             var inputAnswer= tdAnswer.find(".inputAnswer");
             var spanAnswer= tdAnswer.find(".spanAnswer");
             inputAnswer.val(val);
             spanAnswer.html(val);
             var tablecss=$(this).parent().parent().parent();
             //var tablecsss=tablecss.find(".editTable");
             tablecss.removeClass("editTable");
             tablecss.addClass("editTable2");
          });
      });  //$("button.selecter").each(function(index){
      
     // $("button.easyui-linkbutton").each(function(index){
     // 		  $(this).click(function(){
      //		  var val=$(this).val();
     // 		  alert(val);
     // 		  });
      
    //  }
    //  );
   
   <%=JQueryModel.DOC_READY_END%>
  </script>
  
    ${cartype} <br>
    <%!int k=0; %>
   <%for(int i=1;i<10;i++){ %>
   <table id="t<%=i%>" cellspacing="0" cellpadding="0" style="width:100%;table-layout:auto;" class="editTable">
   <tr>
   <td style="width:10%">
       题号：<%=i%>
   </td>
   <td colspan="2">
       你是不是个代笔？
   </td>
   </tr>
   
   <tr>
	   <td>
	   &nbsp;
	   </td>
	   <td>
	   
	       请选答案：
	       	<button type="button" class="selecter" value="A">A</button>
	       	<button type="button" class="selecter" value="B">B</button>
	       	<button type="button" class="selecter" value="C">C</button>
	       	<button type="button" class="selecter" value="D">D</button>
	   </td>
	   <td style="width: 300px">
	   <input type="hidden" name="answer_<%=i%>" class="inputAnswer" value="T">
	   <input type="hidden" class="corectanswer" value="A">
	        答案:<span class="spanAnswer"></span><span class="rightanswer"></span>
	   </td>
   </tr>
   </table>
   <%k=i;} %>
    <%for(int i=k+1;i<20;i++){ %>
   <table id="t<%=i%>" cellspacing="0" cellpadding="0" style="width:100%;table-layout:auto;" class="editTable">
   <tr>
   <td style="width:10%">
       题号：<%=i%>
   </td>
   <td colspan="2">
      这是判断题
   </td>
   </tr>
   
   <tr>
	   <td>
	   &nbsp;
	   </td>
	   <td>
	   
	       请选答案：
	       <button type="button" class="selecter"  value="&radic;">&radic;</button>
	       <button type="button" class="selecter"  value="&Chi;">&Chi;</button>
	   </td>
	   <td style="width: 300px">
	   <input type="hidden" name="answer_<%=i%>" class="inputAnswer" value="T">
	   <input type="hidden" class="corectanswer" value="&radic;">
	        答案:<span class="spanAnswer"></span><span class="rightanswer"></span>
	   </td>
   </tr>
   </table>
   <%} %>
   <table cellspacing="0" cellpadding="0" style="width:100%;table-layout:auto;" class="editTable">
     <tr>
     <td style="width:10%">
	   &nbsp;
	   </td>
	   <td>
	   &nbsp;
	   </td>
		<td style="text-align: left;width:300px" >
		<button type="button" onclick="computescore()" >计算得分</button>得分：<span id="score" style="color:red"></span>分
		</td>   
     </tr>
   </table>
  </body>
</html>
