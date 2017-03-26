package vs.test;

import org.junit.Test;

import vs.service.UserService;
import vs.service.impl.UserServiceImpl;

public class TestUserService {

	UserService userService = null;
	{
		userService = new UserServiceImpl();
	}
	
	@Test
	public void testUserLoginCheck() {
		int result = userService.userLoginCheck("105032014035", "12345");
		System.out.println(result);
	}

	@Test
	public void testVote() {
		userService.vote("105032014035");
	}

	@Test
	public void testAddCandidate() {
		userService.delCandidate("1");
	}
}
