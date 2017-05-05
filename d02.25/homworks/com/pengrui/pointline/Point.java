package com.pengrui.pointline;

public class Point {
	
	private double x;
	private double y;
	
	public Point() {
		
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
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
	
	public Point getPoint() {
		return this;
	}
	
	public void setPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}
}
