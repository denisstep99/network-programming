package ru.ifmo.lab.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    PrintWriter pw = null;

    public CookieServlet() {
        super();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        /* Вызов метода doPost() класса HttpServlet. */
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        pw = res.getWriter();
        /* Получение информации от пользователя из запроса HttpServlet. */
        String username = req.getParameter("user");
        String password = req.getParameter("password");
        /* Создание cookie, которое содержит имя пользователя. */
        Cookie ck = new Cookie("user", username);
        Cookie ckp = new Cookie("password", password);
        /* Добавление cookie к браузеру клиента. */
        res.addCookie(ck);
        res.addCookie(ckp);
        pw.println("Cookie containing user name is stored in your browser.");
    }
}
