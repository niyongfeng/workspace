package com.pengrui.object;

public class Users {
	private int id = 0;
	private String name = "";
	private String pwd = "";
	private int customersId = 0;
	private int sellersId = 0;
	
	public Users() {
		
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getCustomersId() {
		return customersId;
	}
	public void setCustomersId(int customersId) {
		this.customersId = customersId;
	}
	public int getSellersId() {
		return sellersId;
	}
	public void setSellersId(int sellersId) {
		this.sellersId = sellersId;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", pwd=" + pwd + ", customersId=" + customersId + ", sellersId="
				+ sellersId + "]";
	}
	
	
}
