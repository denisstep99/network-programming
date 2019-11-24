<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<jsp:useBean id="emp" class="ru.ifmo.Employee">

    <jsp:setProperty name="emp" property="empNo" value="E007"/>
    <jsp:setProperty name="emp" property="empName" value="James Bond"/>

</jsp:useBean>


<br>
Emp No: <input type="text" value="${emp.empNo}">
<br>
Emp Name <input type="text" value="${emp.empName}">
</body>
</html>
