package com.pengrui.test2;

public class Vehicle {
	private double speed;
	private double size;
	
	public Vehicle() {
		
	}
	
	public Vehicle(double speed, double size) {
		this.size = size;
		this.speed = speed;
	}
	
	public void move() {
		System.out.println("车开始动了！");
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void speedUp() {
		System.out.println("车子开始加速了！");
		speed = speed + 10;
		System.out.println("当前车速：" + getSpeed() + "km/h");
	}
	
	public void speedDown() {
		System.out.println("车子开始减速了！");
		if(speed > 10) {
			speed = speed - 10;
		}else {
			speed = 0;
		}
		System.out.println("当前车速：" + getSpeed() + "km/h");
	}
	
	public String toString() {
		return "Vehicle:Size:" + size + "Kg,Speed:" + speed + "km/h";
	}
	
	public static void main(String[] args) {
		Vehicle v = new Vehicle(20.0, 5000);
		System.out.println(v.toString());
		v.move();
		v.speedUp();
		v.speedDown();
	}
}
