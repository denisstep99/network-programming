package ru.ifmo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadFileServlet
 */
@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DownloadFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // читаем входной файл из абсолютного пути
        String filePath = "C:\\Users\\Deniska\\IdeaProjects\\HomeWork\\HW_4\\web\\index.jsp";
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);

        // если надо использовать относительный путь context root:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);

        // получаем ServletContext
        ServletContext context = getServletContext();

        // получаем тип MIME файла
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {
            // назначить двоичный тип, если отображение MIME не обнаружено
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // модифицируем response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // инициируем диалоговое окно для загрузки на клиерте
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
        System.out.println("headerKey = " + headerValue);
        response.setHeader(headerKey, headerValue);

        // получаем выходной поток для response
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();
        System.out.println("File downloaded to client successfully");
    }

}

