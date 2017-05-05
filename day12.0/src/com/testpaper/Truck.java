package com.testpaper;

public class Truck extends Vehicles{

	private float load;
	
	public Truck(String brand, String color, float load) {
		super(brand, color);
		this.load = load;
	}
	
	public float getLoad() {
		return load;
	}
	
	public void setLoad(float load) {
		this.load = load;
	}
	
	public String showTruck() {
		return "Truck [ " + super.showInfo() + ", load: " + load + " ]";
	}
}
