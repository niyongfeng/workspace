package com.pengrui.point;

public class TestPoint {

	public static void main(String[] args) {
		MyPoint p1 = new MyPoint(6,6);
		MyPoint p2 = new MyPoint(1,1);
		System.out.println("与原点之间的距离" + p1.distance());
		System.out.println("与（8，8）之间的距离" + p1.distance(8, 8));
		System.out.println("与p2之间的距离" + p1.distance(p2));
		
		String[] point = new String[10];
		for(int i = 0; i < 10; i++) {
			point[i] = "(" + (i + 1) + "," + (i + 1) + ")"; 
		}
		for(String str : point) {
			System.out.println(str);
		}
	}
}
