package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Order_DAO;

import bean.*;

public class OrdersController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String statues=request.getParameter("Statues");
		if(statues.equals("LogedIn")){
			doPost(request,response);
			}
		}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		Users user=(Users)session.getAttribute("User");
		
		String username=user.getUsername();
		ArrayList<Order> result=Order_DAO.Order_getList(username);
		session.setAttribute("order_list", result);

		
		
		out.flush();
		out.close();
	
	}

}
