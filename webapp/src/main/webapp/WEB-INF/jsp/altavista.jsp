<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<jsp:useBean id="currentPageNumber" type="java.lang.Integer" scope="request"/>
<font face=Helvetica size=-1>

<pg:prev export="pageUrl">&nbsp;<a href="<%= pageUrl %>">[上一页]</a></pg:prev>
<pg:pages><%
  if (pageNumber.intValue() < 10) {
    %>&nbsp;<%
  }
  if (pageNumber == currentPageNumber) {
    %><b><%= pageNumber %></b><%
  } else {
    %><a href="<%= pageUrl %>"><%= pageNumber %></a><%
  }
%>
</pg:pages>
<pg:next export="pageUrl">&nbsp;<a href="<%= pageUrl %>">[下一页 ]</a></pg:next>
<br></font>
