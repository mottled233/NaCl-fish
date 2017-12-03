package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import util.Log;

import bean.*;
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

	public static GoodInfo Item_getDetailInfo(int GID) {
		// TODO �Զ����ɵķ������

		return null;
	}


	public static ArrayList<Goods> Item_getRank(String Rank,int mode) {

		// TODO �Զ����ɵķ������
		String str="select * from goods limit 1000";
		switch(mode){
		case 0://���ݷ�����
			str="select * from goodinfo order by Gview limit 1000";
			break;
		case 1://�����ղ���

			str="select * from goodinfo order by Gcollect limit 1000";
			break;
		case 2://���ݵ�����
			str="select * from goodinfo order by Gnice limit 1000";
			break;
		default:
			str="select * from goodinfo order by Gview limit 1000";
			break;
		}
		try {
			Connection conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			ArrayList<Goods> result = new ArrayList<Goods>();


			rs = statement.executeQuery(str);
			while (rs.next()) {
				Goods good = new Goods();
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
			return result;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("Rank create Fail!");
			return null;
		}
		
		
	}

	public static ArrayList<Goods> Item_getListByKeyword(String[] keyword) {
		// TODO �Զ����ɵķ������
		try {
			Connection conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;
			ArrayList<Goods> result = new ArrayList<Goods>();

			str = "select * from goods where Gname like";

			for (int i = 0; i < keyword.length - 1; i++) {
				str += "'%" + keyword[i] + "%' and";
			}
			str += "'%" + keyword[keyword.length] + "%'";

			rs = statement.executeQuery(str);
			while (rs.next()) {
				Goods good = new Goods();
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

	public static ArrayList<Goods> Item_getListByClass(String category) {
		// TODO �Զ����ɵķ������
		try {
			Connection conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;
			ArrayList<Goods> result = new ArrayList<Goods>();

			str = "select * from goods where Gkind='" + category+"'";
			rs = statement.executeQuery(str);
			while (rs.next()) {
				Goods good = new Goods();
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

	public static ArrayList<Comment> Item_getCritisizes(int ItemID) {
		// TODO �Զ����ɵķ������
		try {
			Connection conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;
			ArrayList<Comment> result = new ArrayList<Comment>();

			str = "select * from comment where GID="+ItemID;
			rs = statement.executeQuery(str);
			while (rs.next()) {
				Comment comm=new Comment();
				comm.setcID(rs.getInt("Cid"));
				comm.setcTime(rs.getDate("Ctime"));
				comm.setContent(rs.getString("Content"));
				comm.setcType(rs.getInt("Ctype"));
				comm.setUsername(rs.getString("Username"));
				comm.setgID(rs.getInt("Gid"));
				comm.setReplyname(rs.getString("Replyname"));
				comm.setParentid(rs.getString("Parentid"));
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

	public static int Item_Issue(Goods item, GoodInfo detail) {
		int gid = -1;
		// TODO �Զ����ɵķ������
		try {
			Connection conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;

			str = "insert into goods(gNmae,gPrice,gKind,Owner,gLocation,gImg) values=('"+ item.getgName() + "','" + item.getgPrice() + "','"
					+ item.getgKind() + "','" + item.getOwner() + "','" + item.getgLocation() +"','"+ item.getgImg() + "')";
			statement.executeUpdate(str);
			rs = statement.getGeneratedKeys();
			rs.next();
			gid = rs.getInt(1);
			
			statement.close();
			conn.close();
			return gid;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("Issue good Fail!");
			return -1;
		}
	}

	public static void Item_LeaveStore(int ItemID) {
		// TODO �Զ����ɵķ������
		try {
			Connection conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;

			str = "delete from goods where Gid=" + ItemID;
			statement.executeUpdate(str);
			statement.close();
			conn.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("Leavestore Fail!");
			return;
		}

	}

}
