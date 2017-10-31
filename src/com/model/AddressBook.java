package com.model;

import java.util.ArrayList;

public class AddressBook {
	private int abid;
	private String mobile;
	private String name;
	private int groupid;
	private String uid;
	public int getAbid() {
		return abid;
	}
	public void setAbid(int abid) {
		this.abid = abid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "AddressBook [abid=" + abid + ", mobile=" + mobile + ", name="
				+ name + ", groupid=" + groupid + ", uid=" + uid + "]";
	}
	public AddressBook(int abid, String mobile, String name, int groupid,
			String uid) {
		super();
		this.abid = abid;
		this.mobile = mobile;
		this.name = name;
		this.groupid = groupid;
		this.uid = uid;
	}
	public AddressBook() {
		super();
	}


}
