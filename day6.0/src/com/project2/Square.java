package com.project2;

public class Square extends Rectangle{

	public Square() {
		
	}
	
	public Square(double side) {
		this.setWidth(side);
	}
	
	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}
	
	public double getSide() {
		return this.getWidth();
	}
	
	public void setSide(double side) {
		this.setWidth(side);
	}
	
	public void setLength(double side) {
		this.setLength(side);
	}
	
	public String toString() {
		return "Square [ Side = " + getSide() + ", " + super.toString();
	}
}
