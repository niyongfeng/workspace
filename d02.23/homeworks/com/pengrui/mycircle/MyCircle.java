package com.pengrui.mycircle;
import com.pengrui.point.MyPoint;

public class MyCircle {

	private MyPoint center = new MyPoint();
	private int radius = 1;
	
	public MyCircle() {
		
	}
	
	public MyCircle(int x, int y, int radius) {
		center.setXY(x, y);
		this.radius = radius;
	}
	
	public MyCircle(MyPoint anthor, int radius) {
		center = anthor;
		this.radius = radius;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public MyPoint getCenter() {
		return center;
	}
	
	public void setCenter(MyPoint center) {
		this.center = center;
	}
	
	public int getCenterX() {
		return center.getX();
	}
	
	public void setCenterX(int x) {
		center.setX(x);
	}
	
	public int getCenterY() {
		return center.getY();
	}
	
	public void setCenterY(int y) {
		center.setY(y);;
	}
	
	public int[] getCenterXY() {
		return new int[]{center.getX(), center.getY()};
	}
	
	public void setCenterXY(int x, int y) {
		center.setXY(x, y);;
	}
	
	public String toString() {
		return "MyCircle [ radius = " + getRadius() + ", center = (" + getCenterX() + "," + getCenterY() + ") ]"; 
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public double getCirumference() {
		return 2 * Math.PI * radius;
	} 
	
	public double distance(MyCircle anthor) {
		return center.distance(anthor.getCenterX(), anthor.getCenterY());
	}
	
}
