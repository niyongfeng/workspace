package com.pengrui.datastatistics;

import java.util.Arrays;

public class DataStatistics {

	public static void main(String[] args) {
		int[] num = new int[10000];
		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 100 + 1);
		}
//		for (int i = 0; i < num.length; i++) {
//			System.out.println(num[i]);
//		}
//		 gradeStatistics(num);
		String[] str = {"李小龙", "张无忌", "张三丰", "李元芳", "李白", "夏侯淳", "亚瑟"};
		nameStatistics(str, "李");
	}

	static void gradeStatistics(int[] num) {
		Arrays.sort(num);
//		int m = 0;
//		int n = 1;
//		for (int i = 0; i < 9999; i++) {
//			if (num[i] == num[i + 1]) {
//				m++;
//				if (i == 9998 && num[9998] == num[9999]) {
//					m++;
//					System.out.println(n + "出现的次数为：" + m);
//				}else if(i == 9998 && num[9998] != num[9999]) {
//					System.out.println(n + "出现的次数为：" + m);
//					System.out.println((n + 1) + "出现的次数为：" + 1);
//				}
//			} else {
//				System.out.println(n + "出现的次数为：" + m);
//				m = 0;
//				n++;
//			}		
//		}

		int m = 0;
		int n = 0;
		for(int i = 1; i <= 100; i++) {
			for(int j = m; j < num.length; j++) {
				if(i == num[j]) {
					m++;
					n++;
					if(j == num.length - 1) {
						System.out.println(i + "出现的次数为：" + n);
						break;
					}
				}else {
					System.out.println(i + "出现的次数为：" + n);
					n = 0;
					break;
				}
			}
		}
		
		
	}
	
	static void nameStatistics(String[] str, String strname) {
		
		int x = 0;
		for(int i = 0; i < str.length; i++) {
			if(str[i].startsWith(strname)) {
				x++;
			}
		}
		System.out.println(strname + "姓出现的次数为：" + x);
	}
	

}
