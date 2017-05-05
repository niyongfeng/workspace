package com.test4;

import java.util.Scanner;

public class Test22 {

	public static void main(String[] args) {
		
		System.out.println("请输入你要反转的字符串： ");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println("反转后的字符串为：");
		for(int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(str.length() - i - 1));
		}
		sc.close();
	} 
}
