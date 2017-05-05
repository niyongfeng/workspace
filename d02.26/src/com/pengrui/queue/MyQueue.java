package com.pengrui.queue;

public class MyQueue implements Queue{
	private String[] array = new String[8];
	private int index = 0;
	
	public MyQueue() {
		
	}
	
	public MyQueue(int index) {
		this.index = index;
	}
	
	public boolean isEmpty() {
		if(index > array.length - 1) {
			String[] array = new String[2 * index];
			System.out.println("数组已存满，扩大数组长度，长度为：" + array.length);
			return true;
		}else {
			return false;
		}
	}
	
	public void add(String x) {
		this.isEmpty();
		array[index] = x;
		index++;
	}
	
	public void remove() {
		for(int i = 1; i < array.length; i++) {
			array[i - 1] = array[i];
		}
		array[array.length - 1] = "";
	}
}
