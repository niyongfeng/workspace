package com.project1;

public class MovableCircle implements Movable{
	
	private int radius;
	private MovablePoint center = new MovablePoint(0, 0, 0, 0);
	
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		center.x = x;
		center.y = y;
		center.xSpeed = xSpeed;
		center.ySpeed = ySpeed;
		this.radius = radius;
	}
	
	public String toString() {
		return "Circle [ Radius = " + radius + ", Center = ( " + center.x + ", " + center.y + " ) ]";
	}

	public void moveUp() {
		center.y = center.y + center.ySpeed;
	}
	
	public void moveDown() {
		center.y = center.y - center.ySpeed;
	}
	
	public void moveLeft() {
		center.x = center.x - center.xSpeed;
	}
	
	public void moveRight() {
		center.x = center.x + center.xSpeed;
	}
}
