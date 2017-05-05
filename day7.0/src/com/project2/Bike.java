package com.project2;

public class Bike implements Vehicle{
	
	private int a;
	private int b;

	public Bike() {
		
	}
	
	public void start(int a) {
		this.a = a;
	}
	
	public void stop(int b) {
		this.b = b;
	}
	
	public String toString() {
		return "BikeTime : " + (b - a) + "小时";
	}
	
}
