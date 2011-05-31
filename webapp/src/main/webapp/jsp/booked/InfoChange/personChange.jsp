<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.model.impl.EasyUiModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsContextModel"%>
<%@page import="com.smartken.kia.core.model.impl.JQueryModel"%>
<%@page import="com.smartken.kia.core.model.impl.JsFunctionModel"%>
<%@page import="com.ett.drv.model.booked.PersonChangeModel"%>
<%@page import="com.ett.drv.model.admin.DictModel"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
    String bookedInfoChangePath=basePath+"booked/InfoChange";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'person.jsp' starting page</title>

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
       String formPerson="formPerson";
    
       JsFunctionModel clickSaveHandler=new JsFunctionModel("clickSaveHandler",null);
       clickSaveHandler
       .appendContext("$.messager.confirm('操作提示','确认车主联系方式?',function(yes){")
       .appendContext("var url=\"{0}\";",bookedInfoChangePath+"/do/savePersonChange.action")
       .appendContext("{0}.form(\"submit\",'{'",JQueryModel.id(formPerson))
       .appendContext("url:url")
       .appendContext(",success:function(str){str.messager();}")
       .appendContext(",onSubmit:function(){ return $(this).form(\"validate\"); }")
       .appendContext("});  //form ")
       .appendContext("});  //$.messager.confirm")
       ;
    
       JsContextModel jsContext=new JsContextModel();
       jsContext.appendScript("{0}.form(\"validate\");",JQueryModel.id(formPerson));
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

	<body class="<%=EasyUiModel.Layout.CLASS %>">
	  <div <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_CENTER) %>
	  >
	 <h1>驾驶人联系方式变更备案</h1>
	 <form method="post" id="<%=formPerson %>">
	 <table border="0" cellpadding="4" cellspacing="0" width="200px"
style="font-size:1.2em" class="editTable">
			<tr >
				<th style="width: 350px;">驾驶人姓名</th>
				<td><input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    name="personChange.<%=PersonChangeModel.F.CName %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("姓名必须输入！") %>
				     <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("Chinese") %>
				/></td>
			</tr>
			<tr >
				<th >身份证明种类</th>
				<td>
				   <input class="<%=EasyUiModel.ComboBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ComboBox.Properties.URL(bookedInfoChangePath+"/combobox/idcardType.action") %>
				    <%=EasyUiModel.ComboBox.Properties.TEXT_FIELD(DictModel.F.CDictText.name()) %>
				    <%=EasyUiModel.ComboBox.Properties.VALUE_FIELD(DictModel.F.CDictValue.name()) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("身份证明种类必须输入！") %>
				    name="personChange.<%=PersonChangeModel.F.CIdcardType %>"
				    value="A"
				    />
				</td>
			</tr>
			<tr >
				<th >身份证明号码</th>
				<td>				   
				   <input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("身份证明号码必须输入！") %>
				    name="personChange.<%=PersonChangeModel.F.CIdcard %>"
				   <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("idCard") %>
				    />
				</td>
			</tr>
			<tr >
			    <th>档案编号</th>
				<td>
		           <input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("档案编号必须输入！") %>
				    name="personChange.<%=PersonChangeModel.F.CDabh %>"
				    />
                </td>
			</tr>
			<tr >
				<th>手机号码</th>
				<td>				  
				   <input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("手机号码必须输入！") %>
				    name="personChange.<%=PersonChangeModel.F.COldPhone %>"
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
			<tr >
			    <th>联系地址</th>
				<td >
		           <input class="<%=EasyUiModel.ValidateBox.CLASS %>"
				    <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
				    <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("联系地址必须输入！") %>
				    name="personChange.<%=PersonChangeModel.F.CNewAddress %>"
				    <%=EasyUiModel.ValidateBox.Properties.VALID_TYPE("Chinese") %>
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
				    name="personChange.<%=PersonChangeModel.F.CNewPostcode %>"
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
                     name="personChange.<%=PersonChangeModel.F.CNewPhone %>"
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
				     name="personChange.<%=PersonChangeModel.F.CEmail %>"
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
