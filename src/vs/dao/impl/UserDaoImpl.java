package vs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vs.dao.UserDao;
import vs.entity.User;
import vs.util.DBHelper;

public class UserDaoImpl implements UserDao {
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	@Override
	public User findById (String id) {
		conn = DBHelper.getConnection();
		String sql = "select * from t_user where id = ?";
		User u = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()){
				String name = rs.getString("name");
				String password = rs.getString("password");
				int vote = rs.getInt("vote");
				int userType = rs.getInt("user_type");
				int isCandidate = rs.getInt("is_candidate");
				u = new User(id, name, password, vote, userType, isCandidate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(ps, conn);
		}
		return u;
	}

	@Override
	public int update(User user) {
		conn = DBHelper.getConnection();
		String sql = "update t_user set vote = ? , is_candidate = ? where id = ?";
		int result = 0;
		if (user != null) {
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, user.getVote());
				ps.setInt(2, user.getIsCandidate());
				ps.setString(3, user.getId());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBHelper.closeConnection(ps, conn);
			}
			
		}
		return result;
	}

	@Override
	public ArrayList<User> findAll() {
		ArrayList<User> users = new ArrayList<User>();
		conn = DBHelper.getConnection();
		String sql = "select * from t_user";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				int vote = rs.getInt("vote");
				int userType = rs.getInt("user_type");
				int isCandidate = rs.getInt("is_candidate");
				User user = new User(id, name, password, vote, userType, isCandidate);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(ps, conn);
		}
		return users;
	}

	@Override
	public int addUser(User user) {
		String sql = "insert into t_user values(?, ?, ?, ?, ?, ?, '0', '0', '1')";
		Connection conn= DBHelper.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getSex());
			ps.setString(5, user.getHobbies());
			ps.setString(6, user.getIntroduction());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConnection(ps, conn);
		}
		return result;
	}

}
