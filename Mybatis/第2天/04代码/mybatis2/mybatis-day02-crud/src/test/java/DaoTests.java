
import com.itheima.mybatis.day02.crud.mapper.impl.UserDaoImpl;
import com.itheima.mybatis.day02.crud.model.User;
import org.junit.Test;

/**
 * 传统开发方式测试入口.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/7 21:58
 * @description : DaoTests
 * @modified : -
 */
public class DaoTests {

    @Test
    public void testFindById(){
        UserDaoImpl dao = new UserDaoImpl();
        User user = dao.findById(24);
        System.out.println(user);
    }
}
