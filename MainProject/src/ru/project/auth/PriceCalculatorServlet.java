package ru.project.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/FinalServlet")
public class PriceCalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PriceCalculatorServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int price1 = 0;
        int price2 = 0;
        int price3 = 0;
        int price4 = 0;
        int totalPrice = 0;

        String username = "";

        PrintWriter pw = response.getWriter();

        /* Получение объекта сеанса. */
        HttpSession session = request.getSession(true);

        /* Получение значения, связанного с "user". */
        username = (String) session.getAttribute("user");

        /* Получение значения, связанного с "counter". */
        String counter = (String) session.getAttribute("counter");
        int count = Integer.parseInt(counter);

        for (int i = 1; i <= count - 1; i++) {

            /* Создание массива строк. */
            String shname[] = new String[count - 1];
            shname[i - 1] = (String) session.getAttribute("c" + i);

            /* Вычисление итоговой цены выбранных товаров. */

            if ((shname[i - 1]).equals("c1")) {
                price1 = 65;
            }
            if ((shname[i - 1]).equals("c2")) {
                price2 = 70;
            }
            if ((shname[i - 1]).equals("c3")) {
                price3 = 85;
            }
            if ((shname[i - 1]).equals("c4")) {
                price4 = 75;
            }
        }
        /* Вычисление итогового счета. */
        totalPrice = price1 + price2 + price3 + price4;
        /* Вывод итогового счета, который пользователь должен оплатить. */

        pw.println("<HTML><BODY>");
        pw.println(username + ", your bill is $" + totalPrice);
        pw.println("</BODY></HTML>");
        pw.close();
    }

}

