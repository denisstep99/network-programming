package ru.ifmo.lab.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IncludeServlet")
public class IncludeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public IncludeServlet() {
        super();
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException
    {
        /*Получение объекта RequestDispatcher */
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/CopyrightServlet");
        PrintWriter pw = response.getWriter();
        pw.println("<B> The copyright information included from cop-yright servlet: </B><BR>");
        /*использование метода include() в RequestDispatcher для включения содержимого*/
        dispatch.include(request, response);
    }
}
