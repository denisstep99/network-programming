package ru.ifmo.lab.request;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        /* Получение чисел, введенных пользователем в HTML-форме */
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        /* Нахождение суммы чисел, введенных пользователем. */
        int result = num1 + num2;
        /* Запись результата в атрибут объекта запроса */
        request.setAttribute("result", new Integer(result));
        /* Получение объекта ServletContext */
        ServletContext contx = getServletConfig().getServletContext();
        /* Получение объекта RequestDispatcher */
        RequestDispatcher reqDispatcher = contx
                .getRequestDispatcher("/DisplayServlet");
        /* Передача запроса */
        reqDispatcher.forward(request, response);
    }
}
