package com.pengrui.socket3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Server服务器启动中...");
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("Server启动成功...");
		
		Socket socket = serverSocket.accept();
		
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		boolean b = true;
		Scanner sc = new Scanner(System.in);
		String serverMsg;
		InputHandle inputHandle = new InputHandle(input);
		inputHandle.start();
		
		while(b) {
			serverMsg = sc.nextLine();
			System.out.println("Server:" + serverMsg);
			output.write(serverMsg);
			output.flush();
			
			if("bye".equals(serverMsg)) {
				b = false;
				System.out.println("Server关闭...");
				
			}
		}
		sc.close();
		socket.close();
		serverSocket.close();

	
	}

}


