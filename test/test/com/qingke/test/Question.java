package com.qingke.test;

import java.util.Scanner;

/**
 * 
 * @author niyongfeng
 * 1.对于String对象，可以使 “=”赋值，也可以使new关键字赋值，两种方式有什么区别?
 * 答：“=”赋值时，如果常量池中有这个值，直接引用，没有则创建一个对象，而new关键字赋值是创建String的对象，然后创建一个字符串；
 * 2.String类和StringBuffer类有什么区别？
 * 答：String是个不可变的字符序列，StringBuffer是线程安全的，效率低，可变的字符序列；
 * 3.for循环中的break语句和continue语句的使用。
 * break是终止循环，而continue是继续执行；
 * 4.使用代码，创建一个长度为5的String型数组，并使用增强for循环迭代数组打印出数组中的元素。
 * String[] str = new String[5];
 * for(int i = 0; i < 5; i++) {
 * 		str[i] = i + "" + i;
 * }
 * for(String s : str) {
 * 		System.out.println(s);
 * }
 * 5.说明Arrays类的作用,并举例
 * 数组的工具类，包含了对数组操作的各种方法，Arrays.sort()可对数组进行排序；
 * 6.Overload和 Override的区别。Overloaded的方法是否可以改变返回值的类型?
 * Overload是重载，是在本类中，方法参数类型、参数个数不同，方法名相同，与返回值类型无关的方法；
 * Override是重写，是在继承关系中，子类对父类的方法进行重写，返回值类型、方法名、参数个数、参数类型均相同，方法体不同，修饰符可不同，但重写的修饰范围一定要大于父类的；
 * 可以改变，重载与返回值类型无关；
 * 7.定义类A和类B 如下:
 * class A {
     int a=11;
     double d=2.0;
     void display(){
         System.out.println("Class A: a="+a +"\td="+d);
     }
 	}
 	class B extends A{
     float a=3.0f;
     String d="Java program.";
     void display(){
         super.display();
         System.out.println("Class B: a="+a +"\td="+d);
     }
	}
	 问:
	(1) 若在应用程序的main方法中有以下语句:
		A a=new A();
		a.display();
		则输出的结果如何?
		Class A: a= 11 d = 2.0
	(2) 若在应 程序的main方法中定义类B的对象b: 
		A b=new B();
		b.display();
		则输出的结果如何?
		Class A: a= 11 d = 2.0
		Class B: a= 3.0f d= java program
		
 * 8.请说明什么是抽象类?抽象类有什么作用?
 * 用abstract修饰的类，而且不能实例化，抽象类中可以定义一个或者多个抽象方法，非抽象类子类须重写这些抽象方法
 * 9.final类与final方法有什么作用?
 * final修饰的类不能被继承；
 * final修饰的方法不能被重写；
 * 10.Object类中的equals方法和hashCode方法。
 * equals方法相当于“==”,比较的是对象，hashCode方法是他的内部方法，计算的是他的对象的哈希吗值
 * 11.throws关键字和throw关键字有什么区别和联系?
 * throws写在方法名后面，声明异常但是不处理异常，格式：修饰符 返回值类型 方法名（参数类型 参数名...）throws 异常类名 {}
 * throw写在方法体里面，抛出异常，格式： try{} catch { throw new 异常类名（）;}
 * 12.List和Set集合有什么区别?
 * List集合是有序的（存和取的顺序一致），有索引可存储重复元素；
 * Set集合是无序的（存和取的顺序不一致），无索引不可存储重复元素；
 * 13.Collection 和Collections有什么区别?
 * Collection是集合的接口，Set和List继承了Collection这个接口；
 * Collections是集合的工具类，里面包含了对集合操作的各种方法；
 * 14.java中多态是什么?
 * 多态是指事物有多种表现形式，在Java中多态的体现有：方法的重载和重写，继承，父类引用指向子类的对象
 * 15.请举Java语言中的八种基本数据类型，并说明每种数据类型的含义及长度。
 * 整型：byte 8位1字节；short（短整型） 16位2字节；int 32位4字节；long（长整型） 64位8字节  整型的默认值为0
 * 浮点型：float（单精度） 32位4字节；double（双精度） 64位8字节 浮点型的默认值为0.0
 * 布尔型（boolean）：false 假 ; true 真  布尔型的默认值为false
 * 字符型：char 默认值为\u0000
 * 16.面向对象的特征有哪些?并解释特征。
 * 继承：子类从父类派生而来，这种关系为继承
 * 多态：重载和重写，继承，父类引用指向子类的对象
 * 封装：将某些属性和方法隐藏起来，不为其他对象使用
 * 抽象：取出各对象共有的特征，而舍弃不共有的，从而创生出来的类
 * 17.作用域public,private,protected,以及不写时的区别?
 *               本类     同包    子类    不同包
 * public        可以     可以    可以     可以
 * protected     可以     可以    可以     不可以
 * (默认的)       可以     可以    不可以    不可以
 * private       可以     不可以  不可以    不可以
 * 18.写一个程序, 要求功能:求出 1，2，5这三个数不同个数组合的和为100的组合个数。如:100个1是一个组合，5个1加19个5是一个组合。。。。 请用JAVA语言写。
 * 		int count = 0;
		for(int x = 0; x <= 20; x++) {
			for(int y = 0; y <= 50; y++) {
				if((5 * x + 2 * y) <= 100) {
					count++;
				}
			}
		}
		System.out.println(count);
 * 19.说明try/catch/finally语句块的作用。
 * try:可能会出现异常的操作
 * catch：捕获和处理异常
 * finally：最终的清理工作，不管是否抛出异常，finally的代码都会被执行到
 * 20.返回值是多少?“beijing”.equalsIgnoreCase(new String(“beijing”))
 * true
 * 
 */

public class Question {
	public static void main(String[] args) {
		String b = "abc";
		String c = new String("abc");
		//System.out.println(c.equals(b));
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(str);
	}
	
}

