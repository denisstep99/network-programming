package ru.project.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondSessionServlet
 */
@WebServlet("/Session")
public class SessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        /* Вызов метода doPost() класса HttpServlet. */
        doPost(req, res);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Объявление локальных переменных для хранения информации сеанса. */
        String user = null;
        String item = null;
        int i = 1;
        Enumeration en = null;

        /* Получение экземпляра класса PrintWriter. */
        PrintWriter pw = response.getWriter();

        /* Получение объекта сеанса. */
        HttpSession session = request.getSession(true);

        /* Получение значения, связанного с  пвраметром "user". */
        user = (String) session.getAttribute("username");

        /* Получение имен всех параметров, переданных конечным поль-зователем. */
        en = request.getParameterNames();
        while (en.hasMoreElements()) {
            String sname = (String) en.nextElement();

            /* Сохранение имен в объекте сеанса. */
            session.setAttribute("c" + i, sname);
            i++;
        }

        /* Сохранение значения счетчика в объекте сеанса. */
        session.setAttribute("counter", i + "");
        /* Отправка запроса сервлету FinalServlet. */
        RequestDispatcher disp = request.getRequestDispatcher("FinalServlet");
        disp.forward(request, response);
    }

}

