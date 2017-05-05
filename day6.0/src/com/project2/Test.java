package com.project2;

public class Test {
	
	public static void main(String[] args) {
	
		Circle circle = new Circle(1.0, "red", true);
		Rectangle rectangle = new Rectangle(2.0, 3.0, "blue", false);
		Square square = new Square(4.0, "green", true);
		
		System.out.println("圆：" + circle.toString() + "\n");
		System.out.println("矩形：" + rectangle.toString() + "\n");
		System.out.println("正方形：" + square.toString() + "\n");
	
	
	
	
	}
	

}
