package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.Log;


public class DBHelper {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	// localhost指本机，也可以用本地ip地址代替，3306为MySQL数据库的默认端口号，“user”为要连接的数据库名
	private static final String url = "jdbc:mysql://localhost:3306/naclfish";
	
	// 填入数据库的用户名跟密码
	private static final String username = "root";
	private static final String password = "";
	
	public static Connection getConnection() throws SQLException{
		Connection con = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			Log.e("数据库连接失败！");
			e.printStackTrace();
		}// 加载驱动程序，此处运用隐式注册驱动程序的方法
		try{
			con = DriverManager.getConnection(url, username, password);// 创建连接对象
		}catch(Exception e){
			Log.e("数据库初始化时遇到问题");
			e.printStackTrace();
		}
		return con;
	}
	
	
}