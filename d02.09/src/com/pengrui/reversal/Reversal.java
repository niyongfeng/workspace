package com.pengrui.reversal;

import java.util.Scanner;

public class Reversal {
	public static void main(String[] args) {
		System.out.println("请输入需要反转的字符串:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String str1 = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
			str1 = str1 + str.charAt(i);
		}
		System.out.println(" ");
		System.out.println(str1);
		//StringBuffer
		StringBuffer sb = new StringBuffer();
		for(int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		System.out.println(sb.toString());
		
		//StringBuilder
		StringBuilder sb1 = new StringBuilder();
		for(int i = str.length() - 1; i >= 0; i--) {
			sb1.append(str.charAt(i));
		}
		System.out.println(sb1.toString());
		sc.close();
	}

}
