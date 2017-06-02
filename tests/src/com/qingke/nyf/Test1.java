package com.qingke.nyf;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] index = new int[]{2,0,3,2,4,0,1,3,2,3,3};
		getTel(index);
	}

	public static String getTel(int[] index) {
	     int[] arr = new int[]{8,2,1,0,3};	     
	     String tel = "";
	     for(int i : index){
	         tel += arr[i];
	     }
	     System.out.println("联系方式:"+tel);
	     return tel;
	}
}
