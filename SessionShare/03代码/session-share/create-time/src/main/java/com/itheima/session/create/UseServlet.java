package com.itheima.session.create;

import org.apache.catalina.servlets.DefaultServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet.
 *
 * @author : Jason.lee
 * @version : 1.0
 */
public class UseServlet extends DefaultServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.endsWith("index.html") || uri.equals("/")) {
            // 第1次使用Session
//            HttpSession session = req.getSession();
            super.doGet(req, resp);
        } else if (uri.endsWith(".html")) {
            String sessionId = req.getRequestedSessionId() != null ? req.getRequestedSessionId() : "没有生成Session";
            resp.setCharacterEncoding("UTF-8");
            PrintWriter writer = resp.getWriter();
            writer.write(req.getLocalPort() + ": " + sessionId);
            writer.flush();
            writer.close();
        } else if (uri.endsWith(".do")) {
            // 第1次访问JSP
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
