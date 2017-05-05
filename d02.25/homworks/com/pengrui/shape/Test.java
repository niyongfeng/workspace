package com.pengrui.shape;

public class Test {
	public static void main(String[] args) {
		Shape shape = new Shape("green", false);
		System.out.println(shape);
		Circle circle = new Circle(2.0, "yellow", true);
		System.out.println(circle);
		Rectangle rectangle = new Rectangle(2.0, 3.0, "black", false);
		System.out.println(rectangle);
		Square square = new Square(2.0, "write", true);
		System.out.println(square);
	}
}
