import com.itheima.mybatis.day04.a.kit.SqlSessionKit;
import com.itheima.mybatis.day04.a.mapper.UserMapper;
import com.itheima.mybatis.day04.a.model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 注解开发测试入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/19 17:39
 * @description : AnnotationTests
 * @modified : -
 */
public class AnnotationTests {

    @Test
    public void testFindById(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSession();
        // 执行操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = mapper.findById(1);
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
        u.setUsername("马拉松");
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
    public void testUpdateUser(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSession();
        // 执行操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User u = new User();
        u.setId(61);
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
        u.setId(62);
        mapper.deleteUser(u);
        // 提交事务
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }


    @Test
    public void testO2M(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSession();
        // 执行操作
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findO2M();
        all.forEach(u -> System.out.println(u));
        // 关闭资源
        sqlSession.close();
    }
}
