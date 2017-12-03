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
			util.Log.e("��ȡ����ʱ��������");
			return null;
		} finally{
			try {
				connection.close();
			} catch (SQLException e) {
				util.Log.e("�ر����ݿ�����ʱ��������");
				e.printStackTrace();
			}
		}
	}

	public static Goods Item_getDetailInfo(int GID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	public static ArrayList<Goods> Item_getRank(String rank) {
		// TODO �Զ����ɵķ������
		return null;
	}

	public static ArrayList<Goods> Item_getListByKeyword(String[] keyword) {
		// TODO �Զ����ɵķ������
		return null;
	}

	public static ArrayList<Goods> Item_getListByClass(String category) {
		// TODO �Զ����ɵķ������
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
			// TODO �Զ����ɵ� catch ��
			System.out.println("Order create Fail!");
			return null;
		}
		
		return null;
	}

	public static ArrayList<String> Item_getCritisizes(int ItemID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	public static void Item_Issue(Goods item) {
		// TODO �Զ����ɵķ������

	}

	public static void Item_LeaveStore(int ItemID) {
		// TODO �Զ����ɵķ������

	}

}
