package com.itheima.mybatis.day01.custom.kit;

import com.itheima.mybatis.day01.custom.core.SqlSession;

/**
 * 会话工厂类.
 * <p>
 *     作用: 创建对象
 *     说明: 往往使用工厂类创建对象都是因为创建对象的步骤繁琐.
 * </p>
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/15 20:31
 * @description : SqlSessionFactory
 * @modified : -
 */
public class SqlSessionFactory {
    /**
     * 获取会话连接对象.
     *
     * @return the sql session
     */
    public static SqlSession openSession(){
        return new SqlSession();
    }
}
