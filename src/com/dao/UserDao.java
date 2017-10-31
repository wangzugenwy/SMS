package com.dao;

import java.sql.SQLException;

import com.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.tools.DBConnection;

public class UserDao {
	
	public int modifyinformat(User user,String olduserid) throws SQLException{
		Connection con = (Connection) DBConnection.getConnection();
		String sql="update user set userid=?,real_name=?,sex=?,mobile=?,area_id=? where userid=?";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, user.getUserid());
		pstmt.setString(2, user.getReal_name());
		pstmt.setString(3, user.getSex());
		pstmt.setString(4, user.getMobile());
		pstmt.setInt(5, user.getArea_id());
		
		pstmt.setString(6, olduserid);
		return pstmt.executeUpdate();		
	}
	public int modifypassword(User user,String password) throws SQLException{
		Connection con = (Connection) DBConnection.getConnection();
		String sql="update user set password=? where userid=? and password=?";
		PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getUserid());
		pstmt.setString(3, password);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 找回密码
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User findUser(User user) throws SQLException{
		User resultuser = null;
		Connection con = (Connection) DBConnection.getConnection();
		String sql = "select * from user where question=? and answer=?";
		PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
		
		st.setString(1, user.getQuestion());
		st.setString(2, user.getAnswer());
		
		ResultSet rs = (ResultSet) st.executeQuery();
		if(rs.next()){
			resultuser = new User();
			resultuser.setUserid(rs.getString("userid"));
			resultuser.setAnswer(rs.getString("answer"));
			resultuser.setArea_id(Integer.parseInt(rs.getString("area_id")));
			resultuser.setEmail(rs.getString("email"));
			resultuser.setSex(rs.getString("sex"));
			resultuser.setReal_name(rs.getString("real_name"));
			resultuser.setMobile(rs.getString("mobile"));
			resultuser.setPassword(rs.getString("password"));
			resultuser.setQuestion(rs.getString("question"));
			resultuser.setPost_date(rs.getString("post_date"));
		}
		
		
		return resultuser;
		
	}
	/**
	 * 向数据库插入数据
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int register(User user) throws SQLException{
		Connection con = (Connection) DBConnection.getConnection();
		String sql = "insert into user value(?,?,?,?,?,?,?,?,null,?,?,0);";
		PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
		st.setString(1, user.getUserid());
		st.setString(2, user.getReal_name());
		st.setString(3, user.getPassword());
		st.setString(4, user.getQuestion());
		st.setString(5, user.getAnswer());
		st.setString(6, user.getSex());
		st.setString(7, user.getMobile());
		st.setString(8, user.getEmail());
		st.setString(9, user.getPost_date());
		st.setInt(10, user.getArea_id());
		return st.executeUpdate();
		
	}
	/**
	 * 登录验证
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User login(User user) throws SQLException{
		User resultuser = null;
		Connection con = (Connection) DBConnection.getConnection();
		String sql = "select * from user where userid=? and password=?";
		
		PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
		
		st.setString(1, user.getUserid());
		st.setString(2, user.getPassword());
		
		ResultSet rs = (ResultSet) st.executeQuery();
		
		if(rs.next()){
			resultuser = new User();
			resultuser.setUserid(rs.getString("userid"));
			resultuser.setPassword(rs.getString("password"));
		}
		return resultuser;
		
	}

}
