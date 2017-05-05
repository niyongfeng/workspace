package com.test;

public class Test1 {

	public static void main(String[] args) {
		// System.out.println(func());
		// System.out.println(AccountType.FIXED);
		String str = "catdsdadog";
		int x = 0;
		int y = 0;
		String str2 = "dog";
		for (int i = 0; i < str.length() - 2; i++) {
//			if (str.substring(i, i + 2).equals("cat")) {
//				x++;
//			}
			String str1 = str.substring(i, i + 3);
			if(str.charAt(i) == 'c' && str.charAt(i + 1) == 'a' && str.charAt(i + 2) == 't') {
				x++;
			}
			if (str1.equals(str2)) {
				y++;
			}
		}

		System.out.println(x);
		System.out.println(y);


	}

	// public static int func(){
	// try{
	// return 1;
	// }catch (Exception e){
	// return 2;
	// }finally {
	// return 3;
	// }
	// }
	// }

	// enum AccountType
	// {
	// SAVING, FIXED, CURRENT;
	// private AccountType()
	// {
	// System.out.println("It is a account type");
	// }
}
