<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" import="java.io.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Some error in page</h2>

Message:
<%=exception.getMessage()%>


<h3>StackTrace:</h3>
<%
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    exception.printStackTrace(printWriter);
    out.println("<pre>");
    out.println(stringWriter);
    out.println("</pre>");
    printWriter.close();
    stringWriter.close();
%>

</body>

</html>
