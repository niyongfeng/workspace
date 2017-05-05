package com.pengrui.car;

public class TestCar {
	public static void main(String[] args) {
		Car car = new Car("保时捷", "911");
		System.out.println(car.toString());
		for(int i = 0; i < 15; i++) {
			car.start();
		}
		System.out.println(car.getClass());
		
	}
}
