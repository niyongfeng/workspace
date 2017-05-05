package com.nyf.projo;

public class User {
	
	private Integer id;
	private String student_number;
	private String name;
	private int age;
	private String gender;
	private String major;
	private String phone;
	private String email;
	private Integer status;
	private int Login_id;
	private int volunteer_id;
	private String desc;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getVolunteer_id() {
		return volunteer_id;
	}
	public void setVolunteer_id(int volunteer_id) {
		this.volunteer_id = volunteer_id;
	}
	public int getLogin_id() {
		return Login_id;
	}
	public void setLogin_id(int login_id) {
		Login_id = login_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudent_number() {
		return student_number;
	}
	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", student_number=" + student_number + ", name=" + name + ", age=" + age + ", gender="
				+ gender + ", major=" + major + ", phone=" + phone + ", email=" + email + ", status=" + status
				+ ", Login_id=" + Login_id + ", volunteer_id=" + volunteer_id + ", desc=" + desc + "]";
	}
	
	
}
