package com.pengrui.movablepoint;

public class Point {

	private float x = 0.0f;
	private float y = 0.0f;
	
	public Point() {
		
	}
	
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float[] getXY() {
		return new float[]{x, y};
	}
	
	public void setXY(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}
}
