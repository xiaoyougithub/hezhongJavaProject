package live.hmj.test;

import live.hmj.dal.UserDal;
import live.hmj.entity.User;

public class UserTest {
	public static void main(String[] args) {
		UserDal dal=new UserDal();
		User user=new User();
		user.setUserName("»ÆÃ¯¿¡");
		user.setPassword("123456");
		System.out.println(dal.insertUser(user));
	}

}
