package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Area;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.tools.DBConnection;

public class AreaDao {
	
	public ArrayList<Area> getAllArea() throws SQLException{
		Connection con = (Connection) DBConnection.getConnection();
		ArrayList<Area> arealist = new ArrayList<Area>();
		String sql = "select * from area";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = (ResultSet) pst.executeQuery();
		while(rs.next()){
			Area area = new Area();
			area.setId(rs.getInt("id"));
			area.setTitle(rs.getString("title"));
			arealist.add(area);
		}
		return arealist;
	}
	
}
