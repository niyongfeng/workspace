package com.pengrui.lock;

public class LearnLock {
	public static void main(String[] args) {
		Object lock1 = new Object();
		Object lock2 = new Object();
		Thread t1 = new Thread1(lock1, lock2);
		Thread t2 = new Thread(new Thread2(lock1, lock2));
		t1.start();
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		t2.start();
	}
}

class Thread1 extends Thread {
	Object lock1;
	Object lock2;
	
	public Thread1(Object lock1, Object lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	public void run() {
		synchronized(lock1) {
			System.out.println("Thread1:拿到lock1，准备拿lock2。。。");
			synchronized(lock2) {
				System.out.println("Thread1:拿到lock2，完成任务。。。");
			}
		}
	}
}

class Thread2 implements Runnable{
	Object lock1;
	Object lock2;
	
	public Thread2(Object lock1, Object lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}
	
	public void run() {
		//死锁：1、两个线程同时争夺两个资源
//		synchronized(lock2) {
//			System.out.println("Thread2:拿到lock2，准备拿lock1。。。");
//			synchronized(lock1) {
//				System.out.println("Thread2:拿到lock1，完成任务。。。");
//			}
//		}
		synchronized(lock1) {
			System.out.println("Thread2:拿到lock1，准备拿lock2。。。");
			synchronized(lock2) {
				System.out.println("Thread2:拿到lock2，完成任务。。。");
			}
		}
	}
}
