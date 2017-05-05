package com.pengrui.arrays;

public class LearnArrays {

	public static void main(String[] args) {
		//定义申明数组：数据类型[] 数组名称； 数据类型 数组名称[];
		int[] numbers1;
		int numbers2[];
		
		//数组的初始化
		//1)数据类型[] 数组名称 = {数据1，数据2，……，数据n}；
		int[] numbers3 = {1,2,3,4,5};
		
		//2)数据类型[] 数组名称 = new 数据类型[数组长度]；
		String[] numbers4 = new String[20];
		
		//3)数据类型[] 数组名称 = new 数据类型[]{数据1，数据2，……，数据n}；
		int[] numbers5 = new int[]{1,2,3,4,5,6};
		
		//输出的为数组类型；数组的地址
		System.out.println(numbers4);//[Ljava.lang.String;@677327b6  
		
	    //给数组赋值
		for(int i = 0; i < numbers3.length; i++) {
			numbers3[i] = i * i;
		}
		
		//数组的输出
		//1)for循环  2)for each 
	}
}
