package com.pengrui.learnarraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearnArrayList {
	String a = "abc";
	int b = 0;
	public LearnArrayList(String a,int b) {
		this.a = a;
		this.b = b;
	}
	
	public LearnArrayList(int b, String a) {
		this.b = b;
		this.a = a;
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
	
		//1.增加
		list.add("第一");
		list.add("第二");
		list.add("第三");
		list.add("第四");
		list.add(4, "第五");
		
		//2.访问
		System.out.println("找第一个元素:" + list.get(0));
		System.out.println("找第二个元素:" + list.get(1));
		System.out.println("找第三个元素:" + list.get(2));
		System.out.println("找第四个元素:" + list.get(3));
		
		//3.删除
		list.remove(0);
		list.remove("第二");
		
		//4.替换
		list.set(0, "00");
		
		//5.遍历
		Iterator<String> l = list.iterator();
		while(l.hasNext()) {
			String s = l.next();
			System.out.println(s);
		}
		
		for(String s : list) {
			System.out.println(s);
		}
		
	
	
	}
	
}
