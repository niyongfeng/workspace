package com.pengrui.movable;

public class Test {
	public static void main(String[] args) {
		MovableCircle m = new MovableCircle(1, 1, 2, 2, 3);
		System.out.println(m.toString());
		m.moveDown();
		System.out.println("向下移动：" + m.toString());
		m.moveLeft();
		System.out.println("向左移动：" + m.toString());
		m.moveRight();
		System.out.println("向右移动：" + m.toString());
		m.moveUp();
		System.out.println("向上移动：" + m.toString());
		
		MovableRectangle r = new MovableRectangle(0, 1, 3, 0, 2, 2);
		System.out.println(r.toString());
		r.moveDown();
		System.out.println("向下移动：" + r.toString());
		r.moveLeft();
		System.out.println("向左移动：" + r.toString());
		r.moveRight();
		System.out.println("向右移动：" + r.toString());
		r.moveUp();
		System.out.println("向上移动：" + r.toString());
	}
	
}
