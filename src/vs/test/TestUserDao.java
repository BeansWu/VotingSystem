package vs.test;

import java.util.List;

import org.junit.Test;

import vs.dao.UserDao;
import vs.dao.impl.UserDaoImpl;
import vs.entity.User;

public class TestUserDao {

	UserDao userDao;
	{
		userDao = new UserDaoImpl();
	}
	
	@Test
	public void testFindById() {
		User u = userDao.findById("105032014035");
		if (u != null) {
			System.out.println(u);
		}
	}

	@Test
	public void testUpdate() {
		User u = userDao.findById("105032014001");
		if (u != null) {
			u.setVote(u.getVote() + 1);
			System.out.println(userDao.update(u));
		}
	}
	
	@Test
	public void testFindAll() {
		List<User> users = userDao.findAll();
		for (User u : users) {
			System.out.println(u);
		}
	}

	@Test
	public void testAddUser () {
//		File f = new File("resources" + File.separator + "introduction.txt");
//		User u = new User("105032014001", "Sam", "12345", "male", "画画;唱歌", f);
//		System.out.println(userDao.addUser(u));
	}

}
