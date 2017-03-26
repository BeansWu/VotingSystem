package vs.service;

import java.util.ArrayList;

import vs.entity.User;

public interface UserService {
	//用户登陆验证
	int userLoginCheck(String id, String password);
	//投票
	boolean vote(String id);
	//注册
	boolean register(User user);
	//查询用户信息
	User getUser(String id);
	//获得所有候选人的信息
	ArrayList<User> getCandidates();
	//获得所有非候选人的信息
	ArrayList<User> getOthers();
	//增加候选人
	boolean addCandidate(String id);
	//删除候选人
	boolean delCandidate(String id);
}
