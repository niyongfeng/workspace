package com.test;

public class Test6 {

	public static void main(String[] args) {
		// m(9);
		System.out.println(bunnyEars2(5));
	}

//	static void m(int i) {
//		if (i == 1) {
//			System.out.println("1*1=1 ");
//		} else {
//			m(i - 1);
//			for (int j = 1; j <= i; j++) {
//				System.out.print(j + "*" + i + "=" + j * i + " ");
//			}
//			System.out.println();
//		}
//	}
	static int bunnyEars2(int bunnies) {
		  if(bunnies == 0) return sum(0);
		  return bunnyEars2(bunnies - 1) + sum(bunnies);
		  
		}

		static int sum(int bunnies) {
		  if(bunnies == 0) {return 0;}
		  else if(bunnies % 2 == 1) {return 2;}
		  else {return 3;}
		}
}
