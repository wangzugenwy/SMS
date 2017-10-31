package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

public class BookGroupServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("addgroup")){
			try {
				addgroup(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(action.equals("showgroup")){
			try {
				showgroup(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}


	private void showgroup(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		 HttpSession session = request.getSession();
		 String userid = (String) session.getAttribute("userid");
		 
		 //拿到当前用户所有分组
		 BookGroupDao bookgroupdao = new BookGroupDao();
		 ArrayList<BookGroup> grouplist = bookgroupdao.getAllGroup(userid);
		 
		 //拿到当前登录用户所有联系人
		 AdressBookDao adressbookdao = new AdressBookDao();
		 ArrayList<AddressBook> addressooklist = adressbookdao.getAdressBook(userid);
		 
		 
		 session.setAttribute("addressooklist", addressooklist);
		 session.setAttribute("grouplist", grouplist);
		 response.sendRedirect(request.getContextPath()+"/address_box.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          
		doGet(request, response);
		
		
	}
	public void addgroup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		      response.setContentType("text/html; charset=UTF-8");
		      PrintWriter out=response.getWriter();
		      HttpSession session = request.getSession();
		      String userid = (String) session.getAttribute("userid");
		   
		      String title = new String(request.getParameter("title").getBytes("iso-8859-1"), "utf-8");
		      String description = new String(request.getParameter("description").getBytes("iso-8859-1"), "utf-8");
		     
		      
		      BookGroup bookgroup=new BookGroup();
		      bookgroup.setTitle(title);
		      bookgroup.setDescription(description);
		      bookgroup.setUid(userid);
		      
		      BookGroupDao bookgroupdao = new BookGroupDao();
		      
		      if((bookgroupdao.addGroup(bookgroup))>0){
		    	  out.print("<script type='text/javascript'>alert('添加分组成功!');window.location.href='../servlet/BookGroupServlet?action=showgroup'</script>");	
		      }else{
		    	  out.print("<script type='text/javascript'>alert('添加分组失败!');window.location.href='../addgroup.jsp'</script>");	
		      }
		      
         
		}



}
