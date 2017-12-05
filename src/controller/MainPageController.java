package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Goods;
import bean.Users;
import dao.Goods_DAO;
import dao.Order_DAO;

public class MainPageController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		String uname = user.getUsername();
		String[] categorys={"数码","生鲜","服装"};
		for(int i=0;i<categorys.length;i++){
			ArrayList<Goods> Rank1=Goods_DAO.Item_getRank(categorys[i], 1);
			session.setAttribute("main_views_"+categorys[i], Rank1);
			ArrayList<Goods> Rank2=Goods_DAO.Item_getRank(categorys[i], 2);
			session.setAttribute("main_collects_"+categorys[i], Rank1);
			ArrayList<Goods> Rank3=Goods_DAO.Item_getRank(categorys[i], 3);
			session.setAttribute("main_nices_"+categorys[i], Rank1);
		}
		
		
		
		out.flush();
		out.close();
	
	}
	
}
