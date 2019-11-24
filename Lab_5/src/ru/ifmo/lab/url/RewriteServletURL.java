package ru.ifmo.lab.url;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/RewriteServletURL")
public class RewriteServletURL extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RewriteServletURL() {
        super();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        /*
         * Получение параметров, связанных с пользователем (пароль и
         * регистрационной имя) из объекта запроса.
         */
        String username = req.getParameter("user");
        PrintWriter pw = res.getWriter();
        /* Verify the login status */
        res.setContentType("text/html");
        pw.println("Hello! <a href=\"http://localhost:8080/Lab_5_war_exploded/SecondServlet?user="
                + username + "\"> click here </a>to proceed");
    }
}
