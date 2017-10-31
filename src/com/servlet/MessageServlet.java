package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MessageDao;
import com.model.Message;
import com.tools.DBConnection;

public class MessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String action = request.getParameter("action");
			if(action.equals("sendmessage")){
				try {
					sendmessage(request,response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(action.equals("draftmessage")){
				try {
					draftmessage(request,response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(action.equals("deletemessage")){
				try {
					deletemessage(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	
	}
	/**
	 * 删除信息
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	
private void deletemessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	response.setContentType("text/html; charset=UTF-8");
	PrintWriter out=response.getWriter();
	int status_flag =Integer.parseInt(request.getParameter("status_flag")) ;
	
	String[] mid= request.getParameterValues("mid");
	
	
	 String messageMid = "";
	for (int i = 0; i < mid.length; i++) {  
		messageMid+=mid[i]+",";  
	}
	
	String messagemid = messageMid.substring(0, messageMid.length()-1);
	
	
	MessageDao messagedao = new MessageDao();
	if((messagedao.messageDelete(messagemid, status_flag))>0){
		if(status_flag==1){
			out.print("<script type='text/javascript'>alert('删除信息成功!');window.location.href='../servlet/MessageManageServlet?status_flag=1'</script>");
		}else if(status_flag==2){
			out.print("<script type='text/javascript'>alert('是否将信息移入回收站!');window.location.href='../servlet/MessageManageServlet?status_flag=2'</script>");
		}else if(status_flag==3){
			out.print("<script type='text/javascript'>alert('是否将信息移入回收站!');window.location.href='../servlet/MessageManageServlet?status_flag=3'</script>");
			
		}	
	}else{
		out.print("<script type='text/javascript'>alert('删除失败!');window.location.href='../index.jsp'</script>");
	}
	
	}


/**
 * 编辑信息到草稿箱
 * @param request
 * @param response
 * @throws IOException 
 * @throws SQLException 
 */
	private void draftmessage(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		String mobile = new String(request.getParameter("mobile").getBytes("iso-8859-1"), "utf-8");
		String content = new String(request.getParameter("content").getBytes("iso-8859-1"), "utf-8");
		String post_date = DBConnection.formatDate(new Date(), "yyyy-MM-dd");
		Message  message = new Message();
		message.setContent(content);
		message.setPost_date(post_date);
		message.setMobile(mobile);
		message.setUid(userid);
		//status_flag=2代表存入草稿箱
		message.setStatus_flag(2);
		MessageDao messagedao = new MessageDao();
		if((messagedao.addmessage(message))>0){
			out.print("<script type='text/javascript'>alert('是否存入草稿箱!');window.location.href='../index.jsp'</script>");
		}else{
			out.print("<script type='text/javascript'>alert('编辑失败!');window.location.href='../servlet/AdressBookServlet?action=getAlladress'</script>");
		}
					
		
	}
/**
 * 发送信息
 * @param request
 * @param response
 * @throws IOException
 * @throws SQLException
 */
	private void sendmessage(HttpServletRequest request,
			HttpServletResponse response) throws IOException, SQLException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		
		
		String userid = (String) session.getAttribute("userid");
		String mobile = new String(request.getParameter("mobile").getBytes("iso-8859-1"), "utf-8");
		String content = new String(request.getParameter("content").getBytes("iso-8859-1"), "utf-8");
		
		
		String post_date = DBConnection.formatDate(new Date(), "yyyy-MM-dd");
		
		
		Message  message = new Message();
		message.setContent(content);
		message.setPost_date(post_date);
		message.setMobile(mobile);
		message.setUid(userid);
		//status_flag=1代表已发信息
		message.setStatus_flag(1);
		
		MessageDao messagedao = new MessageDao();
		
		if((messagedao.addmessage(message))>0){
			out.print("<script type='text/javascript'>alert('发送成功!');window.location.href='../index.jsp'</script>");
		}else{
			out.print("<script type='text/javascript'>alert('发送失败!');window.location.href='../servlet/AdressBookServlet?action=getAlladress'</script>");
		}
					
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
		doGet(request, response);
	}

}
