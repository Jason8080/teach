package com.itheima.mybatis.day02.crud.kit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 会话工具类
 */
public class SqlSessionKit {


    /**
     * 主配置文件的输入流
     */
    private InputStream in;
    /**
     * 会话连接
     */
    private SqlSession sqlSession;

    // 初始化工具类
    private static SqlSessionKit kit = new SqlSessionKit();


    /**
     * 获取会话连接
     * @return
     */
    public static SqlSession openSession() {
        return kit.sqlSession;
    }

    private SqlSessionKit() {
        try {
            this.in = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            this.sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void close(){
        kit.sqlSession.close();
    }
}
