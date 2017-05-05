package com.pengrui.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListHomeWorks {
	
	public static void main(String[] args) {
		
		System.out.println("请输入集合元素：（当输入-1时结束输入）");
		Scanner sc = new Scanner(System.in);
		int s = 0;
		ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		while(true) {
			s = sc.nextInt();
			if(s == -1) {
				break;
			}else {
				l.add(s);
			}
		}
		System.out.println("请输入一整数n:");
		int n = sc.nextInt();
		if(n == 1) {
			System.out.println("没了！");
		}else {
			testDel(l, n);
			System.out.println(l.toString());
		}
		System.out.println("请输入集合元素：（当输入-1时结束输入）");
		while(true) {
			s = sc.nextInt();
			if(s == -1) {
				break;
			}else {
				l2.add(s);
			}
		}
		for(int a : testAd(l2)) {
			System.out.println(a);
		}
		
		sc.close();
		
		
		
	}
	
	public static void testDel(List<Integer> list, int n) {
		int i = 1;
		ArrayList<Integer> l = (ArrayList<Integer>) list;
		int x = n - 1;
		while(x <= l.size()) {
			l.remove(x);
			i++;
			x = (n - 1) * i;
		}
	}
	
	public static ArrayList<Integer> testAd(ArrayList<Integer> l) {
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(l.get(0));
		int index = 1;
		while(index < l.size()) {
			if(!(l2.contains(l.get(index)))) {
				l2.add(l.get(index));
			}
			index++;
		}
		return l2;

	}
}
