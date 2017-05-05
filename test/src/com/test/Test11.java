package com.test;

public class Test11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = chkBlood("O", "B");
		String[] str1 = ss("O", "B");
		for(String s : str1) {
			System.out.println(s);
		}
	}
    static String[] chkBlood(String father, String mother) {
        // write code here
        String s = father + mother;
        //String[] str;
        if(s.equals("OO")) {
        	return new String[]{"O"};
        }else if(s.equals("AO") || s.equals("OA") || s.equals("AA")) {
        	return new String[]{"A", "O"};
        }else if(s.equals("AB") || s.equals("BA")) {
        	return new String[]{"A", "B", "AB", "O"};
        }else if(s.equals("AAB") || s.equals("ABA") 
                 || s.equals("BAB") || s.equals("ABB")) {
        	return new String[]{"A", "B", "AB"};
        }else if(s.equals("BO") || s.equals("OB")) {
        	//System.out.println("B" + "," + "O");
            return new String[]{"B", "O"};
        }else if(s.equals("ABO") || s.equals("OAB")) {
        	return new String[]{"A", "B"};
        }else {
            return new String[]{"A", "B", "AB"};
        }
        //return str;
    }
    static String[] ss(String a, String b) {
    	String[] arr = {a, b};
    	return arr;
    }

}
