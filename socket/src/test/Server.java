package test;

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
		//1. 创建ServerSocket
		try {
			System.out.println("server启动中....");
			ServerSocket serverSocket = new ServerSocket(6666);
			System.out.println("server启动成功,等待client连接...");
			//2. 侦听连接请求
			Socket socket = serverSocket.accept();
			System.out.println("server接收到了client连接");
			//3. 获得InputStream
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//4. 获得OutputStream
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			Scanner sc = new Scanner(System.in);

			//4.1 设置多线程，读取对方的数据
			InputHandler inputHandler = new InputHandler(input);
			inputHandler.start();
			String serverMsg;
			boolean shouldContinue = true;
			while(shouldContinue) {
				System.out.println("请输入回复：");
				serverMsg = sc.nextLine();
				
				System.out.println("server:" + serverMsg);
				
				output.write(serverMsg + "\r");
				output.flush();
				
				if("bye".equals(serverMsg)) {
					shouldContinue = false;
				}
				
		    }

		    //5. 关闭相关数据
			inputHandler.shouldContinue = false;
			sc.close();
			socket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
