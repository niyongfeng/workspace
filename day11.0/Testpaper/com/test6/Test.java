package com.test6;

public class Test {

	public static void main(String[] args) {
		BaseTeacher baseteacher = new BaseTeacher();
		System.out.println(baseteacher.toString());
		baseteacher.setName("niyongfeng");
		System.out.println(baseteacher.toString());
		
		BaseTeacher baseteacher1 = new BaseTeacher("nyf", 24, true, 9000);
		System.out.println(baseteacher1.toString());
	}
}
