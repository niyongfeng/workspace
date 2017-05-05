package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Person extends Thread {
	Set<Puker> p1 = new TreeSet<Puker>();
	private int i = 0;
	private int n = 1;
	private File file;
	public Person() {
		
	}
	
	public Person(int n) throws IOException {
		this.n = n;
		String filePath1 = "/users/niyongfeng/DouDiZhu/Player" + n + ".txt";
		file = new File(filePath1);
		if(file.createNewFile()) {
			System.out.println("创建玩家" + n + "的游戏日志!");
		}else {
			if(file.exists()) {
				System.out.println("玩家" + n + "的游戏日志已存在！");
			}else {
				System.out.println("创建失败！");
			}
		}
	}
	public void run() {
		while(i < 51) {
			if(i % 3 == (n - 1)) {
				p1.add(Box.list.get(i));
			}
			i++;
		}
		print();
		try {
			writeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void print() {
		System.out.println("玩家" + n + "的手牌为:");
		for(Puker str : p1) {
			System.out.print(str.toString() + " ");
		}
		System.out.println(" ");
	}
	
	
	public void writeFile() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		
		for(Puker str : p1) {
			bw.write(str.toString() + " ");
		}
		
		bw.newLine();
		bw.close();
	} 
}

