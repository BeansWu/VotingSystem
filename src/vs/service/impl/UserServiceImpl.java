package vs.service.impl;

import java.util.ArrayList;

import vs.dao.UserDao;
import vs.dao.impl.UserDaoImpl;
import vs.entity.User;
import vs.service.UserService;

public class UserServiceImpl implements UserService {

	private static UserDao userDao;
	{
		userDao = new UserDaoImpl();
	}
	
	@Override
	public int userLoginCheck(String id, String password) {
		User u = userDao.findById(id);
		if (u != null) {
			if (password.equals(u.getPassword())) {
				if (u.getUserType() == 1) {
					return 2;
				} else {
					return 1;
				}
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}

	@Override
	public boolean vote(String id) {
		User u = userDao.findById(id);
		if (u != null) {
			u.setVote(u.getVote() + 1);
		}
		userDao.update(u);
		return true;
	}

	@Override
	public User getUser(String id) {
		return userDao.findById(id);
	}

	@Override
	public boolean addCandidate(String id) {
		User u = userDao.findById(id);
		u.setIsCandidate(1);
		userDao.update(u);
		return true;
	}

	@Override
	public boolean delCandidate(String id) {
		User u = userDao.findById(id);
		u.setIsCandidate(0);
		userDao.update(u);
		return true;
	}

	@Override
	public boolean register(User user) {
		if (userDao.addUser(user) <= 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public ArrayList<User> getCandidates() {
		ArrayList<User> users = userDao.findAll();
		ArrayList<User> candidates = new ArrayList<User>();
		for (User user : users) {
			if (user.getIsCandidate() == 1) {
				candidates.add(user);
			}
		}
		return candidates;
	}

	@Override
	public ArrayList<User> getOthers() {
		ArrayList<User> users = userDao.findAll();
		ArrayList<User> others = new ArrayList<User>();
		for (User user : users) {
			if (user.getIsCandidate() == 0) {
				others.add(user);
			}
		}
		return others;
	}

}
