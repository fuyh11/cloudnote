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

    public UserDao login(String name, String password) throws UserNotFoundException, PasswordException {
        if (StringUtils.isEmpty(password)) {
            throw new PasswordException("密码空");
        }
        if (StringUtils.isEmpty(name)) {
            throw new UserNotFoundException("用户名空");
        }
        UserDao user = userMapper.findUserByName(name.trim());
        if (user == null) {
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
        if (name == null || name.trim().isEmpty()) {
            throw new UserNameException("不能空");
        }
        UserDao one = userMapper.findUserByName(name);
        if (one != null) {
            throw new UserNameException("已注册");
        }
        //检查密码
        if (password == null || password.trim().isEmpty()) {
            throw new PasswordException("不能空");
        }
        if (!password.equals(confirm)) {
            throw new PasswordException("确认密码不一致");
        }
        //检查nick
        if (nick == null || nick.trim().isEmpty()) {
            nick = name;
        }
        String id = UUID.randomUUID().toString();
        String token = "";

        password = DigestUtils.md5DigestAsHex((SALT + password).getBytes());
        UserDao user = new UserDao(id, name, password, token, nick);
        int n = userMapper.addUser(user);
        if (n != 1) {
            throw new RuntimeException("添加失败!");
        }
        return user;
    }

}



