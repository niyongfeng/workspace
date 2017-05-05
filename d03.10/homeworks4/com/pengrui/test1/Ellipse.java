package com.pengrui.test1;

public class Ellipse extends Point{
	private double x2;
	private double y2;

	
	public Ellipse() {
		
	}
	
	public Ellipse(double x1, double y1, double x2, double y2) {
		super(x1,y1);
		this.x2 = x2;
		this.y2 = y2;

	}
	
	public String toString() {
		return "Ellipse[x^2/" + super.getX() + "^2 + y^2/" + y2 + "^2]";   
	}
}
