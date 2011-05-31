<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsContextModel"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsFunctionModel"%>
<%@page import="com.ett.drv.model.booked.CarOwnerChangeModel"%>
<%@page import="com.ett.drv.model.admin.DictModel"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bookedInfoChangePath=basePath+"booked/InfoChange";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'carowner.jsp' starting page</title>
    
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
	<%
       String formCar="formCar";
    
       JsFunctionModel clickSaveHandler=new JsFunctionModel("clickSaveHandler",null);
       clickSaveHandler
       .appendContext("$.messager.confirm('操作提示','确认变更车主联系方式信息?',function(yes){")
       .appendContext("var url=\"{0}\";",bookedInfoChangePath+"/do/saveCarOwnerChange.action")
       .appendContext("{0}.form(\"submit\",'{'",JQueryModel.id(formCar))
       .appendContext("url:url")
       .appendContext(",success:function(str){str.messager();}")
       .appendContext(",onSubmit:function(){ return $(this).form(\"validate\"); }")
       .appendContext("});  //form ")
       .appendContext("});  //$.messager.confirm")
       ;
    
       JsContextModel jsContext=new JsContextModel();
       jsContext.appendScript("{0}.form(\"validate\");",JQueryModel.id(formCar));
       JsContextModel jsFun=new JsContextModel();
       jsFun.appendScript(clickSaveHandler);
    %>
    <script type="text/javascript">
      <%=jsFun.toScirpt()%>
      <%=JQueryModel.DOC_READY_START%>
      <%=jsContext.toScirpt()%>
      <%=JQueryModel.DOC_READY_END %>
    
    </script>

  </head>
  
  <body>
    <div
<%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_CENTER) %>>
<h1>车主联系方式变更备案 </h1>
<form method="post" id="<%=formCar %>">
<table border="0" cellpadding="4" cellspacing="0" width="200px"
style="font-size:1.2em" class="editTable">
           <tr>
			   
				<th style="width: 350px;">
					以下项目均为必填（选）项：
				</th>
				 <td>&nbsp;</td>
			</tr>
		
			<tr >
				<th >车牌号码</th>
				<td>				   
				   <input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("车牌号码必须输入！") %>
				    name="cardOwnerChange.<%=CarOwnerChangeModel.F.CHmhp %>"
				    <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("carno") %>
				    />
				</td>
			</tr>
			<tr >
				<th >号牌种类</th>
				<td>
				   <input class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(bookedInfoChangePath+"/combobox/carType.action") %>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("车牌种类必须输入！") %>
				    name="cardOwnerChange.<%=CarOwnerChangeModel.F.CHpzl %>"
				    value="A"
				    />
				</td>
			</tr>
			<tr >
				<th >车架号码后5位</th>
				<td>				   
				   <input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("车架号码后5位必须输入！") %>
				    name="cardOwnerChange.<%=CarOwnerChangeModel.F.CCjh %>"
				     <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("five") %>
				    />
				</td>
			</tr>
			<tr >
				<th >发动机号码后5位</th>
				<td>				   
				   <input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("发动机号码后5位必须输入！") %>
				    name="cardOwnerChange.<%=CarOwnerChangeModel.F.CFdjh %>"
				     <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("five") %>
				    />
				</td>
			</tr>
			<tr >
				<th >登记证书号码</th>
				<td>				   
				   <input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("登记证书号码必须输入！") %>
				    name="cardOwnerChange.<%=CarOwnerChangeModel.F.CDjzs %>"
				    />
				</td>
			</tr>
			<tr >
				<th >手机号码</th>
				<td>				   
				   <input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("手机号码必须输入！") %>
				    name="cardOwnerChange.<%=CarOwnerChangeModel.F.COldPhone %>"
				      <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("mobile") %>
				    />
				</td>
			</tr>
			<tr>
			   
				<th>
					请填写变更后的联系方式，三项都必须输入
				</th>
				 <td>&nbsp;</td>
			</tr>
			<tr>
			<th>联系地址</th>
				<td >
		           <input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("联系地址必须输入！") %>
				    name="cardOwnerChange.<%=CarOwnerChangeModel.F.CNewAddress %>"
				    />
					(必须包含省、直辖市、自治区的名字)
				</td>
			</tr>
			<tr >
				<th>邮政编码</th>
				<td>
				<input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("邮政编码必须输入！") %>
				    name="cardOwnerChange.<%=CarOwnerChangeModel.F.CNewPostcode %>"
				    <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("zip") %>
				    />
				 </td>
			</tr>
			<tr>
			  <th>联系电话</th>
				<td>				   
				<input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("联系电话必须输入！") %>
                     name="cardOwnerChange.<%=CarOwnerChangeModel.F.CNewPhone %>"
                     <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("phone") %>
				    />
				 </td>
			</tr>
			<tr >
			    <th>电子邮箱</th>
				<td>				  
				  <input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("电子邮箱必须输入！") %>
				     name="cardOwnerChange.<%=CarOwnerChangeModel.F.CEmail %>"
				    <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("email") %>
				    />
				 </td>
			</tr>

			<tr >
			<td>&nbsp;</td>
				<td >
                   <a class="<%=EasyUiModel.LinkButton.CLASS %>"
                     <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SAVE) %>
                     onclick="<%=clickSaveHandler.getFunName() %>()"  
                   >确认修改
                   </a>
				</td>
			</tr>
		</table>    
	   </form>
	  </div>
	 
	</body>
</html>


			
			

