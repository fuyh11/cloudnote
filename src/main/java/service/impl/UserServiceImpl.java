package service.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import dao.UserDao;
import mapper.UserMapper;
import service.PasswordException;
import service.UserNotFoundException;
import service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

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
            throw new UserNotFoundException("name错误");
        }
        String salt = "今天你吃了吗?";
        String pwd = DigestUtils.md5DigestAsHex((salt + password.trim()).getBytes());
        if (Objects.equals(pwd, user.getPassword())) {
            return user;
        }
        throw new PasswordException("密码错误");
    }
}



