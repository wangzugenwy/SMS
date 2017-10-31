package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;
import com.tools.DBConnection;

public class UserServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("register")) {
			try {
				register(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("login")) {
			try {
				login(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("cancle")) {
			cancle(request, response);
		} else if (action.equals("findpassword")) {
			try {
				findpassword(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (action.equals("modifypassword")) {
			try {
				modifypassword(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if(action.equals("modifyinformat")) {
			try {
				modifyinformat(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * �޸ĸ�����Ϣ
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws SQLException 
	 */
	private void modifyinformat(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		
		String olduserid = (String) session.getAttribute("userid");
		
		String userid = new String(request.getParameter("userid").getBytes("iso-8859-1"), "utf-8");
		String real_name = new String(request.getParameter("real_name").getBytes("iso-8859-1"), "utf-8");
		String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"), "utf-8");
		String mobile = request.getParameter("mobile");
		int area_id = Integer.parseInt(request.getParameter("area_id"));
		
		
		
		UserDao userdao = new UserDao();
		User user = new User();
		user.setUserid(userid);
		user.setReal_name(real_name);
		user.setSex(sex);
		user.setMobile(mobile);
		user.setArea_id(area_id);
		
		
		if((userdao.modifyinformat(user, olduserid))>0){
			out.print("<script type='text/javascript'>alert('�޸���Ϣ�ɹ�!');window.location.href='../index.jsp'</script>");	
		}else{
			out.print("<script type='text/javascript'>alert('�޸���Ϣʧ��!');window.location.href='../revised_information.jsp'</script>");	
		}
	}

	/**
	 * �޸�����
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws IOException 
	 */
	private void modifypassword(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();

		String userid = (String) session.getAttribute("userid");
		
		String oldpassword=(String) session.getAttribute("password");
		
		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		String repassword = request.getParameter("repassword");
		
		UserDao userdao = new UserDao();
		
		//�ѵ�ǰ�û������������װ��user����
		User user = new User();
		user.setUserid(userid);
		user.setPassword(newpassword);
		
		
		if(password.equals(oldpassword)){
			if(repassword.equals(newpassword)){
				if((userdao.modifypassword(user, password))>0){
					//����޸�����ɹ��ˣ��������޸�һ���������ԭ��session���е�password������ǰ�ľ����룬����Ҫ����session�����password
					session.setAttribute("password", newpassword);
					
					out.print("<script type='text/javascript'>alert('�޸�����ɹ�!');window.location.href='../index.jsp'</script>");	
						
				}else{	
					out.print("<script type='text/javascript'>alert('�޸�����ʧ��!');window.location.href='../revised_password.jsp'</script>");	
				}
			}else{
				out.print("<script type='text/javascript'>alert('�����ȷ�����벻һ��!');window.location.href='../revised_password.jsp'</script>");
			}
		}else{
			out.print("<script type='text/javascript'>alert('���������!');window.location.href='../revised_password.jsp'</script>");	
		}
		
	}

	
	/**
	 * �һ�����
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void findpassword(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		String question = new String(request.getParameter("question").getBytes("iso-8859-1"), "utf-8");
		String answer = new String(request.getParameter("answer").getBytes("iso-8859-1"), "utf-8");
		
		User user = new User();
		user.setQuestion(question);
		user.setAnswer(answer);
		
		
		
		UserDao userdao = new UserDao();
		
		user = userdao.findUser(user);
		
		if (user != null) {
			session.setAttribute("userid", user.getUserid());
			session.setAttribute("password", user.getPassword());
			out.print("<script type='text/javascript'>alert('�ɹ��ҵ�!');window.location.href='../findPassword.jsp'</script>");
		} else {
			out.print("<script type='text/javascript'>alert('��������ܱ��𰸲���ȷ!');window.location.href='../forget_password.jsp'</script>");
		}

	}

	/**
	 * ע��
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();

		String userid = new String(request.getParameter("userid").getBytes("iso-8859-1"), "utf-8");
		String real_name = new String(request.getParameter("real_name").getBytes("iso-8859-1"), "utf-8");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String question = new String(request.getParameter("question").getBytes("iso-8859-1"), "utf-8");
		String answer = new String(request.getParameter("answer").getBytes("iso-8859-1"), "utf-8");
		String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"), "utf-8");
		String mobile = request.getParameter("mobile");
		String email = new String(request.getParameter("email").getBytes("iso-8859-1"), "utf-8");

		String post_date = DBConnection.formatDate(new Date(), "yyyy-MM-dd");

		int area_id = Integer.parseInt(request.getParameter("area_id"));
		
		
		User user = null;

		user = new User(userid, real_name, password, question, answer, sex, mobile, email, post_date, area_id);
		
		
		UserDao userdao = new UserDao();
		int result = 0;

		if (!repassword.equals(password)) {
			out.print("<script type='text/javascript'>alert('������ȷ�����벻һ��!');window.location.href='../register.jsp'</script>");
		} else {
			result = userdao.register(user);
			if (result > 0) {
				out.print("<script type='text/javascript'>alert('ע��ɹ�!');window.location.href='../login.jsp'</script>");
			} else {
				out.print("<script type='text/javascript'>alert('���û�����ע��!');window.location.href='../register.jsp'</script>");
			}
		}

	}

	/**
	 * ��½
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SQLException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		
		String userid = new String(request.getParameter("userid").getBytes("iso-8859-1"), "utf-8");
		String password = request.getParameter("password");

		User user = new User(userid, password);
		
		
		UserDao userdao = new UserDao();
		
		if ((userdao.login(user)) != null) {
			session.setAttribute("userid", userid);
			session.setAttribute("password", password);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else {
			out.print("<script type='text/javascript'>alert('�û������������!');window.location.href='../login.jsp'</script>");
		}
	}

	private void cancle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		
		//String userid = (String) session.getAttribute("userid");
		
		session.setAttribute("userid", "");
		session.setAttribute("password", "");
		out.print("<script type='text/javascript'>alert('�Ƿ�ȷ���˳���ǰ�û�!');window.location.href='../login.jsp'</script>");
	}

}
