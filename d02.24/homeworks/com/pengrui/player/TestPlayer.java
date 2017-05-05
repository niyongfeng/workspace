package com.pengrui.player;

public class TestPlayer {

	public static void main(String[] args) {
		Player player = new Player(110708132, 1.0f, 1.0f);
		Ball ball1 = new Ball(0, 0, 0);
		Ball ball2 = new Ball(10, 10, 0);
		
		player.jump(1.0f);
		player.kick(ball1);
		player.kick(ball2);
	}
}
