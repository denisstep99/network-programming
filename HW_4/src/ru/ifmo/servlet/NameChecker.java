package ru.ifmo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/NameChecker")
public class NameChecker extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_USER = "Guest";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameChecker() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            String user = request.getParameter("user");
            if(user == null)
                user = NameChecker.DEFAULT_USER;
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.append("<!DOCTYPE html>\r\n")
                    .append("<html>\r\n")
                    .append(" <head>\r\n")
                    .append(" <title>Hello User Application</title>\r\n")
                    .append(" </head>\r\n")
                    .append(" <body>\r\n")
                    .append(" Hello, ").append(user).append("!<br/><br/>\r\n")
                    .append(" <form action=\"NameChecker\" method=\"POST\">\r\n")
                    .append(" Enter your name:<br/>\r\n")
                    .append(" <input type=\"text\" name=\"user\"/><br/>\r\n")
                    .append(" <input type=\"submit\" value=\"Submit\"/>\r\n")
                    .append(" </form>\r\n")
                    .append(" </body>\r\n")
                    .append("</html>\r\n");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

