package com.pengrui.object;

import java.util.HashSet;
import java.util.Set;

public class Test{
	public static void main(String[] args) {
		Dog d1 = new Dog("旺财", 50);
		System.out.println(d1.toString());
		Dog d2 = new Dog("旺财", 50);
		Dog d3 = new Dog("旺财", 40);
		//Collections容器包里面的1个借口和实现类
		Set set = new HashSet();
		set.add(d1);
		System.out.println(d1.hashCode());
		System.out.println(d2.hashCode());
		System.out.println(d3.hashCode());
		System.out.println(set.contains(d2));
		System.out.println(set.contains(d3));
		String str = "旺财";
		System.out.println(str.hashCode());
		Person p = new Person("sd", 12, d1);
		Person p2 = (Person)p.clone();
	}
	
}
