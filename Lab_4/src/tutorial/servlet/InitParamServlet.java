package tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet("/initParamServlet")
public class InitParamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitParamServlet() {
        super();
// TODO Auto-generated constructor stub
    }
    private String emailSupport1;
    // Данный метод всегда вызывается 1 раз
// сразу после того, как создается объект Servlet.
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

// Получить значение параметра инициализирования (initialization parameter) Servlet.
// (Конфигурацииданный Servlet в web.xml).
        this.emailSupport1 = config.getInitParameter("emailSupport1");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Получить значение параметра инициализирования (initialization parameter) другим способом.
        String emailSupport2 = this.getServletConfig().getInitParameter("emailSupport2");

        ServletOutputStream out = response.getOutputStream();

        out.println("<html>");
        out.println("<head><title>Init Param</title></head>");

        out.println("<body>");
        out.println("<h3>Init Param</h3>");
        out.println("<p>emailSupport1 = " + this.emailSupport1 + "</p>");
        out.println("<p>emailSupport2 = " + emailSupport2 + "</p>");
        out.println("</body>");
        out.println("<html>");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

