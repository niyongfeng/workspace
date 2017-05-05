package com.pengrui.interfacevehicle;

public class Test {
	public static void main(String[] args) {
		Bike bike = new Bike();
		Bus bus = new Bus();
		bike.start();
		bike.stop();
		bus.start();
		bus.stop();
	}
}
