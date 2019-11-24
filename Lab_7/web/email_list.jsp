<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 20.11.2019
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
</head>
<%@ page import="ru.project.business.*,ru.project.business.*,java.util.ArrayList"%>
<jsp:useBean id="user" scope="session" class="ru.project.business.User" />
<table border="1" cellpadding="5">
    <tr>
        <th>Number</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email Address</th>
    </tr>
    <%
        ServletContext sc = request.getServletContext();
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        ArrayList<User> users = UserIO.getUsers(path);
        session.setAttribute("users", users);
        session.setAttribute("itogo", users.size());
    %>
    <% int i=0; for (User usr : users)
    {  %>
    <tr valign="top">
        <td><%= i+1 %></td>
        <td><%=usr.getFirstName()%></td>
        <td><%=usr.getLastName()%></td>
        <td><%=usr.getEmailAddress()%></td>

    </tr>
    <% i=i+1;} %>


    <td>Sum</td>
    <td><%= session.getAttribute("itogo")%></td><td></td><td></td>
</table>
<form action="email_list.html">
    <input type="submit" value="Return to register">
</form>


</body>

</html>
