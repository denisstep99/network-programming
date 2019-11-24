package tutorial.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();

        out.println("<html>");
        out.println("<head><title>Hello Servlet</title></head>");

        out.println("<body>");
        out.println("<h3>Hello World</h3>");
        out.println("This is my first Servlet");
        out.println("</body>");
        out.println("<html>");

    }
}
