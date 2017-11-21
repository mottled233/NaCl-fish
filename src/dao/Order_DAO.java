package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.org.apache.regexp.internal.recompile;

import bean.Goods;
import bean.Users;
import util.DBHelper;

public class Order_DAO {

	public static int Order_Create(String costumer_ID, int Item_ID) {

		try {
			Connection conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;
			str = "select * from goods where Gid=" + Item_ID;
			rs = statement.executeQuery(str);

			str = "Insert into order(Buyer,Seller,Transid,Ostatus,Gid) values(" + costumer_ID + ","
					+ rs.getString("Owner") + ",-1,0," + Item_ID + ")";
			statement.executeUpdate(str);
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("Order create Fail!");
			return -1;
		}

		return 0;
	}

	public static ArrayList<bean.Order> Order_getList(String User_ID, String category) {
		// TODO 自动生成的方法存根
		ArrayList<bean.Order> result = new ArrayList<bean.Order>();

		try {
			Connection conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;

			str = "select * from order where Buyer=" + User_ID + " OR Seller=" + User_ID;
			rs = statement.executeQuery(str);
			while (rs.next()) {
				bean.Order order = new bean.Order();
				order.setBuyer(rs.getString("Buyer"));
				order.setgID(rs.getInt("Gid"));
				order.setoID(rs.getInt("Oid"));
				order.setoStatus(rs.getInt("Ostatus"));
				order.setSeller(rs.getString("Seller"));
				order.setTransID(rs.getString("Transid"));
				result.add(order);
			}
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("Order create Fail!");
			return null;
		}

		return result;
	}

	public static void Order_Sent(int Order_ID, String Sent_ID) {
		// TODO 自动生成的方法存根
		try {
			Connection conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;

			str = "Update order set Transid=" + Sent_ID + ",Ostatus=1 where Oid=" + Order_ID;
			statement.executeUpdate(str);
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("Sent Fail!");
		}

	}

	public static void Order_Pay(int Order_ID) {
		// TODO 自动生成的方法存根

	}

	public static bean.Order Order_getDetails(int Order_ID) {
		// TODO 自动生成的方法存根
		try {
			Connection conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;

			str = "select * from order where Oid="+Order_ID;
			rs = statement.executeQuery(str);
			bean.Order order = new bean.Order();
			order.setBuyer(rs.getString("Buyer"));
			order.setgID(rs.getInt("Gid"));
			order.setoID(rs.getInt("Oid"));
			order.setoStatus(rs.getInt("Ostatus"));
			order.setSeller(rs.getString("Seller"));
			order.setTransID(rs.getString("Transid"));

			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return null;
	}

}
