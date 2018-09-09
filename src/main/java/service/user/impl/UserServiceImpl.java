package service.user.impl;

import java.util.Objects;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import mapper.UserMapper;
import service.exception.PasswordException;
import service.exception.UserNameException;
import service.exception.UserNotFoundException;
import service.user.UserService;
import service.user.dataobject.UserDao;
import service.user.param.UserParam;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final String SALT = "今天你吃了吗?";
    @Resource
    private UserMapper userMapper;

    public UserDao login(UserParam param) throws UserNotFoundException, PasswordException {
        String name = param.getName();
        String password = param.getPassword();

        if (StringUtils.isEmpty(password)) {
            throw new PasswordException("密码空");
        }
        if (StringUtils.isEmpty(name)) {
            throw new UserNotFoundException("用户名空");
        }
        UserDao user = userMapper.findUserByName(name.trim());
        if(Objects.isNull(user)){
            throw new UserNotFoundException("用户名错误");
        }
        String pwd = DigestUtils.md5DigestAsHex((SALT + password.trim()).getBytes());
        if (Objects.equals(pwd, user.getPassword())) {
            return user;
        }
        throw new PasswordException("密码错误");
    }

    public UserDao regist(UserParam param) throws UserNameException, PasswordException {
        //检查name, 不能重复
        String name = param.getName();
        String password = param.getPassword();
        String nick = param.getNick();
        String confirm = param.getConfirm();
        if (StringUtils.isEmpty(name)) {
            throw new UserNameException("不能空");
        }
        UserDao userDao = userMapper.findUserByName(name);
        if (Objects.isNull(userDao)) {
            throw new UserNameException("已注册");
        }
        //检查密码
        if (StringUtils.isEmpty(password)) {
            throw new PasswordException("不能空");
        }
        if (!Objects.equals(password,confirm)) {
            throw new PasswordException("确认密码不一致");
        }
        //检查nick
        if (StringUtils.isEmpty(nick)) {
            param.setNick(name);
        }
        param.setId(UUID.randomUUID().toString());
        param.setToken("");
        param.setPassword( DigestUtils.md5DigestAsHex((SALT + password).getBytes()));

        UserDao user = convertToUserDao(param);
        Integer n = userMapper.addUser(user);
        if (n != 1) {
            throw new RuntimeException("添加失败!");
        }
        return user;
    }


    public static UserDao convertToUserDao(UserParam userParam) {
        if (userParam == null) {
            return null;
        }
        UserDao userDao = new UserDao();

        userDao.setId(userParam.getId());
        userDao.setName(userParam.getName());
        userDao.setPassword(userParam.getPassword());
        userDao.setToken(userParam.getToken());
        userDao.setNick(userParam.getNick());

        return userDao;
    }

}



