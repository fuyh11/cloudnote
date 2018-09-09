package mapper;


import dao.UserDao;

public interface UserMapper {
	
	UserDao findUserByName(String name);

}
