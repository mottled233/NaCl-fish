package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Goods;
import util.DBHelper;

public class Item implements ItemDAO {

	public Goods Item_getDdtailInf(int GID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	public ArrayList<Goods> Item_getRank(String Rank) {
		// TODO �Զ����ɵķ������
		return null;
	}

	public ArrayList<Goods> Item_getListByKeyword(String[] keyword) {
		// TODO �Զ����ɵķ������
		return null;
	}

	public ArrayList<Goods> Item_getListByClass(String category) {
		// TODO �Զ����ɵķ������
		try {
			Connection conn=DBHelper.getConnection();
			Statement statement=conn.createStatement();
			ResultSet rs;
			String str;
			ArrayList<bean.Order> result;
			
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

	public ArrayList<String> Item_getCritisizes(int ItemID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	public void Item_Issue(Goods item) {
		// TODO �Զ����ɵķ������

	}

	public void Item_LeaveStore(int ItemID) {
		// TODO �Զ����ɵķ������

	}

}
