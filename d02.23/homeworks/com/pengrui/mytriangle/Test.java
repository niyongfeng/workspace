package com.pengrui.mytriangle;

import com.pengrui.point.MyPoint;

public class Test {
	public static void main(String[] args) {
		MyTriangle t1 = new MyTriangle(1,1, 2,2, 3,1);
		System.out.println(t1.getPermeter());
		System.out.println(t1.getType());
		
		MyPoint p1 = new MyPoint(0,0);
		MyPoint p2 = new MyPoint(1,1);
		MyPoint p3 = new MyPoint(4,0);
		MyTriangle t2 = new MyTriangle(p1, p2, p3);
		System.out.println(t2.getType());
	}

}
