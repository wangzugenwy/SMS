package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.model.AddressBook;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.tools.DBConnection;

public class AdressBookDao {

	public ArrayList<AddressBook> getAllAddress(String userid) throws SQLException {
		Connection con = (Connection) DBConnection.getConnection();
		ArrayList<AddressBook> adresslist = new ArrayList<AddressBook>();
		String sql = "select * from address_book where uid=?";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
		pst.setString(1, userid);
		ResultSet rs = (ResultSet) pst.executeQuery();
		while(rs.next()){
			AddressBook addressbook = new AddressBook();
			addressbook.setAbid(rs.getInt("abid"));
			addressbook.setGroupid(rs.getInt("groupid"));
			addressbook.setMobile(rs.getString("mobile"));
			addressbook.setName(rs.getString("name"));
			addressbook.setUid(rs.getString("uid"));
		
			adresslist.add(addressbook);
		}
		return adresslist;
	}
/**
 * 拿到联系人
 * @param userid
 * @return
 * @throws SQLException
 */
	public ArrayList<AddressBook> getAdressBook(String userid) throws SQLException {
		Connection con = (Connection) DBConnection.getConnection();
		ArrayList<AddressBook> adresslist = new ArrayList<AddressBook>();
		String sql = "select * from address_book where uid=?";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
		pst.setString(1,userid);
		ResultSet rs = (ResultSet) pst.executeQuery();
		while(rs.next()){
			AddressBook addressbook = new AddressBook();
			addressbook.setAbid(rs.getInt("abid"));
			addressbook.setGroupid(rs.getInt("groupid"));
			addressbook.setMobile(rs.getString("mobile"));
			addressbook.setName(rs.getString("name"));
			addressbook.setUid(rs.getString("uid"));
		
			adresslist.add(addressbook);
		}
		return adresslist;
	
	}
public ArrayList<AddressBook> getAdressotherBook(String userid, int gid) throws SQLException {
	Connection con = (Connection) DBConnection.getConnection();
	ArrayList<AddressBook> adresslist = new ArrayList<AddressBook>();
	String sql = "select * from address_book where uid=? and groupid=?";
	PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
	pst.setString(1,userid);
	pst.setInt(2, gid);
	ResultSet rs = (ResultSet) pst.executeQuery();
	while(rs.next()){
		AddressBook addressbook = new AddressBook();
		addressbook.setAbid(rs.getInt("abid"));
		addressbook.setGroupid(rs.getInt("groupid"));
		addressbook.setMobile(rs.getString("mobile"));
		addressbook.setName(rs.getString("name"));
		addressbook.setUid(rs.getString("uid"));
		adresslist.add(addressbook);
	}
	return adresslist;
}
public int deleteadress(String id) throws SQLException {
	Connection con = (Connection) DBConnection.getConnection();	
	String sql="delete from address_book where abid in("+id+");";
	PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);;
	return  pstmt.executeUpdate();
	
	
}
	
public int deleteadressbook(String id,String userid) throws SQLException {
	Connection con = (Connection) DBConnection.getConnection();	
	String sql="delete from address_book where uid=? and groupid in("+id+");";
	PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(sql);
	pstmt.setString(1, userid);
	return  pstmt.executeUpdate();
	
	
}
public int addbookadress(AddressBook addressbook) throws SQLException {
	Connection con = (Connection) DBConnection.getConnection();
	String sql = "insert into address_book value(null,?,?,?,?);";
	PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
	st.setString(1, addressbook.getMobile());
	st.setString(2, addressbook.getName());
	st.setInt(3, addressbook.getGroupid());
	st.setString(4, addressbook.getUid());
	return st.executeUpdate();
}
	

}
