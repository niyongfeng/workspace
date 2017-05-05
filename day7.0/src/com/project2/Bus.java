package com.project2;

public class Bus implements Vehicle{
	
	private int a;
	private int b;
	
	public Bus() {
		
	}

	public void start(int a) {
		this.a = a;
	}
	
	public void stop(int b) {
		this.b = b;
	}
	
	public String toString() {
		return "BusTime : " + (b - a) + "小时";
	}
}
