<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="helloBean" class="ru.ifmo.HelloBean"/>
    <h3>Say Hello:</h3>
    <jsp:getProperty name="helloBean" property="hello" />

    <!-- Set property name for helloBean -->
    <jsp:setProperty  name="helloBean" property="name" value="JSP"/>
    <h3>Say Hello after setName</h3>
    <jsp:getProperty name="helloBean" property="hello" />
</body>
</html>
