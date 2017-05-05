package com.pengrui.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lambda2 {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person("张三", "物理", 88));
		list.add(new Person("李四", "化学", 90));
		list.add(new Person("王五", "生物", 60));
		list.add(new Person("马六", "语文", 75));
		list.add(new Person("嘻嘻", "英语", 80));
		
		list.forEach((Person p) -> System.out.println(p.getName()));
		list.forEach((Person p) -> System.out.println(p.getName() + ":" + p.getScore()));
		list.forEach((Person p) -> System.out.println(p.getName() + ":" + p.getDepartment()));
		System.out.println("=============");
		print(list,(Person p) -> p.getDepartment().equals("化学"));
		System.out.println("=============");
		print(list,(Person p) -> p.getScore() < 80);
		System.out.println("=============");
		print(list,(Person p) -> p.getName().startsWith("王"));
		System.out.println("=============");
		Fuck fuck = () -> {return "sister";};
		learn(list, fuck);
	}
	
	public static void print(List<Person> list, Predicate<Person> predicate) {
		for(Person p : list) {
			if(predicate.test(p)) System.out.println(p.getName());
		}
	}
	
	public static void learn(List<Person> list, Fuck fuck) {
		for(Person p : list) {
			if(p.getName().startsWith("王")) {
				System.out.println("隔壁老王 ！fuck your " + fuck.fuck() + "!");
			}
		}
	}
}
