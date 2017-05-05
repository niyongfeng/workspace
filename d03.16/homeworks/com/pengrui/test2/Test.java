package com.pengrui.test2;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		MyObjectFactory m = new MyObjectFactory();
		Person o1 = (Person) m.getObject("com.pengrui.test2.Person");
		System.out.println(o1.toString());
		//System.out.println(Person.class);
		Dog d = (Dog) m.getObject("com.pengrui.test2.Dog");
//		String str = "Person";
//		Person o2 = (Person) m.getObject(str.getClass().getName());
//		System.out.println(o2.toString());
		System.out.println(d.toString());
//		System.out.println(d.owner.toString());
	}
}
