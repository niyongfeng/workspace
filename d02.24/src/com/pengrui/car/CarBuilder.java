package com.pengrui.car;

public class CarBuilder {

	public static void main(String[] args) {
		setBMW();
		setBenC();
	}
	
	static void setBMW() {
		Car car = new Car();
		car.setColor("red");
		car.setName("宝马");
		car.setPrice(800000);
		System.out.println(car.toString());
		Type type = new Type(4);
		System.out.println(type.toString());
		SuperType t = new SuperType();
		System.out.println(t.toString());
	}
	
	static void setBenC() {
		Type t = new Type(4);
		Car car = new Car("奔驰", 1000000, t, "black");
		System.out.println(car.toString());
		SeniorType t2 = new SeniorType();
		System.out.println(t2.toString());
	}
}
