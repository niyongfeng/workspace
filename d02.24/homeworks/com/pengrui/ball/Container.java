package com.pengrui.ball;

public class Container {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public Container(int x, int y, int width, int height){
		this.x1 = x;
		this.y1 = y;
		this.x2 = width;
		this.y2 = height;
	}
	
	public int getX() {
		return x1;
	}
	
	public int getY() {
		return y1;
	}
	
	public int getWidth() {
		return x2;
	}
	
	public int getHeight() {
		return y2;
	}
	
	public boolean collidesWith(Ball ball) {
		if((ball.getX() + ball.getRadius() >= x2) || (ball.getX() - ball.getRadius() <= x1)) {
			ball.reflectHorizontal();
			return true;
		}
		if((ball.getY() + ball.getRadius() >= y1) || (ball.getY() - ball.getRadius() <= y2)){
			ball.redlectVertical();
			return true;
		}
		return false;
	
	}
	
	
 }
