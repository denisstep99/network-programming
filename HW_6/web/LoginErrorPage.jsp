<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3> An exception has occurred</h3>
<%@ page isErrorPage="true" %>
<table>
    <tr>
        <td>Exception Class:</td>
        <%-- Получение имени класса исключения, где 'exception' является неявным объектом, предоставляемым JSP --%>
        <td><%= exception.getClass() %></td>
    </tr>
    <tr>
        <td>Message:</td>
        <%-- Получение сообщения исключения, где 'exception' является неявным объектом, предоставляемым JSP --%>
        <td><%= exception.getMessage() %></td>
    </tr>
</table>
<br>
To go back to the login page click Login Page button
<form name="f2" action="pages/LoginPage.html">
    <input type="submit" name="button1" value="Login Page">
</form>
</body>

</html>
