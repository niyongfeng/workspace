package com.pengrui.randomaccessfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFtest {
	
	public static void main(String[] args) {
		String filePath = "/users/niyongfeng/test";
//		try {
//			BufferedWriter br = new BufferedWriter(new FileWriter(f));
//			br.write("aaaa\n");
//			br.write("bbbb\n");
//			br.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		read(new File(filePath), "rw");
	}
	
	public static void read(File file, String model) {
		try {
			RandomAccessFile r = new RandomAccessFile(file,model);
			String str = r.readLine();
			while(str != null) {
				System.out.println(str);
				str = r.readLine();
			}
			r.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
