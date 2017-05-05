package com.pengrui.animals;

public class Test {
	public static void main(String[] args) {
		Dog d = new Dog("阿宝", 2, "niyongfeng");
		Cat c = new Cat("阿花", 1, "nyf");
		System.out.println(d.toString() + " " + d.information());
		System.out.println(c.toString() + " " + c.information());
		d.run();
		d.eat();
		c.run();
		c.eat();
		//Dog d1 = new Dog("大黄");
		
	}
}
