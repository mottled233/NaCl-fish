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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return false;
	}

	public Users User_getInf(String User_ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	public void Rigist(Users user) {
		// TODO �Զ����ɵķ������

	}

	public void User_Update(Users user) {
		// TODO �Զ����ɵķ������

	}

}
