package com.itheima.mybatis.day03.relate;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 会话工具类
 */
@SuppressWarnings("all")
public class SqlSessionKit {

    /**
     * 会话工厂
     */
    private static SqlSessionFactory factory;

    static {
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * 获取会话连接
     *
     * @return
     */
    public static SqlSession openSession(boolean... auto) {
        return factory.openSession(auto.length>0?auto[0]:false);
    }
}
