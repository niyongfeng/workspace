package com.pengrui.classes;

public class Test {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		t.print();
		System.out.println("===============增加后：");
		t.map.put("Allen", "JDBC");
		t.print();
		System.out.println("===============修改后：");
		t.change(new Teacher("Lucy","CoreJava"));
		t.print();
		System.out.println("===============查找：");
		t.search("JSP");
	}
}
