import com.itheima.mybatis.day03.relate.kit.SqlSessionKit;
import com.itheima.mybatis.day03.relate.mapper.OrderMapper;
import com.itheima.mybatis.day03.relate.model.Order;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 关联查询测试入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/17 10:45
 * @description : AssociationTest
 * @modified : -
 */
public class AssociationTests {

    SqlSession sqlSession = SqlSessionKit.openSession();
    OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

    @Test
    public void testO2O(){
        List<Order> all = orderMapper.findAll();
        all.forEach(u -> System.out.println(u));
        sqlSession.close();
    }
}
