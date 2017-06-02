package com.qingke.nyf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest {
	
	public static void changeFile(String inputpath,String outputPath) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(inputpath)));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(outputPath), true));
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				bw.write(line + "\r");
				line = br.readLine();
			}
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String inputPath = "/users/niyongfeng/in.txt";
		String outputPath = "/users/niyongfeng/out.txt";
		changeFile(inputPath,outputPath);
	}

}
