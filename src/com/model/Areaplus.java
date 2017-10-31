package com.model;



public class Areaplus {
       private int id;
       private int upid;
       private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUpid() {
		return upid;
	}
	public void setUpid(int upid) {
		this.upid = upid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Areaplus(int upid, String title) {
		super();
		this.upid = upid;
		this.title = title;
	}
	public Areaplus() {
		super();
	}
       
       
}

