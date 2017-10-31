package com.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DBConnection {

	private static String username = "root";
	private static String password = "123456";
	private static String url = "jdbc:mysql://123.207.126.229:6306/sms_db";
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url, username, password);
			//Connection conn = DriverManager.getConnection("jdbc:mysql://"+host+"6306"+"/"+dbName+"?user="+username+"&password="+password+"&useUnicode=true&characterEncoding=utf-8");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static Statement getSmt(Connection conn){
		try {
			Statement smt= conn.createStatement();
			return smt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
		}
		return null;
	}
	
	public static void closeAll(Statement smt , Connection conn){
		if(smt != null){
			try {
				smt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void closeAll(ResultSet rs, Statement smt , Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		closeAll(smt, conn);
	}
	
	public static String formatDate(Date date,String format){
		
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if(date!=null){
			result = sdf.format(date);
		}
		return result;
		
	}
}
