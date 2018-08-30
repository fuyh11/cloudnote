package mapper;


import dao.UserDAO;

public interface UserMapper {
	
	UserDAO findUserByName(String name);

}
