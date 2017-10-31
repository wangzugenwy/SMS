package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AreaDao;
import com.model.Area;

public class AreaServlet extends HttpServlet {

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
         AreaDao areadao = new AreaDao();
         HttpSession session = request.getSession();
         
         //用来判断是否登陆，登陆了就跳转修改个人资料页面，没登录的话就跳转注册页面
         String userid = (String) session.getAttribute("userid");
         
         try {
			ArrayList<Area> arealist = areadao.getAllArea();
			session.setAttribute("arealist", arealist);
			if(userid==null||userid.equals("")){
				response.sendRedirect(request.getContextPath() + "/register.jsp");
			}else{
				response.sendRedirect(request.getContextPath() + "/revised_information.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
