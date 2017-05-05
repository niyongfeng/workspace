package com.pengrui.transform;

import java.util.Scanner;

public class Transform {

	public static void main(String[] args) {
		
		System.out.println("请输入你要转换的字符串:");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
		System.out.println(str);
		sc.close();
	}
}
