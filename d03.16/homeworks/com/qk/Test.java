package com.qk;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		Person p = new Person();
		Class p1 = Person.class;
		System.out.println("创建的对象是(方法1):" + p1.getName());
		Class p2 = p.getClass();
		System.out.println("创建的对象是(方法2):" + p2.getName());	
		try {
			Class p3 = Class.forName("com.qk.Person");
			System.out.println("创建的对象是(方法3):" + p3.getName());
			Object o1 = p1.newInstance();
			getGetMethod(p1, o1);
			getSetMethod(p1, o1);
			fieldChange(p1, o1);
			Class p4 = Class.forName("com.qk.Chinese");
			getClassFullMethod(p4);
			getClassMethod(p4);
			getSuperClassMethod(p4);
			getClassInterface(p4);
			relectPerson("com.qk.Person", "nyf1", 20);
			relectPerson("com.qk.Chinese", "nyf2", 21);
			relectPerson("com.qk.Japanese", "nyf3", 22);
			relectPerson("com.qk.dhd", "nyf4", 23);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void getGetMethod(Class p1, Object o1) {
		System.out.println("=============================================");
		try {
			Method m1 = p1.getMethod("getName", new Class[]{});
			Method m2 = p1.getMethod("getAge", new Class[]{});
			System.out.println("getName():" + m1.invoke(o1, new Object[]{}));
			System.out.println("getAge():" + m2.invoke(o1, new Object[]{}));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void getSetMethod(Class p1, Object o1) {
		System.out.println("=============================================");
		try {
			Method m3 = p1.getMethod("setName", new Class[]{String.class});
			Method m4 = p1.getMethod("setAge", new Class[]{int.class});
			m3.invoke(o1, new Object[]{"lll"});
			m4.invoke(o1, new Object[]{28});
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void fieldChange(Class p1, Object o1) {
		try {
			Field f1 = p1.getDeclaredField("name");
			Field f2 = p1.getDeclaredField("age");
			f1.setAccessible(true);
			f2.setAccessible(true);
			System.out.println("setName()后的name:" + f1.get(o1));
			System.out.println("setAge()后的age:" + f2.get(o1));
			f1.set(o1, "ppp");
			f2.set(o1, 22);
			System.out.println("=============================================");
			System.out.println("更改后的name:" + f1.get(o1));
			System.out.println("更改后的age:" + f2.get(o1));
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void getClassFullMethod(Class p1) {
		System.out.println("=============================================");
		Method[] method1 = p1.getDeclaredMethods();
		System.out.println("获取Chinese的所有自定义方法");
		for(Method m : method1) {
			System.out.println(m.toString());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void getClassMethod(Class p1) {
		System.out.println("=============================================");
		System.out.println("获取Chinese的所有公开方法");
		Method[] method2 = p1.getMethods();
		for(Method m : method2) {
			System.out.println(m.toString());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void getSuperClassMethod(Class p1) {
		System.out.println("=============================================");
		System.out.println("获取Chinese的父类信息");
		Method[] method3 = p1.getSuperclass().getDeclaredMethods();
		for(Method m : method3) {
			System.out.println(m.toString());
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void getClassInterface(Class p1) {
		System.out.println("=============================================");
		System.out.println("获取Chinese的接口信息");
		Class[] inf = p1.getInterfaces();
		for(Class i : inf) {
			System.out.println(i.getName());
		}
		
		for(Class c : inf) {
			for(Method m : c.getMethods()) {
				System.out.println(m.toString());
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void relectPerson(String className, String name, int age) {
		try {
			Class c = Class.forName(className);
			Constructor con = c.getConstructor(new Class[]{String.class,int.class});
			Object o = con.newInstance(new Object[]{name,age});
			Class[] inf = c.getInterfaces();
			int i = 0;
			boolean b = false;
			while(i < inf.length) {
				if(inf[i].getSimpleName().equals("Fightable")) {
					b= true;
					break;
				}
				i++;
			}
			if(b == true) {
				System.out.println("true");
				Method method = c.getMethod("fight", new Class[]{});
				method.invoke(o, new Object[]{});
			}else {
				System.out.println("false");
			}
			
			Method[] methods = c.getMethods();
			int count1 = 0;
			int count2 = 0;
			for(Method m : methods) {
				if(m.getName().equals("pingpang(")) {
					m.invoke(o, new Object[]{});
					count1++;
					break;
				}
				if(m.getName().equals("eatSusi")) {
					m.invoke(o, new Object[]{});
					count2++;
					break;
				}
			}
			if(count1 == 0) {
				System.out.println("没有pingpang()");
			}
			if(count2 == 0) {
				System.out.println("没有eatSusi()");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到对应的类！");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

	
