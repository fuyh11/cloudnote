import org.junit.Test;

import dao.UserDao;
import service.UserService;

public class UserServiceTest extends BaseTest {
	
	@Test
	public void testLogin(){
		String name = "demo";
		String password = "123456";
		UserService service =
			ctx.getBean("userService",
			UserService.class);
		UserDao user = service.login(
			name, password);
		System.out.println(user); 
	}
}




