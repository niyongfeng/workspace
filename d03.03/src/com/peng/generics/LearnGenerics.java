package com.peng.generics;


public class LearnGenerics {
	
	public static void main(String[] args) {
		MyContainer<String, Integer> m = new MyContainer<String, Integer>("nyf", 20);
		System.out.println(m.key.getClass());
		System.out.println(m.value.getClass());
		
	}
	
		
}

class MyContainer<K, V>{
	public K key;
	public V value;
	
	public MyContainer(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
