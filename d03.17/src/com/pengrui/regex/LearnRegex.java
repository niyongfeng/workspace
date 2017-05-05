package com.pengrui.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnRegex {

	public boolean test(String str) {
		Pattern p = Pattern.compile("0\\d{2,3}-\\d{7,8}");
		Matcher matcher = p.matcher(str);
		System.out.println(str + " : " + matcher.matches());
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		LearnRegex l = new LearnRegex();
		String[] str = new String[]{"1233", "123-3545345","0123-12345678"};
		for(String s : str) {
			l.test(s);
		}
	}
}
