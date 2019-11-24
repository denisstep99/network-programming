package ru.ifmo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "downloadServlet", urlPatterns = { "/download" })
@MultipartConfig(fileSizeThreshold = 5_242_880, // 5MB
        maxFileSize = 20_971_520L, // 20MB
        maxRequestSize = 41_943_040L // 40MB
)
public class FileDownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FileDownloadServlet() {

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file1");
        if (filePart != null) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.write("<html><head></head><body>");
            this.processAttachment(filePart);
            out.write("File " + filePart.getName() + " uploaded successfully.");
            out.write("<br>");
        }
    }

    private void processAttachment(Part fileItem) throws IOException {
        InputStream inputStream = fileItem.getInputStream();
        System.out.println("getName " + fileItem.getName()); // file1
        System.out.println("getContentType " + fileItem.getContentType());
        System.out.println("getSubmittedFileName "
                + fileItem.getSubmittedFileName());
        System.out.println("getSize " + fileItem.getSize());
        System.out.println("getHeaderNames " + fileItem.getHeaderNames());
        System.out.println("toString " + fileItem.toString());
        String name = fileItem.getSubmittedFileName();
        System.out.println("getSubmittedFileName>>>>>>>>" + name);
        int i = fileItem.getSubmittedFileName().lastIndexOf('\\');
        String filename = name.substring(i + 1);
        System.out.println("Имя файла->>>>>>>>>>>>>>>>>" + filename);
        File file = new File(
                "C:\\Users\\Deniska\\IdeaProjects\\HomeWork\\HW_4"
                        + filename);
        OutputStream to_file = new FileOutputStream(file);
        System.out.println("Absolute Path at server=" + file.getAbsolutePath());
        int read;
        final byte[] bytes = new byte[1024];
        while ((read = inputStream.read(bytes)) != -1) {
            to_file.write(bytes, 0, read);
        }
        to_file.close();
        System.out.println("File uploaded from client successfully");
    }

}
