import com.itheima.mybatis.day03.tx.dao.mapper.impl.UserDaoImpl;
import com.itheima.mybatis.day03.tx.dao.model.User;
import org.junit.Test;

/**
 * 事务控制.
 *
 * @author ：Jason.lee
 * @version : 1.0
 * @date ：2019/4/16 14:25
 * @description : TxTests
 * @modified : -
 */
public class TxTests {

    @Test
    public void testJdbcManual() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("JDBC");
        user.setAddress("手动");
        userDao.saveUserManual(user);
    }

    @Test
    public void testJdbcAuto() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("JDBC");
        user.setAddress("自动");
        userDao.saveUserAuto(user);
    }
}
