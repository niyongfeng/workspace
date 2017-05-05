package com.pengrui.object;

public class User {
	private int id = 0;
	private String name = "";
	private String gender = "false";
	private String company = "";
	private String phone = "";
	public User() {
		
	}
	public User(int id, String name, String gender, String company, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.company = company;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String isGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", company=" + company + ", phone=" + phone
				+ "]";
	}
	
	
}
