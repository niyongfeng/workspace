package com.pengrui.test2;

public class Vehicles {
	private String brand;
	private String color;
	
	public Vehicles() {
		
	}
	
	public Vehicles(String brand, String color) {
		this.brand = brand;
		this.color = color;
	}
	
	public void run() {
		System.out.println("我已经开动了！");
	}
	
	public String showInfo() {
		return "Vehicle:Brand:" + brand + ",Color:" + color;
	}
	
	

}
