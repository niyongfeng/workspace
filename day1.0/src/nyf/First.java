package nyf;

import java.util.Scanner;

//输入输出语句的用法
//首先要创建一个Scanner的对象： Scanner sc = new Scanner(System.in);
//                         String 变量名 = sc.next()；
//if语句的用法
//1、if() {}
//2、if() {}else {}
//3、if() {}else if() {}else {}

public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("haole");
		int x,y,z;
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		z = sc.nextInt();
		
		if(x > y) {			
			if(x > z) {				
				System.out.println(x);
			}else {
				 System.out.println(z);
			}
		}else {
			if(y > z) {
				System.out.println(y);
			}else {
				System.out.println(z);
			}
		}
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(sum(a,b));
		sc.close();
		//System.out.println(x+" "+y);
		
	}
	
	public static int sum(int a, int b) {
		return a + b;
	}
	

}
