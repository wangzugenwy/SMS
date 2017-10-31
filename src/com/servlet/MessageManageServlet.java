package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MessageDao;
import com.model.Message;

/**
 * Servlet implementation class MessageManageServlet
 */

public class MessageManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		int status_flag =Integer.parseInt(request.getParameter("status_flag")) ;
		MessageDao messagedao = new MessageDao();
		ArrayList<Message> messagelist = null;
		try {
			messagelist = messagedao.getMessage(userid, status_flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("messagelist", messagelist);
		if(status_flag==1){
			response.sendRedirect(request.getContextPath()+"/outbox.jsp");
		}else if(status_flag==2){
			response.sendRedirect(request.getContextPath()+"/draft_box.jsp");
		}else if(status_flag==3){
			response.sendRedirect(request.getContextPath()+"/recycle.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
