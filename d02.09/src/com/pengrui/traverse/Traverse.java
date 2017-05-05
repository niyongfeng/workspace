package com.pengrui.traverse;

import java.util.Scanner;

public class Traverse {

	public static void main(String[] args) {
		System.out.println("请输入需要遍历的字符串：");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for(int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		sc.close();
	}
}
