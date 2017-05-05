package com.pengrui.test1;

public abstract class Point {
	
	private double x = 0;
	private double y = 0;
	
	public Point() {
		
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String getPoint() {
		return "(" + x + "," + y + ")";
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	} 
	
	public abstract String toString();
	
}
