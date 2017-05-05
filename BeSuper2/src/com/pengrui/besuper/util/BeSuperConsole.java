package com.pengrui.besuper.util;

import java.util.Scanner;

public class BeSuperConsole {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void println(String str) {
		System.out.println(str);
	}
	
	public static void println(Object obj) {
		System.out.println(obj);
	}
	
	public static String askUserInput() {
		String input = null;
		while(true) {
			System.out.print("cmd> ");
			input = sc.nextLine();
			if("".equals(input)) {
				System.out.println("您的输入为空，请重新输入！");
			} else {
				break;
			}
		}
		
		return input;
	}
	
	public static int askUserInputInt() {
		int result = -1;
		
		while(true) {
			String out = askUserInput();
			try {
			result = Integer.valueOf(out);
			} catch (Exception e) {
				System.out.println("请输入纯数字!");
			}
			if(result != -1) {
				break;
			}
		}
		
		return result;
	}
}
