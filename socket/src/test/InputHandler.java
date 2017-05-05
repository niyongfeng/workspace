package test;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler extends Thread {
	BufferedReader reader;
	public boolean shouldContinue = true;
	
	public InputHandler(BufferedReader reader) {
		this.reader = reader;
	}
	
	public void run() {
		while(shouldContinue) {
			try {
				String msg = reader.readLine();
				
				if("bye".equals(msg)) {
					shouldContinue = false;
				}
				
				System.out.println("收到消息：" + msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}