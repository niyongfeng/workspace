package com.pengrui.test2;

public class Test {
	public static void main(String[] args) {
		Car c = new Car("宝马", "red", 4);
		Truck t = new Truck("长安", "yellow", 2.0f);
		System.out.println(c.showCar());
		System.out.println(t.showTruck());
		
	}
}
