import java.util.Scanner;

public class Table1 {

	public static void main(String[] args) {
		
		System.out.println("请输入您需要统计的字符串：");
		Scanner sc = new Scanner(System.in);
		String mm = sc.next();
		int a = 0;
		int b = 0;
		int c = 0;
		for(int i = 0; i < mm.length(); i++) {
			if(mm.charAt(i) >= 'A' && mm.charAt(i) <= 'Z') {
				a++;
			}
			if(mm.charAt(i) >= 97 && mm.charAt(i) <= 122) {
				b++;
			}
			if(mm.charAt(i) >= 48 && mm.charAt(i) <= 57) {
				c++;
			}
		}
		System.out.println("您输入的字符串长度为：" + mm.length());
		System.out.println("大写字母个数为：" + a);
		System.out.println("小写字母个数为：" + b);
		System.out.println("数字个数为：" + c);
		System.out.println("其他字符个数为：" + (mm.length() - a - b - c));
		sc.close();
	}
}
