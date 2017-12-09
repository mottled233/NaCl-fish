package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import exception.BadInputException;

import util.DataPage;
import util.Log;

import bean.*;
import util.DBHelper;

public class Goods_DAO{
	
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

	public static List<Goods> item_getGoods_bycondition(List<Map<String,Object>> params) throws SQLException{
		List<Goods> resultGoods = new ArrayList<Goods>();
		
		Connection con = DBHelper.getConnection();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select * from goods where 1=1 ");
		
		if(params != null && params.size( )> 0){
			for (int i = 0; i < params.size(); i++) {
				Map<String,Object> map = params.get(i);
				sb.append("and "+ map.get("name") + " " + map.get("rela") + " " + map.get("'value'"));
			}
		}
		PreparedStatement ptmt = con.prepareStatement(sb.toString());
		ResultSet rs = ptmt.executeQuery();
		
		Goods good = null;
		while(rs.next()){
			good = new Goods();
			good.setgID(rs.getInt("Gid"));
			good.setgImg(rs.getString("Gimg"));
			good.setgKind(rs.getString("Gkind"));
			good.setgLocation(rs.getString("Glocation"));
			good.setgName(rs.getString("Gname"));
			good.setgPrice(rs.getDouble("Price"));
			good.setOwner(rs.getString("Owner"));
			
			resultGoods.add(good);
		}
		
		return resultGoods;
	}
	
	public static GoodInfo Item_getDetailInfo(int GID) {
		// TODO 自动生成的方法存根
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


	public static ArrayList<Goods> Item_getRank(String Rank,int mode) {
		Connection conn=null;
		PreparedStatement statement=null;
		// TODO 自动生成的方法存根
		String str="select * from goods limit 1000";
		switch(mode){
		case 0://依据访问量
			str="select * from goodinfo natural join goods wher GKind='"+Rank+"' order by Gview limit 1000";
			break;
		case 1://依据收藏量

			str="select * from goodinfo natural join goods wher GKind='"+Rank+"' order by Gcollect limit 1000";
			break;
		case 2://依据点赞量
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
			// TODO 自动生成的 catch 块
			util.Log.e("关闭数据库连接时发生错误");
			return null;
		}finally{
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				util.Log.e("关闭数据库连接时发生错误");
				e.printStackTrace();
			}
		}
		
		
	}

	public static DataPage<Goods> Item_getListByKeyword(String[] keyword,int currentPage,int recordPerPage,String[] params) {
		Connection conn = null;
		PreparedStatement statement=null;
		ResultSet rs=null;
		
		
		
		try {
			conn = DBHelper.getConnection();
			String str;
			ArrayList<Goods> result = new ArrayList<Goods>();
			str = "select * from goods where true";
			
			if (keyword.length!=0) {
				
				for (int i = 0; i < keyword.length; i++) {
					str += " and '%" + keyword[i] + "%'";
				}
			}
			if(params[0]!=null&&!params[0].equals("")){
				str+="and gkind like ? ";
			}
			if(params[1]!=null&&!params[1].equals("")){
				str+="and gprice>?";
			}
			if(params[2]!=null&&!params[2].equals("")){
				str+="and gprice<?";
			}
			
			
			
			str += "limit"+(currentPage-1)*recordPerPage+","+currentPage*recordPerPage;
			statement=conn.prepareStatement(str);
			
			
			statement.setString(1,params[0]);
			statement.setDouble(2, Double.parseDouble(params[1]));
			statement.setDouble(3, Double.parseDouble(params[2]));
			rs = statement.executeQuery();
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
			str = "select count(*) from goods where true";
			
			if (keyword.length!=0) {
				
				for (int i = 0; i < keyword.length; i++) {
					str += " and '%" + keyword[i] + "%'";
				}
			}
			if(params[0]!=null&&!params[0].equals("")){
				str+="and gkind like ? ";
			}
			if(params[1]!=null&&!params[1].equals("")){
				str+="and gprice>?";
			}
			if(params[2]!=null&&!params[2].equals("")){
				str+="and gprice<?";
			}
			
			
			
			str += "limit"+(currentPage-1)*recordPerPage+","+currentPage*recordPerPage;
			statement=conn.prepareStatement(str);
			
			
			statement.setString(1,params[0]);
			statement.setDouble(2, Double.parseDouble(params[1]));
			statement.setDouble(3, Double.parseDouble(params[2]));
			rs = statement.executeQuery();
			rs.next();
			int total = rs.getInt(0);
			DataPage<Goods> res=new DataPage<Goods>(total,recordPerPage,currentPage);
			res.setList(result);
			return res;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			util.Log.e("关闭数据库连接时发生错误");
			return null;
		}catch(BadInputException e){
			util.Log.e("输入错误");
			return null;
		}
		finally{
			try {
				rs.close();
				statement.close();
				conn.close();

			} catch (SQLException e) {
				util.Log.e("关闭数据库连接时发生错误");
				e.printStackTrace();
			}
		}

	}

	public static ArrayList<Goods> Item_getListByClass(String category) {
		// TODO 自动生成的方法存根
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
			// TODO 自动生成的 catch 块
			util.Log.e("关闭数据库连接时发生错误");
			return null;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				util.Log.e("关闭数据库连接时发生错误");
				e.printStackTrace();
			}
		}

		return null;
	}

	public static ArrayList<Comment> Item_getCritisizes(int ItemID) {
		// TODO 自动生成的方法存根
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
			// TODO 自动生成的 catch 块
			util.Log.e("关闭数据库连接时发生错误");
			return null;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				util.Log.e("关闭数据库连接时发生错误");
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
			// TODO 自动生成的 catch 块
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
			// TODO 自动生成的 catch 块
			util.Log.e("关闭数据库连接时发生错误");
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				util.Log.e("关闭数据库连接时发生错误");
				e.printStackTrace();
			}
		}

	}

}
