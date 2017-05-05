package com.project3;

public class Car extends Vehicle{
	
	private final int amount = 4;
	
	public Car() {
		
	}
	
	public String NoOfWheels() {
		return "Car有" + amount + "个轮子。";
	}

}
