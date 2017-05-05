package com.pengrui.circle;

public class Test {
	
	public static void main(String[] args) {
		Circle c = new Circle(2.0);	
		System.out.println("初始面积为：" + c.getArea());
		System.out.println("初始周长为：" + c.getPerimeter());
		
		ResizableCircle r = new ResizableCircle(2.0);
		System.out.println("初始面积为：" + r.getArea());
		System.out.println("初始周长为：" + r.getPerimeter());
		r.resize(50);
		System.out.println("变形后面积为：" + r.getArea());
		System.out.println("变形后周长为：" + r.getPerimeter());
	}
}
