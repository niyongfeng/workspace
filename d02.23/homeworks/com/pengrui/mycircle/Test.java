package com.pengrui.mycircle;

public class Test {
	public static void main(String[] args) {
		MyCircle c1 = new MyCircle(1, 1, 1);
		MyCircle c2 = new MyCircle(2, 2, 2);
		System.out.println(c1.toString());
		System.out.println("面积：" + c1.getArea());
		System.out.println("周长：" + c1.getCirumference());
		System.out.println("两个圆之间的距离：" + c1.distance(c2));
	}
}
