package controller;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Log;

import dao.Goods_DAO;
import bean.Comment;
import bean.GoodInfo;
import bean.Goods;
import bean.Users;

public class SellReleaseController extends HttpServlet{

	public static final String PARAM_OWNER= "owner_name";
	
	public static final String PARAM_HAVE_LIST = "have_list";
	public static final String PARAM_HAVE_LIST_INFO = "have_list_info";
	
	
	public SellReleaseController() {
		super();
	}
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		List<Map<String,Object>> params = new ArrayList<Map<String,Object>>();
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("name", "Owner");
		param.put("rela", "=");
		param.put("value", request.getParameter(PARAM_OWNER));
		params.add(param);
		List<Goods> resultGoods = null;
		try {
			resultGoods = Goods_DAO.item_getGoods_bycondition(params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<GoodInfo> goodinfo = new ArrayList<GoodInfo>();
		for(int i = 0 ; i < resultGoods.size();i++){
			goodinfo.add(Goods_DAO.Item_getDetailInfo(resultGoods.get(i).getgID()));
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("have_list",resultGoods);
		Log.d(goodinfo.toString());
		session.setAttribute("have_list_info", goodinfo);
		
		PrintWriter out = response.getWriter();
		out.println("</HTML>");
		out.flush();
		out.close();
		
	}

	public void init() throws ServletException {
		// Put your code here
	}
	
}
