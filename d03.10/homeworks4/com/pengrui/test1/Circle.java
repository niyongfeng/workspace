package com.pengrui.test1;

public class Circle extends Point{
	private double radius;
	
	public Circle() {
		
	}
	
	public Circle(double x1, double y1, double radius) {
		super(x1, y1);
		this.radius = radius;
	}
	
	public String toString() {
		return "Circle[" + super.getPoint() + ",Radius:" + radius + "]";
	}
}
