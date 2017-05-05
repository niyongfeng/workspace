package com.pengrui.worker;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestWorker {
	public static void main(String[] args) {
		List<Worker> l = new LinkedList<Worker>();
		l.add(new Worker("张三", 18, 3000));
		l.add(new Worker("李四", 25, 3500));
		l.add(new Worker("王五", 22, 3200));
		
		l.add(1, new Worker("赵六", 24, 3300));
		
		l.remove("王五");
		
		for(Worker worker : l) {
			System.out.println(worker.toString());
		}
		
		Iterator<Worker> it = l.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
