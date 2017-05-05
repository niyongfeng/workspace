package com.pengrui.array2dtest;

public class ArrayTest {

	public static void main(String[] args) {
		String[][] names = {{"Tom", "Mike", "Jike"}, {"Nyf", "Qyt", "Tom"}, {"Zyf", "Zsf", "Hhc"}};
		int x = 0;
		for(int i = 0; i < names.length; i++) {
			for(int j =0; j < names[0].length; j++) {
				if(names[i][j].equals("Tom")) {
					System.out.println("Tom在" + i + "行，" + j + "列。");
					x++;
				}
			}
		}
		if(x == 0) {
			System.out.println("Tom不在里面！");
		}else {
			System.out.println("Tom在里面出现了" + x + "次！");
		}
		System.out.println(" ");
		for(int i = 0; i < names.length; i++) {
			for(int j = 0; j < names[0].length; j++) {
				System.out.print(names[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println(" ");
		int[][] num = new int[2][2];
		for(int i = 0; i < names.length; i++) {
			for(int j = 0; j < names[0].length; j++) {
				if(names[i][j].equals("Mike")) {
					num[0][0] = i;
					num[0][1] = j;
				}
				if(names[i][j].equals("Nyf")) {
					num[1][0] = i;
					num[1][1] = j;
				}
			}
		}
		String b = "";
		b = names[num[0][0]][num[0][1]];
		names[num[0][0]][num[0][1]] = names[num[1][0]][num[1][1]];
		names[num[1][0]][num[1][1]] = b;
		for(int i = 0; i < names.length; i++) {
			for(int j = 0; j < names[0].length; j++) {
				System.out.print(names[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
