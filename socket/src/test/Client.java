package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		//1. 创建socket连接
		try {
			System.out.println("尝试建立连接....");
			Socket socket = new Socket("localhost", 6666);
			System.out.println("连接成功！");

			
			//2. 获得InputStream
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//3. 获得OutputStream
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//4. 写数据
			Scanner sc = new Scanner(System.in);
			String clientMsg;
			
			InputHandler inputHandler = new InputHandler(input);
			inputHandler.start();
			boolean shouldContinue = true;

			while(shouldContinue) {
				clientMsg = sc.nextLine();
				System.out.println("client:" + clientMsg);

				output.write(clientMsg + "\r");
				output.flush();
				
				if("bye".equals(clientMsg)) {
					shouldContinue = false;
				}				
			}
			inputHandler.shouldContinue = false;
			sc.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}