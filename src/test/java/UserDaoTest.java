import org.junit.Test;

import dao.UserDao;
import mapper.UserMapper;

public class UserDaoTest extends BaseTest {

    @Test
    public void testFindUserByName() {
        String name = "demo";
        UserMapper userMapper = ctx.getBean("userMapper", UserMapper.class);
        UserDao user = userMapper.findUserByName(name);
        System.out.println(user);
    }

}





