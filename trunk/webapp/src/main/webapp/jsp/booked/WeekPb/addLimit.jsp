<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.smartken.kia.core.util.StringUtil"%>
<%@page import="com.ett.drv.model.booked.BookedLimitModel"%>
<%@page import="com.ett.drv.model.admin.DictModel"%>
<%@page import="com.ett.drv.model.admin.DepartmentModel"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String sysMenuPath=basePath+"sys/Menu";
String bookedWeekPbPath=basePath+"booked/WeekPb";
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
          
           
           
  
           
           JsMapModel optEditForm=new JsMapModel();
           optEditForm.put(EasyUiModel.Form.Properties.URL,bookedWeekPbPath+"/do/addLimit.action",true);
           optEditForm.put(EasyUiModel.Form.Events.SUCCESS,
                new JsFunctionModel(new String[]{"data"})
                .appendContext("var re=eval('('+data+')');")
                .appendContext(new EasyUiMessager()
                                .setTitle("re.title")
                                .setMsg("re.msg")
                                .alert()
                )
           );
           
           JQueryModel btnSaveClick=new JQueryModel(StringUtil.formatId("#","-",formEditLimit,aSaveLimit),JQueryModel.Events.CLICK);
           btnSaveClick.appendParma(
               new JsFunctionModel(null)
               .appendContext(
                 new EasyUiModel(StringUtil.formatId(true,"#",null,formEditLimit),
                                    EasyUiModel.Form.NAME,
                                    EasyUiModel.Form.Methods.SUBMIT,
                                    optEditForm.toScirpt())
                          //.appendAttrs(EasyUiModel.Form.Properties.URL,StringUtil.quota(basePath+"booked/WeekPb/do/editLimit.action"),true)
               )
           )
           ;
           
           
           JsContextModel jsContext=new JsContextModel();
           jsContext
           //.appendScript(comboboxSchool)
          // .appendScript(numberTotal)
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
  	         <input type="hidden" name="tempLimit.km" value="${tempLimit.km}">
  	         <input type="hidden" name="tempLimit.dayofweek" value="${tempLimit.dayofweek}">
  	        <input type="hidden" name="tempLimit.dateKsrq" value="${tempLimit.dateKsrq}">
  	          <table class="editTable">
  	            <tr>
  	              <td>考试场次</td>
  	              <td>
  	                 <input name="tempLimit.<%=BookedLimitModel.F.CKsccCode %>"   width="180" 
  	                 id="<%=StringUtil.formatId(null,"-",formEditLimit,selectKscc) %>"  
  	                 class="<%=EasyUiModel.ComboBox.CLASS %>"
  	                 <%=EasyUiModel.ComboBox.Properties.URL(bookedWeekPbPath+"/combobox/kscc.action") %>
  	                 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.REQUIRED(true) %>
  	                  <%=EasyUiModel.ComboBox.Properties.EDITABLE(false) %>
  	                  />
  	              </td>
  	            </tr>
  	            <tr>
  	              <td>考试地点</td>
  	              <td>
  	                 <input name="tempLimit.<%=BookedLimitModel.F.CKsddCode %>"   width="180" 
  	                 id="<%=StringUtil.formatId(null,"-",formEditLimit,selectKsdd) %>" 
  	                 class="<%=EasyUiModel.ComboBox.CLASS %>"
   	                 <%=EasyUiModel.ComboBox.Properties.URL(bookedWeekPbPath+"/combobox/ksdd.action") %>
  	                 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.REQUIRED(true) %>
  	                  <%=EasyUiModel.ComboBox.Properties.EDITABLE(false) %>
  	                 />
  	              </td>
  	            </tr>
  	            <tr>
  	              <td>驾校</td>
  	              <td>
  	                 <input name="tempLimit.<%=BookedLimitModel.F.CSchoolCode %>"  width="180" 
  	                 id="<%=StringUtil.formatId(null,"-",formEditLimit,selectSchool) %>"
  	                  class="<%=EasyUiModel.ComboBox.CLASS %>"
  	                 <%=EasyUiModel.ComboBox.Properties.URL(bookedWeekPbPath+"/combobox/school.action") %>
  	                 <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DepartmentModel.F.CDepnickname.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DepartmentModel.F.CDepcode.name()) %>
  	                  <%=EasyUiModel.ComboBox.Properties.REQUIRED(true) %>
  	                  <%=EasyUiModel.ComboBox.Properties.EDITABLE(false) %>
  	                   />
  	              </td>
  	            </tr>
  	            <tr>
  	              <td>分配人数</td>
  	              <td><input 
  	                      name="tempLimit.<%=BookedLimitModel.F.ITotal %>" id="<%=formEditLimit+"-"+txtTotal %>" value="1" 
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
  	               ">保存</a>
  	               <a id=<%=StringUtil.formatId(null,"-",formEditLimit,aReset) %>
  	                  class="<%=EasyUiModel.LinkButton.CLASS %>"
  	                  <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_RELOAD) %>
  	               >重置</a>
  	              </td>
  	            </tr>
  	          </table>
  	        </form>
  	      </div>
  </body>
</html>
