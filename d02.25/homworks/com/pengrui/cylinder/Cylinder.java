package com.pengrui.cylinder;

public class Cylinder extends Circle{
	private double height;
	private Circle base;
	//private double radius = 1.0;
	
	public Cylinder() {
		base = new Circle();
		height = 1.0;
	}
	
	public Cylinder(Circle cir, double height) {
		base = cir;
		this.height = height;
	}
	
	public Cylinder(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getV() {
		return base.getArea() * height;
		//return Math.PI * radius * radius * height;
	}
	
	public String toString() {
		return base.toString() + ",Height:" + getHeight();
	}
	
	
}
