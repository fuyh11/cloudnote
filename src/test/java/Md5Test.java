
import org.junit.Test;
import org.springframework.util.DigestUtils;

public class Md5Test {
	
	@Test
	public void testMd5(){
		String str = "123456";
		String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
		System.out.println(md5); 
		//e10adc3949ba59abbe56e057f20f883e
		//加盐摘要
		String salt = "今天你吃了吗?";
		md5 = DigestUtils.md5DigestAsHex((salt + str.trim()).getBytes());
		System.out.println(md5); 
		//8bbf37d0962bf915a780f410ec1a4741
		// update cn_user 
		// set cn_user_password='8bbf37d0962bf915a780f410ec1a4741'
		// where cn_user_name='demo';
		
	}
}





