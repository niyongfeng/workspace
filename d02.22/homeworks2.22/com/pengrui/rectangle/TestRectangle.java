package com.pengrui.rectangle;

public class TestRectangle {
	
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		System.out.println(r1.toString());
		System.out.println("");
		r1.setLength(2.0f);
		r1.setWideth(4.0f);
		System.out.println(r1.toString());
		System.out.println("");
		
		Rectangle r2 = new Rectangle(2.0f, 3.0f);
		System.out.println(r2.toString());
		System.out.println("Area:" + r2.getArea() + "\nPerimeter:" + r2.getPerimeter());
		
		Rectangle r3 = (Rectangle) r2.clone();
		System.out.println("克隆体：" + r3.toString());
		System.out.println(r3.hashCode());
		System.out.println(r2.equals(r3));
		
	}

}
