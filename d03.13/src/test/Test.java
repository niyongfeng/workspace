package test;

import java.io.IOException;

public class Test {

	public static void main(String[] args) throws InterruptedException, IOException {
		Box box = new Box();
		box.ruffle();
		Person p1 = new Person(1);
		Person p2 = new Person(2);
		Person p3 = new Person(3);
		
		p1.start();
		p1.join();
		p2.start();
		p2.join();
		p3.start();
		p3.join();
		
		box.cards();
		
	}
}
