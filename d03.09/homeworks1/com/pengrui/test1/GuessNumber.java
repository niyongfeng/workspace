package com.pengrui.test1;

import java.util.Scanner;

public class GuessNumber {
	private int v = 100;
	Scanner sc = new Scanner(System.in);
	public GuessNumber() {
		
	}
	
	public void guessNumber() {
		while(true){
			System.out.println("请猜数字：");
			int x = sc.nextInt();
			if(x == v) {
				System.out.println("恭喜你猜对了！");
				break;
			}else if(x < v) {
				System.out.println("你猜的数字小了！");
			}else {
				System.out.println("你猜的数字大了！");
			}
		}
	}
	
	public static void main(String[] args) {
		GuessNumber g = new GuessNumber();
		g.guessNumber();
	}
}
