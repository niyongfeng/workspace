package com.pengrui.test3;

public class Test {
	public static void main(String[] args) {
		Bike b1 = new Bike();
		Bus b2 = new Bus();
		System.out.println(b1.start());
		System.out.println(b1.stop());
		System.out.println(b2.start());
		System.out.println(b2.stop());
	}
}
