package vs.dao;

import java.util.ArrayList;

import vs.entity.User;

public interface UserDao {
	//根据 id 查找用户
	User findById(String id);
	//更新用户信息
	int update(User user);
	//查询所有用户的信息
	ArrayList<User> findAll();
	//增加用户
	int addUser(User user);
}
