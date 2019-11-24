<%@ page import="ru.ifmo.CookieUtils" %><%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    CookieUtils.demoUserCookie(request,response, out);
%>

<a href ="<%=request.getRequestURI() %>">Try again!!</a>


</body>

</html>
