import com.itheima.mybatis.dao.AccountDao;
import com.itheima.mybatis.dao.impl.AccountDaoImpl;
import com.itheima.mybatis.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Mybatis传统方式开发测试.
 *  传统方式开发的特点:
 *      1. 需要提供持久层实现类
 *      2. 手动调用Api操作数据库
 *
 * @author : Jason.lee
 * @version : 1.0
 */
public class ApiTests {

    AccountDao accountDao;


    @Before
    public void before() throws Exception {
        // 1. 加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 2. 构建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 3. 创建持久层实现类
        accountDao = new AccountDaoImpl(sqlSessionFactory);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setId(10);
        account.setUid(10);
        account.setMoney(10D);
        accountDao.save(account);
    }

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(10);
        account.setMoney(11D);
        accountDao.update(account);
    }

    @Test
    public void testDel(){
        Account account = new Account();
        account.setId(10);
        accountDao.del(account);
    }

    @Test
    public void testFind(){
        List<Account> all = accountDao.findAll();
        all.forEach(x -> System.out.println(x));
    }

}
