package com.pengrui.cylinder;

public class Test {
	public static void main(String[] args) {
		Circle c = new Circle(5.0, "Yellow");
		Cylinder cy = new Cylinder(c, 6.0);
		System.out.println(c.toString());
		System.out.println("圆的面积:" + c.getArea());
		System.out.println("圆的周长:" + c.getPerimeter());
		System.out.println(cy.toString());
		System.out.println("圆柱的体积:" + cy.getV());
		
	}
	
}
