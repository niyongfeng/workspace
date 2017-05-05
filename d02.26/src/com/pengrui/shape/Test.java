package com.pengrui.shape;

public class Test {
	public static void main(String[] args) {
		Circle c = new Circle(1.0, "Green", true);
		System.out.println(c.toString());
		Rectangle r = new Rectangle(2.0, 3.0, "Yellow", false);
		System.out.println(r.toString());
		Square s = new Square(4.0, "black", true);
		System.out.println(s.toString());
	}
}
