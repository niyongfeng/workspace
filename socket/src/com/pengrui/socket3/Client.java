package com.pengrui.socket3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Client连接中...");
		Socket socket = new Socket("localhost",8888);
		System.out.println("Client连接成功...");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		boolean b = true;
		Scanner sc = new Scanner(System.in);
		String clientMsg;
		
		InputHandle inputHandle = new InputHandle(input);
		inputHandle.start();
		
		while(b) {
			clientMsg = sc.nextLine();
			System.out.println("Client:" + clientMsg);
			output.write(clientMsg + "\r");
			output.flush();
			
			if("bye".equals(clientMsg)) {
				b = false;
				System.out.println("Client关闭...");
				
			}
		}
		sc.close();
		socket.close();
		
	}

}

