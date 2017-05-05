package com.pengrui.car;

public class Car {
	private String name;
	private int price;
	private Type type;
	private String color;
	
	public Car() {
		
	}
	
	public Car(String name, int price, Type type, String color) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.color = color;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return "Car [ name:" + getName() + ", price: " + getPrice() + ", type: " + getType() + ",color: " + getColor() + " ]";
	}
}
