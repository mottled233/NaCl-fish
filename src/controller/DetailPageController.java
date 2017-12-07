package controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Goods_DAO;
import bean.Comment;
import bean.GoodInfo;
import bean.Goods;
import bean.Users;

public class DetailPageController extends HttpServlet{

	public static final String PARAM_IN_ID = "in_id";
	
	public static final String PARAM_INFO_GOOD = "info_good";
	public static final String PARAM_INFO_GOODINFO = "info_goodinfo";
	public static final String PARAM_INFO_COMMENT ="info_comment";
	
	/**
	 * Constructor of the object.
	 */
	public DetailPageController() {
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
		int goodID = Integer.parseInt(request.getParameter(PARAM_IN_ID));
		Goods goods = Goods_DAO.item_getGoods(goodID);
		GoodInfo goodinfo = Goods_DAO.Item_getDetailInfo(goodID);
		List<Comment> good_comment = new ArrayList<Comment>();
		good_comment = Goods_DAO.Item_getCritisizes(goodID);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("info_good",goods);
		session.setAttribute("info_goodinfo",goodinfo);
		session.setAttribute("info_comment",good_comment);
		
		PrintWriter out = response.getWriter();
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	public void init() throws ServletException {
		// Put your code here
	}
	
}
