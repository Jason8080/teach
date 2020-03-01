package com.itheima.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * RequestMappingController.
 *
 * @author : Jason.lee
 * @version : 1.0
 */
@Controller
/**
 * 修饰类: 表示映射(限制)根路径
 */
// @RequestMapping("user"): http://localhost:8080/user/list.do
//@RequestMapping("user")
public class RequestMappingController {


    /**
     * http://localhost:8080/list.do
     *
     * @return
     * @RequestMapping: 修饰方法, 类
     * 作用: 映射请求地址
     * 举例: value: list.do, 那么访问地址就应该是http://localhost:8080/list.do
     */
    @RequestMapping("list") // 访问后缀可以省略
//    @RequestMapping("list.do")
//    @RequestMapping("/list.do") // 一般/开头
    public String list() {
        System.out.println("执行了list方法...");
        return "success";
    }


    /**
     * method: 限制请求的方法 (不写method表示不限制任何方式的请求)
     * params: 限制请求的参数 (不写不限制)
     * @return
     */
    @RequestMapping(value = "list2", method = {RequestMethod.GET, RequestMethod.POST},
            params = {"id!=1", "name=Jason1"},
            headers = {"Host=localhost:8080", "Cookie=JSESSIONID=1A1053F6C113A25FE9C66217113F7615"}
    )
    public String list2() {
        System.out.println("执行了list2方法...");
        return "success";
    }
}
