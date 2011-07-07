<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.smartken.kia.core.util.EasyUiUtil"%>
<%@page import="com.smartken.kia.core.model.impl.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>暂住证号码雷同超过3</title>
    
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
  </head>
  
  <script type="text/javascript">
  $(document).ready(
  function(){
  $("#test").datagrid({
  fit:true,
  columns:[[
  {field:"Id",checkbox:true},
  {field:"",title:"暂住证号码",width:150},
  {field:"",title:"数量",width:150}
  ]],
  pagination:true
  }
  );
  }
  );
  </script>
  <body  class="<%=EasyUiModel.Layout.CLASS %>" >
 <div   <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_NORTH) %>  
 style="height: 50px">
 <!-- style="height: 100px">
   <p style="text-align: center"><h3>暂住证号码雷同超过3</h3></p>
  -->
  <form method="post" id="formSearch">
  <table class="editTable" cellspacing="0" align="right">
  <tr>
  <td>
  操作时间起：<input type="text" value="" id="begindate" 
  class="<%=EasyUiModel.DateBox.CLASS%>"
   <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
  <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("请输入开始日期 ") %>
   />
  </td>
   <td>
 操作时间止：<input type="text" value="" id="enddate" 
 class="<%=EasyUiModel.DateBox.CLASS%>" 
  <%=EasyUiModel.ValidateBox.Properties.REQUIRED(true) %>
  <%=EasyUiModel.ValidateBox.Properties.MISSING_MESSAGE("请输入结束日期 ") %>
 /> 
 </td>
 <td>
 <a  class="easyui-linkbutton" <%=EasyUiModel.LinkButton.Properties.ICON_CLS(EasyUiModel.ICON_SEARCH) %>/>查询</a>
 </td>
 </tr>
 </table>
</form>
  </div>
<div <%=EasyUiModel.Layout.Properties.REGION(EasyUiModel.REGION_CENTER) %> >
<table id="test" ></table>
</div>
    <!--                     操作时间起：<input onclick="setday(this)" id="txtBeginDate" runat="server" />
                    &nbsp; 
                   操作时间止
                    &nbsp;&nbsp;&nbsp;
                    
                    <input onclick="setday(this)" id="txtEndDate" runat="server" />&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;<asp:Button ID="btnSearch" runat="server" OnClick="btnSearch_Click" Text="查询" />
    </div>
    <div>
    <asp:DataGrid ID="DataGrid1" runat="server" AutoGenerateColumns="False"
                        BorderWidth="0px" CellPadding="1" CellSpacing="1" CssClass="table-border" 
                        Width="100%" >
                        <Columns>
                            <asp:BoundColumn DataField="zzzm" HeaderText="暂住证明号码"></asp:BoundColumn>
                            <asp:BoundColumn DataField="num" HeaderText="数量"></asp:BoundColumn>
                            
                        </Columns>
                        <HeaderStyle CssClass="table-title" />
                        <ItemStyle CssClass="table-content" />
                        <EditItemStyle CssClass="table-content" />
                    </asp:DataGrid> -->
  </body>
</html>
