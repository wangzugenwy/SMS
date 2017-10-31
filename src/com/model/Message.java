package com.model;

public class Message {
	private int mid;
	private String content;
	private String mobile;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	private int status_flag;
	private String post_date;
	private String uid;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus_flag() {
		return status_flag;
	}
	public void setStatus_flag(int status_flag) {
		this.status_flag = status_flag;
	}
	public String getPost_date() {
		return post_date;
	}
	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Message [mid=" + mid + ", content=" + content
				+ ", status_flag=" + status_flag + ", post_date=" + post_date
				+ ", uid=" + uid + "]";
	}
	public Message() {
		super();
	}
	public Message(int mid, String content, int status_flag, String post_date,
			String uid) {
		super();
		this.mid = mid;
		this.content = content;
		this.status_flag = status_flag;
		this.post_date = post_date;
		this.uid = uid;
	}
	
	

}
