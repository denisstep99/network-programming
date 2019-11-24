package ru.ifmo.javaee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");

        username = username != null ? username : "noname";
        username = password != null ? username : "****";

        PrintWriter out = response.getWriter();
        out.println(
                "<!DOCTYPE HTML>\n"
                + "<html>\n"
                + "<head>\n"
                + " <title>Online Shopping</title>\n"
                + "</head>\n"
                + "<body>\n"
        );

        int counter = 0;
        if (username.equals("Michael") && password.equals("qwerty")) {
            out.println(username + "Welcome to Online Shopping!" + "<BR>");
            /* Создание сеанса для пользователя и сохранение имени пользователя. */
            HttpSession session = request.getSession(true);
            session.setAttribute("user", username);
        } else {
            out.println("Sorry! Invalid username and password");
            counter = 1;
        }

        if (counter == 0) {
            /* Вывод данных пользователю. */
            out.println("<HR>");

            out.println("<FORM ACTION = http://localhost:8080/Servlet/SecondSessionServlet METHOD=POST>");

            out.println("<TABLE WIDTH=500>");
            out.println("<TR><TH>ITEM NO</TH> <TH>SHIRT TYPE </TH> <TH>BUY</TH> </TR> ");
            out.println("<TR><TD> 1 </TD><TD> PeterEngland  </TD> <TD> <INPUT NAME = c1 TYPE = CHECKBOX VALUE = PeterEngland ></TD> </TR> ");
            out.println("<TR><TD> 2 </TD><TD> Excaliber     </TD> <TD> <INPUT NAME = c2 TYPE = CHECKBOX VALUE = Excaliber ></TD> </TR> ");

            out.println("<TR><TD> 3 </TD><TD> Vaun Newman   </TD> <TD> <INPUT NAME = c3 TYPE = CHECKBOX VALUE = VaunNewman></TD> </TR> ");

            out.println("<TR><TD> 4 </TD><TD> Wills Classic </TD> <TD> <INPUT NAME = c4 TYPE = CHECKBOX VALUE = WillsClassic></TD> </TR> ");

            out.println("</TABLE>");
            out.println("<INPUT TYPE = SUBMIT VALUE = SUBMIT>");
            out.println("</FORM>");
            out.println("</BODY></HTML>");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
