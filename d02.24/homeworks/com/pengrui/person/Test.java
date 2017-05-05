package com.pengrui.person;

public class Test {
	public static void main(String[] args) {
		Person p1 = new Person("niyongfeng", "浙江传媒学院");
		System.out.println(p1.toString());
		Student s1 = new Student("niyongfeng", "浙江传媒学院", "JAVA", 1, 10000);
		System.out.println(s1.toString());
		Staff s2 = new Staff("nyf", "新加坡科技园", "清华大学", 9999);
		System.out.println(s2.toString());
	}
}
