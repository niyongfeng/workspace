package com.pengrui.LearnHashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LearnHashSet {
	public static void main(String[] args) {
//		Set<Integer> set = new HashSet<Integer>();
//		for(int i = 0; i < 100; i++) {
//			set.add(i);
//		}
//		for(int j = 0; j < 100; j++) {
//			set.add(j);
//		}
//		set.add(-10);
//		set.add(-5);
//		Iterator<Integer> i = set.iterator();
//		Set<String> set = new HashSet<String>();
		Set<Dog> set = new HashSet<Dog>();
		Dog d1 = new Dog("abc", "abc", 1);
		Dog d2 = new Dog("abc", "abc", 1);
		set.add(d1);
		set.add(d2);
//		set.add("abc");
//		set.add("bcd");
//		set.add("cde");
//		set.add("efg");
//		Iterator<String> i = set.iterator();
		Iterator<Dog> i = set.iterator();
		while(i.hasNext()) {
//			System.out.println(i.next() + "_" + i.hashCode());
			System.out.println(i.next().toString());
		}
	} 
}
