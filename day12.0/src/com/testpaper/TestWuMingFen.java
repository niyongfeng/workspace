package com.testpaper;

public class TestWuMingFen {

	public static void main(String[] args) {
		WuMingFen f1 = new WuMingFen("牛肉", 3, true);
		WuMingFen f2 = new WuMingFen("牛肉", 2);
		WuMingFen f3 = new WuMingFen();
		
		System.out.println(f1.check());
		System.out.println(f2.check());
		System.out.println(f3.check());
	}
}
