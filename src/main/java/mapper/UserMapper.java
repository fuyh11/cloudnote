package mapper;


import dao.UserDao;

public interface UserMapper {
	
	UserDao findUserByName(String name);

	int addUser(UserDao user);

	UserDao findUserById(String userId);

}
