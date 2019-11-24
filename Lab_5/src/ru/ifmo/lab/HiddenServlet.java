package ru.ifmo.lab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HiddenServlet")
public class HiddenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HiddenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        /* Вызов метода doPost() класса HttpServlet. */
        doPost(req, res);
    }

    /* Переопределение метода doPost() класса HttpServlet для реализации функциональности сервлета. */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {
        /* Получение параметров, связанных с пользователем (пароль и регистрационное имя) из объекта запроса */
        String username = req.getParameter("user");
        PrintWriter pw = res.getWriter();
        pw.println("<!DOCTYPE HTML>");
        pw.println("<html lang=\"en\">");
        pw.println("<head><meta charset=\"UTF-8\"></head>");
        pw.println("<body>");
        pw.println("Hello! click Submit to proceed");
        pw.println("<form name=\"login\" action=\"http://localhost:8080/Lab_5_war_exploded/SecondServlet\">");
        /* Добавление скрытого поля */
        pw.println("<input type=\"hidden\" name=\"user\" value=\"" + username + "\">");
        pw.println("<input type=\"Submit\" value=\"Submit\"></form>");
        pw.println("</body>");
        pw.println("</html>");
    }
}
