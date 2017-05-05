package com.pengrui.statistics;

import java.util.Scanner;

public class Statistics {

	public static void main(String[] args) {
		System.out.println("请输入需要统计的字符串：");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int x = 0;
		int y = 0;
		int z = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				x++;
			}
			if(str.charAt(i) >= 97 && str.charAt(i) <= 122) {
				y++;
			}
			if(str.charAt(i) >= 48 && str.charAt(i) <= 57) {
				z++;
			}
		}
		System.out.println("大写字母个数为：" + x);
		System.out.println("小写字母个数为：" + y);
		System.out.println("数字个数为：" + z);
		System.out.println("其他字符个数为：" + (str.length() - x - y - z));
		sc.close();

	}
}
