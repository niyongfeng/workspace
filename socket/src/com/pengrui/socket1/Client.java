package com.pengrui.socket1;

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
			String clientMsg = sc.nextLine();
			System.out.println("客户端发送请求：" + clientMsg);
			
			output.write(clientMsg + "\n");
			output.flush();
			
			String serverMsg = input.readLine();
			System.out.println("服务器发来的请求：" + serverMsg);
			
			sc.close();
			socket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
