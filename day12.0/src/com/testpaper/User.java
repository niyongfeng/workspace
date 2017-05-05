package com.testpaper;

public class User {
	
	public int id;
	public String pwd;
	public String email;
	
	public User(int id, String pwd, String email) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
	} 
	
	public User(int id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		this.email = id + "@gameschool.com";
	}
	
	public String toString() {
		return "id: " + id + "\npwd: " + pwd + "\nemail: " + email;
	}
	
	

}
