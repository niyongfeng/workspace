package com.pengrui.test10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public List<String> list = new ArrayList<String>();
	
	public Test() {
		
	}
	
	public void reverseList(List<String> list) {
		String str = "";
		for(int i = 0; i < list.size() / 2; i++) {
			str = list.get(i);
			list.set(i, list.get(list.size() - i - 1));
			list.set(list.size() - i - 1, str);
		}
	}
	
	public void print() {
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.list.add("Hello");
		t.list.add("World");
		t.list.add("Learn");
		t.list.add("Thanks");
		t.print();
		t.reverseList(t.list);
		t.print();
		
	}
}
