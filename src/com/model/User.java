package com.model;

public class User {
   private  String userid;
   private  String  real_name;
   private  String password;
   private  String question;
   private  String answer;
   private  String sex;
   private  String mobile;
   private  String email;
   private  String last_login_date;
   private  String post_date;
   private  int area_id;
   private  int areaplus_id;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getReal_name() {
	return real_name;
}
public void setReal_name(String real_name) {
	this.real_name = real_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getLast_login_date() {
	return last_login_date;
}
public void setLast_login_date(String last_login_date) {
	this.last_login_date = last_login_date;
}
public String getPost_date() {
	return post_date;
}
public void setPost_date(String post_date) {
	this.post_date = post_date;
}
public int getArea_id() {
	return area_id;
}
public void setArea_id(int area_id) {
	this.area_id = area_id;
}
public int getAreaplus_id() {
	return areaplus_id;
}
public void setAreaplus_id(int areaplus_id) {
	this.areaplus_id = areaplus_id;
}
public User(String userid, String real_name, String password, String question,
		String answer, String sex, String mobile, String email,
		String post_date, int area_id) {
	super();
	this.userid = userid;
	this.real_name = real_name;
	this.password = password;
	this.question = question;
	this.answer = answer;
	this.sex = sex;
	this.mobile = mobile;
	this.email = email;
	this.post_date = post_date;
	this.area_id = area_id;
}
public User() {
	super();
}
public User(String userid, String password) {
	super();
	this.userid = userid;
	this.password = password;
}
@Override
public String toString() {
	return "User [userid=" + userid + ", real_name=" + real_name + ", password=" + password + ", question=" + question
			+ ", answer=" + answer + ", sex=" + sex + ", mobile=" + mobile + ", email=" + email + ", last_login_date="
			+ last_login_date + ", post_date=" + post_date + ", area_id=" + area_id + ", areaplus_id=" + areaplus_id
			+ "]";
}



}
