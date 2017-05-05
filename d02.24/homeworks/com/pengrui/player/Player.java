package com.pengrui.player;

public class Player {

	private int number;
	private float x;
	private float y;
	private float z = 0.0f;
	
	public Player(int number, float x, float y) {
		this.number = number;
		this.x = x;
		this.y = y;
	}
	
	public void move(float xDisp, float yDisp) {
		x = x + xDisp;
		y = y + yDisp;
	}
	
	public void jump(float zDisp) {
		z = z + zDisp;
	}
	
	public boolean near(Ball ball) {
		if(ball.getX() - x < 8 && ball.getY() - y < 8) {
			return true;
		}else {
			return false;
		}
	}
	
	public void kick(Ball ball) {
		if(near(ball) == true) {
			System.out.println("我要射门了!");
		}else {
			System.out.println("快传球给我！");
		}
	}
}
