import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import mapper.UserMapper;
import service.user.dataobject.UserDao;

public class UserDaoTest extends BaseTest {

    UserMapper userMapper;

    private static final String SALT = "今天你吃了吗?";

    @Before
    public void initDao() {
        userMapper = ctx.getBean("userMapper", UserMapper.class);
    }

    @Test
    public void testFindUserByName() {
        String name = "demo";
        UserDao user = userMapper.findUserByName(name);
        System.out.println(user);
    }

    @Test
    public void testAddUser() {
        String id = UUID.randomUUID().toString();
        String name = "Tom";
        String password = DigestUtils.md5DigestAsHex(((SALT + "123456").getBytes()));
        String token = "";
        String nick = "";
        UserDao user = new UserDao(id, name, password, token, nick);
        int n = userMapper.addUser(user);
        System.out.println(n);
    }
}





