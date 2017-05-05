package com.Point;

public class Test {
	
	public static void main(String[] agres){
		MovablePoint movablepoint1 = new MovablePoint();
		Point point1 = new Point();
		System.out.println("起点： " + point1.toString());
		System.out.println("信息： " + movablepoint1.toString());
		System.out.println("终点： " + movablepoint1.move());
		
		MovablePoint movablepoint2 = new MovablePoint(1.1f,1.1f,1,1);
		Point point2 = new Point(2.2f, 2.2f);
		System.out.println("起点： " + point2.toString());
		System.out.println("信息： " + movablepoint2.toString());
		System.out.println("终点： " + movablepoint2.move());
		
		MovablePoint movablepoint3 = new MovablePoint(2, 2);
		Point point3 = new Point(3.3f, 3.3f);
		point3.setXY(3.3f, 3.3f);
		System.out.println("起点: " + movablepoint3.toString());
		System.out.println("终点： " + movablepoint3.move());
	}

}
