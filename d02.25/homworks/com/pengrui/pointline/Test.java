package com.pengrui.pointline;

public class Test {

	public static void main(String[] args) {
		Point point1 = new Point(1.0, 1.0);
		Point point2 = new Point(2.0, 2.0);
		System.out.println(point1.toString());
		System.out.println(point2.toString());
		Line line = new Line(point1, point2);
		System.out.println(line.toString());
		
		LineSub linesub = new LineSub(point1, point2);
		System.out.println(linesub.toString());
		System.out.println(linesub.getLength());
		System.out.println(linesub.getGradient());
	}
}
