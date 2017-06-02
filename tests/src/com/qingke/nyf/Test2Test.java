package com.qingke.nyf;


import org.junit.Test;

public class Test2Test {

	@Test
	public void test() {
		int[] arr = new int[]{1,2,3,4,5};
		Object[] obj = new Object[arr.length];
		for(int i = 0; i < arr.length; i++) {
			obj[i] = (Object) arr[i];
		}
		Object[] obj1 = Test2.getArray(obj);
		for(Object o : obj1) {
			System.out.println(o);
		}
		
	}

}
