package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.Log;

import bean.Goods;
import util.DBHelper;

public class Goods_Dao{
	
	public static Goods item_getGoods(int GID){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		String sql = "select from goods where gid=?";
		try{
			connection = DBHelper.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, GID);
			
			rs = statement.executeQuery();
			Goods good = new Goods();
			if(rs.next()){
				good.setgID(rs.getInt("Gid"));
				good.setgImg(rs.getString("Gimg"));
				good.setgKind(rs.getString("Gkind"));
				good.setgLocation(rs.getString("Glocation"));
				good.setgName(rs.getString("Gname"));
				good.setgPrice(rs.getDouble("Price"));
				good.setOwner(rs.getString("Owner"));
				return good;
			}else
				return null;
		}catch(SQLException e){
			util.Log.e("获取数据时发生错误");
			return null;
		} finally{
			try {
				connection.close();
			} catch (SQLException e) {
				util.Log.e("关闭数据库连接时发生错误");
				e.printStackTrace();
			}
		}
	}

	public static Goods Item_getDetailInfo(int GID) {
		// TODO 自动生成的方法存根
		return null;
	}

	public static ArrayList<Goods> Item_getRank(String rank) {
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
