package com.pengrui.abstractvehicle;

public class Test {
	public static void main(String[] args) {
		Car c = new Car();
		Motorbike m = new Motorbike();
		System.out.println(c.NoOfWheels());
		System.out.println(m.NoOfWheels());
	}
}
