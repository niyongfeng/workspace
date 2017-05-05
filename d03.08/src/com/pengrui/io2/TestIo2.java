package com.pengrui.io2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class TestIo2 {
	
	public static void main(String[] args) {
		String filePath1 = "/users/niyongfeng/test/test1.txt";
		String filePath2 = "/users/niyongfeng/test/test2.doc";
		String folder = "/users/niyongfeng/test";
		copeFile(folder,filePath1, filePath2);
	}
	
	public static void copeFile(String folder,String filePath1, String filePath2) {
		File fl = new File(folder);
		fl.mkdir();
		File file1 = new File(filePath1);
		File file2 = new File(filePath2);
		Scanner sc = new Scanner(System.in);
		try {
			BufferedWriter bw1 = new BufferedWriter(new FileWriter(file1));
			while(true) {
				System.out.println("请输入你要输入的文本：");
				String strin = sc.next();
				bw1.write(strin + "\n");
				System.out.println("是否继续输入(y/n)");
				String strbo = sc.next();
				if(strbo.equals("n")) {
					break;
				}
			}
			sc.close();
			bw1.close();
			//复制文本
			BufferedReader br1 = new BufferedReader(new FileReader(file1));
			BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2, true));
			String strr = br1.readLine();
			while(strr != null) {
				bw2.write(strr + "\n");
				strr = br1.readLine();
			}
			bw2.close();
			br1.close();
			//输出复制后的文本
			System.out.println("复制完后文本内容：");
			BufferedReader br2 = new BufferedReader(new FileReader(file2));
			String str2 = br2.readLine();
			while(str2 != null) {
				System.out.println(str2);
				str2 = br2.readLine();
			}
			br2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
