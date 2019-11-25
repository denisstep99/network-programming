<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- импорт пакетотов и классов, необходиых для скриптов -->

<%@ page import="ru.ifmo.*"%>
<%
    // получение параметров из объекта request
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String emailAddress = request.getParameter("emailAddress");
    // получение реального пути для файла EmailList.txt
    ServletContext sc = session.getServletContext();
    String path = sc.getRealPath("/WEB-INF/EmailList.txt");

    System.out.println(path);
    // использование регулярных объектов Java
    User user = new User(firstName, lastName, emailAddress);
    UserIO.add(user, path);
%>
<!---->
<p>This email address was added to our list on
    <%= new java.util.Date()%></p>

<h1>Спасибо за регистрацию в списке email</h1>
<p>Ниже представлена введенная Вами информация:</p>
<table cellspacing="5" cellpadding=" 5 " border="1">
    <tr>
        <td align="right">Имя:</td>
        <td><%=user.getFirstName() %></td>
    </tr>
    <tr>
        <td align="right">Фамилия :</td>
        <td><%=user.getLastName() %></td>
    </tr>
    <tr>
        <td align="right">Email адрес:</td>
        <td><%=user.getEmailAddress() %></td>
    </tr>
</table>
<p>
    Чтобы ввести другой адрес, нажмите кнопку Back <br> в браузере
    или кнопку Возврат <br> ниже.
</p>
<form action="pages/email_list.html" method="post">
    <input type="submit" value="Возврат">
</form>
</body>

</html>
