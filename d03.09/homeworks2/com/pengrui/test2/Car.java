package com.pengrui.test2;

public class Car extends Vehicles{
	private int seats;
	
	public Car() {
		
	}
	
	public Car(String brand, String color, int seats) {
		super(brand, color);
		this.seats = seats;
	}
	
	public String showCar() {
		return super.showInfo() + ",Seats:" + seats;
	}
}
