package com.itheima.session.create;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户控制器.
 *
 * @author : Jason.lee
 * @version : 1.0
 */
@Controller
public class UserController {


    /**
     * 访问HTML页面
     */
    @RequestMapping("html")
    public String html() {
        return "forward:index.html";
    }

    /**
     * 访问HTML页面
     * 并 使用Session
     */
    @RequestMapping("use")
    public String use(HttpServletRequest request) {
        // 使用Session
        HttpSession session = request.getSession();
        return "forward:index.html";
    }


    /**
     * 访问Jsp页面
     */
    @RequestMapping("jsp")
    public String jsp(HttpServletRequest request) {
        return "index";
    }




    /**
     * 访问JSP页面
     *  并登陆
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        session.setAttribute("user", name);
        return "redirect:jsp.do";
    }

    /**
     * 获取端口号
     *
     * @param request
     * @return
     */
    @RequestMapping("getPort")
    public void jsp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int port = request.getLocalPort();
        String sessionId = request.getRequestedSessionId();
        response.getWriter().write(port + ": " + sessionId);
    }
}
