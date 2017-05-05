package com.pengrui.test1;

public class Rectangle extends Point{
	private double x2;
	private double y2;
	
	public Rectangle() {

	}
	
	public Rectangle(double x1, double y1, double x2, double y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public String toString() {
		return "Rectangle:[" + super.getPoint() + ",(" + x2 + "," + y2 + ")]";
	}
}
