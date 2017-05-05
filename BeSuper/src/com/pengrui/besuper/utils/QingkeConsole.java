package com.pengrui.besuper.utils;

import java.util.Scanner;

public class QingkeConsole {
	public static void println(String msg) {
		System.out.println(msg);
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}

	private static Scanner sc = new Scanner(System.in);

	public static String askUserInput(String msg) {
		System.out.print(msg + "> ");
		String input = null;
		while (true) {
			input = sc.nextLine();
			if (input != null && input.trim().length() > 0) {
				break;
			}

			System.out.println("please enter a non-empty string!");
		}

		return input;
	}

	public static int askUserInputInt(String msg) {
		int inputInt = -1;
		while (true) {
			String input = askUserInput(msg);
			try {
				inputInt = Integer.valueOf(input);
				break;
			} catch (NumberFormatException e) {
				System.out.println("please enter a number value!");
			}
		}
		return inputInt;
	}
	
	public static void terminate() {
		System.out.println("bye-bye");
		System.exit(0);
	}
}
