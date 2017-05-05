package com.test1;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		int[] a = {4,5,9,8,7,2,1,9,0,3,4,5,7,8,2,3,4,8,7,4,3};
	    int x = a.length;
	    int i;
	    System.out.println("请输入你要查找的元素：");
	    Scanner sc = new Scanner(System.in);
	    int y = sc.nextInt();
	    for(i = 0; i < x; i++) {
	    	if(y == a[i]) {
	    		System.out.println("找到第一个对应元素的索引为：" + i);
	    		break;
	    	}
	    	if((i == x - 1) && !(y == a[i])){
	    		System.out.println("没有找到指定元素");
	    		break;
	    	}
	    }
//	    if(a[i] == y) {
//	    	System.out.println("找到第一个对应元素的索引为：" + i);
//	    }else {
//	    	System.out.println("没有找到指定元素");
//	    }
	    sc.close();
	}
}
