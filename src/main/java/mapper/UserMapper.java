package mapper;

import service.user.dataobject.UserDao;

public interface UserMapper {
	
	UserDao findUserByName(String name);

	int addUser(UserDao user);

	UserDao findUserById(String userId);

}
