package nyf;
//类的定义，构造方法，方法的定义


public class Circle {

	private double radius = 1.0;
	//private String color = "red";
	
	
	public Circle(){
		 //System.out.println(radius);
		 //System.out.println(color);
	}
	
	public Circle(double radius){
		//Scanner sc = new Scanner(System.in);
		//radius = sc.nextInt();
		this.radius = radius;
	}
	
	public double getRadius(){
		return radius;
	}
	public double getArea(){
		double Area = Math.PI * radius * radius;
		return Area;
	}
}
