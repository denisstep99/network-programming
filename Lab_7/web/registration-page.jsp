<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 20.11.2019
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
</head>
<body>
<h1>Регистрация в списке email</h1>
<p>
    Для регистрации в списке, введите персональные данные и email адрес ниже. <br>
    Затем, нажмите кнопку Ввести.
</p>
<form action="display_email_entry_el.jsp" method="get">
    <table cellspacing="5" border="0">
        <tr>
            <td align="right">Имя:</td>
            <td><input type="text" name="firstName"></td>
        </tr>
        <tr>
            <td align="right">Фамилия:</td>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td align="right">Email адрес:</td>
            <td><input type="text" name= "emailAddress"></td>
        </tr>
        <tr>
            <td></td>
            <td><br>
                <input type="submit" value="Ввести"></td>
        </tr>
    </table>
</form>

</body>
</html>
