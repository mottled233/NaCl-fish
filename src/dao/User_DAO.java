package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Users;
import util.DBHelper;

public class User_DAO{

	public static boolean User_checkin(String User_ID, String password) {
		try {
			Connection connection=DBHelper.getConnection();
			Statement statement=connection.createStatement();
			String str="select password from users where Username='"+User_ID+"'";
			ResultSet rs=statement.executeQuery(str);
			String password_pre=rs.getString(0);
			rs.close();
			statement.close();
			if(password_pre.equals(password))
				return true;
			return false;
			
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("SQL fail in checkin");
		}
		
		return false;
	}

	public static Users User_getInf(String User_ID) {
		// TODO 自动生成的方法存根
		try {
			Users user=new Users();
			Connection connection=DBHelper.getConnection();
			Statement statement=connection.createStatement();
			String str="select * from users where Username='"+User_ID+"'";
			ResultSet rs=statement.executeQuery(str);
			String password=rs.getString("Password");
			String HeadImg=rs.getString("HeadImg");
			String Address=rs.getString("Address");
			String PhoneNumber=rs.getString("PhoneNumber");
			String QQ=rs.getString("QQ");
			String Email=rs.getString("Email");
			double balance=rs.getDouble("Balance");
			user.setAddress(Address);
			user.setBalance(balance);
			user.setEmail(Email);
			user.setQq(QQ);
			user.setPassword(password);
			user.setHeadImg(HeadImg);
			user.setPhoneNumber(PhoneNumber);
			rs.close();
			statement.close();
			return user;
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("SQL fail in checkin");
		}
		return null;
	}

	public static void Register(Users user) {
		// TODO 自动生成的方法存根
		try {
			Connection connection=DBHelper.getConnection();
			Statement statement=connection.createStatement();
			String str="Insert into users values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getHeadImg()+"','"+user.getAddress()+"','"+user.getPhoneNumber()+"','"+user.getQq()+"','"+user.getEmail()+"','"+user.getBalance()+"')";
			statement.executeUpdate(str);
			statement.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("SQL fail in Register");
		}
	}

	public static void User_Update(Users user) {
		// TODO 自动生成的方法存根
		try {
			Connection connection=DBHelper.getConnection();
			Statement statement=connection.createStatement();
			String str="Update users set Password='"+user.getPassword()+"',HeadImg='"+user.getHeadImg()+"',Address='"+user.getAddress()+"',PhoneNumber='"+user.getPhoneNumber()+"',QQ='"+user.getQq()+"',Email='"+user.getEmail()+"',Balance='"+user.getBalance()+"' where username='"+user.getUsername()+"'";
			
			statement.executeUpdate(str);
			statement.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("SQL fail in Update");
		}
	}

}
