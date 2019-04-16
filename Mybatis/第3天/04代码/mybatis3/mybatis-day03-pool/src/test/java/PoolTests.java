
import com.itheima.mybatis.day03.pool.dao.mapper.impl.UserDaoImpl;
import com.itheima.mybatis.day03.pool.dao.model.User;
import org.junit.Test;

/**
 * 连接池测试入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/7 21:58
 * @description : DaoTests
 * @modified : -
 */
public class PoolTests {

    @Test
    public void testPool(){
        UserDaoImpl dao = new UserDaoImpl();
        User user = dao.findById(24);
        System.out.println(user);
        System.out.println("--------------------- 分 割 线 ----------------------");
        User user2 = dao.findById(24);
        System.out.println(user2);
    }

    @Test
    public void testUnPool(){
        testPool();
    }

    @Test
    public void testJndi(){
        testPool();
    }
}
