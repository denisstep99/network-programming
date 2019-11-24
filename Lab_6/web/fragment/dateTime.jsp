<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date,java.text.*"%>
<%
    Date now = new Date();
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss SSS");
%>
<h4>Current Time:</h4>
<%=df.format(now)%>

