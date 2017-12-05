package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DataPage;

import dao.Goods_Dao;

import bean.Goods;
import bean.Users;

public class SearchController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		
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
		
		String prekey=request.getParameter("keyword");
		String[] keyword=prekey.split(" ");
		
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		String top=request.getParameter("in_price_high");
		String upper=request.getParameter("in_price_low");
		String param[]=new String[3];
		param[0]="";
		param[1]=upper;
		param[2]=top;
		DataPage<Goods> result=Goods_Dao.Item_getListByKeyword(keyword,currentPage,44,param);
		session.setAttribute("select_page",result);
		
		out.flush();
		out.close();
	
	}

}
