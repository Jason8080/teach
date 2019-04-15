package com.itheima.mybatis.day01.jdbc;

import java.lang.reflect.Method;

/**
 * Jdbc入门案例.
 * <p>
 *     根据ID查找用户
 * </p>
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/5 14:39
 * @description : Jdbc
 * @modified : -
 */
public class Jdbc {
    private static String url = "jdbc:mysql:///mybatisdb";
    private static String name = "root";
    private static String pass = "root";

    public static void main(String[] args) throws Exception {
        //1. 加载驱动
        //2. 创建连接
        //3. 准备SQL语句(?)
        //4. 获取预编译对象
        //5. 设置参数
        //6. 执行操作并且返回结果集
        //7. 处理结果集
        //8. 关闭资源
    }
}
