package test;

import dao.UserDAO;
import junit.runner.BaseTestRunner;
import mapper.UserMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserDaoTest{
	protected ClassPathXmlApplicationContext ctx;

	@Before
	public void initCtx() {
		ctx = new ClassPathXmlApplicationContext(
				"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml",
				"conf/spring-service.xml");
	}

	@After
	public void close() {
		ctx.close();
	}
	
	@Test
	public void testFindUserByName(){
		String name = "demo";
		UserMapper dao = ctx.getBean(
			"userDao", UserMapper.class);
		UserDAO user = dao.findUserByName(name);
		System.out.println(user); 
	}
}





