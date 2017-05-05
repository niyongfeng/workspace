package com.pengrui.LearnHashSet;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LearnSet {
	public static void main(String[] args) {
//      HashSet存储
//		Set<Dog> set = new HashSet<Dog>();
//		TreeSet存储方法1.实现Comparable借口，重写compareTo()方法
//		Set<Dog> set = new TreeSet<Dog>();
//		TreeSet存储方法2.写一个比较类实现Comparator<?>借口，重写compare()方法
		Set<Dog> set = new TreeSet<Dog>(new AgeComparator());

		set.add(new Dog("dog2", "nyf", 1));
		set.add(new Dog("dog1", "nyf", 2));
		set.add(new Dog("dog1", "nyf", 2));
		set.add(new Dog("dog3", "nyf", 5));
		set.add(new Dog("dog4", "nyf", 3));
		
		
		Iterator<Dog> d = set.iterator();
		while(d.hasNext()) {
			System.out.println(d.next().toString());
		}
	}

}

class AgeComparator implements Comparator<Dog>{

	public int compare(Dog o1, Dog o2) {
		if(o1.age == o2.age) return 0;
		if(o1.age < o2.age) return -1;
		return 1;
	}

}



