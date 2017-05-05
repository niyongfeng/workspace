package com.pengrui.student;

import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws IOException {
		StudentManage stu = new StudentManage();
//		StudentInformation s1 = new StudentInformation("zhangsan", 70, 60, 70);
//		StudentInformation s2 = new StudentInformation("lisi", 70, 66, 75);
//		StudentInformation s3 = new StudentInformation("wangwu", 50, 60, 70);
//		StudentInformation s4 = new StudentInformation("xiaoqi", 70, 60, 70);
//		StudentInformation s5 = new StudentInformation("qinshou", 80, 70, 90);
//		StudentInformation s6 = new StudentInformation("zhangfei", 70, 50, 80);
//		stu.entering(s1);
//		stu.entering(s2);
//		stu.entering(s3); 
//		stu.entering(s4);
//		stu.entering(s5);
//		stu.entering(s6);
		Scanner sc = new Scanner(System.in);
		String str = "";
		while(true) {
			System.out.println("请输入学生信息：(姓名，数学成绩，英语成绩，语文成绩)");
			str = sc.next();
			String name = str.substring(0, str.indexOf(','));
			str = str.substring(str.indexOf(',') + 1);
			int math = Integer.parseInt(str.substring(0, str.indexOf(',')));
			str = str.substring(str.indexOf(',') + 1);
			int english = Integer.parseInt(str.substring(0, str.indexOf(',')));
			int chinese = Integer.parseInt(str.substring(str.indexOf(',') + 1));

			StudentInformation s = new StudentInformation(name, math, english, chinese);
			stu.entering(s);
			System.out.println("是否继续：（y/n）");
			if(sc.next().equals("n")) {
				break;
			}
		}
		stu.print();
		sc.close();
	}
}
