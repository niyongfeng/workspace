package com.pengrui.test3;

public class Users {
	private String id;
	private String pwd;
	private String email;
	
	public Users() {
		
	}
	
	public Users(String id, String pwd, String email) {
		this.id = id;
		this.pwd = pwd;
		this.email = email;
	}
	
	public Users(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		email = id + "@gameschool.com";
	}
	
	
	public void print() {
		System.out.println("ID:" + id + ",Pwd:" + pwd + ",Email:" + email);
	}
	public static void main(String[] args) {
		Users u1 = new Users("110708132", "123", "495970749@qq.com");
		u1.print();
		Users u2 = new Users("niyongfeng", "1111");
		u2.print();
	}
}
