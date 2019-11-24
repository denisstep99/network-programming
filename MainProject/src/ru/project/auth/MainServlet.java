package ru.project.auth;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        /* Вызов метода doPost() класса HttpServlet. */
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        int counter = 0;
        if (username.equals("Michael") && password.equals("qwerty")) {
            out.println(username + " Welcome to Online Shopping!" + "<BR>");
            counter = 0;
            /* Создание сеанса для пользователя и сохранение в сеансе имени пользователя. */
            HttpSession session = request.getSession(true);
            session.setAttribute("user", username);
        } else {
            out.println("Sorry! Invalid username and password");
            counter = 1;
        }
        if (counter == 0) {
            /* Вывод данных пользователю. */
            RequestDispatcher view = request.getRequestDispatcher("/src/pages/catalog-page.jsp");
            view.forward(request, response);
            out.close();
        }
    }
}

