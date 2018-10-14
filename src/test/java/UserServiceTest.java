import org.junit.Test;

import service.user.UserService;
import service.user.dataobject.UserDao;
import service.user.param.UserParam;

public class UserServiceTest extends BaseTest {

    @Test
    public void testLogin() {
        UserService service = ctx.getBean("userService", UserService.class);
        UserParam param = new UserParam();
        param.setName("demo");
        param.setPassword("123456");
        UserDao user = service.login(param);
        System.out.println(user);
    }
}




