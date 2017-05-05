package com.qingke.test;

import java.io.IOException;
import java.util.Scanner;

public class Console {
	public static void main(String[] args) throws IOException {
		Test f = new Test();
		//f.help();
		//f.ls("","02");
		//f.ls("-all");
		//f.find("-name", "江");
		//f.find("-salary", 5000);
		//f.sort("-name");
		//f.sort("-salary");
		System.out.println("欢迎来到倪永烽的控制台！");
		Scanner sc = new Scanner(System.in);
		one : while(true) {
			int count = 0;
			String str = sc.nextLine();
			switch(str) {
			case "help" : f.help();count++;break;
			case "exit" : System.out.println("程序已退出！");;break one;
			case "ls -all" :f.ls("-all");count++;break;
			case "sort -name" : f.sort("-name");count++;break;
			case "sort -salary" : f.sort("-salary");count++;break;
			default:break;
			}
			if(str.length() >=3 && str.substring(0, 3).equals("ls ")) {
				if(str.length() >= 7 && str.substring(3, 7).equals("-all")) {
					if(str.length() >= 8) {
						int x = 0;
						str = str.substring(8);
						for(int i = 0; i < str.length(); i++) {
							if(!(Character.isDigit(str.charAt(i)))) {
								break;
							}
							x++;
						}
						if(x != 0 && x == str.length()) {
							f.ls("-all", str);
							count++;
						}
					}
				}else if(str.length() >= 4) {
					int x = 0;
					str = str.substring(3);
					for(int i = 0; i < str.length(); i++) {
						if(!(Character.isDigit(str.charAt(i)))) {
							break;
						}
						x++;
					}
					if(x != 0 && x == str.length()) {
						f.ls("",str);
						count++;
					}
				}
			}
			if(str.length() >= 12 && str.substring(0,11).equals("find -name ")) {
				f.find("-name", str.substring(11));
				count++;
			}else if(str.length() >= 14 && str.substring(0,13).equals("find -salary ")) {
				if(str.substring(13).contains("~")) {
					f.find1("-salary", str.substring(13));
					count++;
				}else {
					int x = 0;
					str = str.substring(13);
					for(int i = 0; i < str.length(); i++) {
						if(!(Character.isDigit(str.charAt(i)))) {
							break;
						}
						x++;
					}
					if(x != 0 && x == str.length()) {
						f.find("-salary", Integer.parseInt(str));
						count++;
					}
				}
			}
			if(count == 0) {
				System.out.println("指令有误！可通过help查看帮助");
			}
			
		}
		sc.close();
	}
}
