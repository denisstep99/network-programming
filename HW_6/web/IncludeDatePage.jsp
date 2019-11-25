<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- Использование действия <jsp: include> --%>
<%
    java.util.Calendar day = new java.util.GregorianCalendar();
    int d =  day.get(Calendar.DAY_OF_MONTH);
    int m = 1 + day.get(Calendar.MONTH);
    int g = day.get(Calendar.YEAR);
    int z = (day.get(Calendar.ZONE_OFFSET) + day.get(Calendar.DST_OFFSET)) / (60 * 60 * 1000);
%>
Сегодня  <%= d %>/<%= m %>/<%= g %> Greenwich Mean Time: <%= z %>
<% out.println("<h3>  DatePage.jsp показан ниже из другой JSP страницы</h3>");%>

<%-- происходит вставка кода из файла DateJSP.jsp --%>
<h1> Текущее время: <jsp:include page="DateJSP.jsp" flush="true"/></h1>

</body>
</html>
