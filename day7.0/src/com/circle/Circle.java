package com.circle;

public class Circle implements GeometricObject{
	
	public double radius = 1.0;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
//	private Circle() {
//		
//	}
	
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}

}
