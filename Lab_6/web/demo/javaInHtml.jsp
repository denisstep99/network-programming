<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Random random = new Random();
        // Returns a random number (0, 1 or 2)
        int randomInt = random.nextInt(3);
    %>
    <h<%=randomInt + 1%>>Random value =<%=randomInt%></h<%=randomInt + 1%>>

    <a href="<%= request.getRequestURI() %>">Try Again</a>
</body>

</html>
