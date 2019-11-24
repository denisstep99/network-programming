<%--
  Created by IntelliJ IDEA.
  User: Deniska
  Date: 19.11.2019
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList"%>
<%@page import="ru.ifmo.Employee"%>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="EmployeesServlet">
    Фамилия сотрудника <input type="text" name="lastname"> <input
          type=submit value="поиск">
  </form>
  <%
    // Получение значения параметра employeesFound
    ArrayList<Employee> employees = (ArrayList) request.getAttribute("employeesFound");
    // Если параметр задан, начинаем обработку
    if (employees != null) {
      // Если не найдено ни одного сотрудника - вывод сообщения
      if (employees.size() == 0)
        out.print("Сотрудники не найдены");
      else {
        out.print("<TABLE border=\"1\">");
        // Заголовок таблицы
        out.print("<TR><TD>Id</TD><TD>Имя</TD><TD>Фамилия</TD>"
                + "<TD>Должность</TD><TD>Телефон</TD></TR>");
        for (int i = 0; i < employees.size(); i++) {
          // По каждому найденному сотруднику
          // формируется строка таблицы
          out.print("<TR>");
          // Получение очередного сотрудника из коллекции
          Employee emp = (Employee) employees.get(i);
          // Заполнение строки таблицы свойствами сотрудника
          out.print("<TD>" + emp.getId() + "</TD>");
          out.print("<TD>" + emp.getFirstName() + "</TD>");
          out.print("<TD>" + emp.getLastName() + "</TD>");
          out.print("<TD>" + emp.getDesignation() + "</TD>");
          out.print("<TD>" + emp.getPhone() + "</TD>");
          out.print("</TR>");
        }
        out.print("</TABLE>");
      }
    }
  %>
  </body>

</html>
