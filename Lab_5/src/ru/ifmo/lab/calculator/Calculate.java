package ru.ifmo.lab.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculate
 */
@WebServlet("/Calculate")
public class Calculate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        int number1 = Integer.parseInt(req.getParameter("num1"));
        int number2 = Integer.parseInt(req.getParameter("num2"));
        int sum = number1 + number2;
        pw.println("Sum of the numbers is&nbsp;&nbsp;" + sum);
    }

}

