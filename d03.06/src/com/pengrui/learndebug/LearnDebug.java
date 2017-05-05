package com.pengrui.learndebug;

public class LearnDebug {
	public static void main(String[] args) {
		String str = "";
		for(int i = 0; i < 100; i++) {
			if(i % 15 == 0) {
				str = "aaaaa";
			}else if(i % 5 == 0) {
				str = "bbbbb";
			}else if(i % 3 == 0) {
				str = "ccccc";
			}else {
				str = "ddddd";
			}
		}
	}
}
