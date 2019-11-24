package ru.ifmo.lab.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/RetrieveCookie")
public class RetrieveCookie extends HttpServlet {
    private static final long serialVersionUID = 1L;
    PrintWriter pw = null;

    public RetrieveCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        /* Вызов метода doPost() класса HttpServlet. */
        doPost(req, res);
    }

    /* Переопределение метода doPost() класса HttpServlet, который реализует функциональность сервлета. */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        /* Получение экземпляра класса PrintWriter. */
        pw = res.getWriter();
        HashMap<String, String> cookiesMap = new HashMap<String, String>();
        String username = null;
        /* Получение cookies, если таковые есть, хранимых в браузере кли-ента. */
        Cookie cookies[] = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                cookiesMap.put(cookie.getName(), cookie.getValue());
            }
            pw.println(" Hello! " + cookiesMap.get("user"));
            pw.println(" Password: " + cookiesMap.get("password"));
        } else {
            pw.println("No cookies found");
        }
    }
}
