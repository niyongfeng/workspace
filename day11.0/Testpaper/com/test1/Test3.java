package com.test1;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		String[] a = {"","星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
		System.out.println("请输入索引：（1代表的是星期一）");
		 Scanner sc = new Scanner(System.in);
		 int x;
		 while(true) {
			 x =sc.nextInt();
			 if(x > 0 && x < 8) {
				 break;
			 }else {
				 System.out.println("您的输入有误，请重新输入：");
			 }
			 
			 
		 }
		 System.out.println(a[x]);
		 sc.close();
	}

}
