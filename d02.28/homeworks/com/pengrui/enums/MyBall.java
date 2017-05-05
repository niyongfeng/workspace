package com.pengrui.enums;

enum Ball {
	BASKETBALL("篮球"),PINGPANGBALL("乒乓球"),FOOTBALL("足球"),TENNIS("网球");
	
	public String cN;
	private Ball(String cN) {
		this.cN = cN;
	}
}

public class MyBall {
	public void getBall(Ball ball) {
		System.out.println("我喜欢打：" + ball.cN + "_" + ball.name());
		switch(ball) {
		case BASKETBALL : System.out.println("篮球好玩");break;
		case PINGPANGBALL : System.out.println("乒乓球还行");break;
		case FOOTBALL : System.out.println("足球很棒");break;
		case TENNIS : System.out.println("网球不会");break; 
		}
	}
	
	public static void main(String[] args) {
		MyBall m = new MyBall();
		m.getBall(Ball.BASKETBALL);
		m.getBall(Ball.FOOTBALL);
		m.getBall(Ball.PINGPANGBALL);
		m.getBall(Ball.TENNIS);
	}
}
