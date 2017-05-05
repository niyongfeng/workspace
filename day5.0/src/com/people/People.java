package com.people;

public class People {
	private String name;
	private String address;

	public People(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return "People [ name = " + name + ", address = " + address + " ]";
	}
}
