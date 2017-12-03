package service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem; 
import org.apache.commons.fileupload.FileUploadException; 
import org.apache.commons.fileupload.disk.DiskFileItemFactory; 
import org.apache.commons.fileupload.servlet.ServletFileUpload; 

import dao.Goods_Dao;

import util.Log;

import bean.GoodInfo;
import bean.Goods;
import bean.Users;

public class PostServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PostServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		//为解析类提供配置信息 
		DiskFileItemFactory factory = new DiskFileItemFactory(); 
		//创建解析类的实例 
		ServletFileUpload sfu = new ServletFileUpload(factory); 
		//开始解析 
		sfu.setFileSizeMax(1024*400); 
		//每个表单域中数据会封装到一个对应的FileItem对象上 
		List<FileItem> items;
		try {
			items = sfu.parseRequest(request);
		} catch (FileUploadException e1) {
			Log.e("上传文件失败");
			return;
		} 
		//区分表单域 
		for (int i = 0; i < items.size(); i++) { 
			FileItem item = items.get(i); 
			//isFormField为true，表示这不是文件上传表单域 
			if(!item.isFormField()){ 
				//获得存放文件的物理路径 
				//upload下的某个文件夹 得到当前在线的用户 找到对应的文件夹 
		
				String path = "../image";
				System.out.println(path); 
				//获得文件名 
				String fileName = item.getName(); 
				//该方法在某些平台(操作系统),会返回路径+文件名 
				fileName = fileName.substring(fileName.lastIndexOf("/")+1); 
				Log.d(path+"/"+fileName);
				File file = new File(path+"/"+fileName); 
				if(!file.exists()){ 
					try {
						item.write(file);
					} catch (Exception e) {
						Log.e("上传文件失败");
						
						return;
					} 
				
				} 
			}
		} 
		
		
		PrintWriter out = response.getWriter();
		
		Goods good = new Goods();
		good.setgName(request.getParameter("in_gname"));
		good.setgPrice(Double.parseDouble(request.getParameter("in_gprice")));
		good.setgKind(request.getParameter("in_gkind"));
		good.setgImg(request.getParameter("in_gimg"));
		good.setgLocation(request.getParameter("in_glocation"));
		good.setOwner(((Users)request.getSession().getAttribute("user")).getUsername());
		
		GoodInfo detail = new GoodInfo();
		detail.setgImgs(request.getParameter("in_gimgs"));
		detail.setgCollect(0);
		detail.setgView(0);
		detail.setgInfo(request.getParameter("in_info"));
		detail.setgNice(0);
		
		Goods_Dao.Item_Issue(good, detail);
		
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
