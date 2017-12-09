package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Users;
import util.DBHelper;
import util.Log;

public class User_DAO{

	public static boolean User_checkin(String User_ID, String password)   {
			String password_pre = null;
			Connection con = null;
			PreparedStatement ptmt  = null;
			try{
				con = DBHelper.getConnection();
				String str = "select Password from users where Username=?";
				ptmt = con.prepareStatement(str);
				ptmt.setString(1, User_ID);
				
				Log.d(ptmt.toString());
				ResultSet rs = ptmt.executeQuery();
				while(rs.next()){
					password_pre = rs.getString("Password");
				}
			} catch(SQLException e){
				e.printStackTrace();
			}
		    if(password_pre.equals(password)){
		    	System.out.println("成攻！");
		    	return true;
		    } else{
		    	System.out.println("失败！");
		    	return false;
		    }
		
//			String password_pre =null;
//			try{Connection connection=DBHelper.getConnection();
//			Statement statement=connection.createStatement();
//			String str="select Password from users where Username='"+User_ID+"'";
//			System.out.println(str);
//			ResultSet rs=statement.executeQuery(str);
//			while(rs.next()){
//			password_pre = rs.getString("Password");
//			}
//			} catch (SQLException e){
//				e.printStackTrace();
//			}
//			if(password_pre.equals(password)){
//				System.out.println("验证成功！");
//				return true;}
//				
//			else{return false;}
//			
//			rs.close();
//			statement.close();

		
	}

	public static Users User_getInf(String User_ID) {
		// TODO 自动生成的方法存根
		Connection connection = null;
		PreparedStatement ptmt  = null;
		ResultSet rs = null;
		Users user=null;
		try {
			
			connection=DBHelper.getConnection();
			String str="select * from users where Username=?";
			ptmt = connection.prepareStatement(str);
			ptmt.setString(1, User_ID);
			Log.d(ptmt.toString());
			rs=ptmt.executeQuery();
		
		
			while(rs.next()){
			user = new Users();
			user.setAddress(rs.getString("Address"));
			user.setBalance(rs.getDouble("Balance"));
			user.setEmail(rs.getString("Email"));
			user.setQq(rs.getString("QQ"));
			user.setPassword(rs.getString("Password"));
			user.setHeadImg(rs.getString("HeadImg"));
			user.setPhoneNumber(rs.getString("PhoneNumber"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("SQL fail in checkin");
		}
			return user;
			
			
		
		
	}

	public static void Register(Users user) {
		// TODO 自动生成的方法存根
		Connection connection = null;
		PreparedStatement ptmt  = null;
		try {
			connection=DBHelper.getConnection();
			String str="Insert into users values(?,?,?,?,?,?,?,?)";
			ptmt = connection.prepareStatement(str);
			
			ptmt.setString(1, user.getUsername());
			ptmt.setString(2, user.getPassword());
			ptmt.setString(3, user.getHeadImg());
			ptmt.setString(4, user.getAddress());
			ptmt.setString(5, user.getPhoneNumber());
			ptmt.setString(6, user.getQq());
			ptmt.setString(7, user.getEmail());
			ptmt.setDouble(8, user.getBalance());
			
			ptmt.execute();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("SQL fail in Register");
		}
	}

	public static void User_Update(Users user) {
		// TODO 自动生成的方法存根
		Connection connection = null;
		PreparedStatement ptmt  = null;
		try {
			connection=DBHelper.getConnection();
			
			String str="Update users set Password=?,HeadImg=?,Address=?,PhoneNumber=?,QQ=?,Email = ?,Balance=? where username=?";
			
			ptmt = connection.prepareStatement(str);
			ptmt.setString(1, user.getPassword());
			ptmt.setString(2, user.getHeadImg());
			ptmt.setString(3, user.getAddress());
			ptmt.setString(4, user.getPhoneNumber());
			ptmt.setString(5, user.getQq());
			ptmt.setString(6, user.getEmail());
			ptmt.setDouble(7, user.getBalance());
			ptmt.setString(8, user.getUsername());
			
			ptmt.execute();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("SQL fail in Update");
		}
	}

}
