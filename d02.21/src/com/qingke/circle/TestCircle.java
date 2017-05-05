package com.qingke.circle;

public class TestCircle {
	
	public static void main(String[] args) {
		Circle c1 = new Circle();
		System.out.println(c1.toString());
		
		System.out.println(c1.getColor());
		System.out.println(c1.getRadius());
		c1.setColor("yellow");
		c1.setRadius(2.0);
		System.out.println(c1.toString());
		
		Circle c2 = new Circle(3.0);
		System.out.println(c2.toString());
		
		Circle c3 = new Circle(3.0, "green");
		System.out.println(c3.toString());
		
	}

}
