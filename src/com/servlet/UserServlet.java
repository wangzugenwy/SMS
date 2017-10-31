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
	 * 修改个人信息
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
			out.print("<script type='text/javascript'>alert('修改信息成功!');window.location.href='../index.jsp'</script>");	
		}else{
			out.print("<script type='text/javascript'>alert('修改信息失败!');window.location.href='../revised_information.jsp'</script>");	
		}
	}

	/**
	 * 修改密码
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
		
		//把当前用户名和新密码封装到user类中
		User user = new User();
		user.setUserid(userid);
		user.setPassword(newpassword);
		
		
		if(password.equals(oldpassword)){
			if(repassword.equals(newpassword)){
				if((userdao.modifypassword(user, password))>0){
					//如果修改密码成功了，再重新修改一次密码存在原来session当中的password还是以前的旧密码，所以要更新session里面的password
					session.setAttribute("password", newpassword);
					
					out.print("<script type='text/javascript'>alert('修改密码成功!');window.location.href='../index.jsp'</script>");	
						
				}else{	
					out.print("<script type='text/javascript'>alert('修改密码失败!');window.location.href='../revised_password.jsp'</script>");	
				}
			}else{
				out.print("<script type='text/javascript'>alert('密码和确认密码不一样!');window.location.href='../revised_password.jsp'</script>");
			}
		}else{
			out.print("<script type='text/javascript'>alert('旧密码错误!');window.location.href='../revised_password.jsp'</script>");	
		}
		
	}

	
	/**
	 * 找回密码
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
			out.print("<script type='text/javascript'>alert('成功找到!');window.location.href='../findPassword.jsp'</script>");
		} else {
			out.print("<script type='text/javascript'>alert('你输入的密保答案不正确!');window.location.href='../forget_password.jsp'</script>");
		}

	}

	/**
	 * 注册
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
			out.print("<script type='text/javascript'>alert('密码与确认密码不一致!');window.location.href='../register.jsp'</script>");
		} else {
			result = userdao.register(user);
			if (result > 0) {
				out.print("<script type='text/javascript'>alert('注册成功!');window.location.href='../login.jsp'</script>");
			} else {
				out.print("<script type='text/javascript'>alert('该用户名已注册!');window.location.href='../register.jsp'</script>");
			}
		}

	}

	/**
	 * 登陆
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
			out.print("<script type='text/javascript'>alert('用户名或密码错误!');window.location.href='../login.jsp'</script>");
		}
	}

	private void cancle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		
		//String userid = (String) session.getAttribute("userid");
		
		session.setAttribute("userid", "");
		session.setAttribute("password", "");
		out.print("<script type='text/javascript'>alert('是否确定退出当前用户!');window.location.href='../login.jsp'</script>");
	}

}
