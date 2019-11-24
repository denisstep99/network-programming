<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- Задание имени страницы ошибок --%>
<%@ page errorPage="LoginErrorPage.jsp" %>
<font face="verdana"> <%
    /* Получение значения текстового поля uname */
    String customerID = (String)request.getParameter("uname");
    /* Получение значения текстового поля password b пПреобразование строкового значения в целое значение */
    int pass = Integer.parseInt(request.getParameter("password"));
    /* Проверка ID и пароля клиента */
    if (pass == 1010 && customerID.equals("Customer")) // Такой Login/Password должен вводиться
    {
        out.println("Welcome to Online Banking System");
%> <br> <br> <%
        out.println("Login Successful");
    } else {
        out.println("Login Unsuccessful");
    }
%>
</font>
</body>

</html>
