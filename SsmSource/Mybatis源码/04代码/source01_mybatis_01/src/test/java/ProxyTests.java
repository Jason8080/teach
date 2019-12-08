import com.itheima.mybatis.dao.AccountDao;
import com.itheima.mybatis.dao.impl.AccountDaoImpl;
import com.itheima.mybatis.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Mybatis代理方式开发测试.
 *  代理方式开发的特点:
 *      1. 不需要提供持久层实现类
 *      2. 根据会话对象自动生成代理类
 *
 * @author : Jason.lee
 * @version : 1.0
 */
public class ProxyTests {

    SqlSession sqlSession;
    AccountDao accountDao;


    @Before
    public void before() throws Exception {
        // 1. 加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 2. 构建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 3. 获取会话对象
        sqlSession = sqlSessionFactory.openSession();
        // 4. 生成代理对象
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void after(){
        // 5. 最后提交事务
        sqlSession.commit();
        sqlSession.close();
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
