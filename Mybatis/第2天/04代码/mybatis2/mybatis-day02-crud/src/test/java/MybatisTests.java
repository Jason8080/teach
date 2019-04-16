
import com.itheima.mybatis.day02.crud.kit.SqlSessionKit;
import com.itheima.mybatis.day02.crud.mapper.UserMapper;
import com.itheima.mybatis.day02.crud.model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * MybatisTests.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/7 17:10
 * @description : MybatisTests
 * @modified : -
 */
public class MybatisTests {

    public static void main(String[] args) throws IOException {
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSession();
        // 执行操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        all.forEach(u -> System.out.println(u));
        // 关闭资源
        sqlSession.close();
    }


    @Test
    public void testFindById(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSession();
        // 执行操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = mapper.findById(24);
        System.out.println(u);
        // 关闭资源
        sqlSession.close();
    }


    @Test
    public void testSaveUser(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSession();
        // 执行操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setUsername("小李");
        u.setBirthday(new Date());
        u.setSex("1");
        u.setAddress("江西");
        mapper.saveUser(u);
        // 提交事务
        sqlSession.commit();

        System.out.println(u);
        // 关闭资源
        sqlSession.close();
    }





    @Test
    public void testLikeByUsername(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSession();
        // 执行操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.likeByUsername("陈");
        all.forEach(u -> System.out.println(u));
        // 关闭资源
        sqlSession.close();
    }



    @Test
    public void testUpdateUser(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSession();
        // 执行操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setId(2);
        u.setUsername("小李3");
        u.setBirthday(new Date());
        u.setSex("1");
        u.setAddress("江西 抚州");
        mapper.updateUser(u);
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }


    @Test
    public void testDeleteUser(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSession();
        // 执行操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setId(49);
        mapper.deleteUser(u);
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }





}
