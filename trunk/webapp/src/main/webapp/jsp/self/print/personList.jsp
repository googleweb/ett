<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>驾驶证受理凭证列表</title>
</head>
<body>
<table width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">  
    <tr bgcolor="#EFF3F7">  
        <TD align="center">流水号</TD>  
        <TD align="center">号牌号码</TD>  
        <TD align="center">姓名</TD>  
        <TD align="center">业务类型</TD>  
        <TD align="center">申请日期</TD>  
        <TD align="center">相关操作</TD>  
           
    </tr>  
    <c:if test="${empty lists}">  
        <tr>  
            <td colspan="6" align="center" bgcolor="#EFF3F7">  
            没有找到相应的记录   
            </td>  
        </tr>  
        </c:if>  
    <c:if test="${!empty lists}">  
        <c:forEach items="${lists}" var="flow">  
            <tr bgcolor="#EFF3F7">  
                <td align="center">${flow.lsh }</td>  
                <td align="center">${flow.hphm }</td>  
                <td align="center">${flow.xm}</td>  
                <td align="center">${flow.ywlx}</td>  
                <td align="center">${flow.slrq}</td>  
                <td align="center">  
                  <input onclick="javascript:document.location.href='<s:url value="/self/print!carPrint.action"/>?lsh=<s:property value="flow.lsh"/>';" type="button" value="打印预览"/>
                  </td>  
            </tr>  
        </c:forEach>  
        </c:if>  
         
    </table> 
</body>
</html>