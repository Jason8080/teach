import com.itheima.source.controller.CustomController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring IOC代码测试.
 *
 * @author : Jason.lee
 * @version : 1.0
 */
public class IocTests {

    ClassPathXmlApplicationContext ioc;

    @Before
    public void before() {
        // 创建容器
        ioc = new ClassPathXmlApplicationContext("classpath:beans.xml");
    }

    @After
    public void after(){
        // 关闭容器
        ioc.close();
    }

    @Test
    public void testSave() {
        CustomController customController = (CustomController) ioc.getBean("customController");
//        CustomController customController = ioc.getBean(CustomController.class);
        customController.save();
    }
}
