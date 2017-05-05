package com.qingke.circle;

public class Circle {

	private double radius = 1.0;
	private String color = "red";
	
	public Circle() {
		
	}
	
	public Circle(double r) {
		this.radius = r;
	}
	
	public Circle(double r, String color) {
		this.radius = r;
		this.color = color;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public double getCircumference() {
		return 2 * Math.PI * radius;
	}
	
	public String toString() {
		return "Circle [ radius = " + radius + ", color = " + color + ", area = " + getArea() + 
				", circumference = " + getCircumference() + " ]";
	}
	
	
}
