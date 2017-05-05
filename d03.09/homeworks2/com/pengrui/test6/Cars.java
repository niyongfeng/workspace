package com.pengrui.test6;

public class Cars {
	private int type = 4;
	private String color = "red";
	private int weight = 6;
	
	public Cars(int type, String color, int weight) {
		this.type = type;
		this.color = color;
		this.weight = weight;
	}
	
	public Cars(int type) {
		this.type = type;
	}
	
	public Cars(int type, String color) {
		this.type = type;
		this.color = color;
	}
	
	public void speedUp() {
		System.out.println("加速");
	}
	
	public void speedDown() {
		System.out.println("减速");
	}
	
	public void stop() {
		System.out.println("停车");
	}
	
	public static void main(String[] args) {
		Cars c = new Cars(4, "red");
		c.speedUp();
		c.speedDown();
		c.stop();
	}
}
