package nyf2;

public class TestCat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cat cat = new Cat();
		cat.setBathDay(28);
		cat.setBathMonth(4);
		cat.nextBath();
		System.out.println(cat.toPrint());
	}

}
