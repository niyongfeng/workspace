package com.pengrui.car;

public class Auto {
	private int bype;
	private String color;
	private double weight;
	private double speed;
	
	public Auto() {
		
	}
	
	public Auto(int bype, String color, double weight, double speed) {
		this.bype = bype;
		this.color = color;
		this.weight = weight;
		this.speed = speed;
	}

	public int getBype() {
		return bype;
	}

	public void setBype(int bype) {
		this.bype = bype;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void speedUp(double up) {
		speed = speed + up;
	}
	
	public void speedDown(double down) {
		speed = speed - down;
	}
	
	public void stop() {
		speed = 0;
	}
	
	public String toString() {
		return "Car(Type:" + getBype() + ",Color:" + getColor() + ",Weight:" + getWeight() + ",Speed:" + getSpeed() + ")";
	}
	
}
