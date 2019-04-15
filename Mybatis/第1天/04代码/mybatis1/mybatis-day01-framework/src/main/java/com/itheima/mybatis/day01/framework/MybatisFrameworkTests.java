package com.itheima.mybatis.day01.framework;

import com.itheima.mybatis.day01.framework.mapper.UserMapper;
import com.itheima.mybatis.day01.framework.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
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
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        // 根据文件构造会话工厂 (生产会话连接的工具类)
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 获取会话连接对象 (数据库连接对象)
        SqlSession sqlSession = factory.openSession();
        // 创建实例对象 (根据配置信息创建)
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);





        // 执行查找所有用户操作
        List<User> all = mapper.findAll();
        // 处理结果
        all.forEach(u -> System.out.println(u));






        // 关闭资源
        sqlSession.close();
        in.close();
    }
}
