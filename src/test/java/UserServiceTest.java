import org.junit.Test;

import service.user.UserService;
import service.user.dataobject.UserDao;

public class UserServiceTest extends BaseTest {

    @Test
    public void testLogin() {
        String name = "demo";
        String password = "123456";
        UserService service = ctx.getBean("userService", UserService.class);
        UserDao user = service.login(name, password);
        System.out.println(user);
    }
}




