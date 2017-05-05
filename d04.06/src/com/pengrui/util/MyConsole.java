package com.pengrui.util;

import java.util.Scanner;

public class MyConsole {
	private static Scanner sc = new Scanner(System.in);

	public static String userInput() {
		String input = null;
		System.out.print("cmd > ");
		input = sc.nextLine();
		if ("".equals(input)) {
			System.out.println("输入的为空!");
		}
		return input;
	}

	public static int userInputInt() {
		int result = 0;
		String out = userInput();
		try {
			if (!"".equals(out)) {
				result = Integer.valueOf(out);
			}
		} catch (Exception e) {
			System.out.println("非法数字！");
		}
		return result;
	}
}
