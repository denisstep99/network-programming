<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 20.11.2019
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
</head>
<body>
<h1>Thanks for joining our email list</h1>

<p>Here is the information that you entered:</p>

<%@ page import="ru.project.business.UserIO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" scope="session" class="ru.project.business.User"/>
<jsp:setProperty name="user" property="*"/>
<%
    ServletContext sc = request.getServletContext();
    String path = sc.getRealPath("/WEB-INF/EmailList.txt");
    UserIO.add(user, path);
%>
<table cellspacing="5" cellpadding="5" border="1">
    <tr>
        <td align="right">First name:</td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td align="right">Last name:</td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td align="right">Email address:</td>
        <td>${user.emailAddress}</td>
    </tr>
</table>

<p>
    Для ввода другого адреса email нажмите на кнопку Back <br> в
    вашем браузере или кнопку Return показанную ниже.<br>
<form action="email_list.html" method="post">
    <input type="submit" value="Return">
</form>
<br> Чтобы увидеть список зарегистрированных пользователей нажмите
на кнопку Registred List ниже.
</p>
<form action="email_list.jsp" method="post">
    <input type="submit" value="Registred List">
</form>

</body>
</html>
