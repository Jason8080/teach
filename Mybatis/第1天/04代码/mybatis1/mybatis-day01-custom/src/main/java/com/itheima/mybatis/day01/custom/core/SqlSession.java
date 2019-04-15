package com.itheima.mybatis.day01.custom.core;

/**
 * 会话连接对象.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/15 20:32
 * @description : SqlSession
 * @modified : -
 */
public class SqlSession {

    /**
     * 获取指定类型的实例对象.
     *
     * @param <T>   泛型类型
     * @param clazz 指定类型
     * @return 实例对象
     */
    public <T> T getMapper(Class<T> clazz){
        return null;
    }
}
