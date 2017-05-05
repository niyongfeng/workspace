package com.pengrui.thread;

public class XiaoMingWork {
	
	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		coating();
		downloading();
		long endTime = System.currentTimeMillis();
		System.out.println("总共花费" + (endTime - beginTime) + "毫秒!");
	}
	
	public static void coating() {
		for(int i = 1; i <= 100; i ++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("正在敲第" + i + "行代码！");
		}
	}
	
	public static void downloading() {
		for(int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("正在下载第" + i + "集电视剧！");
		}
	}
}
