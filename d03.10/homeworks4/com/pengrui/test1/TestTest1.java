package com.pengrui.test1;

public class TestTest1 {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(0,0,2,1);
		System.out.println(r.toString());
		Triangle t = new Triangle(0,0, 0,1, 1,0);
		System.out.println(t.toString());
		Circle c = new Circle(1,1, 5.0);
		System.out.println(c.toString());
		Ellipse e = new Ellipse(0,5, 3,0);
		System.out.println(e.toString());
	}
}
