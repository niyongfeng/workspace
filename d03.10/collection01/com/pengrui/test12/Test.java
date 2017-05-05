package com.pengrui.test12;

public class Test {
	public static void main(String[] age) {
		Manage m = new Manage();
		m.manage.add(new Student("Tom", 18, 100, "class05"));
		m.manage.add(new Student("Jerry", 22, 70, "class04"));
		m.manage.add(new Student("Owen", 25, 90, "class05"));
		m.manage.add(new Student("Jim", 30, 80, "class05"));
		m.manage.add(new Student("Steve", 28, 66, "class06"));
		m.manage.add(new Student("Kevin", 24, 100, "class04"));
		
		System.out.println(m.ageAve());
		System.out.println(m.scoresAve("class05"));
	}
}
