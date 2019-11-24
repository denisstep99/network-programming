package ru.ifmo.lab.request;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CopyrightServlet")
public class CopyrightServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CopyrightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException
    {
        PrintWriter pw = response.getWriter();
        pw.println("Copyright  2000-2015 ABC, Inc. All Rights Reserved.<BR>");
    }
}

