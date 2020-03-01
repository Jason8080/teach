package com.itheima.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 演示参数绑定.
 *
 * @author : Jason.lee
 * @version : 1.0
 */
@Controller
public class ParamController {


    /**
     * 资源: 控制器方法
     *
     * @param id   参数名
     * @param name 参数名, 如果是中文, 可能乱码
     *             1. tomcat比较老的版本, GET方法就会乱码
     *             2. 哪怕是比较新的版本, POST方法就会乱码
     *
     *             参数列表中:
     *             不建议使用基本数据类型, 比如int, long...,
     *             建议同意使用包装类型(支持null: 可以不传)
     * @return 视图
     */
    @RequestMapping("list3")
    public String list3(int id, String name){
        System.out.println(id);
        System.out.println(name);
        return "success";
    }


    /**
     * 将参数列表封装成对象后, 请求的参数不会改变
     * @param account 对象
     * @return
     */
    @RequestMapping("list4")
    public String list4(Account account){
        System.out.println(account);
        return "success";
    }
}
