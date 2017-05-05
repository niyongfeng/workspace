package com.pengrui.statistics;

import java.util.Scanner;

public class StatisticsString {
	
	public static void main(String[] args) {
		System.out.println("请输入要被统计的字符串：");
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		System.out.println("请输入要统计的关键字符串:");
		String str2 = sc.nextLine();
		int x = 0;
		for(int i = 0; i <= str1.length() - str2.length(); i++) {
			if(str1.substring(i, i + str2.length()).equals(str2)) {
				x++;
				i = i + str2.length() - 1;
			}
		}
		System.out.println("出现关键字符串的次数为：" + x);
		sc.close();
	}

}
