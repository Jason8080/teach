import com.itheima.mybatis.day03.pool.dao.mapper.UserDao;
import com.itheima.mybatis.day03.pool.dao.mapper.impl.UserDaoImpl;
import com.itheima.mybatis.day03.pool.dao.model.User;
import org.junit.Test;

/**
 * 连接池测试入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019-4-21 15:55
 * @description : PoolTests
 * @modified : -
 */
public class PoolTests {

    /**
     * 环境测试
     */
    @Test
    public void testEnv(){
        UserDao dao = new UserDaoImpl();
        User user = dao.findById(24);
        System.out.println(user);
    }

    @Test
    public void testPooled(){
        testEnv();
        System.out.println("==========分割线=========");
        testEnv();
    }

    @Test
    public void testUnPooled(){
        testEnv();
        System.out.println("==========分割线=========");
        testEnv();
    }

    @Test
    public void testJndi(){
        testEnv();
        System.out.println("==========分割线=========");
        testEnv();
    }
}
