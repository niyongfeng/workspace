import java.util.Scanner;

public class Table {
	public static void main(String[] args) {
		
		String[] x = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String[] y = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		String[] z = {"1","2","3","4","5","6","7","8","9","0"};
		
		int a = 0; //统计大写
		int b = 0; //统计小写
		int c = 0; //统计数字
		
		System.out.println("请输入您要统计的字符串：");
		Scanner sc = new Scanner(System.in);
		String mm = sc.next();
		for(int i = 0; i < mm.length(); i++) {
			for(int m = 0; m < 26; m++) {
				if(mm.substring(i, i + 1).equals(x[m])) {
					a++;
				}
				if(mm.substring(i, i + 1).equals(y[m])) {
					b++;
				}
			}
			for(int t = 0; t < 10; t++) {
				if(mm.substring(i, i + 1).equals(z[t])) {
					c++;
				}
			}
		}
		System.out.println("字符串长度为：" + mm.length());
		System.out.println("大写字母个数为：" + a);
		System.out.println("小写字母个数为：" + b);
		System.out.println("数字个数为：" + c);
		System.out.println("其他符号个数为：" + (mm.length() - a - b -c));
		sc.close();
	}

}
