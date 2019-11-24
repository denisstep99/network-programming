<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DateJSP</title>
</head>
<body>
<%--Это содержимое JSP, которое выводит серверное время, используя класс Calendar пакета java.util--%>
<%
    java.util.Calendar dateTime = new java.util.GregorianCalendar();
    int hour = dateTime.get(Calendar.HOUR);
    int minute = dateTime.get(Calendar.MINUTE);
    int second = dateTime.get(Calendar.SECOND);
%>

<h1>Этот код JSP для показа серверного времени</h1>
<h1>Текущее время </h1>
<h2>
    <%=hour%>:<%=minute%>:<%=second%>
</h2>
</body>
</html>
