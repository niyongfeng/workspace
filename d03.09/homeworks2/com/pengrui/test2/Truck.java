package com.pengrui.test2;

public class Truck extends Vehicles{
	private float load;
	
	public Truck() {
		
	}
	
	public Truck(String brand, String color, float load) {
		super(brand, color);
		this.load = load;
	}
	
	public String showTruck() {
		return super.showInfo() + ",Load:" + load + "吨";
	}
}
