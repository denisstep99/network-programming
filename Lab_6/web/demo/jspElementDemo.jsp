<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" ?>
<%@ page pageEncoding="UTF-8"%>

<jsp:element name="data">

    <h3>Please view source of this page</h3>

    <%--  Create Employee object and setting value for its fields --%>

    <jsp:useBean id="emp" class="ru.ifmo.Employee">
        <jsp:setProperty name="emp" property="style" value="background-color: tomato; padding: 10px; color: white;" />
        <jsp:setProperty name="emp" property="empName" value="James Bond" />
    </jsp:useBean>


    <jsp:element name="section">
        <jsp:attribute name="style" trim="true">
            <jsp:getProperty name="emp" property="style" />
        </jsp:attribute>
        <jsp:body>
            <jsp:getProperty name="emp" property="empName" />
        </jsp:body>
    </jsp:element>

</jsp:element>
