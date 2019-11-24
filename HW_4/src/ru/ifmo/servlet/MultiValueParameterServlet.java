package ru.ifmo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MultiValueParameterServlet
 */
@WebServlet("/MultiValueParameterServlet")
public class MultiValueParameterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiValueParameterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n").append("<html>\r\n").append(" <head>\r\n")
                .append(" <title>Hello User Application</title>\r\n").append(" </head>\r\n").append(" <body>\r\n")
                .append(" <form action=\"MultiValueParameterServlet\" method=\"POST\">\r\n")
                .append("Select the fruits you like to eat:<br/>\r\n")
                .append("<input type=\"checkbox\" name=\"fruit\" value=\"Banana\"/>").append(" Banana<br/>\r\n")
                .append("<input type=\"checkbox\" name=\"fruit\" value=\"Apple\"/>").append(" Apple<br/>\r\n")
                .append("<input type=\"checkbox\" name=\"fruit\" value=\"Orange\"/>").append(" Orange<br/>\r\n")
                .append("<input type=\"checkbox\" name=\"fruit\" value=\"Guava\"/>").append(" Guava<br/>\r\n")
                .append("<input type=\"checkbox\" name=\"fruit\" value=\"Kiwi\"/>").append(" Kiwi<br/>\r\n")
                .append("<input type=\"submit\" value=\"Submit\"/>\r\n").append(" </form>").append(" </body>\r\n")
                .append("</html>\r\n");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String[] fruits = request.getParameterValues("fruit");
        java.util.Map<String, String[]> mass = request.getParameterMap();
        java.util.Set<String> iter = mass.keySet();
        String massP[];
        for (String p : iter) {
            writer.println(p);
            massP = mass.get(p);
            for (String i : massP) {
                writer.println(i);
            }
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        writer.append("<!DOCTYPE html>\r\n").append("<html>\r\n").append(" <head>\r\n")
                .append(" <title>Hello User Application</title>\r\n").append(" </head>\r\n").append(" <body>\r\n")
                .append(" <h2>Your Selections</h2>\r\n");
        if (fruits == null)
            writer.append(" You did not select any fruits.\r\n");
        else {
            writer.append(" <ul>\r\n");
            for (String fruit : fruits) {
                writer.append(" <li>").append(fruit).append("</li>\r\n");
            }
            writer.append(" </ul>\r\n");
        }
        writer.append(" </body>\r\n").append("</html>\r\n");
    }
}

