package com.project;

public class Test {

	public static void main(String[] args) {
		Pigeon pigeon = new Pigeon("白色", "信鸽", true, "送信");
		F22 f22 = new F22("战斗机", 500, "军用", 15);
		
		System.out.println(pigeon.toFly());
		System.out.println(pigeon.toString());
		System.out.println(f22.toFly());
		System.out.println(f22.toString());
		
	}
}
