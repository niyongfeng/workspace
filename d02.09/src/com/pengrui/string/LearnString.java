package com.pengrui.string;

import java.util.Arrays;

public class LearnString {
	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "Wold";
		char[] str3 = new char[9];
		
		System.out.println(str1.isEmpty());
		System.out.println(str2.codePointCount(0, 2));
		str1.getChars(0, 5, str3, 0);
		System.out.println(str3);
		
		String a = "abcde";
		String b = a.replace("ab", "f");
		System.out.println(b);
		String c = a.charAt(2) + "";
		
		//Arrays.sort进行排序
		String[] name = new String[]{"atm", "sada", "asdas", "asf", "fsafs"};
		Arrays.sort(name);
		for(String names : name) {
			System.out.println(names);
		}
		
		
		
		long startTime, endTime;
		//StringBuffer是线程安全
		StringBuffer sb = new StringBuffer('0');
		startTime = System.currentTimeMillis();
		for(int i = 1; i < 10000; i++) {
			sb.append(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println(sb.toString());
		System.out.println("StringBuffer的append使用了：" + (endTime - startTime));
		
		//StringBulider不是线程安全
		StringBuilder sbuider = new StringBuilder('0');
		startTime = System.currentTimeMillis();
		for(int i = 1; i< 10000; i++) {
			sbuider.append(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder的append使用了：" + (endTime - startTime));

	}

}
