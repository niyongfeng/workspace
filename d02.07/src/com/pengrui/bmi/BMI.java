package com.pengrui.bmi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		System.out.println("欢迎来到BMI计算");
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.println("请输入您的身高（M）");
		double shengao = sc.nextDouble();
		System.out.println("请输入您的体重（KG）");
		double tizhong = sc.nextDouble();
		/*
		 * 利用强制类型转换，保留小数点后两位
		 */
//		double x = tizhong / (shengao * shengao) * 100;
//		int m = (int) (x);
//		double n = m;
//		n = n / 100;
//		System.out.println(n);
		
		/*
		 * 利用DecimalFormat类规定变量格式
		 */
		double n = tizhong / (shengao * shengao);
		DecimalFormat df = new DecimalFormat("#.00");
		n = Double.parseDouble(df.format(n));
		System.out.println(n);
		if(n < 18.5) {
			System.out.println("您偏瘦，需要多吃点！");
		}else if(n >= 18.5 && n < 24) {
			System.out.println("您很完美，继续保持！");
		}else if(n >= 24 && n < 28) {
			System.out.println("您偏胖，需要多运动！");
		}else if(n >= 28 && n < 30) {
			System.out.println("您有点肥胖，需要少吃多运动！");
		}else {
			System.out.println("您严重肥胖，请下决心减肥吧！");
		}
		System.out.println("是否需要继续计算：（Y/N）or（y/n）?");
		String gg;
		while(true){
			gg = sc.next();
			if(gg.equals("N") || gg.equals("n") || gg.equals("Y") || gg.equals("y")) break;
			System.out.println("请重新输入（Y/N）or（y/n）?");
		}
		if(gg.equals("N") || gg.equals("n")) {
			break;
		}else if(gg.equals("Y") || gg.equals("y")) {
			continue;
		}
		
		}
		sc.close();
	}
}
