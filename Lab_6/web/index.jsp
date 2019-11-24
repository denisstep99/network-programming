<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Hello JSP</h1>

  <%
    java.util.Date date = new java.util.Date();
  %>

  <h2>
    Now is
    <%=date.toString()%>
  </h2>

  <%
    // использование переменной  out:
    out.println("<h2> Now is "+ new Date()+"</h2>");
    // использование переменной  request:
    String serverName= request.getServerName();
    // использование переменной  response:
    out.println("<h2> Server name "+ serverName +"</h2>");
    //response.sendRedirect("http://eclipse.org");
  %>

  </body>

</html>
