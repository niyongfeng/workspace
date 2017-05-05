package com.pengrui.point;

public class MyPoint {
	public int x = 0;
	public int y = 0;
	
	public MyPoint() {
		
	}
	
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int[] getXY() {
		return new int[]{x, y};
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public double distance(int x, int y) {
		return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
	}
	
	public double distance(MyPoint anthor) {
		return distance(anthor.x, anthor.y);
	}
	
	public double distance() {
		return Math.sqrt(x * x + y * y);
	}

}
