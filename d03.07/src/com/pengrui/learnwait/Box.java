package com.pengrui.learnwait;

public class Box {
	int value = 0;
	
	public static void main(String[] args) {
		Box b = new Box();
		Thread p = new Producer(b);
		Thread c = new Consumer(b);
		p.start();
		c.start();
	}
}

class Producer extends Thread {
	Box box;
	public Producer(Box box) {
		this.box = box;
	}
	public void run() {
		for(int i = 1; i <= 6; i++) {
			synchronized(box) {
				if(box.value != 0) {
					try {
						System.out.println("Producer:Box不为空，进入等待状态");
						box.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				box.value = i;
				System.out.println("Producer:Box存入" + box.value);
				box.notify();
			}
		}
	}
}

class Consumer extends Thread {
	Box box;
	public Consumer(Box box) {
		this.box = box;
	}
	public void run() {
		for(int i = 1; i <= 6; i++) {
			synchronized(box) {
				if(box.value == 0) {
					try {
						System.out.println("Consumer:Box为空，进入等待状态");
						box.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Consumer:Box取走" + box.value);
				box.value = 0;
				box.notify();
			}
		}
	}
}