package com.itheima.mybatis.day01.framework;

import com.itheima.mybatis.day01.framework.mapper.UserMapper;
import com.itheima.mybatis.day01.framework.model.User;

import java.util.List;

/**
 * Mybatis Framework 入门案例.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/5 14:40
 * @description : Framework
 * @modified : -
 */
public class MybatisFrameworkTests {

    /*
1. 引入依赖包
2. 创建操作类
3. 添加配置文件 (官网)
4. 编写启动程序 (官网)
     */
    public static void main(String[] args) throws Exception {

        // 第1步: 创建连接



        // 第2步: 执行操作
        UserMapper mapper = null;
        // 执行操作
        List<User> all = mapper.findAll();
        all.forEach(u -> System.out.println(u));


        // 第3步: 关闭资源

    }
}
