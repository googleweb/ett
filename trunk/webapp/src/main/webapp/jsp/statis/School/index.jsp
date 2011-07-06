<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>驾校状况查询</title>
    
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
                        开始日期：<input onclick="setday(this)" id="txtBeginDate" runat="server" />
                    &nbsp; 
                   结束日期：
                    &nbsp;&nbsp;&nbsp;
                    
                    <input onclick="setday(this)" id="txtEndDate" runat="server" />&nbsp;&nbsp;<asp:Button ID="btnSearch" runat="server" OnClick="btnSearch_Click" Text="查询" />
    </div>
    <div>
    <asp:DataGrid ID="DataGrid1" runat="server" AutoGenerateColumns="False"
                        BorderWidth="1px" CellPadding="0" CellSpacing="0" CssClass="table-border" 
                        Width="100%" >
                        <Columns>
                            <asp:BoundColumn DataField="jxmc" HeaderText="驾校名称"></asp:BoundColumn>
                            <asp:BoundColumn DataField="onStudy" HeaderText="年受理数"></asp:BoundColumn>
                            <asp:BoundColumn DataField="km1hg" HeaderText="科目一合格"></asp:BoundColumn>
                            <asp:BoundColumn DataField="km1bhg" HeaderText="科目一不合格"></asp:BoundColumn>
                            <asp:BoundColumn DataField="km1hgl" HeaderText="科目一合格率"></asp:BoundColumn>
                            <asp:BoundColumn DataField="km1c1dk" HeaderText="科目一C1待考"></asp:BoundColumn>
                            <asp:BoundColumn DataField="km1nc1dk" HeaderText="科目一非C1待考"></asp:BoundColumn>
                            <asp:BoundColumn DataField="zkhg" HeaderText="桩考合格"></asp:BoundColumn>
                            <asp:BoundColumn DataField="zkbhg" HeaderText="桩考不合格"></asp:BoundColumn>
                            <asp:BoundColumn DataField="zkhgl" HeaderText="桩考合格率"></asp:BoundColumn>
                            <asp:BoundColumn DataField="zkc1dk" HeaderText="桩考C1待考"></asp:BoundColumn>
                            <asp:BoundColumn DataField="zknc1dk" HeaderText="桩考非C1待考"></asp:BoundColumn>
                            
                              <asp:BoundColumn DataField="cdhg" HeaderText="场地合格"></asp:BoundColumn>
                            <asp:BoundColumn DataField="cdbhg" HeaderText="场地不合格"></asp:BoundColumn>
                            <asp:BoundColumn DataField="cdhgl" HeaderText="场地合格率"></asp:BoundColumn>
                            <asp:BoundColumn DataField="cdc1dk" HeaderText="场地C1待考"></asp:BoundColumn>
                            <asp:BoundColumn DataField="cdnc1dk" HeaderText="场地非C1待考"></asp:BoundColumn>
                            
                              <asp:BoundColumn DataField="km3hg" HeaderText="科目三合格"></asp:BoundColumn>
                            <asp:BoundColumn DataField="km3bhg" HeaderText="科目三不合格"></asp:BoundColumn>
                            <asp:BoundColumn DataField="km3hgl" HeaderText="科目三合格率"></asp:BoundColumn>
                            <asp:BoundColumn DataField="km3c1dk" HeaderText="科目三C1待考"></asp:BoundColumn>
                            <asp:BoundColumn DataField="km3nc1dk" HeaderText="科目三非C1待考"></asp:BoundColumn>
                            <asp:BoundColumn DataField="zhgl" HeaderText="总合格率"></asp:BoundColumn>
                        
                            
                        </Columns>
                        <HeaderStyle CssClass="table-title" />
                        <ItemStyle CssClass="table-content" />
                        <EditItemStyle CssClass="table-content" />
                    </asp:DataGrid> -->
  </body>
</html>
