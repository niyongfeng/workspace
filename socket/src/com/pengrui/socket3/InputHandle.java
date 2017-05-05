package com.pengrui.socket3;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandle extends Thread{
	BufferedReader reader;
	public InputHandle(BufferedReader reader) {
		this.reader = reader;
	}
	
	public void run() {
		//System.out.println("1");
		while(true) {
			//System.out.println("2");
			try {
				String msg = reader.readLine();
				System.out.println("收到的信息：" + msg);
				//System.out.println("3");
//				if("bye".equals(msg)) {
//					System.out.println("关闭了...");
//					break;
//				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
