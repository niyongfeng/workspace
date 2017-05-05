package com.pengrui.list;

public class Employee {
	private String name;
	private String id;
	private int price;
	
	public Employee() {
		
	}
	
	public Employee(String name, String id, int price) {
		this.name = name;
		this.id = id;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "Name:" + name + ",Id:" + id + ",Price:" + price;
	}
	
	
}
