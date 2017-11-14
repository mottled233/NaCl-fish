package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Users;
import util.DBHelper;

public class User implements UserDAO {

	public boolean User_checkin(String User_ID, String password) {
		try {
			Connection connection=DBHelper.getConnection();
			Statement statement=connection.createStatement();
			String str="select * from Users where UserID='"+User_ID+"'";
			ResultSet rs=
			
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return false;
	}

	public Users User_getInf(String User_ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	public void Rigist(Users user) {
		// TODO 自动生成的方法存根

	}

	public void User_Update(Users user) {
		// TODO 自动生成的方法存根

	}

}
