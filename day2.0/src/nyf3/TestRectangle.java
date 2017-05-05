package nyf3;

public class TestRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Rectangle rec = new Rectangle();
		System.out.println(rec.toString());
		System.out.println(rec.getArea());
		System.out.println(rec.getPerimeter());
		rec.setLength(2.0f);
		rec.setWidth(3.0f);
		System.out.println(rec.toString());
		System.out.println(rec.getArea());
		System.out.println(rec.getPerimeter());
		
		
		
	}

}
