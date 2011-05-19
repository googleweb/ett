<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="s"  uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>打印日志分页显示</title>
<script type="text/javascript" src="../js/jquery-1.5.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.popup.js"></script>
<script type="text/javascript">

function Pop()
{
	$.popup.open('/images/jsptags.gif','请确认您的身份证信息！','');
}
</script>
</head>
<body>
<s:form action="printLog!list.action" method="post">
<input type="button" value="测试弹出pop" onclick="Pop('popWin','images/jsptag.gif','测试标题')"/>

请输入关键字：<s:textfield name="keywordFilterValue"/>
<input type="submit" value="查询" />
<input type="button" value="添加" onclick="window.open('printLog!add.action');"/>
<table width="778" border="0" cellPadding="0" cellSpacing="1" bgcolor="#6386d6">  
    <tr bgcolor="#EFF3F7">  
        <TD align="center">ID</TD>  
        <TD align="center">名称</TD>  
        <TD align="center">密码</TD>  
        <TD align="center">地址</TD>  
        <TD align="center">创建时间</TD>  
        <TD align="center">相关操作</TD>  
           
    </tr>  
    <c:if test="${!empty lists}">  
        <c:forEach items="${lists}" var="user">  
            <tr bgcolor="#EFF3F7">  
                <td align="center">${user.id }</td>  
                <td align="center">${user.idCard }</td>  
                <td align="center">${user.yxlsh}</td>  
                <td align="center"></td>  
                <td align="center"></td>  
                <td align="center">  
                    修改   
                    &nbsp;    
                    删除</td>  
            </tr>  
        </c:forEach>  
        </c:if>  
         <c:if test="${empty lists}">  
        <tr>  
            <td colspan="5" align="center" bgcolor="#EFF3F7">  
            没有找到相应的记录   
            </td>  
        </tr>  
        </c:if>  
    </table>  
共${rowCount}条记录
<pg:pager url="printLog!list.action" items="${rowCount}" export="currentPageNumber=pageNumber">  
    <pg:first>  
        <a href="${pageUrl}">首页</a>  
    </pg:first>  
    <pg:prev>  
        <a href="${pageUrl }">上一页</a>  
    </pg:prev>  
    <pg:pages>  
        <c:choose>  
            <c:when test="${currentPageNumber eq pageNumber}">  
                <font color="red">${pageNumber }</font>  
            </c:when>  
            <c:otherwise>  
                <a href="${pageUrl }">${pageNumber }</a>  
            </c:otherwise>  
        </c:choose>  
    </pg:pages>  
    <pg:next>  
        <a href="${pageUrl }">下一页</a>  
    </pg:next>  
    <pg:last>  
        <a href="${pageUrl }">尾页</a>  
    </pg:last>  
</pg:pager>
</s:form>
</body>
</html>