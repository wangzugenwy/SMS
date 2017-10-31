package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.model.BookGroup;
import com.model.Message;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.tools.DBConnection;

public class MessageDao {
	
	public int addmessage(Message message) throws SQLException{
		Connection con = (Connection) DBConnection.getConnection();
		String sql = "insert into message value(null,?,?,?,?,?);";
		PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
		st.setString(1, message.getContent());
		st.setString(2, message.getMobile());
		st.setInt(3, message.getStatus_flag());
		st.setString(4, message.getPost_date());
		st.setString(5, message.getUid());
		return st.executeUpdate();	
	}


	public int messageDelete(String messageMid,int status_flag)throws Exception{
		Connection con = (Connection) DBConnection.getConnection();	
		PreparedStatement pstmt=null;
		if(status_flag==1||status_flag==2){
			String sql="update message set status_flag=3 where mid in("+messageMid+");";
			pstmt=(PreparedStatement) con.prepareStatement(sql);
			return pstmt.executeUpdate();
		}else {
			String sql="delete from message where mid in("+messageMid+");";
			pstmt=(PreparedStatement) con.prepareStatement(sql);
			return pstmt.executeUpdate();
		}
			
	}

	public ArrayList<Message> getMessage(String userid, int status_flag) throws SQLException {
		Connection con = (Connection) DBConnection.getConnection();
		ArrayList<Message> messagelist = new ArrayList<Message>();
		String sql = "select * from message where uid=? and status_flag=?";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
		pst.setString(1, userid);
		pst.setInt(2, status_flag);
		ResultSet rs = (ResultSet) pst.executeQuery();
		while(rs.next()){
			Message message = new Message();
			message.setMid(rs.getInt("mid"));
			message.setContent(rs.getString("content"));
			message.setMobile(rs.getString("mobile"));
			message.setStatus_flag(rs.getInt("status_flag"));
			message.setPost_date(rs.getString("post_date"));
			message.setUid(rs.getString("uid"));
			messagelist.add(message);
		}
		return messagelist;
	}

}
