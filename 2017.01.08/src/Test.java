
public class Test {

	public static void main(String[] args) {
		
		Fruits fruits1 = new Fruits();
		Snacks snacks1 = new Snacks();
		
		System.out.println(fruits1.toString());
		System.out.println("");
		System.out.println(snacks1.toString());
		System.out.println("");
		
		Fruits fruits2 = new Fruits("red", "sweet", "apples");
		Snacks snacks2 = new Snacks("干脆面", 85);
		System.out.println(fruits2.toString());
		System.out.println("");
		System.out.println(snacks2.toString());
		System.out.println("");
		
		Fruits fruits3 = new Fruits("yellow", "sweet", "bananas", 6.5, 3);
		Snacks snacks3 = new Snacks("饮料", 90, 2.5, 10);
		System.out.println(fruits3.toString());
		System.out.println("");
		System.out.println(snacks3.toString());
	}
}
