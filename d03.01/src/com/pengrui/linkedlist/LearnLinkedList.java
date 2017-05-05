package com.pengrui.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LearnLinkedList {
	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new LinkedList<Integer>();
		
		for(int i = 0; i < 10000; i++) {
			list1.add(i);
			list2.add(i);
		}
		testRandomAccess(list1);
		testRandomAccess(list2);
		
		testInsert(list1);
		testInsert(list2);
	}
	
	public static void testRandomAccess(List<Integer> list) {
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 10000; i++) {
			Random r = new Random();
			int index = r.nextInt(10000);
			list.get(index);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(list.getClass().getName() + "查询的时间为：" + (end - start));
	}
	
	
	public static void testInsert(List<Integer> list) {
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 10000; i++) {
			Random r = new Random();
			int index = r.nextInt(10000);
			list.add(700, index);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(list.getClass().getName() + "插入的时间为：" + (end - start));
	
	}
}
