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
		
		//Ϊ�������ṩ������Ϣ 
		DiskFileItemFactory factory = new DiskFileItemFactory(); 
		//�����������ʵ�� 
		ServletFileUpload sfu = new ServletFileUpload(factory); 
		//��ʼ���� 
		sfu.setFileSizeMax(1024*400); 
		//ÿ�����������ݻ��װ��һ����Ӧ��FileItem������ 
		List<FileItem> items;
		try {
			items = sfu.parseRequest(request);
		} catch (FileUploadException e1) {
			Log.e("�ϴ��ļ�ʧ��");
			return;
		} 
		//���ֱ��� 
		for (int i = 0; i < items.size(); i++) { 
			FileItem item = items.get(i); 
			//isFormFieldΪtrue����ʾ�ⲻ���ļ��ϴ����� 
			if(!item.isFormField()){ 
				//��ô���ļ�������·�� 
				//upload�µ�ĳ���ļ��� �õ���ǰ���ߵ��û� �ҵ���Ӧ���ļ��� 
		
				String path = "../image";
				System.out.println(path); 
				//����ļ��� 
				String fileName = item.getName(); 
				//�÷�����ĳЩƽ̨(����ϵͳ),�᷵��·��+�ļ��� 
				fileName = fileName.substring(fileName.lastIndexOf("/")+1); 
				Log.d(path+"/"+fileName);
				File file = new File(path+"/"+fileName); 
				if(!file.exists()){ 
					try {
						item.write(file);
					} catch (Exception e) {
						Log.e("�ϴ��ļ�ʧ��");
						
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
