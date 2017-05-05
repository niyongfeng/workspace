package nyf1;

public class Animals {
	
	private String name = "joke";
	private int age = 5;
	
	public Animals() {
		
	}
	
	public String getAnimalsName() {
		return "name:" + name; 
	}
	
	protected String getAnimalsAge() {
		return "age:" + age;
	}
	
	String toIformation() {
		return "name:" + name + "; age:" + age;
	}
	
	/*private String print() {
		return "可以了";
	}*/
}
