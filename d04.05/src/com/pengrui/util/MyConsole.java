package com.pengrui.util;

import java.util.Scanner;

public class MyConsole {
	public static void println(String str) {
		System.out.println(str);
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}

	private static Scanner scan = new Scanner(System.in);

	public static String askUserInput() {
		String input = null;
		//while (true) {
			System.out.print("cmd >");
			input = scan.nextLine();
			if (input.trim().equals("")) {
				//break;
				System.out.println("您输入的内容为空!");
			}
			
		//}
		return input;
	}

	public static int askUserInputInt() {

		int result = 0;
		//while (true) {
			String out = askUserInput();
			try {
				if(!out.equals("")) {
					result = Integer.parseInt(out);
				}
			} catch (Exception e) {
				//println("请输入一个合法的数字！");
			}
			//if (result != -1) {
				//break;
			//}
		//}

		return result;
	}
	
//	public static boolean askUserInputboolean() {
//		boolean input;
//		while (true) {
//			System.out.print("cmd >");
//			input = scan.nextBoolean();
//			if (input == false || input == true) {
//				break;
//			}
//			System.out.println("您输入的内容不合法,请重新输入！");
//		}
//		return input;
//	}
}
