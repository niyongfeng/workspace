package com.pengrui.point3d;

public class Test {
	public static void main(String[] args) {
		Point2D p1 = new Point2D(1,1);
		Point3D p2 = new Point3D(p1,1);
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
	}
}
