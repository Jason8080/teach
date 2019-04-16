import com.itheima.mybatis.day03.sql.kit.SqlSessionKit;
import com.itheima.mybatis.day03.sql.mapper.UserMapper;
import com.itheima.mybatis.day03.sql.model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 动态SQL测试入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/16 16:40
 * @description : SqlTests
 * @modified : -
 */
public class SqlTests {

    @Test
    public void testIf(){
        SqlSession sqlSession = SqlSessionKit.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 用户信息(查询条件)
        User user = new User();
        user.setUsername("%小%");
//        user.setSex("1");
        List<User> users = mapper.findBy(user);
        users.forEach(u -> System.out.println(u));
    }
    @Test
    public void testWhere(){
        SqlSession sqlSession = SqlSessionKit.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 用户信息(查询条件)
        User user = new User();
//        user.setUsername("%小%");
        user.setSex("1");
        List<User> users = mapper.findBy(user);
        users.forEach(u -> System.out.println(u));
    }
    @Test
    public void testSet(){
        SqlSession sqlSession = SqlSessionKit.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 更新内容
        User user = new User();
        user.setId(1);
        user.setBirthday(new Date());
//        user.setSex("2");
        mapper.update(user);
    }
    @Test
    public void testSql(){
        SqlSession sqlSession = SqlSessionKit.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 查询所有用户
        List<User> users = mapper.findBy(new User());
        users.forEach(u -> System.out.println(u));
    }
}
