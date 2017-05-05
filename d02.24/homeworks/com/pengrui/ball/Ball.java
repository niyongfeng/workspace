package com.pengrui.ball;

public class Ball {
	
	private float x;
	private float y;
	private int radius;
	private float xDelta;
	private float yDelta;
	
	public Ball(float x, float y, int radius, int speed, int dirction) {
		this.x = x;
		this.y = y;
		xDelta = (float)(speed * Math.cos(Math.toRadians(dirction)));
		yDelta = (float)(speed * Math.sin(Math.toRadians(dirction)));
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
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public float getXDelta() {
		return xDelta;
	}
	
	public float getYDelta() {
		return yDelta;
	}
	
	public void setXDelta(float xDelta) {
		this.xDelta = xDelta;
	}
	
	public void setYDelta(float yDelta) {
		this.yDelta = yDelta;
	}
	
	public void move() {
		x = x + xDelta;
		y = y + yDelta;
	}
	
	public void reflectHorizontal() {
		xDelta = -xDelta;
	}
	
	public void redlectVertical() {
		yDelta = -yDelta;
	}
	
	public String toString() {
		return "Ball [ (" + getX() + "," + getY() + "),speed = (" + getXDelta() + "," + getYDelta() + ") ]";
	}
}
