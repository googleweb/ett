<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>异地驾驶人考试情况超过100</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <!-- 
                       操作时间起：<input onclick="setday(this)" id="txtBeginDate" runat="server" />
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
                            <asp:BoundColumn DataField="km3ksrq" HeaderText="考试日期"></asp:BoundColumn>
                            <asp:BoundColumn DataField="wk" HeaderText="星期几"></asp:BoundColumn>
                            <asp:BoundColumn DataField="num" HeaderText="人数"></asp:BoundColumn>
                            
                        </Columns>
                        <HeaderStyle CssClass="table-title" />
                        <ItemStyle CssClass="table-content" />
                        <EditItemStyle CssClass="table-content" />
                    </asp:DataGrid>
     -->
  </body>
</html>
