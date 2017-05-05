package com.circle;

public class Test {

	public static void main(String[] args) {

		Circle circle = new Circle(2.0);
		System.out.println("Perimeter = " + circle.getPerimeter());
		System.out.println("Area = " + circle.getArea());
		System.out.println("");
		
		ResizableCircle resizablecircle = new ResizableCircle(3.0);
		resizablecircle.resize(150);
		System.out.println("Perimeter = " +resizablecircle.getPerimeter());
		System.out.println("Area =" + resizablecircle.getArea());
	}
}
