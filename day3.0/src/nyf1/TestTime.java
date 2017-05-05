package nyf1;

public class TestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Time time = new Time(23,59,59);
	
		System.out.println(time.getHour());
		System.out.println(time.getMinute());
		System.out.println(time.getSecond());
		System.out.println(time.toString());
		System.out.println("下一秒：" + time.nextSecond());
		System.out.println("前一秒：" + time.previousSecond());
		time.setHour(9);
		time.setMinute(30);
		time.setSecond(00);
		System.out.println(time.toString());
		System.out.println("下一秒：" + time.nextSecond());
		System.out.println("前一秒：" + time.previousSecond());
		

	}

}
