package com.qk.util;

import java.util.Scanner;

public class MyConsole {
	public static void println(String str) {
		System.out.println(str);
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}

	private static Scanner scan = new Scanner(System.in);

	public static String askUserInput(String test) {
		String input = null;
		while (true) {
			System.out.print(test + ">");
			input = scan.nextLine();
			if (!input.trim().equals("")) {
				break;
			}
			System.out.println("�����������Ϊ�գ����������룡");
		}
		return input;
	}

	public static int askUserInputInt(String test) {

		int result = -1;
		while (true) {
			String out = askUserInput(test);
			try {
				result = Integer.parseInt(out);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				println("������һ���Ϸ������֣�");
			}
			if (result != -1) {
				break;
			}
		}

		return result;
	}
}
