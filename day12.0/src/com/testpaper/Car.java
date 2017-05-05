package com.testpaper;

public class Car extends Vehicles{

	private int seats;
	
	public Car(String brand, String color, int seats) {
		super(brand, color);
		this.seats = seats;
	}
	
	public int getSeats() {
		return seats;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public String showCar() {
		return "Car [ " + super.showInfo() + ", seats: " + seats + " ]"; 
	}
}
