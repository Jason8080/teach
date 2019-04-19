import com.itheima.mybatis.day04.cache.kit.SqlSessionKit;
import com.itheima.mybatis.day04.cache.mapper.OrderMapper;
import com.itheima.mybatis.day04.cache.mapper.UserMapper;
import com.itheima.mybatis.day04.cache.model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * CacheTests.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/19 14:20
 * @description : CacheTests
 * @modified : -
 */
public class CacheTests {

    @Test
    public void testOne(){
        SqlSession sqlSession = SqlSessionKit.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        // 查询userMapper
        userMapper.findAll();
        // 查询orderMapper
        orderMapper.findAll();
        User user = new User();
        user.setId(1);
        user.setAddress("6666666");
        // 修改userMapper内容
        userMapper.update(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testTwo(){
        testOne();
        testOne();
    }
}
