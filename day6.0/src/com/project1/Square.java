package com.project1;

public class Square extends Rectangle{
	
	public Square() {
		
	}
	
	public Square(double side) {
		super(side, side);
	}
	
	public Square(double side, String color, boolean filled) {		
		super(side,side,color,filled);
	}
	
	public double getSide() {
		return super.getWidth();
	}
	
	public void setSide(double side) {
		super.setWidth(side);
		super.setLength(side);
	}
	
	public void setWidth(double side) {
		super.setWidth(side);
	}
	
	public void setLength(double side) {
		super.setWidth(side);
	}
	
	public String toString() {
		return "Square [ side = " + super.getWidth() + ", area = " + super.getArea() + ", perimeter = " + super.getPerimeter() + " ]";
	}

}
