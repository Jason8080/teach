package com.itheima.spring.day01.dep.controller;

import com.itheima.spring.day01.dep.service.UserService;
import com.itheima.spring.day01.dep.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * UserController.
 *
 * @author : Jason.lee
 * @version : 1.0
 * @date : 2019/5/10 10:06
 * @description : UserController
 */
public class UserController {

    private UserService userService = new UserServiceImpl();

    @Test
    public void test (){
        userService.save();
    }
}
