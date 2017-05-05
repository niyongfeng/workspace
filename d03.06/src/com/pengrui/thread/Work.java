package com.pengrui.thread;

public class Work {
	//通过继承实现多线程：1、继承Thread类:1）写一个类继承Thread;2）实现run方法；3）创建一个线程实例，并调用start方法
	//                2、实现Runable接口:1）创建一个类实现Runnable接口；2）实现run方法；3）创建一个Thread类，并且把上面的类的实例作为参数传给Thread的构造函数
	public static void main(String[] args) {
		long beginTime = System.currentTimeMillis();
		
//		Thread cT = new CodingThread();
		Thread cT = new Thread(new CodingThread());
		cT.start();
		
//		Thread dlT = new DownLoadingThread();
		Thread dlT = new Thread(new DownLoadingThread());
		dlT.start();

		long endTime = System.currentTimeMillis();
		System.out.println("总共用了" + (endTime - beginTime) + "毫秒！");
	}

}

//class CodingThread extends Thread {
class CodingThread implements Runnable {
	public void run() {
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
}

//class DownLoadingThread extends Thread {
class DownLoadingThread implements Runnable {
	public void run() {
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
