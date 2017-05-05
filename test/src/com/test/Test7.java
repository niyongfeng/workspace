package com.test;

public class Test7 {

	public static void main(String[] args) {
		stringClean("Hello Bookkeeper");
	}
	static String stringClean(String str) {

		if (str.length() < 2) {
			return str;
		} else {
			int x = str.substring(1).indexOf(str.charAt(0));
			if (x >= 0) {
				//System.out.println(str.substring(0, x + 1) + str.substring(x + 2));
				return stringClean(str.substring(0, x + 1) + str.substring(x + 2));
			} else {
				System.out.println(str.charAt(0));
				return str.charAt(0) + stringClean(str.substring(1));
			}
		}
	}
}
