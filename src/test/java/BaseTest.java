import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class BaseTest {
    protected ClassPathXmlApplicationContext ctx;

    //	ctx = new ClassPathXmlApplicationContext(
    //				"conf/spring-mvc.xml",
    //					"conf/spring-mybatis.xml",
    //					"conf/spring-service.xml");
    @Before
    public void initCtx() {
        ctx = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml", "conf/spring-service.xml");
    }

    @After
    public void close() {
        ctx.close();
    }

}