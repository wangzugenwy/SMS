package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

public class AdressBookServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String action = request.getParameter("action");
		if(action.equals("getAlladress")){
			try {
				getAlladress(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(action.equals("deleteadress")){
			try {
				deleteAdress(request,response);
			} catch (SQLException e) {
				// TODO aaaa
				e.printStackTrace();
			}
		}else if(action.equals("addaddressbook")){
			try {
				addaddressbook(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(action.equals("deleteGroup")){
			try {
				deleteGroup(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void deleteGroup(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 response.setContentType("text/html; charset=UTF-8");
		 HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		String[] abid= request.getParameterValues("gid");
		 String bid = "";
		for (int i = 0; i < abid.length; i++) {  
			bid+=abid[i]+",";  
		}
		
		String id = bid.substring(0, bid.length()-1);
		BookGroupDao bookgroupdao = new BookGroupDao();
		AdressBookDao adressbookdao = new AdressBookDao();
		int result = bookgroupdao.deleteGroup(id);
		
		int result1 = adressbookdao.deleteadressbook(id,userid);
		
		if((result>0)||result1>0){
			 out.print("<script type='text/javascript'>alert('ɾ�����ɹ�!');window.location.href='../servlet/BookGroupServlet?action=showgroup'</script>");
		}else{
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		
		
	}

	private void addaddressbook(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		 response.setContentType("text/html; charset=UTF-8");
		
		 PrintWriter out=response.getWriter();
		 HttpSession session = request.getSession();
		 String userid = (String) session.getAttribute("userid");
		 String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		 String mobile = request.getParameter("mobile");
		 int groupid = Integer.parseInt(request.getParameter("groupid"));
		 AddressBook addressbook = new AddressBook();
		 addressbook.setGroupid(groupid);
		 addressbook.setName(name);
		 addressbook.setUid(userid);
		 addressbook.setMobile(mobile);
		 
		 AdressBookDao adressbookdao = new AdressBookDao();
		 int result = adressbookdao.addbookadress(addressbook);
		 if(result>0){
			 out.print("<script type='text/javascript'>alert('�����ϵ�˳ɹ�!');window.location.href='../servlet/BookGroupServlet?action=showgroup'</script>");
		 }else {
			 out.print("<script type='text/javascript'>alert('���ʧ��!');window.location.href='../servlet/BookGroupServlet?action=showgroup'</script>");
			
		}
		 
	}

	private void deleteAdress(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		String[] abid= request.getParameterValues("abid");
		 String bid = "";
		for (int i = 0; i < abid.length; i++) {  
			bid+=abid[i]+",";  
		}
		
		String id = bid.substring(0, bid.length()-1);
		AdressBookDao adressbookdao = new AdressBookDao();
		if((adressbookdao.deleteadress(id))>0){
			out.print("<script type='text/javascript'>alert('�Ƿ�ȷ��ɾ�����ϵ��!');window.location.href='../servlet/BookGroupServlet?action=showgroup'</script>");
		}else{
			out.print("<script type='text/javascript'>alert('ɾ�� ��ϵ��ʧ��!');window.location.href='../servlet/BookGroupServlet?action=showgroup'</script>");
		}
		
	}

	private void getAlladress(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		
		 HttpSession session = request.getSession();
		 String userid = (String) session.getAttribute("userid");
		 AdressBookDao adressbookdao = new AdressBookDao();
		 
		 ArrayList<AddressBook> adresslist = adressbookdao.getAllAddress(userid);
		 session.setAttribute("adresslist", adresslist);
		 response.sendRedirect(request.getContextPath()+"/send_message.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doGet(request, response);
	}

}
