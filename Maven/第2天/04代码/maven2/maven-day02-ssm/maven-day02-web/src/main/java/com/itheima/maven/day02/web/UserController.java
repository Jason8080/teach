package com.itheima.maven.day02.web;

import com.itheima.maven.day02.domain.User;
import com.itheima.maven.day02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 用户控制器.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019-5-3 14:27
 * @description : UserController
 * @modified : -
 */
@Controller
public class UserController {

    // 注入service
    @Autowired
    private UserService userService;

    @RequestMapping("list.do")
    public String list(Model model){
        List<User> all = userService.findAll();
        model.addAttribute("list",all);
        return "user/list";
    }
}
