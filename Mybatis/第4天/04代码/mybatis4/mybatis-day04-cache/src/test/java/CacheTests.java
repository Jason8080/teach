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
    public void testEvn (){
        SqlSession sqlSession = SqlSessionKit.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        userMapper.findAll();
        orderMapper.findAll();
        sqlSession.close();
    }

    @Test
    public void testOne(){
        testEvn();
        System.out.println("===============分割线==================");
        testEvn();
    }

    @Test
    public void testTwo(){
        testOne();
        System.out.println("===============分割线==================");
        testOne();
    }
}
