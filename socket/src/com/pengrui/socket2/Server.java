package com.pengrui.socket2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	public static void main(String[] args) {
		try {
			System.out.println("服务器端");
			System.out.println("Server启动中。。。。");
			//1.创建ServerSocket
			ServerSocket serverSocket = new ServerSocket(6666);
			System.out.println("Server启动成功。。。。等待连接。。。。");
			
			//2.侦听连接请求
			Socket socket = serverSocket.accept();
			System.out.println("Server接受到了Client连接 ");
			
			//3.获得InputStream
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//4.获得OutputStream
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			boolean b = true;
			Scanner sc = new Scanner(System.in);
			InputHandle inputHandle = new InputHandle(input);
			inputHandle.start();
			while(b) {
				//String clientMsg = input.readLine();
				//System.out.println("客户端发来的请求：" + clientMsg);
			
				System.out.print("请回复：");
				String serverMsg = sc.nextLine();
				System.out.println("服务器发送的请求：" + serverMsg);
			
				output.write(serverMsg + "\n");
				output.flush();
				
				if(/*"bye".equals(clientMsg) || */"bye".equals(serverMsg)) {
					b = false;
				}
			}
			//5.关闭相关数据
			serverSocket.close();
			sc.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
