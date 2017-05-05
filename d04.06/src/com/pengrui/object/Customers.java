package com.pengrui.object;

public class Customers {

	private int id = 0;
	private String pwd = "";
	private String name = "";
	private String phone = "";
	private String address = "";
	private String email = "";
	private int postcode = 0;
	
	public Customers() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	@Override
	public String toString() {
		return "Customers [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ ", email=" + email + ", postcode=" + postcode + "]";
	}
	
	
}
