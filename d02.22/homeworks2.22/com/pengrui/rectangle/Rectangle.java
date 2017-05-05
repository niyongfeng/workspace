package com.pengrui.rectangle;

public class Rectangle {

	private float length = 1.0f;
	private float width = 1.0f;
	
	public Rectangle() {
		
	}
	
	public Rectangle(float length, float width) {
		this.length = length;
		this.width = width;
	}
	
	public float getLength() {
		return length;
	}
	
	public void setLength(float length) {
		this.length = length;
	}
	
	public float getWidth() {
		return width;
	}
	
	public void setWideth(float width) {
		this.width = width;
	}
	
	public double getArea() {
		return length * width;
	}
	
	public double getPerimeter() {
		return 2 * (length + width);
	}
	
	public String toString() {
		return "Rectangle [ length = " + length + ", width = " + width + " ]";
	}
	
	public int hashCode() {
		String str = length + width + "";
		return str.hashCode();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Rectangle)) return false;
		
		Rectangle r = (Rectangle) obj;
		return r.length == length && r.width == width;
	}
	
	public Object clone() {
		Rectangle r1 = new Rectangle(length, width);
		return r1;
	}
}
