package com.pengrui.reflection1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Dog {
	private String name;
	private int age;
	
	public Dog() {
		
	}
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@SuppressWarnings("unused")
	private void setAge(int age) {
		this.age = age;
	}
	
	public void bark() {
		System.out.println("汪汪");
	}
	
	public static void getClassFullName(Dog d) {
		System.out.println("1.获取包名和类名");
		@SuppressWarnings("unchecked")
		Class<Dog> c = (Class<Dog>)d.getClass();
		System.out.println("类名：" + c.getName());
		System.out.println("包名：" + c.getPackage().getName());
		System.out.println(c.getSimpleName());
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void getClassName() {
		System.out.println("1.获取包名的第二种方法");
		String className = "com.pengrui.reflection1.Dog";
		try {
			Class c = Class.forName(className);
			System.out.println(c.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void getClassInfo() {
		System.out.println("获取本类和父类公有方法:");
		Class d = Dog.class;
		Method[] m = d.getMethods();
		for(Method me : m) {
			System.out.println(me.getName());
		}
		System.out.println("获取本类方法：");
		Class dog = new Dog().getClass();
		Method[] method = dog.getDeclaredMethods();
		for(Method me : method) {
			System.out.println(me.toString());
		}
		
	}
	
	public static void getObjectInstance() {
		
		Class<Dog> dogClazz = Dog.class;
		
		try {
			//方法一：通过无参构造函数进行反射创建实例
			Object dog1 = dogClazz.newInstance();
			Dog d = (Dog) dog1;
			System.out.println("创建的对象是：" + d.name);
			
			//方法二：通过找有参构造函数反射创建实例
			@SuppressWarnings("rawtypes")
			Constructor c = dogClazz.getConstructor(new Class[]{String.class, int.class});
			Dog dog2 = (Dog) c.newInstance(new Object[]{"大黄", 5});
			System.out.println("创建的对象是：" + dog2.name);
			
			//调用方法
			Method m = dogClazz.getMethod("bark", new Class[]{});
			Constructor c1 = dogClazz.getConstructor(new Class[]{String.class, int.class});
			Object dog3 = c.newInstance(new Object[]{"大黄", 5});
			m.invoke(dog3, new Object[]{});
			
			//调用属性
			Field f = dogClazz.getDeclaredField("name");
			f.set(dog3, "123");
			f.setAccessible(true);
			System.out.println(f.get(dog3));
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
