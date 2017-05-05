package com.project1;

public class Test {
	
	public static void main(String[] args) {
		MovablePoint p = new MovablePoint(0,0,1,1);
		System.out.println(p.toString());
		System.out.println("");
		
		p.moveRight();
		p.moveUp();
		System.out.println(p.toString());
		System.out.println("");
		
		p.moveDown();
		p.moveLeft();
		System.out.println(p.toString());
		System.out.println("");
		
		MovableCircle c = new MovableCircle(10,10,5,5,5);
		System.out.println(c.toString());
		System.out.println("");
		
		c.moveRight();
		c.moveUp();
		System.out.println(c.toString());
		System.out.println("");
		
		c.moveLeft();
		c.moveDown();
		System.out.println(c.toString());
		
	}

}
