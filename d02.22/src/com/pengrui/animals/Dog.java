package com.pengrui.animals;

public class Dog {
	//实例常量和实例变量,当数据类型前面加static修饰时，此时为类变量/类常量，调用时直接类名.变量名；
	private String firstName;
	private String lastName;
	private int age;
	private String kind;
	//无参构造函数
	public Dog() {
		super();
	}
	//有参构造函数
	public Dog(String firstName, String lastName, int age, String kind) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.kind = kind;
	}
	//静态只能调用静态，静态方法需要调用非静态变量时，可以创建对象，通过对象进行调用变量
	//getName()会报错,getName1()正确
	/*
	public static String getName() {
		return firstName + lastName;
	}
	*/
	public static String getName1() {
		Dog d = new Dog();
		return d.firstName + d.lastName;
	}
	public String getName() {
		return firstName + lastName;
	}
	
	//方法
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String toString() {
		return "name: " + getName() + ", age: " + age + ", kind: " + kind;
	}
	
}
