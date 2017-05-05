package com.enumproject;

public enum TrafficLight {
	RED("Red:"),YELLOW("Yellow:"), GREEN("Green:");
	
	
	private TrafficLight() {
		System.out.println("///");
	}

	public String color;
	private TrafficLight(String color) {
		this.color = color;
	}
	
	public String toString() {
		return color;
	}
}
