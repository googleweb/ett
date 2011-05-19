<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String selfIdentityPath=basePath+"self/Identity";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'contact.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/self/style.css">
    

    <jsp:include page="/plugin/index.jsp">
      <jsp:param value="jquery,keypad" name="plugin"/>
    </jsp:include>
    
    <script type="text/javascript">
    
    var phonefoucs=true;
    
    function clickSubmitHandler(){
    	var phoneValue=$("#textPhone").val();
    	document.location.href="<%=basePath %>self/captureImg!cap.action?returnurl=<%=selfIdentityPath %>/do/contact.action?phone="+phoneValue;
    }
    
    function clickClearHandler(){
    	$("#textPhone").val("");
    }
    
    function clickBackHandler(){
    	 if(phonefoucs){
    	  $("#textPhone").val("");
    	   phonefoucs=false;
          }
        var phoneValue=$("#textPhone").val();
        if(phoneValue.length>0){
        	phoneValue=phoneValue.substr(0,phoneValue.length-1);
        }
        $("#textPhone").val(phoneValue);
    }
    
    
    $(document).ready(function(){
    	
    	// $("#textPhone,#textTel").keypad({showAnim:""});
    	$("#textPhone").select();
    	
    	$(".keypad").each(function(index){
    		 if($(this).hasClass("number")){
    			$(this).click(function(){
    			  
    		      if(phonefoucs){
    				  $("#textPhone").val("");
    				  phonefoucs=false;
    			  }
    				
    			   var thisValue=$(this).val();
    			   var phoneValue=$("#textPhone").val();
    			   $("#textPhone").val(phoneValue+""+thisValue);
    			});
    		 }
    	});
    	
    });
      
    </script>

  </head>
  
  <body>
  
    <div class="selfmaintophint">
     请确认或修改联系信息
  </div>
  
  <div class="divFun">
  <form  action="<%=basePath %>self/captureImg!cap.action?returnurl=<%=selfIdentityPath %>/do/contact.action" method="post">
    <table class="selftable" style="width: 100%;font-size: 25px;" cellspacing="0">
      <tbody>
      <!--  
        <tr>
          <th style="width:35%; ">身份证号码</th>
          <td style="width:60% ">${driverIdNo }</td>
        </tr>
        <tr>
          <th >姓名</th>
          <td >${driverIdName }</td>
        </tr>
        <tr>
          <th>手机号码</th>
          <td><input id="textPhone" name="phone" value="13632254864" /> </td>
        </tr>
      
      -->  
         <tr>
                  <th style="text-align: center;"><span style="font-size: 1.5em;">联系电话:<input id="textPhone" name="phone" value="${user.sjhm}"  /></span>  </th>
        </tr>
        
        <tr>
            <td>
                 <table >
                    <tr>
                       <td><button class="btnmain keypad number">1</button></td>
                       <td><button class="btnmain keypad number">2</button></td>
                       <td><button class="btnmain keypad number">3</button></td>
                       <td><button class="btnmain keypad clear" onclick="clickClearHandler()">清空</button></td>
                    </tr>
                    <tr>
                       <td><button class="btnmain keypad number">4</button></td>
                       <td><button class="btnmain keypad number">5</button></td>
                       <td><button class="btnmain keypad number">6</button></td>
                       <td><button class="btnmain keypad back" onclick="clickBackHandler()">退格</button></td>
                    </tr>
                    <tr>
                       <td><button class="btnmain keypad number">7</button></td>
                       <td><button class="btnmain keypad number">8</button></td>
                       <td><button class="btnmain keypad number">9</button></td>
                       <td><button class="btnmain keypad number">0</button></td>
                    </tr>
                 </table>
            </td>
        </tr>
        
        <tr>
          <td colspan="2" style="text-align: right;">
              <button type="button" class="btnmain" 
              onclick="clickSubmitHandler()">确认
              </button>
          </td>
        </tr>
      </tbody>
    </table>
    
    </form>
    </div>
  </body>
</html>
