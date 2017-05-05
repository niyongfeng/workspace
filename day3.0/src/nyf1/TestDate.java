package nyf1;

public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date = new Date(1,5,2016);
		System.out.println(date.getDay());
		System.out.println(date.getMonth());
		System.out.println(date.getYear());
		System.out.println(date.toString());
		date.setDate(7, 7, 2016);
		System.out.println(date.toString());
		

	}

}
