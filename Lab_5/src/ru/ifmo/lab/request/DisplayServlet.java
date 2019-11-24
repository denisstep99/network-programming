package ru.ifmo.lab.request;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DisplayServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        /* Получение результата, хранимого в объекте запроса */
        Integer res = (Integer) request.getAttribute("result");
        /* Получение объекта PrintWriter */
        PrintWriter pw = response.getWriter();

        /* Отправка ответа для вывода результата */
        pw.println("The result of the calculation is: " + res.toString());
    }
}
