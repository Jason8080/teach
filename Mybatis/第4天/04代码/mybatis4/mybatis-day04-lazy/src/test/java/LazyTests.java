import com.itheima.mybatis.day02.lazy.kit.SqlSessionKit;
import com.itheima.mybatis.day02.lazy.mapper.OrderMapper;
import com.itheima.mybatis.day02.lazy.mapper.UserMapper;
import com.itheima.mybatis.day02.lazy.model.Order;
import com.itheima.mybatis.day02.lazy.model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 懒加载测试入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/18 11:59
 * @description : LazyTests
 * @modified : -
 */
public class LazyTests {

    SqlSession sqlSession = SqlSessionKit.openSession();
    OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


    @Test
    public void testAssociation(){
        List<Order> all = orderMapper.findAll();
        all.get(0).getId();
//        all.forEach(o -> System.out.println(o));
        sqlSession.close();
    }
    @Test
    public void testById(){
        User user = userMapper.findById(24);
        System.out.println(user);
        sqlSession.close();
    }
}
