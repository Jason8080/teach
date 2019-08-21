package com.itheima.session.create;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet.
 *
 * @author : Jason.lee
 * @version : 1.0
 */
public class UseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 第1次使用Session
        HttpSession session = req.getSession();

        // 第1次访问JSP
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
//        req.getRequestDispatcher("/index.html").forward(req, resp);
    }
}
