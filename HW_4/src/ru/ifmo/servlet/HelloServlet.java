package ru.ifmo.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
    }

    /**
     * @see HttpServlet#init(ServletConfig)
     */
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started.");
    }

    /**
     * @see HttpServlet#destroy()
     */
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped.");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hello, World!");
    }

}

