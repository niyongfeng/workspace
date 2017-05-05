package com.keyword;

public class TestStatic {
	
	public static void main(String[] agres)  {
		
		Static test1 = new Static();
		System.out.println(test1.getAge1());
		System.out.println(test1.getAge2());
		
		Static test2 = new Static("nyf", 21);
		System.out.println(test1.getAge2());//静态变量age2存储在静态区域，因此当创建test2对象时，age2赋值了21，再次调用里一个对象test1时age2还是为21
		System.out.println(test1.getName());//name不是存储在静态区，而是存在堆内，所以name属性随对象的消亡而消亡
		
	}
	

}
