package com.pengrui.stringtest;

public class Test {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);// s1 和 s2都存在常量池中， == 需要比较地址和值，因此两个相等，输出为true
		System.out.println(s1.equals(s2));//equals比较的是值，所以输出为true
		
		String s3 = new String("abc");//创建了两个对象，“abc”先在常量池中创建了， new String() 在堆中创建了对象s3并赋值为abc，s3指向堆
		
		String s4 = new String("abc");
		String s5 = "abc";
		System.out.println(s4 == s5);//s4指向堆中的abc，而s5指向常量池中的abc，因此两者地址不同，输出false
		System.out.println(s4.equals(s5));//equals比较的是值，所以输出为true；
		
		String s6 = "a" + "b" + "c";//先创建a,再创建ab，再创建abc，s6指向abc，多余的清除
		String s7 = "abc";
		System.out.println(s6 == s7);//都指向常量池中abc，所以输出为true
		System.out.println(s6.equals(s7));//equals比较的是值，所以输出为true
		
		String s8 = "ab" + "c";
		String s9 = "abcc";
		String s10 = s8 + "c";//会在堆中创建一个对象s10，值为abcc
		System.out.println(s9 == s10);//地址不同输出为false
		System.out.println(s9.equals(s10));//equals比较的是值，所以输出为true
	}

}
