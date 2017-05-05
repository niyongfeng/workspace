package com.project2;

public class InterfaceDemo {
	
	public static void main(String[] args) {
		
		Bike bike = new Bike();
		Bus bus = new Bus();
		
		bike.start(6);
		bike.stop(8);
		
		bus.start(7);
		bus.stop(8);
		
		System.out.println(bike.toString());
		System.out.println(bus.toString());
	}

}
