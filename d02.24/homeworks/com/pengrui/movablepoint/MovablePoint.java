package com.pengrui.movablepoint;

public class MovablePoint extends Point{
	private float xSpeed = 0.0f;
	private float ySpeed = 0.0f;
	
	public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
		super(x, y);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public MovablePoint(float xSpeed, float ySpeed) {
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public MovablePoint() {
		
	}
	
	public float getXSpeed() {
		return xSpeed;
	}
	
	public float getYSpeed() {
		return ySpeed;
	}
	
	public void setXSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}
	
	public void setYSpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public float[] getSpeed() {
		return new float[]{xSpeed, ySpeed};
	}
	
	public void setSpeed(float xSpeed, float ySpeed) {
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	} 
	
	public String toString() {
		return super.toString() + "speed = (" + getXSpeed() + "," + getYSpeed() + ")";
	}
	
	public MovablePoint move() {
		super.setX(super.getX() + xSpeed);
		super.setY(super.getY() + ySpeed);
		return this;
	}
	
	
}
