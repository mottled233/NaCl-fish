package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import exception.BadInputException;

import util.DataPage;
import util.Log;

import bean.*;
import util.DBHelper;

public class Goods_Dao{
	
	public static Goods item_getGoods(int GID){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String s="1";
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
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String sql = "select from goodinfo where gid=?";
		try{
			connection = DBHelper.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, GID);
			
			rs = statement.executeQuery();
			GoodInfo good = new GoodInfo();
			if(rs.next()){
				good.setgID(rs.getInt("Gid"));
				good.setgInfo(rs.getString("Ginfo"));
				good.setgImgs(rs.getString("Gimgs"));
				good.setgNice(rs.getInt("Gnice"));
				good.setgCollect(rs.getInt("Gcollect"));
				good.setgView(rs.getInt("Gview"));
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


	public static ArrayList<Goods> Item_getRank(String Rank,int mode) {
		Connection conn=null;
		PreparedStatement statement=null;
		// TODO �Զ����ɵķ������
		String str="select * from goods limit 1000";
		switch(mode){
		case 0://���ݷ�����
			str="select * from goodinfo natural join goods wher GKind='"+Rank+"' order by Gview limit 1000";
			break;
		case 1://�����ղ���

			str="select * from goodinfo natural join goods wher GKind='"+Rank+"' order by Gcollect limit 1000";
			break;
		case 2://���ݵ�����
			str="select * from goodinfo natural join goods wher GKind='"+Rank+"' order by Gnice limit 1000";
			break;
		default:
			str="select * from goodinfo natural join goods wher GKind='"+Rank+"' order by Gview limit 1000";
			break;
		}
		try {
			conn = DBHelper.getConnection();
			statement = conn.prepareStatement(str);
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
			return result;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			util.Log.e("�ر����ݿ�����ʱ��������");
			return null;
		}finally{
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				util.Log.e("�ر����ݿ�����ʱ��������");
				e.printStackTrace();
			}
		}
		
		
	}

	public static DataPage<Goods> Item_getListByKeyword(String[] keyword,int currentPage,int recordPerPage,int top,int upper) {
		Connection conn = null;
		Statement statement=null;
		ResultSet rs=null;
		try {
			conn = DBHelper.getConnection();
			statement = conn.createStatement();
			String str;
			ArrayList<Goods> result = new ArrayList<Goods>();

			str = "select * from goods where Gname like";

			for (int i = 0; i < keyword.length; i++) {
				str += "'%" + keyword[i] + "%' and";
			}
			str+="gprice>"+top+"and gprice <"+upper+" ";
			str += "limit"+(currentPage-1)*recordPerPage+","+currentPage*recordPerPage;
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
			str="select count(*) from ("+str+")";
			rs = statement.executeQuery(str);
			rs.next();
			int total = rs.getInt(0);
			DataPage<Goods> res=new DataPage<Goods>(total,recordPerPage,currentPage);
			res.setList(result);
			return res;
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			util.Log.e("�ر����ݿ�����ʱ��������");
			return null;
		}catch(BadInputException e){
			util.Log.e("�������");
			return null;
		}
		finally{
			try {
				rs.close();
				statement.close();
				conn.close();

			} catch (SQLException e) {
				util.Log.e("�ر����ݿ�����ʱ��������");
				e.printStackTrace();
			}
		}

	}

	public static ArrayList<Goods> Item_getListByClass(String category) {
		// TODO �Զ����ɵķ������
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
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
			util.Log.e("�ر����ݿ�����ʱ��������");
			return null;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				util.Log.e("�ر����ݿ�����ʱ��������");
				e.printStackTrace();
			}
		}

		return null;
	}

	public static ArrayList<Comment> Item_getCritisizes(int ItemID) {
		// TODO �Զ����ɵķ������
		Connection conn=null;
		try {
			conn = DBHelper.getConnection();
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
			util.Log.e("�ر����ݿ�����ʱ��������");
			return null;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				util.Log.e("�ر����ݿ�����ʱ��������");
				e.printStackTrace();
			}
		}
		
		
		return null;
	}

	public static int Item_Issue(Goods item, GoodInfo detail) {
		int gid = -1;
		Connection conn;
		try {
			conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;

			str = "insert into goods(gNmae,gPrice,gKind,Owner,gLocation,gImg) values=('"+ item.getgName() + "','" + item.getgPrice() + "','"
					+ item.getgKind() + "','" + item.getOwner() + "','" + item.getgLocation() +"','"+ item.getgImg() + "')";
			statement.executeUpdate(str);
			rs = statement.getGeneratedKeys();
			rs.next();
			gid = rs.getInt(1);
			
			str = "insert into goodinfo(Gid,Ginfo,Gimgs,Gnice,Gcollect,Gview) values=("+ detail.getgID() + ",'" + detail.getgInfo() + "','"
					+ detail.getgImgs() + "'," + detail.getgNice() + "," + detail.getgCollect() +","+ detail.getgView()+ ")";
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
		Connection conn = null;
		try {
			conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;

			str = "delete from goods where Gid=" + ItemID;
			statement.executeUpdate(str);
			str = "delete from goodinfo where gid="+ItemID;
			statement.executeUpdate(str);
			statement.close();
			conn.close();
		}catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			util.Log.e("�ر����ݿ�����ʱ��������");
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				util.Log.e("�ر����ݿ�����ʱ��������");
				e.printStackTrace();
			}
		}

	}

}
