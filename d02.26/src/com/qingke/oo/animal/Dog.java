package com.qingke.oo.animal;

import java.util.Date;

public class Dog {
	
	//静态变量
	public static final String typeDescription = "狗是一种哺乳动物，它有。。。。";
	
	public String name;
	public Date birthday;
	public String owner;
	
	//静态方法
	public static int totalDogNumber() {
		
		Dog d = new Dog();
		System.out.println(d.name);
		d.name = "大黑";
		d.name = "小白";
				
		return 123;
	}
	
	

}
