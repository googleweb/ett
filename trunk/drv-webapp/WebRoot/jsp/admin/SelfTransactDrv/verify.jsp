<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="com.ett.drv.model.self.TransactDriverModel"%>
<%@page import="com.ett.drv.model.self.BaseTransactModel"%>
<%@page import="com.ett.drv.model.self.TransactResourceModel"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%@page import="com.smartken.kia.core.util.StringUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String baseActionPath=basePath+"admin/SelfTransactDrv";
String excelTemplatePath=basePath+"js/print/驾驶证申请表-初学.xlt";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'verify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<jsp:include page="/plugin/index.jsp">
	   <jsp:param  name="plugin" value="jquery,easyui"/>
	</jsp:include>
    <jsp:include page="/css/index.jsp"></jsp:include>
    <jsp:include page="/js/index.jsp"></jsp:include>
    <script type="text/javascript" src="<%=basePath+"js/print/excel-tranDrv.js" %>"></script>
    <%
      String divShowImg="divShowImg";
      String imgShow="imgShow";
      String spanShow="spanShow";
      String imgThum="imgThum";
      String formVerify="formVerify";
      String inputPassInd="inputPassInd";

      JsFunctionModel clickPrint =new JsFunctionModel("clickPrint",null);
      clickPrint.appendContext("printExcel(\"{0}\",drivingLicense);",excelTemplatePath);
   
      JsFunctionModel clickThumImgHandler=new JsFunctionModel("clickThumImgHandler",new String[]{});
      clickThumImgHandler
      .appendContext("{0}.show();",JQueryModel.id(divShowImg))
      .appendContext("var srcShow=$(this).attr('src')||'';")
      .appendContext("var altShow=$(this).attr('alt')||'';")
      .appendContext("{0}.attr(\"src\",srcShow);",JQueryModel.id(imgShow))
      .appendContext("{0}.text(altShow);",JQueryModel.id(spanShow))
      ;
      
      JQueryModel imgThumClick =new JQueryModel(JQueryModel.cls(imgThum),"click");
      imgThumClick.appendParma(clickThumImgHandler.getFunName());
      
      JsFunctionModel clickVerifyHandler=new JsFunctionModel("clickVerifyHandler",new String[]{"passInd"});
      clickVerifyHandler
      //.appendContext("alert(verifyInd);")
      .appendContext("{0}.val(passInd);",JQueryModel.id(inputPassInd))
      .appendContext("{0}.form(\"submit\",\n '{' url:{1} \n ,success:{2} \n '}' );"
               ,JQueryModel.id(formVerify)
               ,StringUtil.quota(baseActionPath+"/do/verify.action")
               ,"function(str){var json=Kia.util.strToJson(str);Kia.util.handleJsonResult(json,function(ok){if(ok){clickPrint();}}); }"
      )
      ;
      
      JsContextModel jsFunContext=new JsContextModel();
      jsFunContext.appendScript(clickThumImgHandler);
      jsFunContext.appendScript(clickVerifyHandler);  
      jsFunContext.appendScript(clickPrint);
      
      JsContextModel jsContext=new JsContextModel(); 
      jsContext.appendScript(imgThumClick);
   %>


  <script type="text/javascript">
  
       var drivingLicense=${drivingLicense};
  
     <%=jsFunContext.toScirpt() %>
     

     
     <%=JQueryModel.DOC_READY_START%>
     <%=jsContext.toScirpt()%>
     <%=JQueryModel.DOC_READY_END%>
  
  </script>


   <%  boolean isAgent="agent".equalsIgnoreCase((String)request.getAttribute("applicat")); %>

  </head>
  
  <body>
     <div class="innerDiv">
     <form id="<%=formVerify %>" method="post">
        <table class="editTable" style="width: 60%" cellspacing="0">
        
        
         <tr>
            <th style="width:15%">&nbsp;流水号</th>
            <td style="width:25%">&nbsp;${flowNo }</td>
            <th style="width:15%">&nbsp;排队号</th>
            <td style="width:25%">&nbsp;${seqno}</td>
          </tr>
        
          <tr>
            <th >&nbsp;档案编号</th>
            <td >&nbsp;${licenseNo }</td>
            <th >&nbsp;号牌号码</th>
            <td >&nbsp;${plateNo}</td>
          </tr>
          
          <tr>
            <th>业务类型</th>
            <td>&nbsp;${transact}</td>
            <th>办理方式</th>
            <td>&nbsp;${applicat }</td>
          </tr>
          
         <tr>
            <th>申请日期</th>
            <td>&nbsp;<s:date name="createDate" format="yyyy-MM-dd" /></td>
            <th>已打印凭条</th>
            <td>&nbsp;${printInd }</td>
          </tr>
          
          <tr>
            <th>申请事项</th>
            <td>&nbsp;${item}</td>
            <th>申请原因及明细</th>
            <td>&nbsp;${reason }</td>
          </tr>
          

          
          <tr>
            <th>付款方式</th>
            <td>&nbsp;${payment}</td>
            <th>领取方式</th>
            <td>&nbsp;${receive }</td>
          </tr>
          
          <tr>
            <th>业务费用</th>
            <td>&nbsp;${costTransact}</td>
            <th>快递费用</th>
            <td>&nbsp;${costPost }</td>
          </tr>

         <tr>
            <th>总费用</th>
            <td>&nbsp;${costTransact+costPost}</td>
            <th>已付款</th>
            <td>&nbsp;${payInd }</td>
          </tr>
          
          <tr>
            <th>驾驶人身份证号码</th>
            <td>&nbsp;${driverIdNo}</td>
            <th>驾驶人姓名</th>
            <td>&nbsp;${driverIdName }</td>
          </tr>
          
          <% if(isAgent){ %>
          <tr>
            <th>代理人身份证号码</th>
            <td>&nbsp;${agentIdNo}</td>
            <th>代理人姓名</th>
            <td>&nbsp;${agentIdName }</td>
          </tr>
          <%} %>
          
          <tr>
            <th>联系电话</th>
            <td colspan="3">&nbsp;${phone }</td>
          </tr>
          
          
          <tr>
            <th>审核资料 （点击查看大图）</th>
            <td colspan="3">
               <ul class="ulThum">
                  <li >
                      <img class="<%=imgThum %>"  src="<%=baseActionPath+"/stream/"+TransactResourceModel.F.driverIdFrontImg+".action" %>" alt="车主身份证正面"/>
                      <br/>  车主身份证正面
                  </li>
                  <li >
                      <img class="<%=imgThum %>"  src="<%=baseActionPath+"/stream/"+TransactResourceModel.F.driverIdBackImg+".action" %>" alt="车主身份证背面" />
                      <br/>  车主身份证背面
                  </li>
                  <% if(isAgent){ %>
                  <li >
                      <img class="<%=imgThum %>"  src="<%=baseActionPath+"/stream/"+TransactResourceModel.F.agentIdFrontImg+".action" %>" alt="代理人身份证正面" />
                      <br/>  代理人身份证正面
                  </li>
                 <li >
                      <img class="<%=imgThum %>"  src="<%=baseActionPath+"/stream/"+TransactResourceModel.F.agentIdBackImg+".action" %>" alt="代理人身份证背面" />
                      <br/>  代理人身份证背面
                  </li>
                  <% } %>
                  
                  <li >
                      <img class="<%=imgThum %>"  src="<%=baseActionPath+"/stream/"+TransactResourceModel.F.captureImg+".action" %>" alt="现场拍摄照片" />
                      <br/>  现场拍摄照片
                  </li>
               </ul>
            </td>
          </tr>
          
          
          <tr>
            <th>备注</th>
            <td colspan="3"><textarea name="remark"  cols="5" rows="100" >备注</textarea></td>
          </tr>
          
          <tr>
            <th colspan="4">
                    
                <input type="hidden" name="flowNo" value="${flowNo}" />
                <input type="hidden" name="passInd" id="<%=inputPassInd %>" value="N"/>
                <a class="<%=EasyUiModel.LinkButton.CLASS %>"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_PRINT) %>
                onclick="<%=clickPrint.getFunName() %>()">打印</a>
                <a class="<%=EasyUiModel.LinkButton.CLASS %>"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_NO) %>
                onclick="<%=clickVerifyHandler.getFunName() %>('N');">审核不通过</a>
                <a class="<%=EasyUiModel.LinkButton.CLASS %>"   <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_OK) %>
                onclick="<%=clickVerifyHandler.getFunName() %>('Y');">审核通过</a>

            </th>
          </tr>
       </table> 
       
       </form>
       
       
       <form id="excelData">
          <input type="hidden" id="txtXm" value="${driverIdName}">
          
          <input type="hidden" id="txtSfzmhm" value="${driverIdNo}">
       </form>
       
       
     </div>
     
     
     <div id="<%=divShowImg %>" style="display: none;text-align: center;width: 700px;height: 450px;position: absolute; left: 10%;top: 10%; background-color: white; padding: 20px" 
       onclick="this.style.display='none';" 
     >
        <img id="<%=imgShow %>" style="height:400px" />
        <p/>
        <span id="<%=spanShow %>" style="font-size: 1.3em;font-weight: bolder;"></span>
     </div>
     
     
  </body>
</html>
