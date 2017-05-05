package com.pengrui.movablepoint;

public class Test {
	public static void main(String[] args) {
		Point p1 = new Point(1.0f, 1.0f);
		System.out.println("原点：" + p1.toString());
		MovablePoint p2 = new MovablePoint(1.0f, 1.0f, 2.0f, 2.0f);
		System.out.println("移动前：" + p2.toString());
		p2.move();
		System.out.println("移动后：" + p2.toString());
	}
}
