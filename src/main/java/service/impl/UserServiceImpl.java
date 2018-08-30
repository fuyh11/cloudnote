package service.impl;

import javax.annotation.Resource;

import dao.UserDAO;
import mapper.UserMapper;
import org.springframework.stereotype.Service;


import org.springframework.util.DigestUtils;
import service.PasswordException;
import service.UserNotFoundException;
import service.UserService;


@Service("userService")
public class UserServiceImpl 
	implements UserService {
	
	@Resource
	private UserMapper userMapper;
	
	public UserDAO login(String name, String password)
			throws UserNotFoundException,
			PasswordException {
		if(password==null ||
				password.trim().isEmpty()){
			throw new PasswordException("密码空");
		}
		if(name==null || name.trim().isEmpty()){
			throw new UserNotFoundException("用户名空");
		}
		UserDAO user = userMapper.findUserByName(
				name.trim());
		if(user==null){
			throw new UserNotFoundException("name错误");
		}
		String salt="今天你吃了吗?";
		String pwd = password;
//		String pwd = DigestUtils.md5Hex(
//				salt+password.trim());
		if(pwd.equals(user.getPassword())){
			return user;
		}
		throw new PasswordException("密码错误");
	}
}



