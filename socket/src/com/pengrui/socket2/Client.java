package com.pengrui.socket2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		try {
			System.out.println("客户端");
			System.out.println("Client启动连接中。。。。");
			//1.创建socket连接
			Socket socket = new Socket("localhost",6666);
			System.out.println("连接成功。。。。");
			
			//2.获得InputStream
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//3.获得OutputStream
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			//4.写数据
			Scanner sc = new Scanner(System.in);
			InputHandle inputHandle = new InputHandle(input);
			inputHandle.start();
			
			boolean b = true;
			
			while(b) {
				String clientMsg = sc.nextLine();
				System.out.println("客户端发送请求：" + clientMsg);
			
				output.write(clientMsg + "\n");
				output.flush();
			
				//String serverMsg = input.readLine();
				//System.out.println("服务器发来的请求：" + serverMsg);
			
				if("bye".equals(clientMsg) /*|| "bye".equals(serverMsg)*/) {
					b = false;
				}
			}
			
			sc.close();
			socket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class InputHandle extends Thread {
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
				if("bye".equals(msg)) {
					System.out.println("关闭了...");
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
