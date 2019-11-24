package tutorial.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Вы можете конфигурировать один или более URL pattern,
// которые могут получитьдоступ к данному Servlet.
@WebServlet(urlPatterns = { "/annotationExample", "/annExample" }, initParams = {
        @WebInitParam(name = "emailSupport1", value = "abc@example.com"),
        @WebInitParam(name = "emailSupport2", value = "tom@example.com") })
public class AnnotationExampleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private String emailSupport1;

    public AnnotationExampleServlet() {
        super();
// TODO Auto-generated constructor stub
    }

    // ДанныйметодвызываетсяпередпервымвызовомданногоServlet.
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        emailSupport1 = config.getInitParameter("emailSupport1");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletConfig scfg=  getServletConfig();
        String emailSupport2 = scfg.getInitParameter("emailSupport2");

        ServletOutputStream out = response.getOutputStream();

        out.println("<html>");
        out.println("<head><title>Init Param</title></head>");

        out.println("<body>");
        out.println("<h3>Servlet with Annotation configuration</h3>");
        out.println("<p>emailSupport1 = " + emailSupport1 + "</p>");
        out.println("<p>emailSupport2 = " + emailSupport2 + "</p>");
        out.println("</body>");
        out.println("<html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
