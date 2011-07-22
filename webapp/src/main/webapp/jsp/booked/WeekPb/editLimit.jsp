<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.smartken.kia.core.util.StringUtil"%>
<%@page import="com.ett.drv.model.booked.BookedLimitModel"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addLimit.jsp' starting page</title>
    
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
    <jsp:useBean id="tempLimit" scope="request" beanName="tempLimit"
    type="com.ett.drv.model.booked.BookedLimitModel"></jsp:useBean>
    <script type="text/javascript">
    
    <%=JQueryModel.DOC_READY_START %>
    
    <%
        
           String formEditLimit="formEditLimit";
           String selectKscc="selectKscc";
           String selectKsdd="selectKsdd";
           String selectSchool="selectSchool";
           String txtTotal="txtTotal";
           String aSaveLimit="aSaveLimit";
           String aReset="aReset";
          

           
           EasyUiModel numberTotal=new EasyUiModel(JQueryModel.id(formEditLimit+"-"+txtTotal),EasyUiModel.NumberSpinner.NAME);
           numberTotal.appendAttrs(EasyUiModel.Spinner.Properties.INCREMENT,5)
           .appendAttrs(EasyUiModel.NumberBox.Properties.MIN,1)
           .appendAttrs(EasyUiModel.Spinner.Properties.REQUIRED,true)
           ;
           
           

           
           JsMapModel optEditForm=new JsMapModel();
           optEditForm.put(EasyUiModel.Form.Properties.URL,basePath+"booked/WeekPb/do/editLimit.action",true);
           
           JQueryModel btnSaveClick=new JQueryModel(JQueryModel.id(formEditLimit+"-"+aSaveLimit),JQueryModel.Events.CLICK);
           btnSaveClick.appendParma(
               new JsFunctionModel(null)
               .appendContext(
                 new EasyUiModel(JQueryModel.id(formEditLimit),
                                    EasyUiModel.Form.NAME,
                                    EasyUiModel.Form.Methods.SUBMIT,
                                    optEditForm.toScirpt())
                          //.appendAttrs(EasyUiModel.Form.Properties.URL,StringUtil.quota(basePath+"booked/WeekPb/do/editLimit.action"),true)
               )
           )
           ;
           
         
           JsContextModel jsContext=new JsContextModel();
           jsContext
           .appendScript(btnSaveClick)
           //.appendScript(formEditLimits)
           ;
     %>
    
           <%=jsContext.toScirpt() %>
    
      
    <%=JQueryModel.DOC_READY_END %>
    </script>
    
  </head>
  
  <body>
  	      <div class="innerDiv">
  	        <form  id="<%=formEditLimit %>" method="post">
  	          <table class="editTable" style="width: 100%" cellspacing="0">
  	            <tr>
  	              <td>考试场次</td>
  	              <td>
  	                ${tempLimit.CKscc} 
  	              </td>
  	            </tr>
  	            <tr>
  	              <td>考试地点</td>
  	              <td>
  	                 ${tempLimit.CKsdd}
  	              </td>
  	            </tr>
  	            <tr>
  	              <td>驾校</td>
  	              <td>
  	                 ${tempLimit.CSchoolName}
  	              </td>
  	            </tr>
  	            <tr>
  	              <td>分配人数</td>
  	              <td><input 
  	                      name="tempLimit.<%=BookedLimitModel.F.ITotal %>" id="<%=formEditLimit+"-"+txtTotal %>" value="${tempLimit.ITotal}" 
  	                      class="<%=EasyUiModel.NumberSpinner.CLASS %>"
  	                      <%=EasyUiModel.Spinner.Properties.INCREMENT(10) %>
  	                      <%=EasyUiModel.Spinner.Properties.MIN(1) %>
  	                      <%=EasyUiModel.NumberBox.Properties.REQUIRED(true) %>
  	              /></td>
  	            </tr>
  	            <tr>
  	              <td colspan="2">
  	               <a id=<%=StringUtil.formatId(null,"-",formEditLimit,aSaveLimit) %>
  	                  class="<%=EasyUiModel.LinkButton.CLASS %>"
  	                  <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SAVE) %>
  	               >保存</a>
  	               <!--  
  	               <a id=<%=StringUtil.formatId(null,"-",formEditLimit,aReset) %> 
  	                 	class="<%=EasyUiModel.LinkButton.CLASS %>"
  	                  <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_RELOAD) %>
  	               >重置</a>
  	               -->
  	              </td>
  	            </tr>
  	          </table>
  	        </form>
  	      </div>
  </body>
</html>
