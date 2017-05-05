package com.pengrui.io1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LearnFile {
	
	public static void main(String[] args) {
		String filePath = "/users/niyongfeng/newfile.txt"; 
		String folderPath = "/users/niyongfeng/hahaha";
		creatFile(filePath);
//		writeFile(filePath);
//		readerFile(filePath);
		folderFile(folderPath);
		
		
	}
	
	public static void creatFile(String filePath) {
		File file = new File(filePath);
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getAbsolutePath());
		try {
			if(file.exists()) {
				//file.delete();
				System.out.println("已存在！" + filePath);
			}else {
				if(file.createNewFile()) {
					System.out.println("成功！" + filePath);
				}else {
					System.out.println("失败！" + filePath);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void writeFile(String filePath) {
		File file = new File(filePath);
		try {
//			FileWriter fw = new FileWriter(file);
//			BufferedWriter bw = new BufferedWriter(fw); 
			//覆盖式写入
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//			不覆盖式写入
//			BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
			//换行\r\n或者\r或者\n
			bw.write("aaaaa\r");
			bw.write("bbbbb\r");
			bw.write("ccccc\r");
			//flush()后面的写入缓存区
			bw.flush();
			//newLine()添加空行
			bw.newLine();
			bw.write("ddddd\r");
			bw.write("eeeee\r");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readerFile(String filePath) {
		File file = new File(filePath);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			try {
				line = br.readLine();
				while(line != null) {
					System.out.println(line);
					line = br.readLine();
				}
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void folderFile(String filePath) {
		File folder = new File(filePath);
		
		folder.mkdir();//创建最后一层文件夹
//		folder.mkdirs();//会把缺少的文件夹也创建了
		
		for(int i = 1; i < 10; i++) {
			creatFile(folder.getAbsolutePath() + "/" + i);
		}
		
		File file;
		for(String fileName : folder.list()) {
			file = new File(folder.getAbsolutePath() + "/" + fileName);
			System.out.println(fileName);
			file.delete();
		}
	}
}
