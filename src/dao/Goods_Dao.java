package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Goods;
import util.DBHelper;

public class Goods_Dao{

	public static Goods Item_getDdtailInf(int GID) {
		// TODO 自动生成的方法存根
		return null;
	}

	public static ArrayList<Goods> Item_getRank(String Rank) {
		// TODO 自动生成的方法存根
		return null;
	}

	public static ArrayList<Goods> Item_getListByKeyword(String[] keyword) {
		// TODO 自动生成的方法存根
		return null;
	}

	public static ArrayList<Goods> Item_getListByClass(String category) {
		// TODO 自动生成的方法存根
		try {
			Connection conn=DBHelper.getConnection();
			Statement statement=conn.createStatement();
			ResultSet rs;
			String str;
			ArrayList<Goods> result =new ArrayList<Goods>();
			
			str="select * from goods where Gkind="+category;
			rs=statement.executeQuery(str);
			while(rs.next()){
				Goods good =new Goods();
				good.setgID(rs.getInt("Gid"));
				good.setgImg(rs.getString("Gimg"));
				good.setgKind(rs.getString("Gkind"));
				good.setgLocation(rs.getString("Glocation"));
				good.setgName(rs.getString("Gname"));
				good.setgPrice(rs.getDouble("Price"));
				good.setOwner(rs.getString("Owner"));
				result.add(good);
			}
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("Order create Fail!");
			return null;
		}
		
		return null;
	}

	public static ArrayList<String> Item_getCritisizes(int ItemID) {
		// TODO 自动生成的方法存根
		return null;
	}

	public static void Item_Issue(Goods item) {
		// TODO 自动生成的方法存根

	}

	public static void Item_LeaveStore(int ItemID) {
		// TODO 自动生成的方法存根

	}

}
