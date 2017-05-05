package com.pengrui.test1;

public class Triangle extends Point{
	
	private double x2;
	private double x3;
	private double y2;
	private double y3;
	
	public Triangle() {
		
	}
	
	public Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
		super(x1,y1);
		this.x2 = x2;
		this.x3 = x3;
		this.y2 = y2;
		this.y3 = y3;
	}
	
	public String getPoint(double x, double y) {
		return "(" + x + "," + y + ")";
	}
	public String toString() {
		return "Triangle[" + super.getPoint() + "," + getPoint(x2,y2) + "," + getPoint(x3,y3) + "]";
	}
}
