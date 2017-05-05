package nyf2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Circle1 c1 = new Circle1();
		Circle1 c2 = new Circle1(3.0);
		Circle1 c3 = new Circle1(2.0,"blue");
		
		System.out.println(c1.getArea());
		System.out.println("Color=" + c1.getColor());
		System.out.println("Radius=" + c1.getRadius());
		c1.setColor("blue");
		c1.setRadius(2.0);
		System.out.println(c1.getArea());
		System.out.println("Color=" + c1.getColor());
		System.out.println("Radius=" + c1.getRadius());
		System.out.println("");
		
		System.out.println(c2.getArea());
		System.out.println("Color=" + c2.getColor());
		System.out.println("Radius=" + c2.getRadius());;
		c2.setColor("green");
		c2.setRadius(2.0);
		System.out.println(c2.getArea());
		System.out.println("Color=" + c2.getColor());
		System.out.println("Radius=" + c2.getRadius());
		System.out.println("");
		
		System.out.println(c3.getArea());
		System.out.println("Color=" + c3.getColor());
		System.out.println("Radius=" + c3.getRadius());
		c3.setColor("yellow");
		c3.setRadius(2.0);
		System.out.println(c3.getArea());
		System.out.println("Color=" + c3.getColor());
		System.out.println("Radius=" + c3.getRadius());
		System.out.println("");
		
		

	}

}
