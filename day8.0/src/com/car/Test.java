package com.car;

public class Test {

	public static void main(String[] args) {
		
		Car car = new Car("保时捷", "911");
		System.out.println(car.toString());
		for(int i = 0; i < 11; i++) {
			car.start();
		}
	}
	
}
