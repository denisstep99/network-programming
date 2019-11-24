package ru.ifmo.lab.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    final String EXC = "javax.servlet.error.exception";
    final String MSG = "javax.servlet.error.message";
    final String ST = "javax.servlet.error.status_code";

    /* Переопределение метода doGet() в HttpServlet, который реализует функциональность сервлета. */

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /* Получение экземпляра класса ServletContext. */
        ServletContext sc = getServletContext();
        /* Получение экземпляра класса PrintWriter. */
        PrintWriter pw = response.getWriter();
        /* Получение информации сгенерированном исключении. */
        Exception exc = (Exception)request.getAttribute(EXC);
        /* Получение кода состояния из HttpServletRequest. */
        Integer st_cd = (Integer)request.getAttribute(ST);
        /* Получение строки сообщения, которая объясняет ошибку, или сгенериро-ванного исключения. */
        String msg = (String)request.getAttribute(MSG);
        pw.println("<HTML>");
        pw.println("<BODY>");
        pw.println("<HR>");
        /* Вывод подробной информации об ошибке клиенту. */
        pw.println("<H1>Sorry, an error has occurred that has prevented the server from servicing your request.</H1>");
        pw.println("<FONT SIZE = 5>");
        pw.println("<TABLE ALIGN = CENTER>");
        pw.println("<TR BGCOLOR = LIGHTGREY>");
        pw.println("<TD><B> Status Code  : </B></TD><TD>" + st_cd + " </TD>");
        pw.println("</TR>");
        pw.println("<TR>");
        pw.println("<TD><B> Type of Exception :</B></TD><TD>" + exc.getClass() + " </TD>");
        pw.println("</TR>");
        pw.println("<TR BGCOLOR = LIGHTGREY>");
        pw.println("<TD><B> Message Description  : </B></TD><TD>" + msg + " </TD><HR/>");
        //	String str=exc.toString()+st_cd.toString()+msg;
        sc.log("Exception occurred", exc); // Запись сообщения в лог
        pw.println("</TR>");
        pw.println("</TABLE>");
        pw.println("</FONT>");
        pw.println("<HR>");
        pw.println("<HR>");
        pw.println("<CENTER><H1>Please try again...</H1></CENTER>");
        pw.println("</BODY>");
        pw.println("</HTML>");
    }

}
