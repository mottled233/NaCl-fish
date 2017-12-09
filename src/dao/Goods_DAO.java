package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.Size2DSyntax;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;
import javax.xml.soap.Detail;

import exception.BadInputException;

import util.DataPage;
import util.Log;

import bean.*;
import util.DBHelper;

public class Goods_DAO{
	
	public static void main(String[] args) throws SQLException{
		Goods goods = item_getGoods(1);
		Log.d("in item get goods");
		Log.d("id"+goods.getgID());
		Log.d("kind"+goods.getgKind());
		Log.d("name"+goods.getgName());
		Log.d("gPrice"+goods.getgPrice());
		GoodInfo info = Item_getDetailInfo(1);
		Log.d("in item get info");
		Log.d("id"+info.getgID());
		Log.d("info"+info.getgInfo());
		Log.d("img"+info.getgImgs());
		Log.d("nice"+info.getgNice());
		Log.d("view"+info.getgView());
		
		
		goods.setgID(-1);
		goods.setgName("测试用物品 电子数码 照相机");
		goods.setgPrice(25.00);
		goods.setgKind("数码");
		goods.setgLocation("山东 济南");
		goods.setOwner("mottled");
		
		info.setgInfo("测试用物品，暂不出售，谢谢合作");
		info.setgNice(2);
		info.setgView(1000);
		Log.d("in item issue");
		int gid = Item_Issue(goods, info);
		Log.d(""+gid);
		
		
		List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("name", "owner");
		param.put("rela", "=");
		param.put("value", "'mottled'");
		params.add(param);
		
		List<Goods> list1 = item_getGoods_bycondition(params);
		Log.d("in test item get by condition");
		for(int i = 0;i<list1.size();i++){
			Log.d(""+i+":");
			goods = list1.get(i);
			Log.d("id"+goods.getgID());
			Log.d("kind"+goods.getgKind());
			Log.d("name"+goods.getgName());
			Log.d("gPrice"+goods.getgPrice());
		}
		
		list1 = Item_getRank("数码",0);
		Log.d("in test item get by kind rank");
		for(int i = 0;i<list1.size();i++){
			Log.d(""+i+":");
			goods = list1.get(i);
			Log.d("id"+goods.getgID());
			Log.d("kind"+goods.getgKind());
			Log.d("name"+goods.getgName());
			Log.d("gPrice"+goods.getgPrice());
		}
		
		String[] aaa = {"照相机","测试"};
		DataPage<Goods> dPage = Item_getListByKeyword(aaa, 1, 20, new String[3]);
		Log.d("in test getKeyword");
		Log.d("TotalRecord"+dPage.getTotalRecord());
		Log.d("TotalPage"+dPage.getTotalPage());
		Log.d("CurrentPage"+dPage.getCurrentPage());
		list1 = dPage.getList();
		for(int i = 0;i<list1.size();i++){
			Log.d(""+i+":");
			goods = list1.get(i);
			Log.d("id"+goods.getgID());
			Log.d("kind"+goods.getgKind());
			Log.d("name"+goods.getgName());
			Log.d("gPrice"+goods.getgPrice());
		}
		
		
		Log.d("in test get by class");
		list1 = Item_getListByClass("数码");
		for(int i = 0;i<list1.size();i++){
			Log.d(""+i+":");
			goods = list1.get(i);
			Log.d("id"+goods.getgID());
			Log.d("kind"+goods.getgKind());
			Log.d("name"+goods.getgName());
			Log.d("gPrice"+goods.getgPrice());
		}
		
		Item_LeaveStore(0);
		
	}
	
	public static Goods item_getGoods(int GID){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String sql = "select * from goods where gid=?";
		try{
			connection = DBHelper.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, GID);
			Log.d(statement.toString());
			rs = statement.executeQuery();
			Goods good = new Goods();
			if(rs.next()){
				Log.d("111");
				good.setgID(rs.getInt("Gid"));
				good.setgImg(rs.getString("Gimg"));
				good.setgKind(rs.getString("Gkind"));
				good.setgLocation(rs.getString("Glocation"));
				good.setgName(rs.getString("Gname"));
				good.setgPrice(rs.getDouble("gPrice"));
				good.setOwner(rs.getString("Owner"));
				return good;
			}else{

				Log.d("111");
				return null;
			}
		}catch(SQLException e){
			util.Log.e("获取数据时发生错误");
			e.printStackTrace();
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
		Log.d(sb.toString());
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
			good.setgPrice(rs.getDouble("gPrice"));
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
		String sql = "select * from goodinfo where gid=?";
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
			e.printStackTrace();
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
			str="select * from goodinfo natural join goods where GKind='"+Rank+"' order by Gview  limit 0,1000 ";
			break;
		case 1://依据收藏量

			str="select * from goodinfo natural join goods where GKind='"+Rank+"' order by Gcollect limit 0,1000";
			break;
		case 2://依据点赞量
			str="select * from goodinfo natural join goods where GKind='"+Rank+"' order by Gnice limit 0,1000";
			break;
		default:
			str="select * from goodinfo natural join goods where GKind='"+Rank+"' order by Gview limit 0,1000";
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
				good.setgPrice(rs.getDouble("gPrice"));
				good.setOwner(rs.getString("Owner"));
				result.add(good);
			}
			rs.close();
			return result;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			util.Log.e("数据库连接时发生错误");
			e.printStackTrace();
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
					str += " and gname like '%" + keyword[i] + "%'";
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
			
			
			
			str += " limit "+(currentPage-1)*recordPerPage+","+currentPage*recordPerPage;
			statement=conn.prepareStatement(str);
			
			
			int index = 1;
			for(int i = 0;i<3;i++){
				if(params[i]!=null&&!params[i].equals(""))
					statement.setString(index++,params[i]);
			}
			rs = statement.executeQuery();
			while (rs.next()) {
				Goods good = new Goods();
				good.setgID(rs.getInt("Gid"));
				good.setgImg(rs.getString("Gimg"));
				good.setgKind(rs.getString("Gkind"));
				good.setgLocation(rs.getString("Glocation"));
				good.setgName(rs.getString("Gname"));
				good.setgPrice(rs.getDouble("gPrice"));
				good.setOwner(rs.getString("Owner"));
				result.add(good);
			}
			str = "select count(*) from goods where true";
			
			if (keyword.length!=0) {
				
				for (int i = 0; i < keyword.length; i++) {
					str += " and gname like '%" + keyword[i] + "%'";
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
			
			statement=conn.prepareStatement(str);
			
			index = 1;
			for(int i = 0;i<3;i++){
				if(params[i]!=null&&!params[i].equals(""))
					statement.setString(index++,params[i]);
			}
			
			Log.d(statement.toString());
			rs = statement.executeQuery();
			rs.next();
			int total = rs.getInt("count(*)");
			DataPage<Goods> res=new DataPage<Goods>(total,recordPerPage,currentPage);
			res.setList(result);
			return res;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			util.Log.e("数据库连接时发生错误");
			e.printStackTrace();
			return null;
		}catch(BadInputException e){
			util.Log.e("输入错误");
			e.printStackTrace();
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
				good.setgPrice(rs.getDouble("gPrice"));
				good.setOwner(rs.getString("Owner"));
				result.add(good);
				
			}
			rs.close();
			statement.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			util.Log.e("关闭数据库连接时发生错误");
			e.printStackTrace();
			return null;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				util.Log.e("关闭数据库连接时发生错误");
				e.printStackTrace();
			}
		}

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
				result.add(comm);
			}
			rs.close();
			statement.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			util.Log.e("关闭数据库连接时发生错误");
			e.printStackTrace();
			return null;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				util.Log.e("关闭数据库连接时发生错误");
				e.printStackTrace();
			}
		}
		
	}

	public static int Item_Issue(Goods item, GoodInfo detail) {
		int gid = -1;
		Connection conn;
		try {
			conn = DBHelper.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs;
			String str;

			str = "insert into goods(gname,gPrice,gKind,Owner,gLocation,gImg) values ('"+ item.getgName() + "','" + item.getgPrice() + "','"
					+ item.getgKind() + "','" + item.getOwner() + "','" + item.getgLocation() +"','"+ item.getgImg() + "')";
			statement.executeUpdate (str,Statement.RETURN_GENERATED_KEYS);  
			rs = statement.getGeneratedKeys();
			rs.next();
			gid = rs.getInt(1);
			
			str = "insert into goodinfo(Gid,Ginfo,Gimgs,Gnice,Gcollect,Gview) values ("+ gid + ",'" + detail.getgInfo() + "','"
					+ detail.getgImgs() + "'," + detail.getgNice() + "," + detail.getgCollect() +","+ detail.getgView()+ ")";
			statement.executeUpdate (str);
			
			
			statement.close();
			conn.close();
			return gid;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("Issue good Fail!");
			e.printStackTrace();
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
