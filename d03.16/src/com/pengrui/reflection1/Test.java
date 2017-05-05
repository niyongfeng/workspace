package com.pengrui.reflection1;

public class Test {
	public static void main(String[] args) {
		Dog d = new Dog();
		Dog.getClassFullName(d);
		Dog.getClassName();
		Dog.getClassInfo();
		Dog.getObjectInstance();
	}
}
