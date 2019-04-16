
import com.itheima.mybatis.day02.crud.kit.SqlSessionKit;
import com.itheima.mybatis.day02.crud.mapper.OrderMapper;
import com.itheima.mybatis.day02.crud.model.Order;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * OrderTests.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/7 21:26
 * @description : OrderTests
 * @modified : -
 */
public class OrderTests {


    @Test
    public void testCountOrder(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSession();
        // 执行操作
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Integer count = mapper.countOrder(1);
        System.out.println(count);
        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void testFindAll(){
        // 创建连接
        SqlSession sqlSession = SqlSessionKit.openSession();
        // 执行操作
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> all = mapper.findAll();
        all.forEach(u -> System.out.println(u));
        // 关闭资源
        sqlSession.close();
    }
}
