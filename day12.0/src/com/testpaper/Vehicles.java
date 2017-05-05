package com.testpaper;

public class Vehicles {
	
	private String brand;
	private String color;
	
	public Vehicles(String brand, String color) {
		this.brand = brand;
		this.color = color;
	}
	
	public String run() {
		return "车已经开动了";
	}
	
	public String showInfo() {
		return "brand: " + brand + ", color: " + color;
	}

}
