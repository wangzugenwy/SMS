package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Area;
import com.model.BookGroup;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.tools.DBConnection;

public class BookGroupDao {
	/**
	 * 向数据库添加分组
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int addGroup(BookGroup group) throws SQLException{
		Connection con = (Connection) DBConnection.getConnection();
		String sql = "insert into book_group value(null,?,?,?);";
		PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
	    st.setString(1,group.getTitle());
		st.setString(2,group.getDescription());
		st.setString(3, group.getUid());
		
	    return st.executeUpdate();  //如果插入成功，返回一个大于0的数
		
	}
	
	/**
	 * 向数据库删除分组
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public int deleteGroup(String id) throws SQLException{
		Connection con = (Connection) DBConnection.getConnection();
		String sql="delete from book_group where gid in("+id+");";
		PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
	
		return st.executeUpdate();	
	}

	public ArrayList<BookGroup> getAllGroup(String userid) throws SQLException {
		Connection con = (Connection) DBConnection.getConnection();
		ArrayList<BookGroup> grouplist = new ArrayList<BookGroup>();
		String sql = "select * from book_group where uid=?";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
		pst.setString(1,userid);
		ResultSet rs = (ResultSet) pst.executeQuery();
		while(rs.next()){
			BookGroup group = new BookGroup();
			group.setGid(rs.getInt("gid"));
			group.setTitle(rs.getString("title"));
			group.setDescription(rs.getString("description"));
			group.setUid(rs.getString("uid"));
			grouplist.add(group);
		}
		return grouplist;
	}

	
	
	
}
