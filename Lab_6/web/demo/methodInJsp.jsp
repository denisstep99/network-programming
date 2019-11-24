<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%!
    private int sum(int a, int b) {
        return a + b;
    }
%>
<%
    int a = 1;
    int b = 2;

    if (request.getParameterMap().containsKey("first") && request.getParameterMap().containsKey("second")) {
        a = Integer.parseInt(request.getParameter("first"));
        b = Integer.parseInt(request.getParameter("second"));
    }
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errorPage.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="./methodInJsp.jsp" method="get">
    <input type="text" name="first">
    <input type="text" name="second">
    <input type="submit">
</form>

<h1>
    <%=a + "+" + b + "=" + sum(a, b)%>
</h1>

</body>
</html>
