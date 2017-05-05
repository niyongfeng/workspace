package com.pengrui.worker;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
	public static void main(String[] args) {
		Set<Worker> set = new TreeSet<Worker>(new AgeComparator());
		set.add(new Worker("张三", 18, 1500));
		set.add(new Worker("李四", 18, 1500));
		set.add(new Worker("王五", 18, 1600));
		set.add(new Worker("赵六", 17, 2000));
		
		for(Worker worker : set) {
			System.out.println(worker.toString());
		}
	}
}

class AgeComparator implements Comparator<Worker> {

	public int compare(Worker o1, Worker o2) {
		if(o1.age == o2.age) {
			if(o1.salary == o2.salary) {
				return o1.name.compareTo(o2.name) * (-1);
			}else if(o1.salary < o2.salary) {
				return -1;
			}else {
				return 1;
			}
		}else if(o1.age < o2.age){
			return -1;
		}else {
			return 1;
		}
	}
	
}
