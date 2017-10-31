package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdressBookDao;
import com.dao.BookGroupDao;
import com.model.AddressBook;
import com.model.BookGroup;

/**
 * Servlet implementation class ShowBookOtherGroupServlet
 */
public class ShowBookOtherGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBookOtherGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		int gid= Integer.parseInt(request.getParameter("gid"));
		String userid = (String) session.getAttribute("userid");
		BookGroupDao bookgroupdao = new BookGroupDao();
		ArrayList<BookGroup> grouplist = null;
		try {
			grouplist = bookgroupdao.getAllGroup(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 AdressBookDao adressbookdao = new AdressBookDao();
		 ArrayList<AddressBook> addressooklist =(ArrayList<AddressBook>) session.getAttribute("addressooklist");
		 session.setAttribute("addressooklist", "");
		 
		 try {
			addressooklist = adressbookdao.getAdressotherBook(userid,gid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 session.setAttribute("addressooklist", addressooklist);
		 session.setAttribute("grouplist", grouplist);
		 response.sendRedirect(request.getContextPath()+"/address_box.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
