<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教练车查询</title>
    
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
           身份证明号码：<asp:textbox ID="txtIdCard" runat="server"></asp:textbox>
                    &nbsp; 
                  号码号牌
                    &nbsp;&nbsp;&nbsp;
        <asp:textbox ID="txtHmhp" runat="server">
        </asp:textbox>
                    &nbsp;&nbsp;<asp:Button ID="btnSearch" runat="server" OnClick="btnSearch_Click" Text="查询" />
    </div>
    <div>
    <asp:DataGrid ID="DataGrid1" runat="server" AutoGenerateColumns="False"
                        BorderWidth="0px" CellPadding="1" CellSpacing="1" CssClass="table-border" 
                        Width="100%" >
                        <Columns>
                            <asp:BoundColumn DataField="jxmc" HeaderText="驾校名称"></asp:BoundColumn>
                            <asp:BoundColumn DataField="jlzh" HeaderText="教练证号"></asp:BoundColumn>
                             <asp:BoundColumn DataField="sfzmhm" HeaderText="身份证明名称"></asp:BoundColumn>
                            <asp:BoundColumn DataField="xm" HeaderText="姓名"></asp:BoundColumn>
                             <asp:BoundColumn DataField="clpp" HeaderText="车辆品牌"></asp:BoundColumn>
                            <asp:BoundColumn DataField="hphm" HeaderText="号牌号码"></asp:BoundColumn>
                              <asp:BoundColumn DataField="regdate" HeaderText="入场日期"></asp:BoundColumn>
                            <asp:BoundColumn DataField="sj" HeaderText="联系手机"></asp:BoundColumn>
                            
                        </Columns>
                        <HeaderStyle CssClass="table-title" />
                        <ItemStyle CssClass="table-content" />
                        <EditItemStyle CssClass="table-content" />
                    </asp:DataGrid> 
    -->
  </body>
</html>
