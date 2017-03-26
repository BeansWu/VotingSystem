package vs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description: TODO 连接数据库的工具类
 * @author Andrew
 * @date 2017年3月19日
 */
public class DBHelper {
	//默认的数据库驱动名、URL、用户名、密码
		public static String JDBCNAME = "com.mysql.jdbc.Driver";
		public static String DBURL = "jdbc:mysql://localhost:3306/vs?useSSL=true&useUnicode=true&characterEncoding=UTF-8";
		public static String DBUSER = "root";
		public static String DBPASSWORD = "19951125wbs";
		
		public void configuration(String jdbcName, String dbURL, String dbUser, String dbPassword){
			JDBCNAME = jdbcName;
			DBURL = dbURL;
			DBUSER = dbUser;
			DBPASSWORD = dbPassword;
		}
		
		/**
		 * @Title: getConnection
		 * @Description: TODO 获得数据库连接
		 * @return Connection
		 */
		public static Connection getConnection(){
			Connection connection = null;
			try {
				//加载数据驱动
				Class.forName("com.mysql.jdbc.Driver");
				//通过驱动管理类获得一个数据库连接
				connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
		
		/**
		 * @Title: closeConnection 
		 * @Description: TODO 关闭数据库连接
		 * @param connection 
		 * @return void
		 */
		public static void closeConnection(Statement statement, Connection connection){
			if(statement != null){
				try {
					statement.close();
					if(connection != null){
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
