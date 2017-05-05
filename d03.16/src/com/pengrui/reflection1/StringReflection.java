package com.pengrui.reflection1;

import java.lang.reflect.Method;

public class StringReflection {
	public static void main(String[] args) throws ClassNotFoundException {
		Class str1 = String.class;
		Class str2 = new String().getClass();
		Class str3 = Class.forName("java.lang.String");
		
		System.out.println("String包名(方法1)：" + str1.getPackage().getName());
		System.out.println("String包名(方法2)：" + str2.getPackage().getName());
		System.out.println("String包名(方法3)：" + str3.getPackage().getName());
		
		System.out.println("String类名(方法1)：" + str1.getName());
		System.out.println("String类名(方法2)：" + str2.getName());
		System.out.println("String类名(方法3)：" + str3.getName());
		
		Method[] m1 = str1.getMethods();
		Method[] m2 = str2.getDeclaredMethods();
		System.out.println("获取String本类和父类的公有方法：");
		for(Method me : m1) {
			System.out.println(me.toString());
		}
		System.out.println("获取String本类的方法");
		for(Method me : m2) {
			System.out.println(me.toString());
		}
		
		
	}
}
