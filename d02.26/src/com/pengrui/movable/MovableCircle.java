package com.pengrui.movable;

public class MovableCircle extends MovablePoint implements Movable{
	private int radius;
	private MovablePoint center;
	
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}
	
	public String toString() {
		return "Circle[Center:" + super.toString() + ",Radius:" + radius + "]";
	}
	
	public void moveUp() {
		super.moveUp();
	}
	
	public void moveDown() {
		super.moveDown();
	}
	
	public void moveLeft() {
		super.moveLeft();
	}
	
	public void moveRight() {
		super.moveRight();
	}
}
