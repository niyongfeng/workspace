package com.pengrui.test2;

import java.lang.reflect.Field;

public class MyObjectFactory {
	
	public Object getObject(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class c = Class.forName(className);
		Object o = c.newInstance();
		Class<?> clazz = Object.class;
		Field[] f = c.getDeclaredFields();
		System.out.println(f.length+className);
		for(Field filed : f) {
			String str = filed.getType().getSimpleName();
			System.out.println(filed.getType().getName());
			filed.setAccessible(true);
			switch(str) {
			case "int" : filed.set(o, 1);break;
			case "byte" : filed.set(o, 1);break;
			case "short" : filed.set(o, 1);break;
			case "long" : filed.set(o, 1);break;
			case "double" : filed.set(o, 1.0);break;
			case "float" : filed.set(o, 1.0f);break;
			case "char" : filed.set(o, filed.getName() + " initial value");break;
			case "String" : filed.set(o, filed.getName() + " initial value");break;
			default : getObject(filed.getType().getName());break;
				//filed.set(o, null);break;
				//System.out.println(filed.getType().getName());
				//getObject(filed.getType().getClass().getName());break;
			}
		}
		
		return o;
	}
}
