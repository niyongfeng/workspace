package com.qingke.nyf;

public class Test2 {
	
	public static Object[] getArray(Object[] obj){
		for(int i = 0; i < obj.length / 2; i++) {
			Object o = obj[i];
			obj[i] = obj[obj.length - i - 1];
			obj[obj.length - i - 1] = o;
		}
		return obj;
	}
}
