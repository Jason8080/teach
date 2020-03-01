package com.itheima.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Controller: 修饰类 .
 *  作用: 创建控制器对象并添加到容器中.
 *
 * @author : Jason.lee
 * @version : 1.0
 */
// 也叫处理器 (官方)
@Controller // 不能用其他创建对象的注解创建控制器对象: @Repository @Service @Component
public class HelloController {


    /**
     * http://localhost:8080/hello.do
     * @param model 模型
     * @return 视图名称
     */
    @RequestMapping("hello.do")
    public String hello(Model model){
        System.out.println("执行了hello方法...");
        // 如果没有配置视图解析器的前缀和后缀
//        return "/pages/success.jsp";
        return "success";
    }

}
