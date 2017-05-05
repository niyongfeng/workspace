package com.pengrui.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws ReflectiveOperationException {
		Test t = new Test();
		t.testArrayList();
	}
	
	public void testArrayList() throws ReflectiveOperationException {
		Class<?> c1 = new ArrayList<Object>().getClass();
		Class<?> c2 = Class.forName("java.util.ArrayList");
		Class c3 = ArrayList.class;
		Method[] methods = c3.getDeclaredMethods();
		System.out.println("ArrayList方法：");
		for(Method m : methods) {
			System.out.println(m.toString());
		}
		Field[] field = c1.getDeclaredFields();
		System.out.println("ArrayList属性：");
		for(Field f : field) {
			System.out.println(f.toString());
		}
		
	}
	
	public void testList() {
		
	}

}
