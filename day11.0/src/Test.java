import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		int x = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请随意输入一个字符串:");
		String a = sc.next();
		
		System.out.println("请输入要查询的关键字符串:");
		String b = sc.next();
		
		int length = b.length();
		for(int i = 0; i < a.length() - length; i++) {
			if(a.substring(i, i + length).equals(b)) {
				x++;
			}
		}
		if(a.substring(a.length() - length).equals(b)) {
			x++;
		}
		
		System.out.println("关键字符串出现的次数为：" + x);
		sc.close();
	}

}
